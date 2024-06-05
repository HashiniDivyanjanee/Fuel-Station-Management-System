package Prograss;

import javax.swing.JProgressBar;


public class Progress extends JProgressBar {

    private final ProgressCircleUI ui;

    public Progress() {
        setOpaque(false);
        setStringPainted(true);
        ui = new ProgressCircleUI();
        setUI(ui);
    }

    @Override
    public String getString() {
        return ((int) (getValue() * ui.getAnimate())) + "";
    }

    public void start() {
        ui.start();
    }
    
     public int getProgressValue() {
        return getValue();
    }

    // Method to set the progress value
    public void setProgressValue(int value) {
        setValue(value);
    }
    
}
