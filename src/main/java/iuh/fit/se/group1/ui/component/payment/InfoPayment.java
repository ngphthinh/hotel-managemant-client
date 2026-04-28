/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package iuh.fit.se.group1.ui.component.payment;

import iuh.fit.se.group1.ui.component.booking.InfoOrderPanel;
import iuh.fit.se.group1.ui.component.custom.Combobox;
import iuh.fit.se.group1.ui.component.custom.TextField;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;


public class InfoPayment extends JPanel {


    public JLabel getIconCustomer() {
        return iconCustomer;
    }

    public void setIconCustomer(JLabel iconCustomer) {
        this.iconCustomer = iconCustomer;
    }

    public JLabel getIconRoom() {
        return iconRoom;
    }

    public void setIconRoom(JLabel iconRoom) {
        this.iconRoom = iconRoom;
    }


    public JLabel getLblCustomer() {
        return lblCustomer;
    }

    public void setLblCustomer(JLabel lblCustomer) {
        this.lblCustomer = lblCustomer;
    }

    public JLabel getLblGender() {
        return lblGender;
    }

    public void setLblGender(JLabel lblGender) {
        this.lblGender = lblGender;
    }

    public JLabel getLblMethod() {
        return lblMethod;
    }

    public void setLblMethod(JLabel lblMethod) {
        this.lblMethod = lblMethod;
    }

    public JLabel getLblName() {
        return lblName;
    }

    public void setLblName(JLabel lblName) {
        this.lblName = lblName;
    }

    public JLabel getLblPhone() {
        return lblPhone;
    }

    public void setLblPhone(JLabel lblPhone) {
        this.lblPhone = lblPhone;
    }

    public JLabel getLblTotalAmenitiAndSurchargeValue() {
        return lblPriceTotal;
    }

    public JLabel getLblPricePayment() {
        return lblPricePayment;
    }

    public void setLblPricePayment(JLabel lblPricePayment) {
        this.lblPricePayment = lblPricePayment;
    }

    public JLabel getLblPricePromotion() {
        return lblPricePromotion;
    }

    public void setLblPricePromotion(JLabel lblPricePromotion) {
        this.lblPricePromotion = lblPricePromotion;
    }

    public JLabel getLblPriceRoomValue() {
        return lblPriceRoomValue;
    }


    public JLabel getLblPriceTotal() {
        return lblPriceTotal;
    }

    public void setLblPriceTotal(JLabel lblPriceTotal) {
        this.lblPriceTotal = lblPriceTotal;
    }

    public JLabel getLblPromotion() {
        return lblPromotion;
    }

    public void setLblPromotion(JLabel lblPromotion) {
        this.lblPromotion = lblPromotion;
    }


    public JLabel getLblRoom() {
        return lblRoom;
    }

    public void setLblRoom(JLabel lblRoom) {
        this.lblRoom = lblRoom;
    }


    public JLabel getLblTotalOrder() {
        return lblTotalOrder;
    }

    public void setLblTotalOrder(JLabel lblTotalOrder) {
        this.lblTotalOrder = lblTotalOrder;
    }

    public JLabel getLblTotalPayment() {
        return lblTotalPayment;
    }

    public void setLblTotalPayment(JLabel lblTotalPayment) {
        this.lblTotalPayment = lblTotalPayment;
    }


    public JPanel getPnlPayment() {
        return pnlPayment;
    }

    public void setPnlPayment(JPanel pnlPayment) {
        this.pnlPayment = pnlPayment;
    }


//    public JPanel getPnlSurcharges() {
//        return jPanel1;
//    }
//
//    public void setPnlSurcharges(JPanel pnlSurcharges) {
//        this.jPanel1 = pnlSurcharges;
//    }

    public JScrollPane getScrRoom() {
        return scrRoom;
    }

    public void setScrRoom(JScrollPane scrRoom) {
        this.scrRoom = scrRoom;
    }


    public JSeparator getSprCustomer() {
        return sprCustomer;
    }

    public void setSprCustomer(JSeparator sprCustomer) {
        this.sprCustomer = sprCustomer;
    }


