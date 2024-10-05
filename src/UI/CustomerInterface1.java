package UI;

import javax.swing.JTextField;
import Controller.CustomerController;
import Model.Customer;
import javax.swing.JOptionPane;

public class CustomerInterface1 extends javax.swing.JPanel {

    String name, prefix, address, nic, email, cardType, ExDate, vehicleNo, vehicleType, fuel;
    int mobile, land, fax, cardNo, cvv;

    public CustomerInterface1() {
        initComponents();
        setOpaque(false);
    }

    CustomerController customerController = new CustomerController();

    private void clear() {
        txtName.setText("");
        cmbPrefix.setSelectedIndex(0);
        txtAddress.setText("");
        txtNic.setText("");
        txtEmail.setText("");
        cmbCardType.setSelectedIndex(0);
        txtVehicleRegi.setText("");
        cmbVehicleType.setSelectedIndex(0);
        cmbFuelType.setSelectedIndex(0);
        txtMobile.setText("");
        txtLand.setText("");
        txtCvv.setText("");
        txtFax.setText("");
        txtCardNo.setText("");
        DateEx.setDate(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        details_Box1 = new Components.Details_Box();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbPrefix = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNic = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        txtFax = new javax.swing.JTextField();
        txtLand = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        details_Box4 = new Components.Details_Box();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cmbFuelType = new javax.swing.JComboBox<>();
        cmbVehicleType = new javax.swing.JComboBox<>();
        txtVehicleRegi = new javax.swing.JTextField();
        details_Box2 = new Components.Details_Box();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cmbCardType = new javax.swing.JComboBox<>();
        txtCardNo = new javax.swing.JTextField();
        txtCvv = new javax.swing.JTextField();
        DateEx = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btn_cal = new javax.swing.JButton();
        screen1 = new Components.Screen();
        jLabel1 = new javax.swing.JLabel();
        line7 = new Components.Line();

        setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1800, 600));

        jPanel1.setBackground(new java.awt.Color(239, 250, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(1646, 860));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(12, 89, 118));
        jLabel14.setText("PERSONAL INFORMATION");

        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("You can enter the Customer Personal details here");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setText("CUSTOMER PREFIX");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("CUSTOMER NAME");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel18.setText("NIC");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setText("ADDRESS");

