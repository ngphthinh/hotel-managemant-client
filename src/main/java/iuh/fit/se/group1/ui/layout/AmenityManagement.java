/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package iuh.fit.se.group1.ui.layout;

import iuh.fit.se.group1.dto.AmenityDTO;
import iuh.fit.se.group1.network.ClientEventBus;
import iuh.fit.se.group1.network.Response;
import iuh.fit.se.group1.network.client.SocketFacade;
import iuh.fit.se.group1.network.client.service.AmenityServiceClient;
import iuh.fit.se.group1.network.client.service.ImportExportExcelServiceClient;
import iuh.fit.se.group1.ui.component.custom.message.Message;
import iuh.fit.se.group1.ui.component.modal.ServiceModal;
import iuh.fit.se.group1.ui.component.table.TableActionEvent;
import iuh.fit.se.group1.util.Constants;
import iuh.fit.se.group1.util.ExportUtil;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import raven.glasspanepopup.GlassPanePopup;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author THIS PC
 */
public class AmenityManagement extends JPanel {

    private static final Logger log = LoggerFactory.getLogger(AmenityManagement.class);
    private final SocketFacade socketFacade;
    private final AmenityServiceClient amenityService;
    private static final int GET_ALL = 0;
    private static final int GET_BY_KEYWORD = 1;
    private boolean subscribed = false;

    /**
     * Creates new form AmenityManagement
     */
    public AmenityManagement() {
        initComponents();
        custom();

        socketFacade = SocketFacade.getInstance();
        amenityService = socketFacade.getAmenity();
        // amenityService = new AmenityService();

        try {

            Response response = amenityService.getAllAmenities();
            if (response.getCode() != 200) {
                JOptionPane.showMessageDialog(this, "Server returned HTTP Status " + response.getCode());
                return;
            }

            loadTable((List<AmenityDTO>) response.getData());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!subscribed) {
            ClientEventBus.amenityEventBus.subscribe(response -> SwingUtilities.invokeLater(this::reloadAmenityTable));
            subscribed = true;
        }
    }

