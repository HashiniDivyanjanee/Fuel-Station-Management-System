package chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class GaugeChart1 extends JComponent {

    private int gaugeSize = 15;

    public int getGaugeSize() {
        return gaugeSize;
    }

    public void setGaugeSize(int gaugeSize) {
        this.gaugeSize = gaugeSize;
        repaint();
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
        repaint();
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
        repaint();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            value = 0;
        }
        this.value = value;
        repaint();
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
        repaint();
    }
    private Color color1 = new Color(5,117,230);
    private Color color2 = new Color(0, 242, 96);
    private int value;
    private int maximum;
   

    public GaugeChart1() {
        setFont(new JLabel().getFont().deriveFont(0,20));
        setPreferredSize (new Dimension(250, 220));
        setForeground(new Color(60, 60, 60));
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        float spaceBot = 0.15f;
        int width = getWidth();
        int height = getHeight();
//        height += (int) (height + spaceBot);
        int size = Math.min(width, height) - (gaugeSize + 5);
        int centerSize = 20;
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        int centerX = width / 2;
        int centerY = height / 2;
        int angleStart = -35;
        g2.setColor(new Color(200, 200, 200));
        g2.fillOval(centerX-centerSize/2, centerY-centerSize/2, centerSize, centerSize);
        g2.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        Shape s = new Arc2D.Double(x, y, size, size, angleStart, 250, Arc2D.OPEN);
        g2.draw(s);
        double angle = getAngleofValues();
        if (angle > 0) {
            s = new Arc2D.Double(x, y, size, size, angleStart + 250 - angle, angle, Arc2D.OPEN);
            GradientPaint gra = new GradientPaint(0, 0, color1, width, 0, color2);
            g2.setPaint(gra);
            g2.draw(s);
        }
        g2.setStroke(new BasicStroke(1f));

        double len = 20;
        double space = 250 / len;
        double start = angleStart+7;
        double angleSize = (size / 2) - gaugeSize;
        g2.setColor(new Color(200, 200, 200));
        for (int i = 1; i <= len; i++) {
            Point p = getLocation(start, angleSize);
            g2.fillOval(centerX + p.x - 2, centerY - p.y - 2, 4, 4);
            start += space;
        }
        double ang = angleStart+250-angle;
        g2.setColor(color2);
        Path2D p = new Path2D.Double();
        Point end = getLocation (ang, angleSize);
        Point right = getLocation (ang - 90, 5);
        Point left = getLocation (ang + 90, 5);
         p.moveTo(centerX+left.x, centerY-left.y);
        p.lineTo(centerX+end.x, centerY-end.y);
        p.lineTo(centerX+right.x, centerY-right.y);
        g2.fill(p);
        g2.fillOval(centerX-5,centerY-5, 10, 10);
        g2.setColor(new Color(240,240,240));
        g2.fillOval(centerX-2,centerY-2,4,4);
        drawText(g2, centerX, centerY, angleSize);
        super.paint(grphcs);
    }

    private void drawText (Graphics2D g2, int x, int y, double size){
        g2.setColor(getForeground());
        double max = maximum;
        double v = getValueFixed();
        double n = v/max*100f;
        String text = String.valueOf((int) n)+"%";
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 =ft.getStringBounds(text, g2);
        g2.drawString(text, (int)(x-r2.getWidth()/2), (int) (y+size-r2.getHeight()));
    }
    
    private double getAngleofValues() {
        double max = maximum;
        double v = getValueFixed();
        double n = v / max * 100f;
        double angle = n * 250f / 100f;
        return angle;
    }

    private int getValueFixed() {
        return value > maximum ? maximum : value;

    }

  private Point getLocation(double angle, double size) {
    double x = Math.cos(Math.toRadians(angle)) * size;
    double y = Math.sin(Math.toRadians(angle)) * size; // Fixed cosine to sine
    return new Point((int) x, (int) y);
}

}
