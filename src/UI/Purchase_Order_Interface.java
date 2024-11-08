package UI;

import Calculate.Purchase_order;
import Controller.FuelController;
import Controller.PurchaseController;
import Controller.SupplierController;
import Model.Fuel;
import Model.Purchase;
import Model.Supplier;
import java.awt.Color;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Purchase_Order_Interface extends javax.swing.JPanel {

    double runningTotal = 0.0;
    double Additonal_Discount = 0.0;
    double FinalTotal = 0.00;

    double costs, qtys, discs, sub, tot;
    LocalDate Date;
    LocalTime Time;
    String fuel, id, addi, supp;

    PurchaseController purchaseController = new PurchaseController();

    public Purchase_Order_Interface() {
        initComponents();
        showFuelDropDown();
        showFuelDetails();
        showSupplierDropDown();

        
        JTableHeader Theader = tblPurchase.getTableHeader();
        Theader.setBackground(new Color(8, 114, 146));
        Theader.setForeground(Color.WHITE);
    }

    //Display Supplier in Combo Box
    private void showSupplierDropDown() {
        try {
            SupplierController controller = new SupplierController();
            List<Supplier> suppliers = controller.getSupplier();
            cmbSupplier.removeAllItems();
            for (Supplier supplier : suppliers) {
                cmbSupplier.addItem(supplier.getCompany());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Display Fuel in TextField
    private void showFuelDropDown() {
        try {
            FuelController fuelController = new FuelController();
            List<Fuel> fuels = fuelController.getAllFuel();
            cmbFuel.removeAllItems();
            for (Fuel fuel : fuels) {
                cmbFuel.addItem(fuel.getFluelName());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Show Fueil Details in TextField
    public void showFuelDetails() {
        String selectedPumper = (String) cmbFuel.getSelectedItem();
        if (selectedPumper != null) {
            try {
                FuelController fuelController = new FuelController();
                List<Fuel> fuels = fuelController.getAllFuel();
                boolean fuelFound = false;

                for (Fuel fuel : fuels) {
                    if (fuel.getFluelName().equals(selectedPumper)) {
                        txtFuelID.setText(Integer.toString(fuel.getFuelID()));
                        txtFeul.setText(fuel.getFluelName());
                        txtCost.setText(Double.toString(fuel.getCostPrice()));
                        txtSale.setText(Double.toString(fuel.getSalePrice()));
                        txtTankID.setText(fuel.getTankID());
                        txtFuelID.setEditable(false);
                        txtFeul.setEditable(false);
                        txtTankID.setEditable(false);
                    } else {

                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            txtFeul.setText("Please select a pumper.");
        }
    }

    // Add Button Code
    public void AddPurchaseDetails() {
        if (txtQty.getText().equals("")) {
            Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/red_warning.png"));
            JOptionPane.showMessageDialog(null, "Please enter Quantity.", "Warning", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            fuel = txtFeul.getText();
            costs = Double.valueOf(txtCost.getText());
            qtys = Double.valueOf(txtQty.getText());
            discs = Double.valueOf(txtDisco.getText());
            id = txtFuelID.getText();
            addi = txtAddi.getText();
            double[] x = Purchase_order.getPerTotal(costs, qtys, discs);

            String[] data = {id, fuel, String.valueOf(costs), String.valueOf(discs), String.valueOf(qtys), String.valueOf(x[0])};
            DefaultTableModel tblModel = (DefaultTableModel) tblPurchase.getModel();
            tblModel.addRow(data);
            runningTotal += x[0];
            lblTotal.setText(String.format("%.2f", runningTotal));
            Additonal_Discount = Double.valueOf(addi);
            FinalTotal = runningTotal - Additonal_Discount;
            lblFinalTotla.setText(String.format("%.2f", FinalTotal));
            Clear();
        }
    }

    //Remove Table Row
    public void RemoveTableRow() {
        DefaultTableModel tblModel = (DefaultTableModel) tblPurchase.getModel();
        if (tblPurchase.getSelectedRowCount() == 1) {
            int selectedRow = tblPurchase.getSelectedRow();
            double rowValue = Double.parseDouble(tblModel.getValueAt(selectedRow, 5).toString());
            tblModel.removeRow(selectedRow);
            runningTotal -= rowValue;

            lblTotal.setText(String.format("%.2f", runningTotal));

            FinalTotal = runningTotal - Additonal_Discount;
            lblFinalTotla.setText(String.format("%.2f", FinalTotal));
        } else {
            if (tblPurchase.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty");
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Single Row for Delete");
            }
        }
    }

    //Clear TextField
    public void Clear() {
        txtDisco.setText("0.00");
        txtQty.setText(" ");
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
        jLabel18 = new javax.swing.JLabel();
        txtTankID = new javax.swing.JTextField();
        txtSale = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtFuelID = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtFeul = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtDisco = new javax.swing.JTextField();
        details_Box2 = new Components.Details_Box();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPurchase = new javax.swing.JTable();
        lblCusID = new javax.swing.JLabel();
        btncusRemove = new javax.swing.JButton();
        lblliter = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblFinalTotla = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtAddi = new javax.swing.JTextField();
        lblTest = new javax.swing.JLabel();
        cmbFuel = new javax.swing.JComboBox<>();
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
        jLabel14.setText("FUEL INFORMATION");

        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("You can enter the Fuel details here");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setText("SALE PRICE");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel18.setText("DISCOUNT");

        txtTankID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTankID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTankIDActionPerformed(evt);
            }
        });

        txtSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel46.setText("QTY");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        txtQty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setText("FUEL ID");

        txtFuelID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setText("FUEL");

        txtFeul.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setText("COST PRICE");

        txtCost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAdd.setBackground(new java.awt.Color(8, 114, 146));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setText("TANK ID");

        txtDisco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDisco.setText("0");
        txtDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscoActionPerformed(evt);
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
                            .addComponent(txtTankID, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addGroup(details_Box1Layout.createSequentialGroup()
                                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFuelID, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addGap(51, 51, 51)
                                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28)
                                    .addComponent(txtFeul, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addGroup(details_Box1Layout.createSequentialGroup()
                                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(details_Box1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSale, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16)
                                            .addGroup(details_Box1Layout.createSequentialGroup()
                                                .addComponent(jLabel46)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7))))
                                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 60, Short.MAX_VALUE))))
        );
        details_Box1Layout.setVerticalGroup(
            details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuelID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFeul, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSale, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel46)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTankID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(12, 89, 118));
        jLabel20.setText("PURCHASE");

        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("You can see purchase order details here");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setText("SUPPLIER");

        cmbSupplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierActionPerformed(evt);
            }
        });

        tblPurchase.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblPurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fuel ID", "Fuel", "Price", "Discount", "Qty", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPurchase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblPurchase.setRowHeight(30);
        tblPurchase.setSelectionBackground(new java.awt.Color(228, 239, 242));
        tblPurchase.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPurchase);

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("SUB TOTAL");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ADDITIONAL DISCOUNT");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("TOTAL");

        lblFinalTotla.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFinalTotla.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtAddi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAddi.setText("0.00");
        txtAddi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtAddi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddiActionPerformed(evt);
            }
        });

        lblTest.setBackground(new java.awt.Color(255, 51, 204));

        javax.swing.GroupLayout details_Box2Layout = new javax.swing.GroupLayout(details_Box2);
        details_Box2.setLayout(details_Box2Layout);
        details_Box2Layout.setHorizontalGroup(
            details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblCusID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(299, 299, 299))
                    .addGroup(details_Box2Layout.createSequentialGroup()
                        .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(details_Box2Layout.createSequentialGroup()
                        .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btncusRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23)
                                .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(details_Box2Layout.createSequentialGroup()
                                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(details_Box2Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(lblliter, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(details_Box2Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(lblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(details_Box2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(details_Box2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtAddi, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(details_Box2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFinalTotla, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 60, Short.MAX_VALUE))))
        );
        details_Box2Layout.setVerticalGroup(
            details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(lblCusID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncusRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(details_Box2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblliter, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTest, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(details_Box2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(details_Box2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(details_Box2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_Box2Layout.createSequentialGroup()
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtAddi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFinalTotla, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGap(84, 84, 84))))
        );

        cmbFuel.setEditable(true);
        cmbFuel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbFuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFuelActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("FUEL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(cmbFuel, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(details_Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(details_Box2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFuel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(details_Box2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(details_Box1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(149, Short.MAX_VALUE))
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
        jLabel1.setText("PURCHASE ORDER");
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

    private void cmbFuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFuelActionPerformed
        showFuelDetails();
    }//GEN-LAST:event_cmbFuelActionPerformed

    private void txtTankIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTankIDActionPerformed

    }//GEN-LAST:event_txtTankIDActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddPurchaseDetails();
    }//GEN-LAST:event_btnAddActionPerformed


    private void cmbSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierActionPerformed

    }//GEN-LAST:event_cmbSupplierActionPerformed

    private void btncusRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncusRemoveActionPerformed
        RemoveTableRow();
    }//GEN-LAST:event_btncusRemoveActionPerformed


    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        supp = cmbSupplier.getSelectedItem().toString();
        sub = Double.valueOf(lblTotal.getText());
        discs = Double.valueOf(txtAddi.getText());
        tot = Double.valueOf(lblFinalTotla.getText());
        Date = LocalDate.now();
        Time = LocalTime.now();

        try {
            Purchase purchase = new Purchase(supp,sub,discs,tot,Date,Time);
            purchaseController.savePurchase(purchase);
        } catch (Exception e) {
              e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscoActionPerformed

    }//GEN-LAST:event_txtDiscoActionPerformed

    private void txtAddiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddiActionPerformed

    }//GEN-LAST:event_txtAddiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btncusRemove;
    private javax.swing.JComboBox<String> cmbFuel;
    private javax.swing.JComboBox<String> cmbSupplier;
    private Components.Details_Box details_Box1;
    private Components.Details_Box details_Box2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCusID;
    private javax.swing.JLabel lblFinalTotla;
    private javax.swing.JLabel lblTest;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblliter;
    private Components.Line line7;
    private Components.Screen screen1;
    private javax.swing.JTable tblPurchase;
    private javax.swing.JTextField txtAddi;
    private javax.swing.JTextField txtCost;
    public javax.swing.JTextField txtDisco;
    private javax.swing.JTextField txtFeul;
    private javax.swing.JTextField txtFuelID;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSale;
    public javax.swing.JTextField txtTankID;
    // End of variables declaration//GEN-END:variables
}
