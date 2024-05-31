package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Navigation extends javax.swing.JPanel {

    public Navigation() {
        initComponents();
    }

    int x=210;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Toggle1 = new javax.swing.JLabel();
        Toggle2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(8, 155, 171));

        Toggle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Toggle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Toggle.png"))); // NOI18N
        Toggle1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Toggle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Toggle1MouseClicked(evt);
            }
        });

        Toggle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Toggle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Toggle.png"))); // NOI18N
        Toggle2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Toggle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Toggle2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(Toggle1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(Toggle2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Toggle2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Toggle1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(978, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Toggle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Toggle2MouseClicked
    
        if (x==0){
            Toggle2.show();
            Toggle2.setSize(x, 552);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try {
                        for(int i=0; i<=x; i++){
                            Thread.sleep(1);
                            Toggle2.setSize(i,552);
                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
            x=210;
        }
    }//GEN-LAST:event_Toggle2MouseClicked

    private void Toggle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Toggle1MouseClicked
        if (x==210){
          Toggle1.setSize(210,552);
          Thread th = new Thread (){
              @Override
              public void run (){
                  try{
                      for (int i = 210; i>=0; i--){
                          Thread.sleep(i);
                          Toggle1.setSize(i, 552);
                      }
                  }catch (Exception e){
                      JOptionPane.showMessageDialog(null, e);
                  }
              }
          };th.start();
          x=0;
      }
    }//GEN-LAST:event_Toggle1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Toggle1;
    private javax.swing.JLabel Toggle2;
    // End of variables declaration//GEN-END:variables

class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;
        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }
        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
            
        }
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
//            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//             
        }
    }


}
