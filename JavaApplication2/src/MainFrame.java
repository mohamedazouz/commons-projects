
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 221388
 */
class MainFrame extends JFrame {

    public MainFrame() {
        setSize(300, 200);

        flag = false;

        panel1 = new JPanel();
        label1 = new JLabel("Panel 1");
        panel1.add(label1);

        panel2 = new JPanel();
        label2 = new JLabel("Panel 2");
        panel2.add(label2);

        add(panel1);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem item = new JMenuItem("Change panel");

        menu.add(item);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        item.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                //JOptionPane.showMessageDialog(MainFrame.this, "In action listener");

                if (flag) {
                    flag = false;
                    MainFrame.this.remove(panel2);
                    MainFrame.this.add(panel1);
                    MainFrame.this.repaint();
                } else {
                    flag = true;
                    MainFrame.this.remove(panel1);
                    MainFrame.this.add(panel2);
                    MainFrame.this.repaint();
                }
            }
        });

    }
    private boolean flag;
    private JPanel panel1, panel2;
    private JLabel label1, label2;

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
