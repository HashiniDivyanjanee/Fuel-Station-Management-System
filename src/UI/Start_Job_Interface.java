package UI;

import Model.Mysql_Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Start_Job_Interface extends javax.swing.JPanel {
    String pumper, pump, tankId, fuel, status;
    Double startMeter, endmeter;
    
    // Start Current Date
    Date date = new Date();
    SimpleDateFormat formatDate = new SimpleDateFormat("YYYY-MMM-dd");
    String dt = formatDate.format(date);
    // End Current Date

    // Start Current Time
    DateTimeFormatter times = DateTimeFormatter.ofPattern("hh : mm a");
    LocalDateTime now = LocalDateTime.now();
    String tm = times.format(now);
    // End Current Time

    public Start_Job_Interface() {
        initComponents();
        showPumpDropDown();
        showPumperDropDown();
        showPumpDetails();

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
        txtFuel = new javax.swing.JTextField();
        txtTank = new javax.swing.JTextField();
        cmbPumper = new javax.swing.JComboBox<>();
        txtMeter = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        cmbPump = new javax.swing.JComboBox<>();
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
        jLabel14.setText("PUMP INFORMATION");

        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("You can enter the Pump details here");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setText("TANK ID");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("PUMPER");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel18.setText("FUEL TYPE");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setText("START METER");

        txtFuel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTank.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cmbPumper.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMeter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout details_Box1Layout = new javax.swing.GroupLayout(details_Box1);
        details_Box1.setLayout(details_Box1Layout);
        details_Box1Layout.setHorizontalGroup(
            details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_Box1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(txtTank, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtMeter, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(txtFuel, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPumper, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
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
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(10, 10, 10)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTank, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPumper, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMeter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel43.setText("SELECT PUMP");

        cmbPump.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPump.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPumpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(details_Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPump, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPump, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(details_Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(438, Short.MAX_VALUE))
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
        jLabel1.setText("JOB DETAILS");
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
                .addGap(18, 18, 18))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPumpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPumpActionPerformed
        showPumpDetails();
    }//GEN-LAST:event_cmbPumpActionPerformed

    private void clear() {
        txtTank.setText("");
        txtFuel.setText("");
        txtMeter.setText("");
        cmbPump.setSelectedIndex(0);
        cmbPumper.setSelectedIndex(0);
    }

    // Save Button
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (txtMeter.getText().isEmpty()) {
                throw new IllegalArgumentException("Start meter field cannot be empty. Please enter a valid Value.");
            }

            startMeter = Double.valueOf(txtMeter.getText());
        } catch (NumberFormatException e) {
            Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/red_warning.png"));
            JOptionPane.showMessageDialog(null, "Please check the Start Meter field. It should be a Valid Value.", "Warning", JOptionPane.INFORMATION_MESSAGE, icon);
            return;
        } catch (IllegalArgumentException e) {
            Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/red_warning.png"));
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.INFORMATION_MESSAGE, icon);
            return;
        }
        startMeter = Double.valueOf(txtMeter.getText());
        fuel = txtFuel.getText();
        tankId = txtTank.getText();
        pump = cmbPump.getSelectedItem().toString();
        pumper = cmbPumper.getSelectedItem().toString();
        status = "Active";
        endmeter = 0.00;
        String sql = "INSERT INTO schedule(pumper, pump, fueltype,StartMeter, TankID, Date, Time, Status, EndMeter) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlCheckPump = "SELECT COUNT(*) FROM schedule WHERE pump = ? AND Status = 'Active'";
        String sqlCheckPumper = "SELECT COUNT(*) FROM schedule WHERE pumper = ? AND Status = 'Active'";

        try (Connection conn = Mysql_Connection.getInstance().getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); PreparedStatement pstmtCheckPump = conn.prepareStatement(sqlCheckPump); PreparedStatement pstmtCheckPumper = conn.prepareStatement(sqlCheckPumper)) {

            pstmtCheckPump.setString(1, pump);
            ResultSet rsPump = pstmtCheckPump.executeQuery();
            rsPump.next();
            int countPump = rsPump.getInt(1);

            pstmtCheckPumper.setString(1, pumper);
            ResultSet rsPumper = pstmtCheckPumper.executeQuery();
            rsPumper.next();
            int countPumper = rsPumper.getInt(1);

            if (countPump > 0) {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/red_warning.png"));
                JOptionPane.showMessageDialog(null, "The Pump is already registered. Please enter a different Pump.", "Warning", JOptionPane.INFORMATION_MESSAGE, icon);

            } else if (countPumper > 0) {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/red_warning.png"));
                JOptionPane.showMessageDialog(null, "The Pumper is already registered. Please enter a different Pumper.", "Warning", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                pstmt.setString(1, pumper);
                pstmt.setString(2, pump);
                pstmt.setString(3, fuel);
                pstmt.setDouble(4, startMeter);
                pstmt.setString(5, tankId);
                pstmt.setString(6, dt);
                pstmt.setString(7, tm);
                pstmt.setString(8, status);
                pstmt.setDouble(9, endmeter);
                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/success.png"));
                    JOptionPane.showMessageDialog(null, "A new Schedule was inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, icon);
                    clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/error.png"));
            JOptionPane.showMessageDialog(null, "A new Schedule was inserted Failed!", "Error", JOptionPane.INFORMATION_MESSAGE, icon);
            System.out.println("Error:" + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    // Start Show Pumb name show Drop down list
    private void showPumpDropDown() {
        try {
            PreparedStatement p = Mysql_Connection.getInstance().getConnection().prepareStatement("SELECT DISTINCT `PumpID` FROM `pump`;");
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String pumpdis = r.getString("PumpID");
                cmbPump.addItem(pumpdis);
            }
            r.close();
            p.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // End Show Pumb name show Drop down list

    // Start Show Pumb name show Drop down list
    private void showPumperDropDown() {
        try {
            PreparedStatement p = Mysql_Connection.getInstance().getConnection().prepareStatement("SELECT DISTINCT CONCAT(FirstName, ' ', LastName) AS FullName\n" + "FROM employee;");
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String pumpdis = r.getString("FullName");

                cmbPumper.addItem(pumpdis);
            }
            r.close();
            p.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // End Show Pumb name show Drop down list

    // Start Capture Pump Details
    public void showPumpDetails() {
        String selectedName = (String) cmbPump.getSelectedItem();
        if (selectedName != null) {
            try {
                PreparedStatement p = Mysql_Connection.getInstance().getConnection().prepareStatement("SELECT t.TankID, t.FuelType FROM tank_pump p INNER JOIN tank t ON p.TankID = t.TankID WHERE p.pump = ?;");
                p.setString(1, selectedName);
                ResultSet r = p.executeQuery();
                if (r.next()) {
                    txtTank.setText(r.getString("TankID"));
                    txtFuel.setText(r.getString("FuelType"));
                    txtTank.setEditable(false);
                    txtFuel.setEditable(false);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbPump;
    private javax.swing.JComboBox<String> cmbPumper;
    private Components.Details_Box details_Box1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.Line line7;
    private Components.Screen screen1;
    private javax.swing.JTextField txtFuel;
    private javax.swing.JTextField txtMeter;
    private javax.swing.JTextField txtTank;
    // End of variables declaration//GEN-END:variables
}
