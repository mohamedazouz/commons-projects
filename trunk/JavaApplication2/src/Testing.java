
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 221388
 */
public class Testing {

    public void buildGUI() {
        JFrame f = new JFrame();

        //JPanel p = new JPanel(new BorderLayout());//<---swap this line
        JPanel p = new JPanel();//<---for this line

        p.add(createPanel());
        f.getContentPane().add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JPanel createPanel() {
        final JTextArea textArea = new JTextArea();
        //gets text area of properties description. Dynamically changes
        // when upon selection of particular property
        textArea.setBackground(Color.GRAY);
        textArea.setRows(4);
        textArea.setText("Description of property set here.");
        final JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(600, 60));
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(50, 40));
        panel.setVisible(true);

        return panel;
    }

    public static void main(String args[]) {
        new Testing().buildGUI();
    }
}
