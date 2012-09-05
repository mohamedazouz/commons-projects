package mvc;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StudentDisplayView extends JPanel implements StudentRefInterface {
	private JTextArea studentDetail;

	public StudentDisplayView() {
		createGui();
	}

	public void createGui() {
		setLayout(new BorderLayout());
		studentDetail = new JTextArea(10, 40);
		studentDetail.setEditable(false);
		JScrollPane scrollDisplay = new JScrollPane(studentDetail);
		this.add(scrollDisplay, BorderLayout.CENTER);
	}

	public void refresh(String newFirstName, String newLastName,
			String newCourse, String newAddress) {
		studentDetail.setText("\n\tStudent Details\n\t" + "\tName: "
				+ newFirstName + "\n\t\tLast Name: " + newLastName + "\n"
				+ "\t\tCourse: " + newCourse + "\n" + "\t\tAddress: "
				+ newAddress);
	}
}
