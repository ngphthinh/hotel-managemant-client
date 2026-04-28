/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package iuh.fit.se.group1.ui.component.booking2;

import iuh.fit.se.group1.ui.component.custom.Button;
import iuh.fit.se.group1.ui.component.custom.Combobox;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author THIS PC
 */
public class MainFlow1 extends JPanel {

    public void resetInput (){
        resetInputDate();
        txtNumberOfAdult.setText("0");
        txtNumberOfChildren.setText("0");

    }

    /**
     * Creates new form MainFlow1
     */
    public MainFlow1() {
        initComponents();
        pnl1.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(18),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));
        cbmBookingType.addItem("Theo giờ");
        cbmBookingType.addItem("Theo ngày");
        cbmBookingType.addItem("Qua đêm");
        for (int i = 1; i < 16; i++) {
            cbmTime.addItem(i + " giờ");
        }
        btnAdultDecrement.setText("");
        btnChildDecrement.setText("");
        btnAdultDecrement.setIcon(FontIcon.of(FontAwesomeSolid.MINUS));
        btnChildDecrement.setIcon(FontIcon.of(FontAwesomeSolid.MINUS));
        btnAdultDecrement.setPreferredSize(new Dimension(30, 30));
        btnChildDecrement.setPreferredSize(new Dimension(30, 30));
        btnAdultIncrement.setText("");
        btnChildIncrement.setText("");
        btnAdultIncrement.setIcon(FontIcon.of(FontAwesomeSolid.PLUS));
        btnChildIncrement.setIcon(FontIcon.of(FontAwesomeSolid.PLUS));
        btnAdultIncrement.setPreferredSize(new Dimension(30, 30));
        btnChildIncrement.setPreferredSize(new Dimension(30, 30));
        txtCheckInDate.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),       // border ngoài
                BorderFactory.createEmptyBorder(5, 10, 5, 10)       // padding trong
        ));
        txtCheckOutDate.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),       // border ngoài
                BorderFactory.createEmptyBorder(5, 10, 5, 10)       // padding trong
        ));

        txtCheckInDate.setEditable(false);
        txtCheckOutDate.setEditable(false);
        resetInputDate();

    }

    public JTextField getTxtCheckInDate() {
        return txtCheckInDate;
    }

    public void setTxtCheckInDate(JTextField txtCheckInDate) {
        this.txtCheckInDate = txtCheckInDate;
    }

    public JTextField getTxtCheckOutDate() {
        return txtCheckOutDate;
    }

    public void setTxtCheckOutDate(JTextField txtCheckOutDate) {
        this.txtCheckOutDate = txtCheckOutDate;
    }

    public JTextField getTxtNumberOfAdult() {
        return txtNumberOfAdult;
    }

    public void setTxtNumberOfAdult(JTextField txtNumberOfAdult) {
        this.txtNumberOfAdult = txtNumberOfAdult;
    }

    public JTextField getTxtNumberOfChildren() {
        return txtNumberOfChildren;
    }

    public void setTxtNumberOfChildren(JTextField txtNumberOfChildren) {
        this.txtNumberOfChildren = txtNumberOfChildren;
    }

    public Combobox getCbmTime() {
        return cbmTime;
    }

    public void setCbmTime(Combobox cbmTime) {
        this.cbmTime = cbmTime;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

    public Combobox getCbmBookingType() {
        return cbmBookingType;
    }

    public void setCbmBookingType(Combobox cbmBookingType) {
        this.cbmBookingType = cbmBookingType;
    }

    public void setVisiableTimeBooking(boolean b) {
        cbmTime.setEnabled(b);
        if (b) {
            cbmTime.setBackground(new Color(255, 255, 255));
        } else {
            cbmTime.setBackground(new Color(240, 240, 240));
        }
    }


    public void resetInputDate() {
        LocalDateTime now = LocalDateTime.now();
        String format = "dd/MM/yyyy HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        if (cbmBookingType.getSelectedIndex() == 2) {
            now = now.withHour(20).withMinute(0);
            txtCheckInDate.setText(now.format(formatter));
            now = now.plusDays(1).withHour(10).withMinute(0);
            txtCheckOutDate.setText(now.format(formatter));
        }else if (cbmBookingType.getSelectedIndex() == 1) {
            now = now.withHour(14).withMinute(0);
            txtCheckInDate.setText(now.format(formatter));
            txtCheckOutDate.setText(format);
        }else if (cbmBookingType.getSelectedIndex() == 0) {
            txtCheckInDate.setText(now.format(formatter));
            now = now.plusHours(1);
            txtCheckOutDate.setText(now.format(formatter));
        }
        cbmTime.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new JPanel();
        lbl1 = new JLabel();
        lbl2 = new JLabel();
        lbl3 = new JLabel();
        cbmBookingType = new Combobox();
        lbl4 = new JLabel();
        lbl5 = new JLabel();
        txtCheckInDate = new JTextField();
        txtCheckOutDate = new JTextField();
        lbl6 = new JLabel();
        btnNext = new Button();
        lbl7 = new JLabel();
        cbmTime = new Combobox();
        btnAdultDecrement = new Button();
        txtNumberOfAdult = new JTextField();
        btnAdultIncrement = new Button();
        lbl8 = new JLabel();
        btnChildDecrement = new Button();
        txtNumberOfChildren = new JTextField();
        btnChildIncrement = new Button();

        setBackground(new Color(255, 255, 255));
        setForeground(new Color(241, 241, 241));

        pnl1.setBackground(new Color(185, 215, 254));

        lbl1.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        lbl1.setForeground(new Color(0, 0, 0));
        lbl1.setText("Nhập thông tin yêu cầu");

        lbl2.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lbl2.setForeground(new Color(0, 0, 0));
        lbl2.setText("Vui lòng chọn đầy đủ thông tin để tìm phòng phù hợp");

        GroupLayout pnl1Layout = new GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnl1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl2)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl3.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lbl3.setForeground(new Color(0, 0, 0));
        lbl3.setText("Hình thức thuê phòng:");

        cbmBookingType.setBackground(new Color(255, 255, 255));
        cbmBookingType.setForeground(new Color(51, 51, 51));
        cbmBookingType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmBookingTypeActionPerformed(evt);
            }
        });

        lbl4.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lbl4.setForeground(new Color(0, 0, 0));
        lbl4.setText("Thời gian trả phòng:");

        lbl5.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lbl5.setForeground(new Color(0, 0, 0));
        lbl5.setText("Thời gian nhận phòng:");

        txtCheckInDate.setBackground(new Color(255, 255, 255));
        txtCheckInDate.setForeground(new Color(51, 51, 51));
        txtCheckInDate.setText("dd/MM/yyyy hh:mm");
        txtCheckInDate.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtCheckInDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheckInDateActionPerformed(evt);
            }
        });

        txtCheckOutDate.setBackground(new Color(255, 255, 255));
        txtCheckOutDate.setForeground(new Color(51, 51, 51));
        txtCheckOutDate.setText("dd/MM/yyyy hh:mm");

        lbl6.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lbl6.setForeground(new Color(0, 0, 0));
        lbl6.setText("Số người lớn");

        btnNext.setBackground(new Color(77, 134, 168));
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setText("TIẾP THEO");
        btnNext.setBorderRadius(5);
        btnNext.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lbl7.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lbl7.setForeground(new Color(0, 0, 0));
        lbl7.setText("Thời gian thuê phòng:");

        cbmTime.setBackground(new Color(255, 255, 255));
        cbmTime.setForeground(new Color(51, 51, 51));

        btnAdultDecrement.setBackground(new Color(255, 255, 255));
        btnAdultDecrement.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnAdultDecrement.setForeground(new Color(0, 0, 0));
        btnAdultDecrement.setText("-");
        btnAdultDecrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdultDecrementActionPerformed(evt);
            }
        });

        txtNumberOfAdult.setBackground(new Color(255, 255, 255));
        txtNumberOfAdult.setHorizontalAlignment(JTextField.CENTER);
        txtNumberOfAdult.setText("0");
        txtNumberOfAdult.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        btnAdultIncrement.setBackground(new Color(255, 255, 255));
        btnAdultIncrement.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnAdultIncrement.setForeground(new Color(0, 0, 0));
        btnAdultIncrement.setText("-");
        btnAdultIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdultIncrementActionPerformed(evt);
            }
        });

        lbl8.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lbl8.setForeground(new Color(0, 0, 0));
        lbl8.setText("Số trẻ em");

        btnChildDecrement.setBackground(new Color(255, 255, 255));
        btnChildDecrement.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnChildDecrement.setForeground(new Color(0, 0, 0));
        btnChildDecrement.setText("-");
        btnChildDecrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChildDecrementActionPerformed(evt);
            }
        });

        txtNumberOfChildren.setBackground(new Color(255, 255, 255));
        txtNumberOfChildren.setHorizontalAlignment(JTextField.CENTER);
        txtNumberOfChildren.setText("0");
        txtNumberOfChildren.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        btnChildIncrement.setBackground(new Color(255, 255, 255));
        btnChildIncrement.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnChildIncrement.setForeground(new Color(0, 0, 0));
        btnChildIncrement.setText("-");
        btnChildIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChildIncrementActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl8, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnChildDecrement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumberOfChildren, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnChildIncrement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl5, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl7, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl3, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl6, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCheckOutDate, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCheckInDate, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbmBookingType, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbmTime, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAdultDecrement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtNumberOfAdult, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAdultIncrement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16))))))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(pnl1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnl1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmBookingType, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCheckInDate, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl7, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmTime, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbl4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCheckOutDate, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbl6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdultDecrement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdultIncrement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumberOfAdult, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbl8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChildDecrement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumberOfChildren, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChildIncrement, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtCheckInDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheckInDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckInDateActionPerformed

    private void btnAdultDecrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdultDecrementActionPerformed
        if (Integer.parseInt(txtNumberOfAdult.getText()) > 0) {
            int currentValue = Integer.parseInt(txtNumberOfAdult.getText());
            txtNumberOfAdult.setText(String.valueOf(currentValue - 1));
        }
    }//GEN-LAST:event_btnAdultDecrementActionPerformed

    private void btnAdultIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdultIncrementActionPerformed
        int currentValue = Integer.parseInt(txtNumberOfAdult.getText());
        txtNumberOfAdult.setText(String.valueOf(currentValue + 1));
    }//GEN-LAST:event_btnAdultIncrementActionPerformed

    private void btnChildDecrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChildDecrementActionPerformed
        if (Integer.parseInt(txtNumberOfChildren.getText()) > 0) {
            int currentValue = Integer.parseInt(txtNumberOfChildren.getText());
            txtNumberOfChildren.setText(String.valueOf(currentValue - 1));
        }
    }//GEN-LAST:event_btnChildDecrementActionPerformed

    private void btnChildIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChildIncrementActionPerformed
        int currentValue = Integer.parseInt(txtNumberOfChildren.getText());
        txtNumberOfChildren.setText(String.valueOf(currentValue + 1));
    }//GEN-LAST:event_btnChildIncrementActionPerformed

    private void cbmBookingTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmBookingTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmBookingTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button btnAdultDecrement;
    private Button btnAdultIncrement;
    private Button btnChildDecrement;
    private Button btnChildIncrement;
    private Button btnNext;
    private Combobox cbmBookingType;
    private Combobox cbmTime;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JLabel lbl5;
    private JLabel lbl6;
    private JLabel lbl7;
    private JLabel lbl8;
    private JPanel pnl1;
    private JTextField txtCheckInDate;
    private JTextField txtCheckOutDate;
    private JTextField txtNumberOfAdult;
    private JTextField txtNumberOfChildren;
    // End of variables declaration//GEN-END:variables
}
