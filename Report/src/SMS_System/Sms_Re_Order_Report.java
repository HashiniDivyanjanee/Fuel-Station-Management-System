package SMS_System;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import Connection.DatabaseConnection;
import Controller.Item_Controller;
import Controller.Supplier_Controller;
import Model.Item;
import Model.Supplier;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.SwingUtilities;

public class Sms_Re_Order_Report extends javax.swing.JFrame {

    public Sms_Re_Order_Report() {
        initComponents();
        showSupp();
        showCategory();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Preview = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbSupp = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        btnFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Preview.setBackground(new java.awt.Color(255, 255, 255));
        Preview.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout PreviewLayout = new javax.swing.GroupLayout(Preview);
        Preview.setLayout(PreviewLayout);
        PreviewLayout.setHorizontalGroup(
            PreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        PreviewLayout.setVerticalGroup(
            PreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("SUPPLIER NAME");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("CATEGORY");

        btnFind.setBackground(new java.awt.Color(0, 102, 204));
        btnFind.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFind.setForeground(new java.awt.Color(255, 255, 255));
        btnFind.setText("FIND");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Preview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        try {
            Map<String, Object> parameters = new HashMap<>();
            String jasperFilePath = "JasperReport/LowStock.jrxml";

            String supplier = cmbSupp.getSelectedItem().toString();
            String category = cmbCategory.getSelectedItem().toString();

            parameters.put("ParameterSupplier", supplier);
            parameters.put("ParameterCategory", category);

            // Debugging output
            System.out.println("File exists: " + new File(jasperFilePath).exists());

            InputStream input = new FileInputStream(new File(jasperFilePath));
            JasperDesign myJasperDesign = JRXmlLoader.load(input);

            // Check if connection is closed
            System.out.println("Connection is closed: " + DatabaseConnection.getInstance().getConnection().isClosed());

            JasperReport myJasperReport = JasperCompileManager.compileReport(myJasperDesign);
            JasperPrint myJasperPrint = JasperFillManager.fillReport(myJasperReport, parameters, DatabaseConnection.getInstance().getConnection());

            JRViewer jr = new JRViewer(myJasperPrint);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Preview.removeAll();
                    Preview.setLayout(new BorderLayout());
                    Preview.add(jr, BorderLayout.CENTER);
                    Preview.revalidate();
                    Preview.repaint();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        showSupp();
//        showCategory();
    }//GEN-LAST:event_formWindowOpened

    public void showSupp() {
        try {
            Supplier_Controller supp_Controller = new Supplier_Controller();
            List<Supplier> suppliers = supp_Controller.getSupplier();
            for (Supplier supplier : suppliers) {
                cmbSupp.addItem(supplier.getSupp_Name());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showCategory() {

        try {
            Item_Controller controller = new Item_Controller();
            List<Item> categorys = controller.getItem();
            for (Item category : categorys) {
                cmbCategory.addItem(category.getCategory());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT DISTINCT `Cat_Name` FROM `items` ORDER BY `Cat_Name` ASC;");
//            ResultSet r = p.executeQuery();
//
//            while (r.next()) {
//                String category = r.getString("Cat_Name");
//
//                cmbCategory.addItem(category);
//            }
//            r.close();
//            p.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    }

    public static void main(String args[]) {
        try {
            FlatLightLaf.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sms_Re_Order_Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Preview;
    private javax.swing.JButton btnFind;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbSupp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