    public JSeparator getSprRoom() {
        return sprRoom;
    }

    public void setSprRoom(JSeparator sprRoom) {
        this.sprRoom = sprRoom;
    }


    public JTable getTblRoom() {
        return tblRoom;
    }

    public void setTblRoom(JTable tblRoom) {
        this.tblRoom = tblRoom;
    }

    public Combobox getCboGender() {
        return cboGender;
    }

    public void setCboGender(Combobox cboGender) {
        this.cboGender = cboGender;
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

    /**
     * Creates new form infoOrder
     */
    public InfoPayment() {
        initComponents();
        setOpaque(false);
        iconCustomer.setIcon(FontIcon.of(FontAwesomeSolid.USER, 20, new Color(131, 176, 212)));
        iconCustomer.setText("");
        lblTotalOrder.setFont(new Font("Segoe UI", Font.PLAIN, 12)); // không đậm
        lblPromotion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        iconRoom.setIcon(FontIcon.of(FontAwesomeSolid.BED, 20, new Color(131, 176, 212)));
        iconRoom.setText("");
        txtPhone.setEditable(false);
        // chỉnh style header bảng
        tblRoom.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblRoom.getTableHeader().setBackground(new Color(204, 204, 204));
        tblRoom.getTableHeader().setForeground(Color.BLACK);
        tblRoom.setRowHeight(30);
        tblRoom.getTableHeader().setPreferredSize(new Dimension(0, 30));
//        lblAmenity.setIcon(FontIcon.of(FontAwesomeSolid.SNOWFLAKE, 20, new java.awt.Color(131, 176, 212)));
//        lblSurcharge.setIcon(FontIcon.of(FontAwesomeSolid.FILE_INVOICE_DOLLAR, 20, new java.awt.Color(131, 176, 212)));
//        lblPromition.setIcon(FontIcon.of(FontAwesomeSolid.TAGS, 20, new java.awt.Color(131, 176, 212)));
        cboGender.addItem("Nữ");
        cboGender.addItem("Nam");
        cboGender.setBackground(Color.WHITE);
        infoPromotionOrderPanel1.setVisible(false);
    }

    public JButton getBtnCash() {
        return btnCash;
    }

    public void setBtnCash(JButton btnCash) {
        this.btnCash = btnCash;
    }

    public JButton getBtnTransfer() {
        return btnTransfer;
    }

    public void setBtnTransfer(JButton btnTransfer) {
        this.btnTransfer = btnTransfer;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 5;         // độ cong góc
        int shadowSize = 5;   // độ dày bóng
        int width = getWidth();
        int height = getHeight();

        Color shadowColor = new Color(0, 0, 0, 50);
        g2.setColor(shadowColor);
        g2.fillRoundRect(shadowSize, shadowSize, width - shadowSize, height - shadowSize, arc, arc);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width - shadowSize, height - shadowSize, arc, arc);

        g2.dispose();

        super.paintComponent(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sprCustomer = new JSeparator();
        lblCustomer = new JLabel();
        iconCustomer = new JLabel();
        lblName = new JLabel();
        txtName = new TextField();
        lblGender = new JLabel();
        lblPhone = new JLabel();
        txtPhone = new TextField();
        pnlPayment = new JPanel();
        lblTotalOrder = new JLabel();
        lblPriceTotal = new JLabel();
        lblPromotion = new JLabel();
        lblPricePromotion = new JLabel();
        lblTotalPayment = new JLabel();
        lblPricePayment = new JLabel();
        lblMethod = new JLabel();
        btnTransfer = new JButton();
        btnCash = new JButton();
        sprRoom = new JSeparator();
        lblRoom = new JLabel();
        iconRoom = new JLabel();
        scrRoom = new JScrollPane();
        tblRoom = new JTable();
        cboGender = new Combobox();
        lblPriceRoom = new JLabel();
        lblPriceRoomValue = new JLabel();
        amenitySurchargePanel1 = new AmenitySurchargePanel();
        lblPromotionTitle = new JLabel();
        infoPromotionOrderPanel1 = new iuh.fit.se.group1.ui.component.booking.InfoPromotionOrderPanel();

        setBackground(new Color(241, 241, 241));
        setPreferredSize(new Dimension(650, 643));

        lblCustomer.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblCustomer.setForeground(new Color(131, 176, 212));
        lblCustomer.setText("Khách hàng");

        iconCustomer.setText("jLabel2");

        lblName.setFont(new Font("Segoe UI", 1, 10)); // NOI18N
        lblName.setText("Tên khách hàng:");

        txtName.setBorderRadius(5);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblGender.setFont(new Font("Segoe UI", 1, 10)); // NOI18N
        lblGender.setText("Giới tính:");

        lblPhone.setFont(new Font("Segoe UI", 1, 10)); // NOI18N
        lblPhone.setText("SĐT:");

        txtPhone.setBorderRadius(5);
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        pnlPayment.setBackground(new Color(204, 204, 204));

        lblTotalOrder.setText("Tổng hoá đơn:");

        lblPriceTotal.setFont(new Font("Segoe UI", 2, 14)); // NOI18N
        lblPriceTotal.setForeground(new Color(153, 153, 153));
        lblPriceTotal.setText("18.000.000đ");

        lblPromotion.setText("Khuyến mãi áp dụng:");

        lblPricePromotion.setFont(new Font("Segoe UI", 2, 14)); // NOI18N
        lblPricePromotion.setForeground(new Color(255, 51, 51));
        lblPricePromotion.setText("-500.000đ");

        lblTotalPayment.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblTotalPayment.setText("Tổng thanh toán:");

        lblPricePayment.setFont(new Font("Segoe UI", 2, 14)); // NOI18N
        lblPricePayment.setForeground(new Color(255, 51, 51));
        lblPricePayment.setText("17.500.000đ");

        lblMethod.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        lblMethod.setText("Hình thức thanh toán ");

        btnTransfer.setBackground(new Color(249, 115, 22));
        btnTransfer.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btnTransfer.setForeground(new Color(255, 255, 255));
        btnTransfer.setText("Chuyển khoản");
        btnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferActionPerformed(evt);
            }
        });

        btnCash.setBackground(new Color(249, 115, 22));
        btnCash.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btnCash.setForeground(new Color(255, 255, 255));
        btnCash.setText("Tiền mặt");
        btnCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCashActionPerformed(evt);
            }
        });

        GroupLayout pnlPaymentLayout = new GroupLayout(pnlPayment);
        pnlPayment.setLayout(pnlPaymentLayout);
        pnlPaymentLayout.setHorizontalGroup(
            pnlPaymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlPaymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPaymentLayout.createSequentialGroup()
                        .addComponent(lblMethod, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, pnlPaymentLayout.createSequentialGroup()
                        .addGroup(pnlPaymentLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlPaymentLayout.createSequentialGroup()
                                .addComponent(lblTotalPayment, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPricePayment, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPaymentLayout.createSequentialGroup()
                                .addComponent(lblTotalOrder)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPriceTotal, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPaymentLayout.createSequentialGroup()
                                .addComponent(lblPromotion)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPricePromotion, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPaymentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnTransfer)
                                .addGap(29, 29, 29)
                                .addComponent(btnCash, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))))
        );
        pnlPaymentLayout.setVerticalGroup(
            pnlPaymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPaymentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalOrder)
                    .addComponent(lblPriceTotal))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPaymentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPromotion)
                    .addComponent(lblPricePromotion))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPaymentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPricePayment)
                    .addComponent(lblTotalPayment))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMethod)
                .addGap(0, 0, 0)
                .addGroup(pnlPaymentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCash, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblRoom.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblRoom.setForeground(new Color(131, 176, 212));
        lblRoom.setText("Thông tin phòng");

        iconRoom.setText("jLabel13");

        tblRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Số phòng", "Loại phòng", "Giá phòng", "Thời lượng", "Tổng tiền"
            }
        ));
        scrRoom.setViewportView(tblRoom);

        cboGender.setBackground(new Color(255, 255, 255));
        cboGender.setForeground(new Color(0, 0, 0));

        lblPriceRoom.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblPriceRoom.setForeground(new Color(0, 0, 0));
        lblPriceRoom.setText("Tổng tiền");

        lblPriceRoomValue.setFont(new Font("Segoe UI", 3, 12)); // NOI18N
        lblPriceRoomValue.setForeground(new Color(0, 0, 0));
        lblPriceRoomValue.setText("0");

        lblPromotionTitle.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        lblPromotionTitle.setForeground(new Color(131, 176, 212));
        lblPromotionTitle.setText("Khuyến mãi áp dụng");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(sprRoom, GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iconCustomer)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCustomer))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboGender, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))))
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(sprCustomer)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)))
                .addComponent(pnlPayment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(scrRoom)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(lblPriceRoom, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPriceRoomValue, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconRoom)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRoom)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(amenitySurchargePanel1, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPromotionTitle, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoPromotionOrderPanel1, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPayment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(iconCustomer, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(lblCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sprCustomer, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboGender, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGender, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone)
                            .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoom, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(iconRoom))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sprRoom, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrRoom, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPriceRoom)
                    .addComponent(lblPriceRoomValue))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amenitySurchargePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(lblPromotionTitle)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPromotionOrderPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransferActionPerformed

    private void btnCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCashActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AmenitySurchargePanel amenitySurchargePanel1;
    private JButton btnCash;
    private JButton btnTransfer;
    private Combobox cboGender;
    private JLabel iconCustomer;
    private JLabel iconRoom;
    private iuh.fit.se.group1.ui.component.booking.InfoPromotionOrderPanel infoPromotionOrderPanel1;
    private JLabel lblCustomer;
    private JLabel lblGender;
    private JLabel lblMethod;
    private JLabel lblName;
    private JLabel lblPhone;
    private JLabel lblPricePayment;
    private JLabel lblPricePromotion;
    private JLabel lblPriceRoom;
    private JLabel lblPriceRoomValue;
    private JLabel lblPriceTotal;
    private JLabel lblPromotion;
    private JLabel lblPromotionTitle;
    private JLabel lblRoom;
    private JLabel lblTotalOrder;
    private JLabel lblTotalPayment;
    private JPanel pnlPayment;
    private JScrollPane scrRoom;
    private JSeparator sprCustomer;
    private JSeparator sprRoom;
    private JTable tblRoom;
    private TextField txtName;
    private TextField txtPhone;
    // End of variables declaration//GEN-END:variables

    public void addAmenity(String amenityName, BigDecimal price, String quantity) {
        InfoOrderPanel amenityOrderPanel = new InfoOrderPanel();
        amenityOrderPanel.getLblName().setText(amenityName);
        amenityOrderPanel.getLblPrice().setText(price.toString());
        amenityOrderPanel.getLblQuantity().setText(quantity);
        amenitySurchargePanel1.addAmenity(amenityOrderPanel, price);
    }

    public void addSurcharge(String surchargeName, BigDecimal price, String quantity) {
        InfoOrderPanel surchargeOrderPanel = new InfoOrderPanel();
        surchargeOrderPanel.getLblName().setText(surchargeName);
        surchargeOrderPanel.getLblPrice().setText(price.toString());
        surchargeOrderPanel.getLblQuantity().setText(quantity);

        amenitySurchargePanel1.addSurcharge(surchargeOrderPanel, price);
    }

    public void addPromotion(String promotionName, String price, String quantity) {
        infoPromotionOrderPanel1.setNamePromotion(promotionName);
        infoPromotionOrderPanel1.setPrice(price);
        infoPromotionOrderPanel1.setQuantity(quantity);
        infoPromotionOrderPanel1.setVisible(true);
    }

    public void clearAmenitiesAndSurcharges() {
        amenitySurchargePanel1.clearAll();
    }

    public void clearPromotion() {
        infoPromotionOrderPanel1.setVisible(false);
    }
}
