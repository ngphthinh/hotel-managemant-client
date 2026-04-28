/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package iuh.fit.se.group1.ui.component.modal;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.SelectedAction;
import iuh.fit.se.group1.ui.component.custom.Button;
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
public class InfoPromotionModal extends JPanel {
    private DateChooser dateChooser1;
    private DateChooser dateChooser2;

    public JLabel getLblErrolDesciption() {
        return lblErrolDesciption;
    }

    public DateChooser getDateChooser1() {
        return dateChooser1;
    }

    public void setDateChooser1(DateChooser dateChooser1) {
        this.dateChooser1 = dateChooser1;
    }

    public DateChooser getDateChooser2() {
        return dateChooser2;
    }

    public void setDateChooser2(DateChooser dateChooser2) {
        this.dateChooser2 = dateChooser2;
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

    public void setLblErrolDesciption(JLabel lblErrolDesciption) {
        this.lblErrolDesciption = lblErrolDesciption;
    }

    public TextField getTxtEndDate() {
        return txtEndDate;
    }

    public void setTxtEndDate(TextField txtEndDate) {
        this.txtEndDate = txtEndDate;
    }

    public TextField getTxtName() {
        return txtName;
    }

    public void setTxtName(TextField txtName) {
        this.txtName = txtName;
    }

    public TextField getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(TextField txtPrice) {
        this.txtPrice = txtPrice;
    }

    public TextField getTxtStarDate() {
        return txtStartDate;
    }

    public void setTxtStarDate(TextField txtStarDate) {
        this.txtStartDate = txtStarDate;
    }

    public JLabel getLblDesciption() {
        return lblDesciption;
    }

    public void setLblDesciption(JLabel lblDesciption) {
        this.lblDesciption = lblDesciption;
    }

    public JLabel getLblDiscountPersent() {
        return lblDiscountPersent;
    }

    public void setLblDiscountPersent(JLabel lblDiscountPersent) {
        this.lblDiscountPersent = lblDiscountPersent;
    }

    public JLabel getLblErrolDiscountPersent() {
        return lblErrolDiscountPersent;
    }

    public void setLblErrolDiscountPersent(JLabel lblErrolDiscountPersent) {
        this.lblErrolDiscountPersent = lblErrolDiscountPersent;
    }

    public TextField getTxtDesciption() {
        return txtDesciption;
    }

    public void setTxtDesciption(TextField txtDesciption) {
        this.txtDesciption = txtDesciption;
    }

    public TextField getTxtDiscountPersent() {
        return txtDiscountPersent;
    }

    public void setTxtDiscountPersent(TextField txtDiscountPersent) {
        this.txtDiscountPersent = txtDiscountPersent;
    }

    public JLabel getLblErrolStarDate() {
        return lblErrolStartDate;
    }

    public void setLblErrolStarDate(JLabel lblErrolStarDate) {
        this.lblErrolStartDate = lblErrolStarDate;
    }

    public JLabel getLblErrolEndDate() {
        return lblErrolEndDate;
    }

    public void setLblErrolEndDate(JLabel lblErrolEndDate) {
        this.lblErrolEndDate = lblErrolEndDate;
    }

    public JLabel getLblErrolName() {
        return lblErrolName;
    }

    public void setLblErrolName(JLabel lblErrolName) {
        this.lblErrolName = lblErrolName;
    }

    public JLabel getLblErrolPrice() {
        return lblErrolPrice;
    }

    public void setLblErrolPrice(JLabel lblErrolPrice) {
        this.lblErrolPrice = lblErrolPrice;
    }
    
    
    public void setButton1(Button button1) {
        this.btnSave = button1;
    }

    public void setButton2(Button button2) {
        this.btnClose = button2;
    }
    
    public void closeModel (ActionListener ac) {
        btnClose.addActionListener(ac);
    }

    public void saveData(ActionListener ac) {
        btnSave.addActionListener(ac);
    }

    
    /**
     * Creates new form InfoPromotionModal
     */
    public InfoPromotionModal() {
        initComponents();
        btnClose.setIcon(FontIcon.of(FontAwesomeSolid.TIMES, 18, Color.white));
        txtEndDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconDate2.setIcon(FontIcon.of(FontAwesomeSolid.CALENDAR_ALT, 20, Constants.COLOR_ICON_MENU));
        iconDate2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        dateChooser2 = new DateChooser();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtEndDate.setText(sdf.format(new Date()));
        dateChooser2.setDateFormat("dd/MM/yyyy");
        dateChooser2.toDay();
        dateChooser2.setForeground(Constants.COLOR_ICON_MENU);
        dateChooser2.addEventDateChooser((action, date) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                dateChooser2.hidePopup();
            }
        });
        dateChooser2.setTextRefernce(txtEndDate);
        iconDate2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                dateChooser2.showPopup();
            }
        });
        dateChooser2 = new DateChooser();
        dateChooser2.setTextRefernce(txtEndDate);
        try {
            var popup = DateChooser.class.getDeclaredField("popup");
            popup.setAccessible(true);
            JPopupMenu popupMenu = (JPopupMenu) popup.get(dateChooser2);
            popupMenu.setLightWeightPopupEnabled(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        txtStartDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconDate1.setIcon(FontIcon.of(FontAwesomeSolid.CALENDAR_ALT, 20, Constants.COLOR_ICON_MENU));
        iconDate1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        dateChooser1 = new DateChooser();

        txtStartDate.setText(sdf.format(new Date()));
        dateChooser1.setDateFormat("dd/MM/yyyy");
        dateChooser1.toDay();
        dateChooser1.setForeground(Constants.COLOR_ICON_MENU);
        dateChooser1.addEventDateChooser((action, date) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                dateChooser1.hidePopup();
            }
        });
        dateChooser1.setTextRefernce(txtStartDate);
        iconDate1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                dateChooser1.showPopup();
            }
        });
        dateChooser1 = new DateChooser();
        dateChooser1.setTextRefernce(txtStartDate);
        try {
            var popup = DateChooser.class.getDeclaredField("popup");
            popup.setAccessible(true);
            JPopupMenu popupMenu = (JPopupMenu) popup.get(dateChooser1);
            popupMenu.setLightWeightPopupEnabled(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new JLabel();
        lblName = new JLabel();
        lblPrice = new JLabel();
        lblStartDate = new JLabel();
        txtName = new TextField();
        txtPrice = new TextField();
        txtStartDate = new TextField();
        btnSave = new Button();
        lblEndDate = new JLabel();
        txtEndDate = new TextField();
        btnClose = new Button();
        iconDate1 = new JLabel();
        iconDate2 = new JLabel();
        lblErrolName = new JLabel();
        lblErrolPrice = new JLabel();
        lblErrolStartDate = new JLabel();
        lblErrolEndDate = new JLabel();
        lblDiscountPersent = new JLabel();
        txtDiscountPersent = new TextField();
        lblDesciption = new JLabel();
        txtDesciption = new TextField();
        lblErrolDesciption = new JLabel();
        lblErrolDiscountPersent = new JLabel();

        setBackground(new Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Thông tin khuyến mãi");

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("Tên khuyến mãi:");

        lblPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPrice.setText("Giá khuyến mãi:");

        lblStartDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStartDate.setText("Ngày tạo:");

        txtName.setText("VienThieuNe");
        txtName.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtPrice.setText("10");
        txtPrice.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        txtStartDate.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartDateActionPerformed(evt);
            }
        });

        btnSave.setBackground(new Color(91, 189, 64));
        btnSave.setForeground(new Color(255, 255, 255));
        btnSave.setText("Lưu");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblEndDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEndDate.setText("Ngày hết hạn:");

        btnClose.setBackground(new Color(255, 51, 0));
        btnClose.setForeground(new Color(255, 255, 255));
        btnClose.setText("");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        iconDate1.setText("   ");

        iconDate2.setText("   ");

        lblErrolName.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolName.setForeground(new Color(255, 255, 255));
        lblErrolName.setText("Tên khuyến mãi không hợp lệ");

        lblErrolPrice.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolPrice.setForeground(new Color(255, 255, 255));
        lblErrolPrice.setText("Giá khuyến mãi không hợp lệ");

        lblErrolStartDate.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolStartDate.setForeground(new Color(255, 255, 255));
        lblErrolStartDate.setText("Ngày tạo không hợp lệ");

        lblErrolEndDate.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolEndDate.setForeground(new Color(255, 255, 255));
        lblErrolEndDate.setText("Ngày hết hạn không hợp lệ");

        lblDiscountPersent.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDiscountPersent.setText("Phần trăm:");

        txtDiscountPersent.setText("25");
        txtDiscountPersent.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountPersentActionPerformed(evt);
            }
        });

        lblDesciption.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDesciption.setText("Mô tả:");

        txtDesciption.setText("Mẫu khuyến mãi");
        txtDesciption.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesciptionActionPerformed(evt);
            }
        });

        lblErrolDesciption.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolDesciption.setForeground(new Color(255, 255, 255));
        lblErrolDesciption.setText("jLabel3");

        lblErrolDiscountPersent.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblErrolDiscountPersent.setForeground(new Color(255, 255, 255));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblStartDate)
                            .addComponent(lblEndDate)
                            .addComponent(lblDesciption))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblErrolDesciption, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(61, 61, 61))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtDesciption, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtEndDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblErrolEndDate, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(8, 8, 8)))
                                .addComponent(iconDate2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtStartDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblErrolName, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblPrice)
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lblErrolPrice, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addComponent(lblTitle))
                                        .addGap(20, 20, 20)
                                        .addComponent(lblDiscountPersent)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblErrolDiscountPersent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDiscountPersent, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(iconDate1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErrolStartDate, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiscountPersent)
                    .addComponent(txtDiscountPersent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrolDiscountPersent, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblErrolName)
                        .addComponent(lblErrolPrice)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblStartDate)
                            .addComponent(iconDate1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtStartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrolStartDate, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndDate)
                    .addComponent(iconDate2))
                .addGap(2, 2, 2)
                .addComponent(lblErrolEndDate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesciption)
                    .addComponent(txtDesciption, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrolDesciption, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStartDateActionPerformed

    private void txtDesciptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesciptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesciptionActionPerformed

    private void txtDiscountPersentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountPersentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountPersentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button btnClose;
    private Button btnSave;
    private JLabel iconDate1;
    private JLabel iconDate2;
    private JLabel lblDesciption;
    private JLabel lblDiscountPersent;
    private JLabel lblEndDate;
    private JLabel lblErrolDesciption;
    private JLabel lblErrolDiscountPersent;
    private JLabel lblErrolEndDate;
    private JLabel lblErrolName;
    private JLabel lblErrolPrice;
    private JLabel lblErrolStartDate;
    private JLabel lblName;
    private JLabel lblPrice;
    private JLabel lblStartDate;
    private JLabel lblTitle;
    private TextField txtDesciption;
    private TextField txtDiscountPersent;
    private TextField txtEndDate;
    private TextField txtName;
    private TextField txtPrice;
    private TextField txtStartDate;

    public JLabel getLblTitle() {
        return lblTitle;
    }
    // End of variables declaration//GEN-END:variables
}
