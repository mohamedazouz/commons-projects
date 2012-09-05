package mvc;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentModel {

    private String firstName;
    private String lastName;
    private String course;
    private String address;
    private ArrayList studentViews = new ArrayList();

    public StudentModel() {
        this(null);
    }

    public StudentModel(StudentRefInterface view) {
        firstName = "";
        lastName = "";
        course = "";
        address = "";
        if (view != null) {
            studentViews.add(view);
        }
    }

    public void addContactView(StudentRefInterface view) {
        if (!studentViews.contains(view)) {
            studentViews.add(view);
        }
    }

    public void removeContactView(StudentRefInterface view) {
        studentViews.remove(view);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return course;
    }

    public String getOrganization() {
        return address;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public void setCourse(String newCourse) {
        course = newCourse;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public void updateModel(String newFirstName, String newLastName,
            String newTitle, String newOrganization) {
        if (!isEmptyString(newFirstName)) {
            setFirstName(newFirstName);
        }
        if (!isEmptyString(newLastName)) {
            setLastName(newLastName);
        }
        if (!isEmptyString(newTitle)) {
            setCourse(newTitle);
        }
        if (!isEmptyString(newOrganization)) {
            setAddress(newOrganization);
        }
        updateView();
    }

    private boolean isEmptyString(String input) {
        return ((input == null) || input.equals(""));
    }

    private void updateView() {
        Iterator notifyViews = studentViews.iterator();
        while (notifyViews.hasNext()) {
            ((StudentRefInterface) notifyViews.next()).refresh(firstName,
                    lastName, course, address);
        }
    }
}
