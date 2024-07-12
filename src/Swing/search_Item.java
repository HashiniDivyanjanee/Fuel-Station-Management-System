package Swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class search_Item extends javax.swing.JPanel {

    public search_Item(DataSearch data) {
        initComponents();
        setData(data);
    }

    private void setData(DataSearch data) {
        addEventMouse(this);
        addEventMouse(lblText);
        addEventMouse(lblRemove);
        lblText.setText(data.getText());
        if (data.isStory()) {
            lblText.setForeground(new Color(29, 106, 205));
            lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-time-15.png")));
            lblRemove.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            lblRemove.setText("");

        }
    }

    private void addEventMouse(Component com) {
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(215, 216, 216));

            }

            @Override
            public void mouseExited(MouseEvent e) {

                setBackground(Color.WHITE);
            }

        });
    }

    private ActionListener eventClick;
    private ActionListener eventRemove;

    public void addEvent(ActionListener eventClick, ActionListener eventRemove) {
        this.eventClick = eventClick;
        this.eventRemove = eventRemove;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSearch = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        lblRemove = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-search-15.png"))); // NOI18N

        lblText.setForeground(new java.awt.Color(153, 153, 153));
        lblText.setText("Text....");
        lblText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextMouseClicked(evt);
            }
        });

        lblRemove.setForeground(new java.awt.Color(153, 153, 153));
        lblRemove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRemove.setText("Remove");
        lblRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(lblText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveMouseClicked

        if (!lblRemove.getText().trim().equals("")) {
            eventRemove.actionPerformed(null);
        }

    }//GEN-LAST:event_lblRemoveMouseClicked

    private void lblTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextMouseClicked
        eventClick.actionPerformed(null);
    }//GEN-LAST:event_lblTextMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblRemove;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
}
