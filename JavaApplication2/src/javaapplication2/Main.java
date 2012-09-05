/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 221388
 */
public class Main extends JFrame {

    public static void main(String args[]) {
        new Main();
    }

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel p = new JPanel();
        setContentPane(p);
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

        JPanel panel1 = new first(); 
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);
        p.add(panel1);
        p.add(panel2);
        setSize(200, 200);
        setVisible(true);
    }
}
