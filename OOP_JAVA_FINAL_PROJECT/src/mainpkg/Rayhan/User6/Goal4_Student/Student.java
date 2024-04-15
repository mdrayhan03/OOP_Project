package mainpkg.Rayhan.User6.Goal4_Student;

import java.io.Serializable;
import javafx.collections.ObservableList;
import mainpkg.Rasel.Refugee.Refugee;

/**
 *
 * @author RayhaN
 */
public class Student extends Refugee implements Serializable{
    ObservableList<Course> course ;
    
    public Student(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob , ObservableList<Course> course) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
        this.course = course ;
    }

    public ObservableList<Course> getCourse() {
        return course;
    }

    public void setCourse(ObservableList<Course> course) {
        this.course = course;
    }
    
    public void addCourse (Course course) {
        this.course.add(course) ;
    }
    
    public void progress() {
        
    }
    
}
