/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package iuh.fit.se.group1.ui.component.modal;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.SelectedAction;
import iuh.fit.se.group1.ui.component.custom.AvatarLabel;
import iuh.fit.se.group1.ui.component.custom.Button;
import iuh.fit.se.group1.ui.component.custom.Combobox;
import iuh.fit.se.group1.ui.component.custom.TextField;
import iuh.fit.se.group1.util.Constants;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Windows
 */
public class InfoEmployeeModal extends JPanel {

    public Button getBtnClose() {
        return btnClose;
    }

    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }


    public Combobox getCboGender() {
        return cmbGender;
    }

    public void setCboGender(Combobox cboGender) {
        this.cmbGender = cboGender;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JLabel getLblCode() {
        return lblCode;
    }

    public void setLblCode(JLabel lblCode) {
        this.lblCode = lblCode;
    }

    public TextField getTxtHireDate() {
        return txtHireDate;
    }

    public void setTxtHireDate(TextField txtHireDate) {
        this.txtHireDate = txtHireDate;
    }

    public Button getBtnChooseImg() {
        return btnChooseImg;
    }

    public void setBtnChooseImg(Button btnChooseImg) {
        this.btnChooseImg = btnChooseImg;
    }

    public TextField getTxtName() {
        return txtName;
    }

    public void setTxtName(TextField txtName) {
        this.txtName = txtName;
    }

    public TextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(TextField txtPhone) {
        this.txtPhone = txtPhone;
    }
    private void showImageInPanel(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            if (avatarLabel != null) {
                avatarLabel.setImage(image);
                avatarLabel.revalidate();
                avatarLabel.repaint();
                System.out.println("Image set to existing avatarLabel: " + image.getWidth() + "x" + image.getHeight());
            } else {
                System.err.println("avatarLabel is null!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể hiển thị hình ảnh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JLabel getLblStatus() {
        return lblStatus;
    }

    public void setLblStatus(JLabel lblStatus) {
        this.lblStatus = lblStatus;
    }

    public JLabel getLblTitle (){
        return lblTitle;
    }
    public AvatarLabel getAvatarLabel() {
        return avatarLabel;
    }

    public void setAvatarLabel(AvatarLabel avatarLabel) {
        this.avatarLabel = avatarLabel;
    }
    private DateChooser dateChooser;
    public InfoEmployeeModal() {
        initComponents();
        btnClose.setIcon(FontIcon.of(FontAwesomeSolid.TIMES, 18, Color.white));
        cmbGender.removeAllItems();
        cmbGender.addItem("Nữ");
        cmbGender.setLightWeightPopupEnabled(false);
        cmbGender.addItem("Nam");
        cmbGender.setBackground(new Color(240, 248, 255));
        cmbGender.setForeground(new Color(51, 51, 51));
        cmbGender.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        cmbPosition.removeAllItems();
        cmbPosition.addItem("Nhân viên lễ tân");
        cmbPosition.setLightWeightPopupEnabled(false);
        cmbPosition.addItem("Nhân viên quản lý");
        cmbPosition.setBackground(new Color(240, 248, 255));
        cmbPosition.setForeground(new Color(51, 51, 51));
        cmbPosition.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtHireDate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iconDate.setIcon(FontIcon.of(FontAwesomeSolid.CALENDAR_ALT, 20, Constants.COLOR_ICON_MENU));
        iconDate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        dateChooser = new DateChooser();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtHireDate.setText(sdf.format(new Date()));
        dateChooser.setDateFormat("dd/MM/yyyy");
        dateChooser.toDay();
        dateChooser.setForeground(Constants.COLOR_ICON_MENU);
        dateChooser.addEventDateChooser((action, date) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                dateChooser.hidePopup();
            }
        });
        dateChooser.setTextRefernce(txtHireDate);
        iconDate.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                dateChooser.showPopup(txtHireDate, 0, txtHireDate.getHeight());
            }
        });
        dateChooser = new DateChooser();
        dateChooser.setTextRefernce(txtHireDate);
        try {
            var popup = DateChooser.class.getDeclaredField("popup");
            popup.setAccessible(true);
            JPopupMenu popupMenu = (JPopupMenu) popup.get(dateChooser);
            popupMenu.setLightWeightPopupEnabled(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        btnChooseImg.setIcon(FontIcon.of(FontAwesomeSolid.PENCIL_ALT, 15, new Color(131,176,212)));
        btnChooseImg.setText("");
        btnChooseImg.setBackground(Color.WHITE);
        btnChooseImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnChooseImg.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn hình nhân viên");

            FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
                    "Hình ảnh (*.jpg, *.jpeg, *.png, *.gif)", "jpg", "jpeg", "png", "gif");
            fileChooser.setFileFilter(imageFilter);

            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String imagePath = selectedFile.getAbsolutePath();
                showImageInPanel(imagePath);
                lblStatus.setText("Đã chọn avatar!");
                lblStatus.setForeground(new Color(0, 153, 0));
            }
        });
        btnChooseImg.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnChooseImg.setIcon(FontIcon.of(FontAwesomeSolid.PENCIL_ALT, 20, new Color(100,150,200)));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnChooseImg.setIcon(FontIcon.of(FontAwesomeSolid.PENCIL_ALT, 15, new Color(131,176,212)));
            }
        });
    }

    public JLabel getLblCitizen() {
        return lblCitizen;
    }

    public void setLblCitizen(JLabel lblCitizen) {
        this.lblCitizen = lblCitizen;
    }

    public JLabel getLblErrolCitizen() {
        return lblErrolCitizen;
    }

    public void setLblErrolCitizen(JLabel lblErrolCitizen) {
        this.lblErrolCitizen = lblErrolCitizen;
    }

    public TextField getTxtCitizen() {
        return txtCitizen;
    }

    public void setTxtCitizen(TextField txtCitizen) {
        this.txtCitizen = txtCitizen;
    }

    public Combobox getCmbGender() {
        return cmbGender;
    }

    public void setCmbGender(Combobox cmbGender) {
        this.cmbGender = cmbGender;
    }

    public Combobox getCmbPosition() {
        return cmbPosition;
    }

    public void setCmbPosition(Combobox cmbPosition) {
        this.cmbPosition = cmbPosition;
    }

    public void closeModel (ActionListener ac) {
        btnClose.addActionListener(ac);
    }

    public JLabel getLblErrolHireDate() {
        return lblErrolHireDate;
    }

    public void setLblErrolHireDate(JLabel lblErrolHireDate) {
        this.lblErrolHireDate = lblErrolHireDate;
    }

    public JLabel getLblErrolEmail() {
        return lblErrolEmail;
    }

    public void setLblErrolEmail(JLabel lblErrolEmail) {
        this.lblErrolEmail = lblErrolEmail;
    }

    public JLabel getLblErrolName() {
        return lblErrolName;
    }

    public void setLblErrolName(JLabel lblErrolName) {
        this.lblErrolName = lblErrolName;
    }

    public JLabel getLblErrolPhone() {
        return lblErrolPhone;
    }

    public void setLblErrolPhone(JLabel lblErrolPhone) {
        this.lblErrolPhone = lblErrolPhone;
    }

    public void saveData(ActionListener ac) {
        btnSave.addActionListener(ac);
    }

    public Button getButton1() {
        return btnSave;
    }

    public void setButton1(Button button1) {
        this.btnSave = button1;
    }

    public Button getButton2() {
        return btnClose;
    }

    public void setButton2(Button button2) {
        this.btnClose = button2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jEditorPane1 = new JEditorPane();
        lblTitle = new JLabel();
        lblCode = new JLabel();
        lblStatus = new JLabel();
        lblName = new JLabel();
        lblGender = new JLabel();
        lblPosition = new JLabel();
        lblPhone = new JLabel();
        lblEmail = new JLabel();
        lblHireDate = new JLabel();
        txtName = new TextField();
        txtPhone = new TextField();
        txtEmail = new TextField();
        txtHireDate = new TextField();
        btnSave = new Button();
        btnClose = new Button();
        iconDate = new JLabel();
        lblErrolName = new JLabel();
        lblErrolPhone = new JLabel();
        lblErrolEmail = new JLabel();
        lblErrolHireDate = new JLabel();
        cmbGender = new Combobox();
        cmbPosition = new Combobox();
        lblCitizen = new JLabel();
        txtCitizen = new TextField();
        lblErrolCitizen = new JLabel();
        avatarLabel = new AvatarLabel();
        btnChooseImg = new Button();

        jScrollPane1.setViewportView(jEditorPane1);

        setBackground(new Color(255, 255, 255));

        lblTitle.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Thông tin nhân viên");

        lblCode.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblCode.setForeground(new Color(255, 102, 51));
        lblCode.setHorizontalAlignment(SwingConstants.CENTER);
        lblCode.setText("");

        lblStatus.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setForeground(new Color(0, 204, 0));
        lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lblStatus.setText("");

        lblName.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("Họ tên:");

        lblGender.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblGender.setText("Giới tính:");

        lblPosition.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblPosition.setText("Chức vụ:");

        lblPhone.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("Số điện thoại:");

        lblEmail.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblEmail.setText("Email:");

        lblHireDate.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblHireDate.setText("Ngày vào làm:");

        txtName.setText("");
        txtName.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtPhone.setText("");
        txtPhone.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtEmail.setText("");
        txtEmail.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtHireDate.setText("");
        txtHireDate.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHireDateActionPerformed(evt);
            }
        });

        btnSave.setBackground(new Color(91, 189, 64));
        btnSave.setForeground(new Color(255, 255, 255));
        btnSave.setText("Lưu");
        btnSave.setFont(new Font("Segoe UI", 1, 12)); // NOI18N

        btnClose.setBackground(new Color(255, 0, 0));
        btnClose.setForeground(new Color(255, 255, 255));
        btnClose.setText("");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        iconDate.setText("   ");

        lblErrolName.setFont(new Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolName.setForeground(new Color(255, 255, 255));
        lblErrolName.setText("Tên nhân viên không được bỏ trống");

        lblErrolPhone.setFont(new Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolPhone.setForeground(new Color(255, 255, 255));
        lblErrolPhone.setText("Số điện thoại không hợp lệ");

        lblErrolEmail.setFont(new Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolEmail.setForeground(new Color(255, 255, 255));
        lblErrolEmail.setText("Email không hợp lệ");

        lblErrolHireDate.setFont(new Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolHireDate.setForeground(new Color(255, 255, 255));
        lblErrolHireDate.setText("Ngày bắt đầu không hợp lệ");

        cmbGender.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });

        cmbPosition.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPositionActionPerformed(evt);
            }
        });

        lblCitizen.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblCitizen.setText("CCCD:");

        txtCitizen.setText("");
        txtCitizen.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCitizenActionPerformed(evt);
            }
        });

        lblErrolCitizen.setFont(new Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolCitizen.setForeground(new Color(255, 255, 255));
        lblErrolCitizen.setText("jLabel1");

        btnChooseImg.setBackground(new Color(204, 255, 204));
        btnChooseImg.setText("Chọn hình");
        btnChooseImg.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImgActionPerformed(evt);
            }
        });

        GroupLayout avatarLabelLayout = new GroupLayout(avatarLabel);
        avatarLabel.setLayout(avatarLabelLayout);
        avatarLabelLayout.setHorizontalGroup(
            avatarLabelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, avatarLabelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnChooseImg, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        );
        avatarLabelLayout.setVerticalGroup(
            avatarLabelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, avatarLabelLayout.createSequentialGroup()
                .addGap(0, 67, Short.MAX_VALUE)
                .addComponent(btnChooseImg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(avatarLabel, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(lblStatus, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addGap(346, 346, 346))))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)
                                .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrolEmail, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
                                .addGap(286, 286, 286))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addGap(44, 44, 44)
                                .addComponent(cmbGender, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(lblPhone))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGender)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblPosition)
                                        .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblErrolName, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(cmbPosition, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCitizen, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblHireDate))))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblErrolHireDate, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblErrolCitizen, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCitizen, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtHireDate, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(iconDate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblErrolPhone, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avatarLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrolName, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrolPhone))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGender)
                        .addComponent(cmbGender, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHireDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHireDate)
                        .addComponent(iconDate)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrolHireDate)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPosition, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPosition)
                    .addComponent(lblCitizen)
                    .addComponent(txtCitizen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lblErrolCitizen)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrolEmail)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtHireDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHireDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHireDateActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
//        java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
//    if (window != null) {
//        window.dispose();

    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void cmbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderActionPerformed

    private void cmbPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPositionActionPerformed

    private void txtCitizenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCitizenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCitizenActionPerformed

    private void btnChooseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChooseImgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AvatarLabel avatarLabel;
    private Button btnChooseImg;
    private Button btnClose;
    private Button btnSave;
    private Combobox cmbGender;
    private Combobox cmbPosition;
    private JLabel iconDate;
    private JEditorPane jEditorPane1;
    private JScrollPane jScrollPane1;
    private JLabel lblCitizen;
    private JLabel lblCode;
    private JLabel lblEmail;
    private JLabel lblErrolCitizen;
    private JLabel lblErrolEmail;
    private JLabel lblErrolHireDate;
    private JLabel lblErrolName;
    private JLabel lblErrolPhone;
    private JLabel lblGender;
    private JLabel lblHireDate;
    private JLabel lblName;
    private JLabel lblPhone;
    private JLabel lblPosition;
    private JLabel lblStatus;
    private JLabel lblTitle;
    private TextField txtCitizen;
    private TextField txtEmail;
    private TextField txtHireDate;
    private TextField txtName;
    private TextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
