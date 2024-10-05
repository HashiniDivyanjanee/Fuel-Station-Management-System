package Main;

import Menu.MenuEvent;
import UI.CustomerInterface1;
import UI.Customer_Display;
import UI.Daily_Sheet;
import UI.Dashboard;
import UI.Employee_Display;
import UI.Employee_Interface;
import UI.Fuel_Display;
import UI.Fuel_Interface;
import UI.LowStock;
import UI.Purchase_Order;
import UI.Purchase_Order_Interface;
import UI.Shedule_Display;
import UI.Start_Job_Interface;
import UI.Supplier_Interface;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        showForm(new Dashboard());
        menu1.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                System.out.println("Form:" + index);

                if (index == 0) {
                    showForm(new Dashboard());
                } else if (index == 1 && subIndex == 1) {
                    showForm(new Purchase_Order_Interface());
                } else if (index == 1 && subIndex == 2) {
                    showForm(new Supplier_Interface());
                } else if (index == 1 && subIndex == 3) {
                    showForm(new Fuel_Interface());
                } else if (index == 2 && subIndex == 1) {
                    showForm(new Fuel_Display());
                } else if (index == 2 && subIndex == 2) {
                    showForm(new LowStock());
                } else if (index == 3 && subIndex == 1) {
                    showForm(new CustomerInterface1());
                } else if (index == 3 && subIndex == 2) {
                    showForm(new Customer_Display());
                } else if (index == 4 && subIndex == 1) {
                    showForm(new Employee_Interface());
                } else if (index == 4 && subIndex == 2) {
                    showForm(new Employee_Display());
                } else if (index == 5 && subIndex == 1) {
                    showForm(new Supplier_Interface());
                } else if (index == 5 && subIndex == 2) {
                    showForm(new Employee_Display());
                } else if (index == 6 && subIndex == 1) {
                    showForm(new Start_Job_Interface());
                } else if (index == 6 && subIndex == 2) {
                    showForm(new Daily_Sheet());
                } else if (index == 6 && subIndex == 3) {
                    showForm(new Shedule_Display());
                } else {

                }
            }
        });
    }

    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menu1 = new Menu.Menu();
        head1 = new Components.Head();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setSize(new java.awt.Dimension(1500, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(head1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(head1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE))
        );

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {

            FlatLightLaf.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private Components.Head head1;
    private javax.swing.JPanel jPanel1;
    private Menu.Menu menu1;
    // End of variables declaration//GEN-END:variables
}
