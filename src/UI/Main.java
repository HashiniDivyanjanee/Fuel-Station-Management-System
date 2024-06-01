package UI;

import Components.Menu;
import Event.EventMenuSelected;
import Model.ModelMenu;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private Menu menu = new Menu();
    private JPanel main = new JPanel();
    private MigLayout layout;
    private Animator animator;
    private boolean menuShow;
    private static final int COLLAPSED_WIDTH = 50;
    private static final int EXPANDED_WIDTH = 260;

    public Main() {
        initComponents();
        init();
    }

    private void init() {

        layout = new MigLayout("fill", "0[]10[]0", "0[fill]0");
        screen1.setLayout(layout);
        main.setOpaque(false);
        main.setLayout(new BorderLayout());
        menu.addEventMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });

        menu.setEvent(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    showForm(new Tank());
                } else if (index == 1) {
                    showForm(new CustomerInterface());
                } else if (index == 2) {
                    showForm(new Employee_Interface());
                } else if (index == 3) {
                    showForm(new Supplier_Interface());
                } else if (index == 4) {
                    showForm(new Tank());
                } else if (index == 4) {
//                    showForm(new Mechine_Interface());
                }

            }

        });

        menu.addMenu(new ModelMenu("DASHBOARD", new ImageIcon(getClass().getResource("/Icon/dashboard.png"))));
        menu.addMenu(new ModelMenu("CUSTOMER", new ImageIcon(getClass().getResource("/Icon/costumer.png"))));
        menu.addMenu(new ModelMenu("EMPLOYEE", new ImageIcon(getClass().getResource("/Icon/employee.png"))));
        menu.addMenu(new ModelMenu("SUPPLIER", new ImageIcon(getClass().getResource("/Icon/supplier.png"))));
        menu.addMenu(new ModelMenu("TANK", new ImageIcon(getClass().getResource("/Icon/oil-barrel.png"))));
        menu.addMenu(new ModelMenu("FUEL MACHINE", new ImageIcon(getClass().getResource("/Icon/oil-barrel.png"))));
//        screen1.add(menu, "w 50!");
        screen1.add(menu, "w " + COLLAPSED_WIDTH + "!");
        screen1.add(main, "w 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuShow) {
//                    width = 50 + (150 * (1f - fraction));
                    width = EXPANDED_WIDTH - ((EXPANDED_WIDTH - COLLAPSED_WIDTH) * fraction);

                } else {
//                    width = 50 +(150*fraction);
                    width = COLLAPSED_WIDTH + ((EXPANDED_WIDTH - COLLAPSED_WIDTH) * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!");
                screen1.revalidate();
            }

            @Override
            public void end() {
                menuShow = !menuShow;
            }

        };

        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        showForm(new CustomerInterface());

    }

    private void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        screen1 = new Components.Screen();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        screen1.setPreferredSize(new java.awt.Dimension(1900, 1000));

        javax.swing.GroupLayout screen1Layout = new javax.swing.GroupLayout(screen1);
        screen1.setLayout(screen1Layout);
        screen1Layout.setHorizontalGroup(
            screen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1900, Short.MAX_VALUE)
        );
        screen1Layout.setVerticalGroup(
            screen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(screen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(screen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
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
    private Components.Screen screen1;
    // End of variables declaration//GEN-END:variables
}
