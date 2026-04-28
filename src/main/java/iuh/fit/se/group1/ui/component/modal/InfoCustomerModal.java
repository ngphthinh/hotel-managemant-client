/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package iuh.fit.se.group1.ui.component.modal;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.SelectedAction;
import iuh.fit.se.group1.ui.component.custom.Button;
import iuh.fit.se.group1.ui.component.custom.Combobox;
import iuh.fit.se.group1.ui.component.custom.TextField;
import iuh.fit.se.group1.util.Constants;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Windows
 */
public class InfoCustomerModal extends javax.swing.JPanel {
    private DateChooser dateChooser;
    public Button getButton2() {
        return btnClose;
    }

    public JLabel getLblErrolEmail() {
        return lblErrolEmail;
    }

    public void setLblErrolEmail(JLabel lblErrolEmail) {
        this.lblErrolEmail = lblErrolEmail;
    }

    public void setButton2(Button button2) {
        this.btnClose = button2;
    }


    public JLabel getLblErrolCitizen() {
        return lblErrolCitizen;
    }

    public void setLblErrolCitizen(JLabel lblErrolCitizen) {
        this.lblErrolCitizen = lblErrolCitizen;
    }

    public JLabel getLblErrolDob() {
        return lblErrolDob;
    }

    public void setLblErrolDob(JLabel lblErrolDob) {
        this.lblErrolDob = lblErrolDob;
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
    
    



    public TextField getTxtCitizen() {
        return txtCitizen;
    }

    public void setTxtCitizen(TextField txtCitizen) {
        this.txtCitizen = txtCitizen;
    }

    public TextField getTxtDob() {
        return txtDob;
    }

    public void setTxtDob(TextField txtDob) {
        this.txtDob = txtDob;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }



    public TextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(TextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    public TextField getTxtName() {
        return txtName;
    }

    public void setTxtName(TextField txtName) {
        this.txtName = txtName;
    }

    public Combobox getCmbGender() {
        return cmbGender;
    }

    public void setCmbGender(Combobox cmbGender) {
        this.cmbGender = cmbGender;
    }

    
    /**
     * Creates new form InfoCustomerModal
     */
    public InfoCustomerModal() {
        initComponents();
        btnClose.setIcon(FontIcon.of(FontAwesomeSolid.TIMES, 18, Color.white));
        cmbGender.removeAllItems();
        cmbGender.addItem("Nam");
        cmbGender.setLightWeightPopupEnabled(false);
        cmbGender.addItem("Nữ");
        cmbGender.setBackground(new Color(240, 248, 255));
        cmbGender.setForeground(new Color(51, 51, 51));
        cmbGender.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12)); 
        txtDob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconDate.setIcon(FontIcon.of(FontAwesomeSolid.CALENDAR_ALT, 20, Constants.COLOR_ICON_MENU));
        iconDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        dateChooser = new DateChooser();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtDob.setText(sdf.format(new Date()));
        dateChooser.setDateFormat("dd/MM/yyyy");
        dateChooser.toDay();
        dateChooser.setForeground(Constants.COLOR_ICON_MENU);
        dateChooser.addEventDateChooser((action, date) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                dateChooser.hidePopup();
            }
        });
        dateChooser.setTextRefernce(txtDob);
        iconDate.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                dateChooser.showPopup(txtDob, 0, txtDob.getHeight());
            }
        });
        dateChooser = new DateChooser();
        dateChooser.setTextRefernce(txtDob);
        try {
            var popup = DateChooser.class.getDeclaredField("popup");
            popup.setAccessible(true);
            JPopupMenu popupMenu = (JPopupMenu) popup.get(dateChooser);
            popupMenu.setLightWeightPopupEnabled(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void closeModel (ActionListener ac) {
        btnClose.addActionListener(ac);
    }

    public void saveData(ActionListener ac) {
        btnSave.addActionListener(ac);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        lblTitle = new JLabel();
        lblName = new JLabel();
        lblPhone = new JLabel();
        lblEmail = new JLabel();
        lblGender = new JLabel();
        lblCitizen = new JLabel();
        lblDob = new JLabel();
        txtName = new TextField();
        txtPhone = new TextField();
        txtEmail = new TextField();
        txtCitizen = new TextField();
        btnSave = new Button();
        txtDob = new TextField();
        btnClose = new Button();
        iconDate = new JLabel();
        lblErrolName = new JLabel();
        lblErrolPhone = new JLabel();
        lblErrolEmail = new JLabel();
        lblErrolCitizen = new JLabel();
        lblErrolDob = new JLabel();
        cmbGender = new Combobox();

        setBackground(new Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Thông tin khách hàng");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("Tên khách hàng:");

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPhone.setText("Số điện thoại:");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmail.setText("Email:");

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGender.setText("Giới tính:");

        lblCitizen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCitizen.setText("Căn cước công dân:");

        lblDob.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDob.setText("Ngày sinh");

        txtName.setText("Trầm Hồng Viên Thiệu");
        txtName.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtPhone.setText("0977707088");

        txtEmail.setText("vienthieu692005@gmail.com");
        txtEmail.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtCitizen.setText("084205004821");
        txtCitizen.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCitizenActionPerformed(evt);
            }
        });

        btnSave.setBackground(new Color(91, 189, 64));
        btnSave.setForeground(new Color(255, 255, 255));
        btnSave.setText("Lưu");
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtDob.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDobActionPerformed(evt);
            }
        });

        btnClose.setBackground(new Color(255, 51, 0));
        btnClose.setForeground(new Color(255, 255, 255));
        btnClose.setText("");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        iconDate.setText("   ");

        lblErrolName.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolName.setForeground(new Color(255, 255, 255));
        lblErrolName.setText("Tên khách hàng không hợp lệ");

        lblErrolPhone.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolPhone.setForeground(new Color(255, 255, 255));
        lblErrolPhone.setText("Số điện thoại không hợp lệ");

        lblErrolEmail.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolEmail.setForeground(new Color(255, 255, 255));
        lblErrolEmail.setText("Email không hợp lệ");

        lblErrolCitizen.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolCitizen.setForeground(new Color(255, 255, 255));
        lblErrolCitizen.setText("Căn cước công dân không hợp lệ");

        lblErrolDob.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolDob.setForeground(new Color(255, 255, 255));
        lblErrolDob.setText("Ngày sinh không hợp lệ");

        cmbGender.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle)
                        .addGap(196, 196, 196))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(lblPhone)
                            .addComponent(lblName)
                            .addComponent(lblDob))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblGender)
                                            .addComponent(lblCitizen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblErrolName)
                                    .addComponent(lblErrolEmail)
                                    .addComponent(lblErrolPhone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrolCitizen)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbGender, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                        .addComponent(txtCitizen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErrolDob)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconDate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblGender)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lblErrolName)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhone)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCitizen)
                        .addComponent(txtCitizen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErrolPhone)
                    .addComponent(lblErrolCitizen))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lblErrolEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDob)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(iconDate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrolDob)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtDobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDobActionPerformed

    private void txtCitizenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCitizenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCitizenActionPerformed

    private void cmbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button btnClose;
    private Button btnSave;
    private Combobox cmbGender;
    private JLabel iconDate;
    private javax.swing.JProgressBar jProgressBar1;
    private JLabel lblCitizen;
    private JLabel lblDob;
    private JLabel lblEmail;
    private JLabel lblErrolCitizen;
    private JLabel lblErrolDob;
    private JLabel lblErrolEmail;
    private JLabel lblErrolName;
    private JLabel lblErrolPhone;
    private JLabel lblGender;
    private JLabel lblName;
    private JLabel lblPhone;
    private JLabel lblTitle;
    private TextField txtCitizen;
    private TextField txtDob;
    private TextField txtEmail;
    private TextField txtName;
    private TextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
