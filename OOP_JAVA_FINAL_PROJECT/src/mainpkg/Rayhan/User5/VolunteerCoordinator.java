package mainpkg.Rayhan.User5;

import java.io.Serializable;
import mainpkg.AbstractClass.User;

/**
 *
 * @author RayhaN
 */
public class VolunteerCoordinator extends User implements Serializable{
    private static final long serialVersionUID = 1L ;
    int volunteerAmount = 0 ;
    int volunteerOnWork = 0 ;
    int volunteerFree = 0 ;

    public VolunteerCoordinator(int id, String name, String password, String phoneNo, String email, String userType, String dob) {
        super(id, name, password, phoneNo, email, userType, dob);
    }

    public int getVolunteerAmount() {
        return volunteerAmount;
    }

    public int getVolunteerOnWork() {
        return volunteerOnWork;
    }

    public int getVolunteerFree() {
        return volunteerFree;
    }

    public void setVolunteerAmount(int volunteerAmount) {
        this.volunteerAmount = volunteerAmount;
    }

    public void setVolunteerOnWork(int volunteerOnWork) {
        this.volunteerOnWork = volunteerOnWork;
    }

    public void setVolunteerFree(int volunteerFree) {
        this.volunteerFree = volunteerFree;
    }

    @Override
    public String toString() {
        return super.toString() + "volunteerAmount=" + volunteerAmount + ", volunteerOnWork=" + volunteerOnWork + ", volunteerFree=" + volunteerFree + '}';
    }
    
    
    
    
}
