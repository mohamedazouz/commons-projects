package mvc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentView extends JPanel implements StudentRefInterface {
	private static final long serialVersionUID = 1L;
	private static final String SHOW_BUTTON = "Show";
	private static final String EXIT_BUTTON = "Exit";
	private static final String STUDENT_FIRST_NAME = "First Name  ";
	private static final String STUDENT_LAST_NAME = "Last Name  ";
	private static final String STUDENT_COURSE = "Course  ";
	private static final String STUDENT_ADDRESS = "Address  ";
	private static final int FNAME_COL_WIDTH = 30;
	private static final int LNAME_COL_WIDTH = 50;
	private static final int COURSE_COL_WIDTH = 35;
	private static final int ADDRESS_COL_WIDTH = 50;
	private StudentController controller;
	private JLabel firstNameLabel, lastNameLabel, courseLabel, addressLabel;
	private JTextField firstName, lastName, course, address;
	private JButton display, exit;

	public StudentView(StudentModel model) {
		controller = new StudentController(model, this);
		createGui();
	}

	public StudentView(StudentModel model, StudentController newController) {
		controller = newController;
		createGui();
	}

	public void createGui() {
		display = new JButton(SHOW_BUTTON);
		exit = new JButton(EXIT_BUTTON);

		firstNameLabel = new JLabel(STUDENT_FIRST_NAME);
		lastNameLabel = new JLabel(STUDENT_LAST_NAME);
		courseLabel = new JLabel(STUDENT_COURSE);
		addressLabel = new JLabel(STUDENT_ADDRESS);

		firstName = new JTextField(FNAME_COL_WIDTH);
		lastName = new JTextField(LNAME_COL_WIDTH);
		course = new JTextField(COURSE_COL_WIDTH);
		address = new JTextField(ADDRESS_COL_WIDTH);

		JPanel editPanel = new JPanel();
		editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.X_AXIS));

		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(0, 1));

		labelPanel.add(firstNameLabel);
		labelPanel.add(lastNameLabel);
		labelPanel.add(courseLabel);
		labelPanel.add(addressLabel);

		editPanel.add(labelPanel);

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(0, 1));

		fieldPanel.add(firstName);
		fieldPanel.add(lastName);
		fieldPanel.add(course);
		fieldPanel.add(address);

		editPanel.add(fieldPanel);

		JPanel controlPanel = new JPanel();
		controlPanel.add(display);
		controlPanel.add(exit);
		display.addActionListener(controller);
		exit.addActionListener(new ExitHandler());

		setLayout(new BorderLayout());
		add(editPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
	}

	public Object getUpdateRef() {
		return display;
	}

	public String getFirstName() {
		return firstName.getText();
	}

	public String getLastName() {
		return lastName.getText();
	}

	public String getCourse() {
		return course.getText();
	}

	public String getAddress() {
		return address.getText();
	}

	public void refresh(String newFirstName, String newLastName,
			String newTitle, String newOrganization) {
		firstName.setText(newFirstName);
		lastName.setText(newLastName);
		course.setText(newTitle);
		address.setText(newOrganization);
	}

	private class ExitHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}

}