package iuh.fit.se.group1.ui.component.booking;

import javax.swing.*;
import java.awt.*;

public class InfoPromotionOrderPanel extends javax.swing.JPanel {

    public InfoPromotionOrderPanel() {
        initComponents();
        setOpaque(true);
        setBackground(new Color(223, 228, 231));
    }

    public JLabel getLblName() {
        return lblName;
    }

    public JLabel getLblPrice() {
        return lblPrice;
    }

    public JLabel getLblQuantity() {
        return lblQuantity;
    }

    public void setPrice(String price) {
        lblPrice.setText(price);
    }

    public void setNamePromotion(String name) {
        lblName.setText(name);
    }

    public void setQuantity(String quantity) {
        lblQuantity.setText(quantity);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblName = new JLabel();
        lblPrice = new JLabel();
        jLabel3 = new JLabel();
        lblQuantity = new JLabel();

        setBackground(new Color(223, 228, 231));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblName.setForeground(new Color(77, 134, 168));
        lblName.setText("Tên dịch vụ");

        lblPrice.setFont(new java.awt.Font("Segoe UI", 0, 10));
        lblPrice.setForeground(new Color(255, 108, 3));
        lblPrice.setText("100k");

        jLabel3.setForeground(new Color(102, 102, 102));
        jLabel3.setText("Số lượng:");

        lblQuantity.setText("01");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                        .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 462, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQuantity)
                                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblName)
                                                .addGap(0, 0, 0)
                                                .addComponent(lblPrice))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(lblQuantity)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private JLabel jLabel3;
    private JLabel lblName;
    private JLabel lblPrice;
    private JLabel lblQuantity;
}
