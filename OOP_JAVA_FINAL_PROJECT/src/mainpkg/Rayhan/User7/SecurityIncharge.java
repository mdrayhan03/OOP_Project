package mainpkg.Rayhan.User7;

import java.io.Serializable;
import javafx.collections.ObservableList;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;

/**
 *
 * @author RayhaN
 */
public class SecurityIncharge extends User implements Serializable {
    int volunteerAmount = 0 ;
    int volunteerOnWork = 0 ;
    int volunteerFree = 0 ;
    
    public SecurityIncharge(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
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
        return "SecurityIncharge{" + "volunteerAmount=" + volunteerAmount + ", volunteerOnWork=" + volunteerOnWork + ", volunteerFree=" + volunteerFree + '}';
    }
    
    public Volunteer addVolunteer(String name , String pN , String addedName , int addedId) {
        Volunteer vc = new Volunteer(name ,  pN ,  addedName , addedId) ;
         this.setVolunteerAmount(this.getVolunteerAmount() + 1) ;
         this.setVolunteerFree(this.getVolunteerFree() + 1) ;
         
         return vc ;
    }

    public Refugee refugeeInfo(int id , ObservableList<Refugee> list) {
        for (Refugee re: list) {
            if (re.getId() == id) {
                return re ;
            }
        }
        return null ;
    }
//+crimeFacts():void
//+notice():void
//+timeAndPlace():void
//+request():void
//+report():void
    
}