        cmbPrefix.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPrefix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr.", "Miss.", "Mrs.", "Ms.", "Prof.", "Rev." }));
        cmbPrefix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPrefixActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(12, 89, 118));
        jLabel37.setText("CONTACT INFORMATION");

        jLabel38.setForeground(new java.awt.Color(153, 153, 153));
        jLabel38.setText("You can enter the Customer Contact details here");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setText("MOBILE NUMBER");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setText("LANDLINE NUMBER");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel30.setText("FAX NUMBER");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel31.setText("EMAIL");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        txtNic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMobile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtFax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtLand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout details_Box1Layout = new javax.swing.GroupLayout(details_Box1);
        details_Box1.setLayout(details_Box1Layout);
        details_Box1Layout.setHorizontalGroup(
            details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbPrefix, 0, 295, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGroup(details_Box1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)
                    .addGroup(details_Box1Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jLabel30)
                    .addComponent(txtNic)
                    .addComponent(txtMobile)
                    .addComponent(txtFax))
                .addGap(50, 50, 50)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(details_Box1Layout.createSequentialGroup()
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(details_Box1Layout.createSequentialGroup()
                                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel31))
                                .addGap(0, 151, Short.MAX_VALUE))
                            .addComponent(txtName)
                            .addComponent(txtAddress)
                            .addComponent(txtLand)
                            .addComponent(txtEmail))
                        .addGap(60, 60, 60))
                    .addGroup(details_Box1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        details_Box1Layout.setVerticalGroup(
            details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(details_Box1Layout.createSequentialGroup()
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel4)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLand, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel3)))
                .addGap(154, 154, 154))
        );

        details_Box4.setPreferredSize(new java.awt.Dimension(802, 340));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(12, 89, 118));
        jLabel32.setText("VEHICLE INFORMATION");

        jLabel33.setForeground(new java.awt.Color(153, 153, 153));
        jLabel33.setText("You can enter the Customer Vehicle details here");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel34.setText("VEHICLE REGISTRATION NUMBER");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel35.setText("VEHICLE TYPE");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel36.setText("FUEL TYPE");

        cmbFuelType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbFuelType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Petrol", "Diesel" }));

        cmbVehicleType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbVehicleType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Car", "Truck", "Motorcycle", "Bus", "Van", "SUV (Sport Utility Vehicle)", "Pickup Truck", "Tractor", "Trailer", "RV (Recreational Vehicle)", "Electric Car", "Hybrid Car" }));

        txtVehicleRegi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout details_Box4Layout = new javax.swing.GroupLayout(details_Box4);
        details_Box4.setLayout(details_Box4Layout);
        details_Box4Layout.setHorizontalGroup(
            details_Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(details_Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32)
                    .addGroup(details_Box4Layout.createSequentialGroup()
                        .addGroup(details_Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbFuelType, 0, 295, Short.MAX_VALUE)
                            .addComponent(txtVehicleRegi))
                        .addGap(50, 50, 50)
                        .addGroup(details_Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(cmbVehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        details_Box4Layout.setVerticalGroup(
            details_Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addGroup(details_Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVehicleRegi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbVehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFuelType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(12, 89, 118));
        jLabel20.setText("PAYMENT INFORMATION");

        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("You can enter the Customer Payment details here");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel22.setText("CARD TYPE");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setText("CARD NUMBER");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setText("EXPIRY DATE");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setText("CVV");

        cmbCardType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbCardType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credit Card", "Debit Card", "Fuel Station Loyalty Card" }));

        txtCardNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCvv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout details_Box2Layout = new javax.swing.GroupLayout(details_Box2);
        details_Box2.setLayout(details_Box2Layout);
        details_Box2Layout.setHorizontalGroup(
            details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(details_Box2Layout.createSequentialGroup()
                        .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(cmbCardType, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateEx, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txtCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        details_Box2Layout.setVerticalGroup(
            details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCardType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(details_Box2Layout.createSequentialGroup()
                        .addComponent(txtCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(DateEx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(details_Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(details_Box2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(details_Box4, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(details_Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(details_Box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(details_Box4, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel2.setBackground(new java.awt.Color(8, 114, 146));

        btnClear.setBackground(new java.awt.Color(9, 161, 207));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("CANCEL");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(8, 114, 146));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btn_cal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-calculator-34.png"))); // NOI18N
        btn_cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1283, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btn_cal)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_cal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 14, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CUSTOMER");

        line7.setPreferredSize(new java.awt.Dimension(1110, 4));

        javax.swing.GroupLayout line7Layout = new javax.swing.GroupLayout(line7);
        line7.setLayout(line7Layout);
        line7Layout.setHorizontalGroup(
            line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        line7Layout.setVerticalGroup(
            line7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout screen1Layout = new javax.swing.GroupLayout(screen1);
        screen1.setLayout(screen1Layout);
        screen1Layout.setHorizontalGroup(
            screen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screen1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(screen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(line7, javax.swing.GroupLayout.DEFAULT_SIZE, 1566, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26))
        );
        screen1Layout.setVerticalGroup(
            screen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screen1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1612, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(screen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(screen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        name = txtName.getText();
        prefix = cmbPrefix.getSelectedItem().toString();
        address = txtAddress.getText();
        nic = txtNic.getText();
        email = txtEmail.getText();
        cardType = cmbCardType.getSelectedItem().toString();
        vehicleNo = txtVehicleRegi.getText();
        vehicleType = cmbVehicleType.getSelectedItem().toString();
        fuel = cmbFuelType.getSelectedItem().toString();
        mobile = Integer.valueOf(txtMobile.getText());
        land = Integer.valueOf(txtLand.getText());
        cvv = Integer.valueOf(txtCvv.getText());
        fax = Integer.valueOf(txtFax.getText());
        cardNo = Integer.valueOf(txtCardNo.getText());
        ExDate = ((JTextField) DateEx.getDateEditor().getUiComponent()).getText();

        try {
            Customer customer = new Customer(name, nic, address, mobile, land, fax, email, cardType, cardNo, ExDate, cvv, vehicleNo, vehicleType, fuel);
            customerController.saveCustomer(customer);
            clear();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btn_calActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calActionPerformed
        Calc calculator = new Calc();
        calculator.setVisible(true);
    }//GEN-LAST:event_btn_calActionPerformed

    private void cmbPrefixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPrefixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPrefixActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateEx;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btn_cal;
    private javax.swing.JComboBox<String> cmbCardType;
    private javax.swing.JComboBox<String> cmbFuelType;
    private javax.swing.JComboBox<String> cmbPrefix;
    private javax.swing.JComboBox<String> cmbVehicleType;
    private Components.Details_Box details_Box1;
    private Components.Details_Box details_Box2;
    private Components.Details_Box details_Box4;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.Line line7;
    private Components.Screen screen1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCardNo;
    private javax.swing.JTextField txtCvv;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtLand;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtVehicleRegi;
    // End of variables declaration//GEN-END:variables

}
