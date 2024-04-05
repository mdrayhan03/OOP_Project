package mainpkg.Rayhan.User6;

import java.io.Serializable;
import mainpkg.AbstractClass.User;

/**
 *
 * @author RayhaN
 */
public class EducationCoordinator extends User implements Serializable {
    int teacherAmount = 0 ;
    int studentAmount = 0 ;

    public EducationCoordinator(int id, String name, String password, String phoneNo, String email, String userType, String dob) {
        super(id, name, password, phoneNo, email, userType, dob);
    }

    public int getTeacherAmount() {
        return teacherAmount;
    }

    public int getStudentAmount() {
        return studentAmount;
    }

    public void setTeacherAmount(int teacherAmount) {
        this.teacherAmount += teacherAmount;
    }

    public void setStudentAmount(int studentAmount) {
        this.studentAmount += studentAmount;
    }

    @Override
    public String toString() {
        return "EducationCoordinator{" + "teacherAmount=" + teacherAmount + ", studentAmount=" + studentAmount + '}';
    }
    
    
}
