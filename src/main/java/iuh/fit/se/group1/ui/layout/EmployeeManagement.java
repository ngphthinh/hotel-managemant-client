/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package iuh.fit.se.group1.ui.layout;


import iuh.fit.se.group1.dto.AccountDTO;
import iuh.fit.se.group1.dto.EmployeeDTO;
import iuh.fit.se.group1.dto.RoleDTO;
import iuh.fit.se.group1.enums.Role;
import iuh.fit.se.group1.network.Response;
import iuh.fit.se.group1.network.client.SocketFacade;
import iuh.fit.se.group1.network.client.service.EmployeeServiceClient;
import iuh.fit.se.group1.network.client.service.ImportExportExcelServiceClient;
import iuh.fit.se.group1.network.client.service.RoleServiceClient;
import iuh.fit.se.group1.ui.component.custom.AvatarLabel;
import iuh.fit.se.group1.ui.component.custom.Combobox;
import iuh.fit.se.group1.ui.component.custom.message.CustomDialog;
import iuh.fit.se.group1.ui.component.custom.message.Message;
import iuh.fit.se.group1.ui.component.modal.InfoEmployeeModal;
import iuh.fit.se.group1.ui.component.shift.ShiftList;
import iuh.fit.se.group1.ui.component.table.TableActionEvent;
import iuh.fit.se.group1.util.Constants;
import iuh.fit.se.group1.util.ExportUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;
import raven.glasspanepopup.GlassPanePopup;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class EmployeeManagement extends JPanel {

    private final EmployeeServiceClient employeeService;
    private final RoleServiceClient roleService;
    private int activeFilterColumn = -1;
    private ShiftList shiftList;
    @Getter
    @Setter
    private EmployeeDTO currentEmployee;
    static final int GET_ALL = 1;
    static final int GET_BY_KEYWORD = 2;
//    private static final int GET_BY_ = 3;

    public EmployeeManagement() {
        initComponents();
        custom();
        employeeService = SocketFacade.getInstance().getEmployee();
        roleService = SocketFacade.getInstance().getRole();
        loadTable(fetchData(GET_ALL, ""));
    }

    public void loadData() {
        loadTable(fetchData(GET_ALL, ""));

    }

    public List<EmployeeDTO> fetchData(int type, String filter) {


        try {
            Response response = null;
            if (type == GET_ALL) {
                response = employeeService.getAllEmployee();

            } else if (type == GET_BY_KEYWORD) {
                response = employeeService.getEmployeeByKeyword(filter);
            }
            if (response != null && response.getCode() != 200) {
                JOptionPane.showMessageDialog(this, "Server returned HTTP Status " + response.getCode());
                return null;
            }
            return (List<EmployeeDTO>) response.getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void custom() {
        headerCustom2.getLblTitle().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));

        headerCustom2.getLblTitle().setText(
                "<html><span style='color:white;'>Quản lý nhân viên</span>"

                        + "<span style='color:rgb(204,204,204);'> &gt; Thông tin nhân viên</span></html>");

        btnAddEmployee.setBackground(new Color(108, 165, 200));
        btnAddEmployee.setForeground(Color.WHITE);
        btnAddEmployee.setBorderRadius(10);

        btnExport.setBackground(new Color(13, 200, 7));
        btnExport.setForeground(Color.WHITE);
        btnExport.setBorderRadius(10);

        btnImport.setBackground(new Color(255, 108, 3));
        btnImport.setForeground(Color.WHITE);
        btnImport.setBorderRadius(10);
        btnImport.addActionListener(ev -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            try {
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    ImportExportExcelServiceClient importService = SocketFacade.getInstance().getImportExportExcel();

                    Response response = importService.importEmployeesFromExcel(file);

                    if (response.getCode() != 200) {
                        JOptionPane.showMessageDialog(this, "Server returned HTTP Status " + response.getCode() + response.getMessage());
                        return;
                    }

                    List<EmployeeDTO> imported = (List<EmployeeDTO>) response.getData();
                    if (imported != null && !imported.isEmpty()) {
                        loadTable(fetchData(GET_ALL, ""));
                        Message.showMessage("Thành công", "Đã import " + imported.size() + " nhân viên!");
                    } else {
                        Message.showMessage("Lỗi", "Không có dữ liệu nào được import!");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error importing Excel file: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);

            }
        });

        btnAddEmployee.setIcon(FontIcon.of(FontAwesomeSolid.PLUS, 17, Color.WHITE), SwingConstants.RIGHT);
        btnExport.setIcon(FontIcon.of(FontAwesomeSolid.FILE_EXPORT, 17, Color.WHITE), SwingConstants.RIGHT);
        btnImport.setIcon(FontIcon.of(FontAwesomeSolid.FILE_IMPORT, 17, Color.WHITE), SwingConstants.RIGHT);

        String[] cols = {"Mã nhân viên", "Họ tên", "Giới tính", "Chức vụ", "Số điện thoại", "Chức năng"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        tblEmployee.getTbl().setModel(model);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblEmployee.getTbl().setRowSorter(sorter);

        tblEmployee.getTbl().setAutoCreateRowSorter(false);

        for (int i = 0; i < tblEmployee.getTbl().getColumnCount(); i++) {
            if (i != 2 && i != 3) {
                sorter.setSortable(i, false);
            }
        }
        // DefaultTableModel model = new DefaultTableModel(cols, 0);
        // tblPromotion.getTbl().setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tblEmployee.getTbl().clearSelection();
            }
        });
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) throws Exception {
                DefaultTableModel model = (DefaultTableModel) tblEmployee.getTbl().getModel();
                Long employeeId = (Long) model.getValueAt(row, 0);

                // Lấy thông tin đầy đủ từ database

                Response response = employeeService.getEmployeeById(employeeId);

                if (response.getCode() != 200) {
                    JOptionPane.showMessageDialog(null, "Server returned HTTP Status " + response.getCode() + ": " + response.getMessage());
                    return;

                }

                EmployeeDTO employee = (EmployeeDTO) response.getData();

                if (employee == null) {
                    Message.showMessage("Lỗi", "Không tìm thấy thông tin nhân viên!");
                    return;
                }

                InfoEmployeeModal modal = new InfoEmployeeModal();
                modal.getLblTitle().setText("Cập nhật nhân viên");
                modal.getBtnSave().setText("Cập nhật");

                // Set giá trị cho Employee modal
                modal.getLblCode().setText(String.valueOf(employee.getEmployeeId()));
                modal.getTxtName().setText(employee.getFullName());
                modal.getTxtPhone().setText(employee.getPhone());
                modal.getTxtEmail().setText(employee.getEmail());
                modal.getTxtCitizen().setText(employee.getCitizenId());
                modal.getTxtHireDate().setText(employee.getHireDate().format(Constants.DATE_FORMATTER));

                String genderStr = employee.isGender() ? "Nữ" : "Nam";
                modal.getCmbGender().setSelectedItem(genderStr);

                String roleName = employee.getAccount() != null && employee.getAccount().getRole() != null
                        ? employee.getAccount().getRole().getRoleId()
                        : "N/A";

                int indexPosition = roleName.equals(Role.MANAGER.name()) ? 1 : 0;


                modal.getCmbPosition().setSelectedIndex(indexPosition);

                // Load avatar hiện tại
                AvatarLabel avatarLabel = modal.getAvatarLabel();
                if (avatarLabel != null && employee.getAvt() != null && employee.getAvt().length > 0) {
                    avatarLabel.setImageFromBytes(employee.getAvt());
                }

                modal.closeModel(ae -> GlassPanePopup.closePopupLast());
                modal.saveData(ae -> {
                    try {
                        var result = getValid(modal, employeeId); // ✅ Truyền thêm employeeId
                        if (!result.valid) {
                            return;
                        }
                        String title = "Xác nhận cập nhật nhân viên";
                        String message = "Bạn có chắc chắn muốn cập nhật nhân viên này không?";
                        Message.showConfirm(title, message, () -> {
                            try {
                                String genderSelected = (String) modal.getCmbGender().getSelectedItem();
                                boolean gender = "Nữ".equals(genderSelected);

                                String roleSelected = (String) modal.getCmbPosition().getSelectedItem();
                                String roleId = roleSelected.equalsIgnoreCase("Nhân viên quản lý")
                                        ? Role.MANAGER.toString()
                                        : Role.RECEPTIONIST.toString();
                                Response res = roleService.getRoleById(roleId);
                                if (res.getCode() != 200) {
                                    JOptionPane.showMessageDialog(null, "Server returned HTTP Status " + res.getCode() + ": " + response.getMessage());
                                    return;
                                }
                                RoleDTO newRole = (RoleDTO) res.getData();
                                if (newRole == null) {
                                    Message.showMessage("Lỗi", "Không tìm thấy vai trò!");
                                    return;
                                }

                                EmployeeDTO employeeUpdate = new EmployeeDTO();
                                employeeUpdate.setEmployeeId(employeeId);
                                employeeUpdate.setFullName(result.fullName);
                                employeeUpdate.setPhone(result.phone);
                                employeeUpdate.setEmail(result.email);
                                employeeUpdate.setCitizenId(result.citizenId);
                                employeeUpdate.setHireDate(result.hireDate);
                                employeeUpdate.setGender(gender);

                                if (employee.getAccount() != null) {
                                    AccountDTO accountToUpdate = employee.getAccount();
                                    accountToUpdate.setRole(newRole);
                                    employeeUpdate.setAccount(accountToUpdate);
                                } else {
                                    Message.showMessage("Lỗi", "Nhân viên không có tài khoản!");
                                    return;
                                }

                                AvatarLabel avt = modal.getAvatarLabel();
                                if (avt != null) {
                                    byte[] avtBytes = avt.getImageAsBytes("jpg");
                                    if (avtBytes != null && avtBytes.length > 0) {
                                        employeeUpdate.setAvt(avtBytes);
                                        log.info("Avatar updated for employee: {}", employeeId);
                                    } else {
                                        employeeUpdate.setAvt(employee.getAvt());
                                    }
                                } else {
                                    employeeUpdate.setAvt(employee.getAvt());
                                }

                                Response responseUpdate = null;
                                try {
                                    responseUpdate = employeeService.updateEmployee(employeeUpdate);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                if (responseUpdate.getCode() != 200) {
                                    JOptionPane.showMessageDialog(null, "Server returned HTTP Status " + responseUpdate.getCode() + ": " + responseUpdate.getMessage());
                                    return;
                                }

                                EmployeeDTO entitySave = (EmployeeDTO) responseUpdate.getData();

                                String genderStr2 = entitySave.isGender() ? "Nữ" : "Nam";
                                String roleName2 = entitySave.getAccount() != null && entitySave.getAccount().getRole() != null
                                        ? entitySave.getAccount().getRole().getRoleName()
                                        : "N/A";

                                model.setValueAt(entitySave.getFullName(), row, 1);
                                model.setValueAt(genderStr2, row, 2);
                                model.setValueAt(roleName2, row, 3);
                                model.setValueAt(entitySave.getPhone(), row, 4);

                                Message.showMessage("Thành công", "Cập nhật nhân viên thành công!");
                                loadTable(fetchData(GET_ALL, ""));
                                GlassPanePopup.closePopupLast();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });


                GlassPanePopup.showPopup(modal);

            }

            @Override
            public void onDelete(int row) {

                if (tblEmployee.getTbl().getValueAt(row, 0) == currentEmployee.getEmployeeId()) {
                    JOptionPane.showMessageDialog(null, "Bạn không thể xóa chính mình!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String title = "Xác nhận xóa nhân viên";
                String message = "Bạn có chắc chắn muốn xóa nhân viên này không?";
                Message.showConfirm(title, message, () -> {
                    JTable table = tblEmployee.getTbl();

                    if (table.isEditing()) {
                        table.getCellEditor().stopCellEditing();
                    }

                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int rowDelete = table.getSelectedRow();

                    if (rowDelete >= 0) {
                        Long id = (Long) model.getValueAt(rowDelete, 0);

                        try {
                            Response response = employeeService.deleteEmployee(id);
                            if (response == null || response.getCode() != 200) {
                                JOptionPane.showMessageDialog(null, "Server returned HTTP Status " + response.getCode() + ": " + response.getMessage());
                                return;


                            }

                            model.removeRow(rowDelete);
                        } catch (Exception e) {
                            CustomDialog.showMessage(null,
                                    e.getMessage(),
                                    "Lỗi",
                                    CustomDialog.MessageType.ERROR, 650, 120);
                        }

                        if (shiftList != null) {
                            shiftList.reloadEmployees();
                            log.info("Reloaded ShiftList after deleting employee: {}", id);
                        }
                    }
                });
            }

            @Override
            public void onView(int row) {
                DefaultTableModel model = (DefaultTableModel) tblEmployee.getTbl().getModel();
                Long employeeId = (Long) model.getValueAt(row, 0);


                // Lấy thông tin đầy đủ từ database

                Response response = null;
                try {
                    response = employeeService.getEmployeeById(employeeId);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if (response != null && response.getCode() != 200) {
                    JOptionPane.showMessageDialog(null, "Server returned HTTP Status " + response.getCode() + ": " + response.getMessage());
                    return;
                }

                EmployeeDTO employee = (EmployeeDTO) Objects.requireNonNull(response).getData();

                if (employee == null) {
                    Message.showMessage("Lỗi", "Không tìm thấy thông tin nhân viên!");
                    return;
                }

                InfoEmployeeModal modal = new InfoEmployeeModal();
                modal.getLblTitle().setText("Thông tin nhân viên");
                modal.getBtnSave().setText("Xong");


                log.info("Viewing employee details for ID: {}", employee);

                modal.getLblCode().setText(String.valueOf(employee.getEmployeeId()));
                modal.getTxtName().setText(employee.getFullName());
                modal.getTxtPhone().setText(employee.getPhone());
                modal.getTxtEmail().setText(employee.getEmail());
                modal.getTxtCitizen().setText(employee.getCitizenId());
                modal.getTxtHireDate().setText(employee.getHireDate().format(Constants.DATE_FORMATTER));

                String genderStr = employee.isGender() ? "Nữ" : "Nam";
                modal.getCmbGender().setSelectedItem(genderStr);

                String roleName = employee.getAccount() != null && employee.getAccount().getRole() != null
                        ? employee.getAccount().getRole().getRoleId()
                        : "N/A";

                int indexPosition = roleName.equals(Role.MANAGER.name()) ? 1 : 0;

                System.out.println(indexPosition);


                modal.getCmbPosition().setSelectedIndex(indexPosition);

                // Hiển thị avatar từ database
                AvatarLabel avatarLabel = modal.getAvatarLabel();
                // InfoEmployeeModal
                if (avatarLabel != null) {
                    if (employee.getAvt() != null && employee.getAvt().length > 0) {
                        try {
//                            ByteArrayInputStream bais = new ByteArrayInputStream(employee.getAvt());
//                            BufferedImage image = ImageIO.read(bais);
//                            if (image != null) {
//                                avatarLabel.setImage(image);
//                                log.info("Avatar loaded successfully for employee: {}", employeeId);
//                            } else {
//                                log.warn("Failed to read image from byte array for employee: {}", employeeId);
//                            }
                            avatarLabel.setImageFromBytes(employee.getAvt());
                        } catch (Exception e) {
                            log.error("Error loading avatar image: ", e);
                        }
                    } else {
                        // Reset về ảnh mặc định nếu không có avatar
                        log.info("No avatar found for employee: {}, using default image", employeeId);
                    }
                }
                modal.getBtnChooseImg().setVisible(false);
                modal.getTxtName().setEditable(false);
                modal.getTxtPhone().setEditable(false);
                modal.getTxtEmail().setEditable(false);
                modal.getTxtCitizen().setEditable(false);
                modal.getTxtHireDate().setEditable(false);
                modal.getCmbGender().setEnabled(false);
                modal.getCmbPosition().setEnabled(false);

                modal.saveData(ae -> GlassPanePopup.closePopupLast());
                modal.closeModel(ae -> GlassPanePopup.closePopupLast());

                GlassPanePopup.showPopup(modal);
            }
        };

        tblEmployee.setTableActionColumn(tblEmployee.getTbl(), 5, event, true);
        tblEmployee.getTbl().getColumnModel().getColumn(0).setPreferredWidth(120);
        tblEmployee.getTbl().getColumnModel().getColumn(1).setPreferredWidth(200);
        tblEmployee.getTbl().getColumnModel().getColumn(2).setPreferredWidth(120);
        tblEmployee.getTbl().getColumnModel().getColumn(3).setPreferredWidth(120);
        tblEmployee.getTbl().getColumnModel().getColumn(4).setPreferredWidth(100);
        tblEmployee.getTbl().getColumnModel().getColumn(5).setPreferredWidth(80);

        tblEmployee.getTbl().addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int col = tblEmployee.getTbl().columnAtPoint(e.getPoint());

                if (col == 5) {
                    tblEmployee.getTbl().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                } else {
                    tblEmployee.getTbl().setCursor(Cursor.getDefaultCursor());
                }
            }
        });
        headerCustom2.handleSearch(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = headerCustom2.getSearchText();
                if (text.isEmpty()) {
                    loadTable(fetchData(GET_ALL, ""));
                    return;
                }
                loadTable(fetchData(GET_BY_KEYWORD, text));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = headerCustom2.getSearchText();
                if (text.isEmpty()) {
                    loadTable(fetchData(GET_ALL, ""));
                    return;
                }
                loadTable(fetchData(GET_BY_KEYWORD, text));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        var header = tblEmployee.getTbl().getTableHeader();
        Combobox<String> cmb = new Combobox<>(new String[]{"Tất cả", "Nam", "Nữ"});
        Combobox<String> cmbChucVu = new Combobox<>(new String[]{"Tất cả", "Nhân viên lễ tân", "Nhân viên quản lý"});

        TableCellRenderer defaultRenderer = header.getDefaultRenderer();

        for (int i = 0; i < tblEmployee.getTbl().getColumnCount(); i++) {
            tblEmployee.getTbl().getColumnModel().getColumn(i).setHeaderRenderer(defaultRenderer);
        }

        TableColumn colGender = tblEmployee.getTbl().getColumnModel().getColumn(2);
        colGender.setHeaderRenderer((tbl, value, isSelected, hasFocus, row, col) -> {
            Component comp = defaultRenderer.getTableCellRendererComponent(tbl, value, isSelected, hasFocus, row, col);
            if (comp instanceof JLabel lbl) {
                String text = "Giới tính                                \u25BC";
                lbl.setText(text);
                lbl.setHorizontalAlignment(SwingConstants.LEFT);
            }
            return comp;
        });

        TableColumn colPosition = tblEmployee.getTbl().getColumnModel().getColumn(3);
        colPosition.setHeaderRenderer((tbl, value, isSelected, hasFocus, row, col) -> {
            Component comp = defaultRenderer.getTableCellRendererComponent(tbl, value, isSelected, hasFocus, row, col);
            if (comp instanceof JLabel lbl) {
                String text = "Chức vụ                               \u25BC";
                lbl.setText(text);
                lbl.setHorizontalAlignment(SwingConstants.LEFT);
            }
            return comp;
        });

        cmbChucVu.addActionListener(ev -> {
            String selectedPosition = (String) cmbChucVu.getSelectedItem();
            String selectedGender = (String) cmb.getSelectedItem();
            filterTable(selectedGender, selectedPosition);
            header.remove(cmbChucVu);
            header.repaint();
        });

        cmb.addActionListener(ev -> {
            String selectedGender = (String) cmb.getSelectedItem();
            String selectedPosition = (String) cmbChucVu.getSelectedItem();
            filterTable(selectedGender, selectedPosition);
            header.remove(cmb);
            header.repaint();
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = header.columnAtPoint(e.getPoint());
                int oldCol = activeFilterColumn;

                header.remove(cmb);
                header.remove(cmbChucVu);

                if (col != 2 && col != 3) {
                    if (activeFilterColumn != -1) {
                        activeFilterColumn = -1;
                        header.repaint(header.getHeaderRect(oldCol));
                    }
                    return;
                }

                activeFilterColumn = col;
                Rectangle rect = header.getHeaderRect(col);

                if (col == 2) {
                    cmb.setBounds(rect);
                    header.add(cmb);
                    cmb.setVisible(true);
                    cmb.showPopup();
                } else if (col == 3) {
                    cmbChucVu.setBounds(rect);
                    header.add(cmbChucVu);
                    cmbChucVu.setVisible(true);
                    cmbChucVu.showPopup();
                }
            }

        });

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        headerCustom2 = new iuh.fit.se.group1.ui.component.HeaderCustom();
        btnAddEmployee = new iuh.fit.se.group1.ui.component.custom.Button();
        tblEmployee = new iuh.fit.se.group1.ui.component.table.Table();
        lblTitleEmployee = new JLabel();
        btnExport = new iuh.fit.se.group1.ui.component.custom.Button();
        btnImport = new iuh.fit.se.group1.ui.component.custom.Button();

        setBackground(new Color(241, 241, 241));

        btnAddEmployee.setText("Thêm Nhân Viên");
        btnAddEmployee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddEmployeeActionPerformed(evt);
            }
        });

        tblEmployee.setBorder(BorderFactory.createEmptyBorder(1, 20, 20, 20));

        lblTitleEmployee.setBackground(new Color(131, 131, 131));
        lblTitleEmployee.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTitleEmployee.setForeground(new Color(102, 102, 102));
        lblTitleEmployee.setText("Danh sách nhân viên");

        btnExport.setText("Xuất Excel");
        btnExport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExport.addActionListener(e -> exportAllEmployeesToExcel());

        btnImport.setText("Tải excel");
        btnImport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(headerCustom2, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(tblEmployee, GroupLayout.PREFERRED_SIZE, 0,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(lblTitleEmployee)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAddEmployee, GroupLayout.PREFERRED_SIZE,
                                                        170, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnExport, GroupLayout.PREFERRED_SIZE, 148,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 148,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerCustom2, GroupLayout.PREFERRED_SIZE, 75,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddEmployee, GroupLayout.PREFERRED_SIZE, 43,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTitleEmployee, GroupLayout.PREFERRED_SIZE, 43,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnExport, GroupLayout.PREFERRED_SIZE, 43,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 43,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addComponent(tblEmployee, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                                .addGap(37, 37, 37)));
    }

    private void loadTable(List<EmployeeDTO> employees) {

        DefaultTableModel model = (DefaultTableModel) tblEmployee.getTbl().getModel();
        model.setRowCount(0);
        for (EmployeeDTO employee : employees) {
            String genderStr = employee.isGender() ? "Nữ" : "Nam";
            String roleName = employee.getAccount() != null && employee.getAccount().getRole() != null
                    ? employee.getAccount().getRole().getRoleName()
                    : "N/A";
            model.addRow(new Object[]{
                    employee.getEmployeeId(),
                    employee.getFullName(),
                    genderStr,
                    roleName,
                    employee.getPhone()

            });
        }
    }


    // Header style với font tùy chỉnh

    private void btnAddEmployeeActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnAddEmployeeActionPerformed

        InfoEmployeeModal modal = new InfoEmployeeModal();
        modal.getLblCode().setVisible(false);
        modal.getLblStatus().setText("Hãy chọn avatar!");
        modal.getLblStatus().setForeground(Color.red);
        if (modal.getAvatarLabel() != null) {
            modal.getAvatarLabel().resetToDefault();
        }
        modal.closeModel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GlassPanePopup.closePopupLast();
            }

        });

        modal.saveData(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean success = saveData(modal);
                if (success) {
                    GlassPanePopup.closePopupAll();
                }
            }
        });

        GlassPanePopup.showPopup(modal);
    }

    private void exportAllEmployeesToExcel() {
        try {

            Response response = employeeService.getAllEmployee();

            if (response == null || response.getCode() != 200) {
                JOptionPane.showMessageDialog(this, "Server returned HTTP Status " + (response != null ? response.getCode() : "null") + ": " + (response != null ? response.getMessage() : "No response"), "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }


            byte[] data = ExportUtil.exportTableToExcelEmployee((List<EmployeeDTO>) response.getData(), "Danh sách nhân viên");

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Lưu file Excel");

            // ✔ tên file mặc định
            String defaultFileName = "DanhSachNhanVien_" +
                    LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy")) + ".xlsx";

            fileChooser.setSelectedFile(new File(defaultFileName));

            int result = fileChooser.showSaveDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                if (!file.getName().toLowerCase().endsWith(".xlsx")) {
                    file = new File(file.getAbsolutePath() + ".xlsx");
                }

                try (FileOutputStream fos = new FileOutputStream(file)) {
                    fos.write(data);
                }

                Message.showMessage("Thành công", "Đã lưu file: " + file.getAbsolutePath());
            }

        } catch (Exception ex) {
            Message.showMessage("Lỗi", ex.getMessage());
        }

    }


    private boolean saveData(InfoEmployeeModal modal) {
        try {
            Valid result = getValid(modal, null);
            if (!result.valid) {
                return false;
            }


            try {
                int position = modal.getCmbPosition().getSelectedIndex();
                String roleId;
                if (position == 0) {
                    roleId = Role.RECEPTIONIST.toString();
                } else {
                    roleId = Role.MANAGER.toString();
                }
                EmployeeDTO employee = new EmployeeDTO();
                employee.setFullName(result.fullName);
                employee.setPhone(result.phone);
                employee.setEmail(result.email);
                employee.setGender(result.gender);
                employee.setCitizenId(result.citizenId);
                employee.setHireDate(result.hireDate);
                AvatarLabel avatarLabel = modal.getAvatarLabel();
                if (avatarLabel != null) {
                    byte[] avtBytes = avatarLabel.getImageAsBytes("jpg");
                    if (avtBytes != null && avtBytes.length > 0) {
                        employee.setAvt(avtBytes);
                        log.info("Avatar set for new employee, size: {} bytes", avtBytes.length);
                    } else {
                        log.warn("No avatar data from AvatarLabel");
                    }
                } else {
                    log.warn("AvatarLabel is null in modal");
                }

                Response response = employeeService.createEmployee(employee, roleId);
                if (response.getCode() != 200) {
                    JOptionPane.showMessageDialog(this, "Server returned HTTP Status " + response.getCode() + ": " + response.getMessage());
                    return false;
                }
                EmployeeDTO employeeSave = (EmployeeDTO) response.getData();

                if (employeeSave == null) {
                    Message.showMessage("Lỗi", "Không thể tạo nhân viên!");
                    return false;
                }

                DefaultTableModel model = (DefaultTableModel) tblEmployee.getTbl().getModel();
                String genderStr = employeeSave.isGender() ? "Nữ" : "Nam";


                model.addRow(new Object[]{
                        employeeSave.getEmployeeId(),
                        employeeSave.getFullName(),
                        genderStr,
                        employeeSave.getAccount().getRole().getRoleName(),
                        employeeSave.getPhone()
                });
                if (shiftList != null) {
                    shiftList.addNewEmployee(employeeSave);
                    log.info("Notified ShiftList about new employee: {}", employeeSave.getFullName());
                }
                Message.showMessage("Thành công", "Thêm nhân viên thành công!");
                return true;
            } catch (Exception e) {
                log.error("Error creating employee: ", e);
                Message.showMessage("Lỗi", "Có lỗi xảy ra: " + e.getMessage());
                return false;
            }
        } catch (Exception ex) {
            log.error("Error creating employee: ", ex);
            return false;
        }
    }


    private void filterTable(String genderFilter, String positionFilter) {
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) tblEmployee.getTbl()
                .getRowSorter();

        RowFilter<DefaultTableModel, Object> rf = new RowFilter() {
            @Override
            public boolean include(Entry entry) {
                String gender = entry.getStringValue(2);
                String position = entry.getStringValue(3);

                boolean genderMatches = genderFilter == null || genderFilter.equals("Tất cả")
                        || gender.equals(genderFilter);
                boolean positionMatches = positionFilter == null || positionFilter.equals("Tất cả")
                        || position.equals(positionFilter);

                return genderMatches && positionMatches;
            }

        };
        sorter.setRowFilter(rf);
        sorter.setSortKeys(null);

    }

    private static Valid getValid(InfoEmployeeModal modal, Long currentEmployeeId) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        String name = modal.getTxtName().getText().trim();
        String phone = modal.getTxtPhone().getText().trim();
        String citizenId = modal.getTxtCitizen().getText().trim();
        String email = modal.getTxtEmail().getText().trim();
        String hireDateStr = modal.getTxtHireDate().getText().trim();
        boolean gender = modal.getCmbGender().getSelectedItem() != null
                && modal.getCmbGender().getSelectedItem().toString().equalsIgnoreCase("Nữ");
        Color white = Color.WHITE;
        modal.getLblErrolName().setForeground(white);
        modal.getLblErrolPhone().setForeground(white);
        modal.getLblErrolCitizen().setForeground(white);
        modal.getLblErrolEmail().setForeground(white);
        modal.getLblErrolHireDate().setForeground(white);

        boolean valid = true;
        Color red = Color.RED;

        // Tên
        if (name.isEmpty()) {
            modal.getLblErrolName().setText("Họ tên không được để trống!");
            modal.getLblErrolName().setForeground(red);
            valid = false;
        } else if (name.matches(".*\\d.*")) {
            modal.getLblErrolName().setText("Họ tên không được chứa số!");
            modal.getLblErrolName().setForeground(red);
            valid = false;
        } else {
            String[] words = name.trim().split("\\s+");
            if (words.length < 2) {
                modal.getLblErrolName().setText("Họ tên phải có ít nhất 2 từ!");
                modal.getLblErrolName().setForeground(red);
                valid = false;
            }
        }

        // Số điện thoại
        if (phone.isEmpty()) {
            modal.getLblErrolPhone().setText("Số điện thoại không được để trống!");
            modal.getLblErrolPhone().setForeground(red);
            valid = false;
        } else if (!phone.matches("^0\\d{9}$")) {
            modal.getLblErrolPhone().setText("Số điện thoại không hợp lệ!");
            modal.getLblErrolPhone().setForeground(red);
            valid = false;
        }

        // CCCD
        if (citizenId.isEmpty()) {
            modal.getLblErrolCitizen().setText("CCCD không được để trống!");
            modal.getLblErrolCitizen().setForeground(red);
            valid = false;
        } else if (!citizenId.matches("\\d{12}")) {
            modal.getLblErrolCitizen().setText("CCCD phải có 12 chữ số!");
            modal.getLblErrolCitizen().setForeground(red);
            valid = false;
        } else {
            // Kiểm tra CCCD có tồn tại không

            Response response = SocketFacade.getInstance().getEmployee().getEmployeeByCitizenId(citizenId);

            EmployeeDTO existingEmployee = (EmployeeDTO) response.getData();
            if (existingEmployee != null) {
                if (currentEmployeeId != null) {
                    if (!existingEmployee.getEmployeeId().equals(currentEmployeeId)) {
                        modal.getLblErrolCitizen().setText("CCCD đã tồn tại!");
                        modal.getLblErrolCitizen().setForeground(red);
                        valid = false;
                    }
                } else {
                    // Đang thêm mới -> luôn báo lỗi nếu CCCD đã tồn tại
                    modal.getLblErrolCitizen().setText("CCCD đã tồn tại!");
                    modal.getLblErrolCitizen().setForeground(red);
                    valid = false;
                }
            }
            response = SocketFacade.getInstance().getEmployee().getEmployeesByPhone(phone);
            existingEmployee = (EmployeeDTO) response.getData();
            if (existingEmployee != null) {
                if (currentEmployeeId != null) {
                    if (!existingEmployee.getEmployeeId().equals(currentEmployeeId)) {
                        modal.getLblErrolPhone().setText("Số điện thoại đã tồn tại!");
                        modal.getLblErrolPhone().setForeground(red);
                        valid = false;
                    }
                } else {
//                     Đang thêm mới -> luôn báo lỗi nếu CCCD đã tồn tại

                    modal.getLblErrolPhone().setText("Số điện thoại đã tồn tại!");
                    modal.getLblErrolPhone().setForeground(red);
                    valid = false;
                }
            }
        }
        // Email
        if (email.isEmpty()) {
            modal.getLblErrolEmail().setText("Email không được để trống!");
            modal.getLblErrolEmail().setForeground(red);
            valid = false;
        } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            modal.getLblErrolEmail().setText("Email không hợp lệ!");
            modal.getLblErrolEmail().setForeground(red);
            valid = false;
        }

        // Ngày tuyển dụng
        LocalDate hireDate = null;
        try {
            if (!hireDateStr.isEmpty()) {
                hireDate = LocalDate.parse(hireDateStr, Constants.DATE_FORMATTER);
            } else {
                hireDate = LocalDate.now();
            }
        } catch (DateTimeParseException e) {
            modal.getLblErrolHireDate().setText("Ngày không hợp lệ (dd/MM/yyyy)!");
            modal.getLblErrolHireDate().setForeground(red);
            valid = false;
            log.error("Error parsing hire date: ", e);
        }
        return new Valid(name, valid, gender, phone, citizenId, email, hireDate);
    }

    private record Valid(
            String fullName,
            boolean valid,
            boolean gender,
            String phone,
            String citizenId,
            String email,
            LocalDate hireDate) {
    }

    private iuh.fit.se.group1.ui.component.custom.Button btnAddEmployee;
    private iuh.fit.se.group1.ui.component.custom.Button btnExport;
    private iuh.fit.se.group1.ui.component.custom.Button btnImport;
    private iuh.fit.se.group1.ui.component.HeaderCustom headerCustom2;
    private JLabel lblTitleEmployee;
    private iuh.fit.se.group1.ui.component.table.Table tblEmployee;


}

