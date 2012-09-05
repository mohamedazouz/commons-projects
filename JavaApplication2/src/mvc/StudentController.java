package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController implements ActionListener {
	private StudentModel model;
	private StudentView view;

	public StudentController(StudentModel m, StudentView v) {
		this.model = m;
		this.view = v;
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == view.getUpdateRef()) {
			updateModel();
		}
	}

	private void updateModel() {
		String firstName = null;
		String lastName = null;

		firstName = view.getFirstName();
		lastName = view.getLastName();
		model.updateModel(firstName, lastName, view.getCourse(), view
				.getAddress());
	}

}