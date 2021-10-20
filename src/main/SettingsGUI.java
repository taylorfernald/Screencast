package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SettingsGUI implements ActionListener
{
    JFrame frame1;
    String title;
    int width;
    int height;
    int w, h; //these are for the APPLICATION, not the settings GUI.
    int mapNum;
    JButton start;
    JTextField tf;
    public SettingsGUI(String title, int w, int h, int mapNum)
    {
        this.title = "Screencaster Settings";
        this.width = 400;
        this.height = 300;
        this.w = w;
        this.h = h;
        mapNum = 1;
    }
    
    public void createSettingsGUI()
    {
        frame1 = new JFrame(title);
        frame1.setSize(width, height);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
        //Creating the Starting State Menu
        JMenu jm = new JMenu("Starting State");
        JMenuItem ms = new JMenuItem("map");
        jm.add(ms);
        JMenuItem tb = new JMenuItem("table");
        jm.add(tb);
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Starting Map ID");
        tf = new JTextField(5); // accepts upto 5 characters
        start = new JButton("Start");
        start.addActionListener(this);
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(start);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame1.
        frame1.getContentPane().add(BorderLayout.SOUTH, panel);
        frame1.getContentPane().add(BorderLayout.CENTER, ta);
        frame1.getContentPane().add(BorderLayout.NORTH, jm);
        frame1.setVisible(true);
        //System.out.println("Window Opened");
        //frame1.dispatchEvent(new WindowEvent(frame1, WindowEvent.WINDOW_CLOSING));
    }
    
    public void actionPerformed(ActionEvent e) {
        if (start != null && e.getSource() == start)
        {
            String input = tf.getText();
            if (!input.equals(""))
            {
                int o = Integer.parseInt(input);
                if (o < 1) o = 1;
                this.mapNum = o;
            }
            else this.mapNum = 1;
            runApp(w, h, mapNum);
            //frame1.dispatchEvent(new WindowEvent(frame1, WindowEvent.WINDOW_CLOSING));
            //System.out.println("Post-Termination Command reached.");
        }
    } 
    
    public static void runApp(int w, int h, int mapNum)
    {
        Tabletop ttop = new Tabletop("SCREENCAST", w, h, mapNum);
        ttop.start();
        System.out.println("App started. w: " + w + " h: " + h + " mapNum: " + mapNum);
    }
}
