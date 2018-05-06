package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andy on 2018-04-30.
 */
public class StopWatch extends Frame implements ActionListener{
    private Button toggle;
    private Button reset;
    private Label time;

    private double start;
    private double current;
    private double temp;
    private boolean button;
    private Timer timer;

    private StopWatch() {
        setLayout(new FlowLayout());
        setTitle("Stopwatch");
        toggle = new Button("Toggle");
        add(toggle);
        reset = new Button("Reset");
        add(reset);
        time = new Label();
        add(time);
        toggle.addActionListener(this);
        reset.addActionListener(this);
        button = false;
        setSize(350, 150);
        setVisible(true);
        start=System.currentTimeMillis();
        current = System.currentTimeMillis();
        time.setText(0 + " ms");
        timer=new Timer(1000, this);
        timer.setInitialDelay(1000);
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        new StopWatch();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == toggle)
            button = !button;
        if(e.getSource() == reset) {
            button = false;
            start = current;
            time.setText("0 ms");
        }
        else {
            if (button) {
                current = System.currentTimeMillis();
                start += temp;
                double elapsed = current - start;
                temp = 0.0;
                time.setText(elapsed + " ms");
                timer.start();
            }
            if (!button) {
                temp = System.currentTimeMillis()-current;
                timer.start();
            }
        }
    }
}