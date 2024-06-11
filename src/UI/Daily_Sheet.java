package UI;

import DBConnection.Mysql_Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Calculate.Final_Cash_Amount;
import java.sql.Connection;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Daily_Sheet extends javax.swing.JPanel {

    double startMeter, endMeter, salesPrice, cash;
    String startMeterText, endMeterText, Tank_ID;

    public Daily_Sheet() {
        initComponents();
        showPumperDropDown();
        showPumperDetails();
        showCustomerDropDown();

        txtCusAmount.setEditable(false);
        txtLiter.setEditable(false);
        txtAmount.setEditable(false);
        txtOutstanding.setEditable(false);
        cmbCustomer.setEditable(false);
    }

    // Start Show Pumb name show Drop down list
    private void showPumperDropDown() {
        try {
            PreparedStatement p = Mysql_Connection.getInstance().getConnection().prepareStatement("SELECT DISTINCT `pumper` FROM `schedule`;");
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String pumpdis = r.getString("pumper");

                cmbPumper.addItem(pumpdis);
            }
            r.close();
            p.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // End Show Pumb name show Drop down list

    // Start Show Customer name show Drop down list
    private void showCustomerDropDown() {
        try {
            PreparedStatement p = Mysql_Connection.getInstance().getConnection().prepareStatement("SELECT DISTINCT `Name`, `CustID` FROM `customer`;");
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String cus = r.getString("Name");
                String cusID = r.getString("CustID");
                cmbCustomer.addItem(cus);
                lblCusID.setText(cusID);
            }
            r.close();
            p.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // End Show Customer name show Drop down list

    // Start Capture Pump Details
    public void showPumperDetails() {
        String selectedPumper = (String) cmbPumper.getSelectedItem();

        if (selectedPumper != null) {
            try {
                PreparedStatement p = Mysql_Connection.getInstance().getConnection().prepareStatement("SELECT scheduleID, pump, fuelType, StartMeter, TankID FROM schedule  WHERE pumper = ?;");
                p.setString(1, selectedPumper);
                ResultSet r = p.executeQuery();
                if (r.next()) {
                    txtPump.setText(r.getString("pump"));
                    txtTank.setText(r.getString("TankID"));
                    txtFuel.setText(r.getString("fuelType"));
                    txtStartMeter.setText(r.getString("StartMeter"));

                    txtPump.setEditable(false);
                    txtTank.setEditable(false);
                    txtFuel.setEditable(false);
                    txtStartMeter.setEditable(false);
                } else {
                    txtTank.setText("No matching Tank found.");
                    txtFuel.setText(r.getString("No matching Fuel found."));
                }
                r.close();
                p.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    // End Capture Pump Details

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
        txtLiter = new javax.swing.JTextField();
        txtEndMeter = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        txtStartMeter = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCash = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtOutstanding = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtPump = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtTank = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtFuel = new javax.swing.JTextField();
        btnFinalize = new javax.swing.JButton();
        lblliter = new javax.swing.JLabel();
        details_Box2 = new Components.Details_Box();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtCusAmount = new javax.swing.JTextField();
        cmbCustomer = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOutStanding = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        lblCusID = new javax.swing.JLabel();
        btncusRemove = new javax.swing.JButton();
        cmbPumper = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
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
        jLabel14.setText("METER INFORMATION");

        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("You can enter the Meter details here");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setText("START METER");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("SALES LITERS");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel18.setText("END METER");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setText("AMOUNT");

        txtLiter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEndMeter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEndMeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEndMeterActionPerformed(evt);
            }
        });

        txtAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtStartMeter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel46.setText("CASH");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        txtCash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel47.setText("OUTSTANDING AMOUNT");

        txtOutstanding.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setText("PUMP ID");

        txtPump.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setText("TANK ID");

        txtTank.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setText("FUEL TYPE");

        txtFuel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnFinalize.setBackground(new java.awt.Color(8, 114, 146));
        btnFinalize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalize.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalize.setText("FINALIZE");
        btnFinalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout details_Box1Layout = new javax.swing.GroupLayout(details_Box1);
        details_Box1.setLayout(details_Box1Layout);
        details_Box1Layout.setHorizontalGroup(
            details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(details_Box1Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(details_Box1Layout.createSequentialGroup()
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFinalize, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(details_Box1Layout.createSequentialGroup()
                                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPump, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addGap(51, 51, 51)
                                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28)
                                    .addComponent(txtTank, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addGroup(details_Box1Layout.createSequentialGroup()
                                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(txtLiter, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFuel, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(details_Box1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(txtEndMeter, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOutstanding, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47))
                                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(details_Box1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(details_Box1Layout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtStartMeter, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel16)
                                                        .addGroup(details_Box1Layout.createSequentialGroup()
                                                            .addComponent(jLabel46)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel7))))
                                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(details_Box1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(lblliter, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 60, Short.MAX_VALUE))))
        );
        details_Box1Layout.setVerticalGroup(
            details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPump, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTank, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStartMeter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel5)
                    .addComponent(jLabel46)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndMeter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCash, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(details_Box1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLiter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOutstanding, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(lblliter, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(12, 89, 118));
        jLabel20.setText("OUTSTANDING CUSTOMER");

        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("You can enter the Outstanding Customer details here");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setText("CUSTOMER");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setText("AMOUNT");

        txtCusAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cmbCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(8, 114, 146));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblOutStanding.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer", "Amount", "Note"
            }
        ));
        jScrollPane2.setViewportView(tblOutStanding);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setText("NOTE");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane3.setViewportView(txtNote);

        lblCusID.setForeground(new java.awt.Color(255, 255, 255));

        btncusRemove.setBackground(new java.awt.Color(153, 153, 153));
        btncusRemove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncusRemove.setForeground(new java.awt.Color(255, 255, 255));
        btncusRemove.setText("REMOVE");
        btncusRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncusRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout details_Box2Layout = new javax.swing.GroupLayout(details_Box2);
        details_Box2.setLayout(details_Box2Layout);
        details_Box2Layout.setHorizontalGroup(
            details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(details_Box2Layout.createSequentialGroup()
                            .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21)
                                .addComponent(jLabel23)
                                .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24)
                                .addComponent(txtCusAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(details_Box2Layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box2Layout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box2Layout.createSequentialGroup()
                                            .addComponent(lblCusID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(255, 255, 255))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box2Layout.createSequentialGroup()
                                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btncusRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        details_Box2Layout.setVerticalGroup(
            details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(lblCusID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCusAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncusRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );

        cmbPumper.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPumper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPumperActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("SELECT EMPLOYEE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(cmbPumper, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(details_Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(details_Box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPumper, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(details_Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(details_Box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel2.setBackground(new java.awt.Color(8, 114, 146));

        jButton2.setBackground(new java.awt.Color(9, 161, 207));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLEAR");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("CANCEL");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSave.setBackground(new java.awt.Color(8, 114, 146));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DAILY SHEET");
        jLabel1.setToolTipText("");

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPumperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPumperActionPerformed
        showPumperDetails();
    }//GEN-LAST:event_cmbPumperActionPerformed

    private void txtEndMeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEndMeterActionPerformed

    }//GEN-LAST:event_txtEndMeterActionPerformed
    public void cal() {
        try {
            if (txtStartMeter != null && txtEndMeter != null && txtCash != null) {
                String startMeterText = txtStartMeter.getText().trim();
                String endMeterText = txtEndMeter.getText().trim();
                String cashText = txtCash.getText().trim();
                String tank = txtTank.getText().trim();

                if (!startMeterText.isEmpty() && !endMeterText.isEmpty() && !tank.isEmpty()) {
                    startMeter = Double.parseDouble(startMeterText);
                    endMeter = Double.parseDouble(endMeterText);
                    cash = Double.parseDouble(cashText);
                    double price = Final_Cash_Amount.getPriceFromDatabase(tank);
                    double[] x = Final_Cash_Amount.calc(startMeter, endMeter, price, cash);

                    txtLiter.setText(String.valueOf(x[0]));
                    txtAmount.setText(String.valueOf(x[1]));
                    txtOutstanding.setText(String.valueOf(x[2]));
                    lblliter.setText(String.valueOf(x[3]));

                    if (x[3] >= 0) {
                        txtCusAmount.setEditable(true);
                        cmbCustomer.setEditable(true);
                    }

                } else {
                    Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/warning.png"));
                    JOptionPane.showMessageDialog(null, "Same Text Field are Empty. Please try again", "Warning", JOptionPane.INFORMATION_MESSAGE, icon);

                }
            } else {
                System.out.println("Meter text fields are not initialized.");
            }
        } catch (NumberFormatException e) {
            Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/error.png"));
            JOptionPane.showMessageDialog(null, "Invalid number format. Try again", "Error", JOptionPane.INFORMATION_MESSAGE, icon);

        }
    }

    private void btnFinalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizeActionPerformed
        cal();
    }//GEN-LAST:event_btnFinalizeActionPerformed

    private void cmbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerActionPerformed

    }//GEN-LAST:event_cmbCustomerActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (txtCusAmount.getText().equals("")) {
            Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/red_warning.png"));
            JOptionPane.showMessageDialog(null, "Please enter a Amount.", "Warning", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            String selectedItem = (String) cmbCustomer.getSelectedItem();
            String amount = txtCusAmount.getText();
            String note = txtNote.getText();
            String id = lblCusID.getText();
            String[] data = {id, selectedItem, amount, note};

            DefaultTableModel tblModel = (DefaultTableModel) tblOutStanding.getModel();
            tblModel.addRow(data);
            txtCusAmount.setText("");
            txtNote.setText("");
        };
    }//GEN-LAST:event_btnAddActionPerformed

    private void btncusRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncusRemoveActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel) tblOutStanding.getModel();

        if (tblOutStanding.getSelectedRowCount() == 1) {
            tblModel.removeRow(tblOutStanding.getSelectedRow());
        } else {
            if (tblOutStanding.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty");
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Single Row for Delete");
            }
        }
    }//GEN-LAST:event_btncusRemoveActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String customer;
        Double amount;
        String note;
        int id;

        String endMeterValue = txtEndMeter.getText(); // assuming you have a text field for EndMeter value
        String selectedPumper = cmbPumper.getSelectedItem().toString();

        DefaultTableModel tblModel = (DefaultTableModel) tblOutStanding.getModel();
        if (tblModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Table is Empty");
        } else {
            String sql = "INSERT INTO customer_account (CusID, CustomerName, Amount, Note) VALUES (?,?,?,?)";
            String sql1 = "UPDATE schedule SET EndMeter = ?, Status = 'Inactive' where pumper = ?";

            try (Connection conn = Mysql_Connection.getInstance().getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {

                conn.setAutoCommit(false);
                for (int i = 0; i < tblModel.getRowCount(); i++) {
                    id = Integer.parseInt(tblModel.getValueAt(i, 0).toString());
                    customer = tblModel.getValueAt(i, 1).toString();
                    amount = Double.parseDouble(tblModel.getValueAt(i, 2).toString());
                    note = tblModel.getValueAt(i, 3).toString();

                    pstmt.setInt(1, id);
                    pstmt.setString(2, customer);
                    pstmt.setDouble(3, amount);
                    pstmt.setString(4, note);
                    pstmt.executeUpdate();

                    pstmt1.setString(1, endMeterValue);
                    pstmt1.setString(2, selectedPumper);
                    pstmt1.executeUpdate();
                }

                conn.commit();
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully");
                tblModel.setRowCount(0);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFinalize;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btncusRemove;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbPumper;
    private Components.Details_Box details_Box1;
    private Components.Details_Box details_Box2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCusID;
    private javax.swing.JLabel lblliter;
    private Components.Line line7;
    private Components.Screen screen1;
    private javax.swing.JTable tblOutStanding;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtCusAmount;
    public javax.swing.JTextField txtEndMeter;
    private javax.swing.JTextField txtFuel;
    private javax.swing.JTextField txtLiter;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JTextField txtOutstanding;
    private javax.swing.JTextField txtPump;
    private javax.swing.JTextField txtStartMeter;
    private javax.swing.JTextField txtTank;
    // End of variables declaration//GEN-END:variables
}