    public void reloadAmenityTable() {
        try {
            Response response = amenityService.getAllAmenities();
            if (response.getCode() != 200) {
                JOptionPane.showMessageDialog(this, "Server returned HTTP Status " + response.getCode());
                return;
            }
            loadTable((List<AmenityDTO>) response.getData());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadTable(List<AmenityDTO> amenities) {
        DefaultTableModel model = (DefaultTableModel) tblAmenity.getTbl().getModel();
        model.setRowCount(0);
        for (AmenityDTO amenity : amenities) {
            model.addRow(new Object[] { amenity.getAmenityId(), amenity.getNameAmenity(),
                    Constants.VND_FORMAT.format(amenity.getPrice()) });
        }
    }

    private void custom() {
        btnAddAmenity.setBackground(new Color(108, 165, 200));
        btnAddAmenity.setForeground(Color.WHITE);
        btnAddAmenity.setBorderRadius(10);

        btnExport.setBackground(new Color(13, 200, 7));
        btnExport.setForeground(Color.WHITE);
        btnExport.setBorderRadius(10);

        btnImport.setBackground(new Color(255, 108, 3));
        btnImport.setForeground(Color.WHITE);
        btnImport.setBorderRadius(10);
        btnImport.addActionListener(ev -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn file Excel để import dịch vụ");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                ImportExportExcelServiceClient importService = socketFacade.getImportExportExcel();

                try {
                    Response response = importService.importAmenitiesFromExcel(file);

                    if (response.getCode() != 200) {
                        JOptionPane.showMessageDialog(this,
                                "Server returned HTTP Status " + response.getCode() + ": " + response.getMessage());
                        return;
                    }

                    List<AmenityDTO> imported = (List<AmenityDTO>) response.getData();

                    if (imported != null && !imported.isEmpty()) {

                        response = amenityService.getAllAmenities();
                        if (response.getCode() != 200) {
                            JOptionPane.showMessageDialog(this, "Server returned HTTP Status " + response.getCode());
                            return;
                        }

                        List<AmenityDTO> allAmenities = (List<AmenityDTO>) response.getData();
                        allAmenities.addAll(imported);
                        loadTable(allAmenities);

                        Message.showInfo("Thành công", "Đã import " + imported.size() + " dịch vụ từ Excel!");
                    } else {
                        Message.showError("Lỗi import", "Không có dữ liệu hợp lệ trong file Excel!");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnAddAmenity.setIcon(FontIcon.of(FontAwesomeSolid.PLUS, 17, Color.WHITE), SwingConstants.RIGHT);
        btnImport.setIcon(FontIcon.of(FontAwesomeSolid.FILE_IMPORT, 17, Color.WHITE), SwingConstants.RIGHT);
        btnExport.setIcon(FontIcon.of(FontAwesomeSolid.FILE_EXPORT, 17, Color.WHITE), SwingConstants.RIGHT);

        String cols[] = { "Mã dịch vụ", "Tên dịch vụ", "Giá dịch vụ", "Chức năng" };
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        tblAmenity.getTbl().setModel(model);
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                DefaultTableModel model = (DefaultTableModel) tblAmenity.getTbl().getModel();
                String name = (String) model.getValueAt(row, 1);
                String price = String.valueOf(model.getValueAt(row, 2));

                ServiceModal modal = new ServiceModal();
                modal.getLblTitle().setText("Cập nhật dịch vụ");
                modal.getBtnSave().setText("Cập nhật");

                modal.getTxtName().setText(name);
                modal.getTxtPrice().setText(price);

                modal.closeModel(ae -> GlassPanePopup.closePopupLast());
                modal.saveData(ae -> {
                    String title = "Xác nhận cập nhật dịch vụ";
                    String message = "Bạn có chắc chắn muốn cập nhật dịch vụ này không?";
                    Message.showConfirm(title, message, () -> {
                        var result = getValid(modal);
                        if (!result.valid) {
                            return;
                        }

                        try {
                            Response response = amenityService.updateAmenity(AmenityDTO.builder()
                                    .amenityId((Long) model.getValueAt(row, 0))
                                    .nameAmenity(result.name())
                                    .price(result.price())
                                    .build());

                            if (response.getCode() != 200) {
                                JOptionPane.showMessageDialog(null, response.getMessage(), "Lỗi cập nhật dịch vụ",
                                        JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            AmenityDTO entitySave = (AmenityDTO) response.getData();

                            model.setValueAt(entitySave.getNameAmenity(), row, 1);
                            model.setValueAt(Constants.VND_FORMAT.format(entitySave.getPrice()), row, 2);

                            GlassPanePopup.closePopupLast();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    });
                });

                GlassPanePopup.showPopup(modal);
            }

            @Override
            public void onDelete(int row) {
                String title = "Xác nhận xóa dịch vụ";
                String message = "Bạn có chắc chắn muốn xóa dịch vụ này không?";
                Message.showConfirm(title, message, () -> {
                    JTable table = tblAmenity.getTbl();

                    // Nếu đang chỉnh sửa, dừng lại
                    if (table.isEditing()) {
                        table.getCellEditor().stopCellEditing();
                    }

                    // Lấy model và chỉ số dòng được chọn
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int rowDelete = table.getSelectedRow();

                    if (rowDelete >= 0) {
                        Long id = (Long) model.getValueAt(rowDelete, 0);

                        // Xóa dòng trong model
                        model.removeRow(rowDelete);

                        // Xóa trong database
                        try {
                            Response response = amenityService.deleteAmenity(id);
                            if (response.getCode() != 200) {
                                JOptionPane.showMessageDialog(null, response.getMessage(), "Lỗi xóa dịch vụ",
                                        JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    }
                });
            }

        };
        tblAmenity.setTableActionColumn(tblAmenity.getTbl(), 3, event, false);
        tblAmenity.getTbl().getColumnModel().getColumn(0).setPreferredWidth(200); // chiều rộng mong muốn
        tblAmenity.getTbl().getColumnModel().getColumn(1).setPreferredWidth(300);
        tblAmenity.getTbl().getColumnModel().getColumn(2).setPreferredWidth(200);
        tblAmenity.getTbl().getColumnModel().getColumn(3).setPreferredWidth(80);

        tblAmenity.getTbl().addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent e) {
                int col = tblAmenity.getTbl().columnAtPoint(e.getPoint());
                if (col == 3) {
                    tblAmenity.getTbl().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                } else {
                    tblAmenity.getTbl().setCursor(Cursor.getDefaultCursor());
                }
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                tblAmenity.getTbl().clearSelection();
            }
        });
        headerCustom.handleSearch(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = headerCustom.getSearchText();
                if (text.isEmpty()) {
                    fetchData(GET_ALL, null);
                    return;
                }
                fetchData(GET_BY_KEYWORD, text);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = headerCustom.getSearchText();
                if (text.isEmpty()) {
                    fetchData(GET_ALL, null);
                    return;
                }
                fetchData(GET_BY_KEYWORD, text);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

        });
    }

    public void fetchData(int type, String filter) {
        try {
            Response response = null;

            if (type == GET_BY_KEYWORD) {
                response = amenityService.getAmenityByKeyword(filter);
            } else if (type == GET_ALL) {
                response = amenityService.getAllAmenities();
            }

            if (response.getCode() != 200) {
                JOptionPane.showMessageDialog(this, "Server returned HTTP Status " + response.getCode());
                return;
            }
            loadTable((List<AmenityDTO>) response.getData());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTiTle = new JLabel();
        btnAddAmenity = new iuh.fit.se.group1.ui.component.custom.Button();
        tblAmenity = new iuh.fit.se.group1.ui.component.table.Table();
        headerCustom = new iuh.fit.se.group1.ui.component.HeaderCustom();
        btnExport = new iuh.fit.se.group1.ui.component.custom.Button();
        btnImport = new iuh.fit.se.group1.ui.component.custom.Button();

        setBackground(new Color(241, 242, 241));

        lblTiTle.setBackground(new Color(241, 241, 241));
        lblTiTle.setFont(new Font("Segoe UI", 1, 30)); // NOI18N
        lblTiTle.setForeground(new Color(102, 102, 102));
        lblTiTle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTiTle.setText("Danh sách dịch vụ");

        btnAddAmenity.setText("Thêm dịch vụ");
        btnAddAmenity.setToolTipText("");
        btnAddAmenity.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        btnAddAmenity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddAmenityActionPerformed(evt);
            }
        });

        tblAmenity.setBorder(BorderFactory.createEmptyBorder(1, 20, 20, 20));
        tblAmenity.setForeground(new Color(255, 255, 255));

        btnExport.setText("Xuất Excel");
        btnExport.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        btnExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnImport.setText("Nhập Excel");
        btnImport.setFont(new Font("Segoe UI", 1, 14)); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tblAmenity, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(headerCustom, GroupLayout.DEFAULT_SIZE, 1227, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(lblTiTle, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                                .addGap(372, 372, 372)
                                .addComponent(btnAddAmenity, GroupLayout.PREFERRED_SIZE, 148,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnExport, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(headerCustom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddAmenity, GroupLayout.PREFERRED_SIZE, 43,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTiTle, GroupLayout.PREFERRED_SIZE, 43,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnExport, GroupLayout.PREFERRED_SIZE, 43,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 43,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addComponent(tblAmenity, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(67, Short.MAX_VALUE)));

        btnExport.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAmenityActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnAddAmenityActionPerformed

        ServiceModal modal = new ServiceModal();
        modal.closeModel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GlassPanePopup.closePopupLast();
            }

        });
        modal.saveData(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                saveData(modal);
            }
        });
        GlassPanePopup.showPopup(modal);
    }// GEN-LAST:event_btnAddAmenityActionPerformed

    private void saveData(ServiceModal modal) {
        Valid result = getValid(modal);
        if (result.valid()) {
            Response response = null;
            try {
                response = amenityService.createAmenity(AmenityDTO.builder()
                        .nameAmenity(result.name())
                        .price(result.price())
                        .build());

                if (response.getCode() != 200) {
                    JOptionPane.showMessageDialog(this, response.getMessage(), "Lỗi thêm dịch vụ",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                AmenityDTO entitySave = (AmenityDTO) response.getData();
                if (entitySave == null) {
                    Message.showError("Lỗi thêm dịch vụ", "Dịch vụ với tên '" + result.name() + "' đã tồn tại!");
                    return;
                }
                DefaultTableModel model = (DefaultTableModel) tblAmenity.getTbl().getModel();
                model.addRow(new Object[] { entitySave.getAmenityId(), entitySave.getNameAmenity(),
                        Constants.VND_FORMAT.format(entitySave.getPrice()) });
                GlassPanePopup.closePopupLast();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static Valid getValid(ServiceModal modal) {
        String name = modal.getTxtName().getText().trim();
        String price = modal.getTxtPrice().getText().trim();

        modal.getLblErrolName().setText("");
        modal.getLblErrolPrice().setText("");

        Color red = Color.RED;
        modal.getLblErrolName().setForeground(red);
        modal.getLblErrolPrice().setForeground(red);

        boolean valid = true;

        if (name.isEmpty()) {
            modal.getLblErrolName().setText("Tên không được để trống!");
            valid = false;
        } else if (name.length() < 2) {
            modal.getLblErrolName().setText("Tên quá ngắn (tối thiểu 2 ký tự)!");
            valid = false;
        }

        BigDecimal priceI = BigDecimal.ZERO;
        if (price.isEmpty()) {
            modal.getLblErrolPrice().setText("Giá không được để trống!");
            valid = false;
        } else {
            try {
                priceI = Constants.parseVNDToBigDecimal(price);
                if (priceI.compareTo(BigDecimal.ZERO) <= 0) {
                    modal.getLblErrolPrice().setText("Giá phải lớn hơn 0!");
                    valid = false;
                }
            } catch (Exception e) {
                modal.getLblErrolPrice().setText("Giá phải là số hợp lệ!");
                valid = false;
                log.error("Lỗi chuyển đổi giá dịch vụ: ", e);
            }
        }
        return new Valid(name, valid, priceI);
    }

    private record Valid(String name, boolean valid, BigDecimal price) {

    }

    private void btnExportActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnExportActionPerformed

        try {

            byte[] data = ExportUtil.exportTableToExcel(tblAmenity.getTbl(), "Danh sách dịch vụ", true);

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Lưu file Excel");

            // ✔ tên file mặc định
            String defaultFileName = "DanhSachDichVu_" +
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
    }// GEN-LAST:event_btnExportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private iuh.fit.se.group1.ui.component.custom.Button btnAddAmenity;
    private iuh.fit.se.group1.ui.component.custom.Button btnExport;
    private iuh.fit.se.group1.ui.component.custom.Button btnImport;
    private iuh.fit.se.group1.ui.component.HeaderCustom headerCustom;
    private JLabel lblTiTle;
    private iuh.fit.se.group1.ui.component.table.Table tblAmenity;
    // End of variables declaration//GEN-END:variables
}
