package Main;

import Connection.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Prograss.Progress;
import com.raven.chart.ModelChart;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.chart.ModelPieChart;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SalesReport extends javax.swing.JFrame {

    private JPanel panelToPrint;
    private Progress progressBar;
    private ModelChart modelChart;

    public SalesReport() {

        //Start Database Connection
        try {
            DatabaseConnection.getInstance().connecToDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyWise.class.getName()).log(Level.SEVERE, null, ex);
        }
        //End Database Connection
        
        initComponents();
        setBackground(Color.white);
        barChart();
        lineChart();
        setupMonthlyGoalListener();

        panelToPrint = roundPanel1;

    }
    private double usagePercentage = 0;
    
    
    // Start Bar Chart
    private void barChart() {
        getContentPane().setLayout(new java.awt.FlowLayout());
        ComboEmp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) ComboEmp.getSelectedItem();
                MonthModel month = (MonthModel) ComboMonth.getSelectedItem();
                String selectYearStr = (String) ComboYear.getSelectedItem();
                int selectYear = Integer.parseInt(selectYearStr);
                int salesTarget;
                int salesAchievement;
                chart.clear();

                try {
                    PreparedStatement pSalesTarget = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT SalesTarget FROM employee WHERE Fname=?");
                    pSalesTarget.setString(1, selectedName);
                    ResultSet rsSalesTarget = pSalesTarget.executeQuery();
                    if (rsSalesTarget.next()) {
                        salesTarget = rsSalesTarget.getInt("SalesTarget");
                        PreparedStatement pSalesAchievement = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT date_format(Date ,'%M') AS Month, SUM(TotalCostPrice) AS MonthlyTotal FROM invoice WHERE date_format(Date, '%Y') = ? AND EmpID = ? GROUP BY MONTH(Date)");
                        pSalesAchievement.setInt(1, selectYear);
                        pSalesAchievement.setString(2, selectedName);

                        PreparedStatement pSalesReturn = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT DATE_FORMAT(i.Date, '%M') AS Month, SUM(CASE WHEN sr.inv_Bill_ID IS NOT NULL THEN sr.TotalCostPrice ELSE 0 END) AS TotalSalesReturns FROM invoice i LEFT JOIN sales_return sr ON i.custom_inv_ID = sr.inv_Bill_ID WHERE YEAR(i.Date) = ? AND i.EmpID = ? GROUP BY MONTH(i.Date)");
                        pSalesReturn.setInt(1, selectYear);
                        pSalesReturn.setString(2, selectedName);

                        ResultSet rsSalesAchievement = pSalesAchievement.executeQuery();
                        ResultSet rsSalesReturn = pSalesReturn.executeQuery();
                        while (rsSalesAchievement.next() && rsSalesReturn.next()) {
                            String monthName = rsSalesAchievement.getString("Month");
                            double monthlyTotal = rsSalesAchievement.getDouble("MonthlyTotal");
                            double monthlyReturn = rsSalesReturn.getDouble("TotalSalesReturns");
                            chart.addData(new ModelChart(monthName, new double[]{salesTarget, monthlyTotal, monthlyReturn}));
                        }
                    } else {

                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        chart.addLegend("Total Sale Target", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Total Sale Achievement", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Return", new Color(5, 125, 0), new Color(95, 209, 69));
        chart.start();

    }
 // End Bar Chart
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressCircleUI1 = new Prograss.ProgressCircleUI();
        roundPanel1 = new Swing.RoundPanel();
        header2 = new Component.Header();
        jLabel5 = new javax.swing.JLabel();
        roundPanel2 = new Swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pieChart = new javaswingdev.chart.PieChart();
        gaugeChart = new chart.GaugeChart();
        roundPanel3 = new Swing.RoundPanel();
        lineChart = new com.raven.chart.LineChart();
        jLabel3 = new javax.swing.JLabel();
        roundPanel4 = new Swing.RoundPanel();
        chart = new com.raven.chart.Chart();
        jLabel4 = new javax.swing.JLabel();
        header3 = new Component.Header();
        btnPrint = new javax.swing.JButton();
        ComboMonth = new javax.swing.JComboBox<>();
        ComboYear = new javax.swing.JComboBox<>();
        ComboEmp = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(204, 204, 204));

        header2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setText("Employee Wise Sales Target & Summary");

        javax.swing.GroupLayout header2Layout = new javax.swing.GroupLayout(header2);
        header2.setLayout(header2Layout);
        header2Layout.setHorizontalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(471, 471, 471))
        );
        header2Layout.setVerticalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18))
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Employee Wise Goal");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Current Monthly Goal");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(115, 115, 115))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gaugeChart, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(gaugeChart, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Total Sales Analyse With Current Month & Previous Month");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(179, 179, 179))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Total Sales Target & Achievement for the Year");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(491, 491, 491))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        header3.setBackground(new java.awt.Color(255, 255, 255));

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        ComboMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMonthActionPerformed(evt);
            }
        });

        ComboYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboYearActionPerformed(evt);
            }
        });

        ComboEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout header3Layout = new javax.swing.GroupLayout(header3);
        header3.setLayout(header3Layout);
        header3Layout.setHorizontalGroup(
            header3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ComboEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrint)
                .addGap(20, 20, 20))
        );
        header3Layout.setVerticalGroup(
            header3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(header3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint)
                    .addComponent(ComboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Start Line Chart
    private void lineChart() {
    getContentPane().setLayout(new java.awt.FlowLayout());
    ComboEmp.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String selectedName = (String) ComboEmp.getSelectedItem();
            if (selectedName == null || selectedName.isEmpty()) {
                return;
            }
            try {
                Map<Integer, Double> currentMonthTotals = new HashMap<>();
                PreparedStatement pcurrentMonth = DatabaseConnection.getInstance().getConnection().prepareStatement(
                        "SELECT DATE_FORMAT(Date, '%e') AS Day, SUM(TotalCostPrice) AS TotalSum " +
                        "FROM invoice " +
                        "WHERE EmpID = ? " +
                        "AND MONTH(Date) = MONTH(CURRENT_DATE()) " +
                        "AND YEAR(Date) = YEAR(CURRENT_DATE()) " +
                        "GROUP BY Day " +
                        "ORDER BY Day;"
                );
                pcurrentMonth.setString(1, selectedName);
                ResultSet rscurrentMonth = pcurrentMonth.executeQuery();

                while (rscurrentMonth.next()) {
                    int day = rscurrentMonth.getInt("Day");
                    double totalSum = rscurrentMonth.getDouble("TotalSum");
                    System.out.println("===> " + day + " " + totalSum);
                    currentMonthTotals.put(day, totalSum);
                }
                Map<Integer, Double> previousMonthTotals = new HashMap<>();

                PreparedStatement ppreviousMonth = DatabaseConnection.getInstance().getConnection().prepareStatement(
                        "SELECT DATE_FORMAT(Date, '%e') AS Day, SUM(TotalCostPrice) AS PreviousTotalSum " +
                        "FROM invoice " +
                        "WHERE EmpID = ? " +
                        "AND MONTH(Date) = MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH)) " +
                        "AND YEAR(Date) = YEAR(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH)) " +
                        "GROUP BY Day " +
                        "ORDER BY Day;"
                );
                ppreviousMonth.setString(1, selectedName);
                ResultSet rspreviousMonth = ppreviousMonth.executeQuery();

                while (rspreviousMonth.next()) {
                    int day = rspreviousMonth.getInt("Day");
                    double totalSum = rspreviousMonth.getDouble("PreviousTotalSum");
                    previousMonthTotals.put(day, totalSum);
                }
                lineChart.clear();

                for (int i = 1; i <= 31; i++) {
                    double currentMonthTotal = currentMonthTotals.getOrDefault(i, 0.0);
                    double previousMonthTotal = previousMonthTotals.getOrDefault(i, 0.0);

                    System.out.println(i + " - " + currentMonthTotal);
                    lineChart.addData(new ModelChart(String.valueOf(i), new double[]{currentMonthTotal, previousMonthTotal}));
                }
                lineChart.start();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    });
    lineChart.addLegend("This Month", new Color(12, 84, 175), new Color(0, 108, 247));
    lineChart.addLegend("Last Month", new Color(54, 4, 143), new Color(104, 49, 200));
    lineChart.start();
}
    //End Line Chart

    
    // Start Pie Chart
private void setupMonthlyGoalListener() {
        getContentPane().setLayout(new java.awt.FlowLayout());
        ComboEmp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) ComboEmp.getSelectedItem();
                if (selectedName == null || selectedName.isEmpty()) {
                    return;
                }
                updateMonthlyTotal(selectedName);
                updateSalesTarget(selectedName);
            }
        });
    }

    private void updateMonthlyTotal(String empId) {
        try {
            PreparedStatement dailyTotal = DatabaseConnection.getInstance().getConnection().prepareStatement(
                "SELECT SUM(`TotalCostPrice`) AS TotalSumCurrentMonth " +
                "FROM `invoice` " +
                "WHERE EmpID = ? " +
                "AND MONTH(`Date`) = MONTH(CURRENT_DATE) " +
                "AND YEAR(`Date`) = YEAR(CURRENT_DATE);"
            );
            dailyTotal.setString(1, empId);
            ResultSet rsdailyTotal = dailyTotal.executeQuery();
            if (rsdailyTotal.next()) {
                int monthlyTotal = rsdailyTotal.getInt("TotalSumCurrentMonth");
                gaugeChart.setValue(monthlyTotal);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateSalesTarget(String empName) {
        try {
            PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(
                "SELECT SalesTarget FROM employee WHERE Fname = ? GROUP BY Fname;"
            );
            stmt.setString(1, empName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int salesTarget = rs.getInt("SalesTarget");
                gaugeChart.setMaximum(salesTarget);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
      private void showData(int year, int month) {
        try {
            pieChart.clearData();
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT EmpID, SUM(TotalCostPrice) AS TotalSales FROM invoice where date_format(Date, '%Y')=? and date_format(Date, '%m')=? GROUP BY EmpID;");
            p.setInt(1, year);
            p.setInt(2, month);
            ResultSet r = p.executeQuery();
            int index = 0;
            while (r.next()) {
                String EmpName = r.getString(1);
                double value = r.getDouble(2);
                pieChart.addData(new ModelPieChart(EmpName, value, getColor(index++)));
            }
            r.close();
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Color getColor(int index) {
        Color[] color = new Color[]{new Color(100, 13, 107), new Color(181, 27, 117), new Color(255, 167, 50), new Color(26, 93, 26), new Color(34, 163, 159), new Color(0, 0, 92), new Color(249, 72, 146), new Color(148, 78, 99), new Color(172, 225, 175), new Color(255, 120, 120)};
        return color[index % color.length];
    }

    // End Pie Chart
    
    

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        printRecord(panelToPrint);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try {
            DatabaseConnection.getInstance().connecToDatabase();
            showYear();
            showEmp();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_formWindowOpened

    private void ComboYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboYearActionPerformed
        if (ComboYear.getSelectedIndex() >= 0) {
            int year = Integer.valueOf(ComboYear.getSelectedItem().toString());
            try {
                ComboMonth.removeAllItems();
                showMonth(year);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ComboYearActionPerformed

    private void ComboMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMonthActionPerformed
        if (ComboMonth.getSelectedIndex() >= 0) {
            int year = Integer.valueOf(ComboYear.getSelectedItem().toString());
            MonthModel month = (MonthModel) ComboMonth.getSelectedItem();
            showData(year, month.getMonth());
        }
    }//GEN-LAST:event_ComboMonthActionPerformed

    private void ComboEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboEmpActionPerformed

    private void showEmp() {
        try {
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT DISTINCT `EmpID` FROM `invoice`;");
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String employee = r.getString("EmpID");

                ComboEmp.addItem(employee);
            }
            r.close();
            p.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showYear() throws SQLException {
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT date_format(Date,'%Y') as YearNumber FROM invoice GROUP BY YearNumber;");
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int year = r.getInt("YearNumber");
            ComboYear.addItem(year + "");
        }
        r.close();
        p.close();
    }

    private void showMonth(int year) throws SQLException {
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT date_format(Date, '%M') as MonthText, date_format(Date,'%m') as MonthNumber FROM invoice where date_format(Date, '%Y')=? group by MonthNumber;");
        p.setInt(1, year);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String monthText = r.getNString("MonthText");
            int month = r.getInt("MonthNumber");
            ComboMonth.addItem(new MonthModel(month, monthText));
        }
        r.close();
        p.close();
    }

  
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesReport().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboEmp;
    private javax.swing.JComboBox<Object> ComboMonth;
    private javax.swing.JComboBox<String> ComboYear;
    private javax.swing.JButton btnPrint;
    private com.raven.chart.Chart chart;
    private chart.GaugeChart gaugeChart;
    private Component.Header header2;
    private Component.Header header3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.raven.chart.LineChart lineChart;
    private javaswingdev.chart.PieChart pieChart;
    private Prograss.ProgressCircleUI progressCircleUI1;
    private Swing.RoundPanel roundPanel1;
    private Swing.RoundPanel roundPanel2;
    private Swing.RoundPanel roundPanel3;
    private Swing.RoundPanel roundPanel4;
    // End of variables declaration//GEN-END:variables

    
    
    // Start Print Section
    private void printRecord(JPanel panel) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Record");

        printerJob.setPrintable(new Printable() {
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D graphics2D = (Graphics2D) graphics;
                graphics2D.translate(pageFormat.getImageableX() * 2, pageFormat.getImageableY() * 2);
                graphics2D.scale(0.5, 0.5);
                panel.paint(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });

        boolean returningResult = printerJob.printDialog();
        if (returningResult) {
            try {
                printerJob.print();
            } catch (PrinterException printerException) {
                JOptionPane.showMessageDialog(this, "Print Error:" + printerException.getMessage());
            }
        }
    }
  // End Print Section
}
