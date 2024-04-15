package mainpkg.Rayhan.User7;

import java.io.Serializable;
import javafx.collections.ObservableList;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Holiday;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.RequestedItems;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;
import mainpkg.Rayhan.User5.Goal8_Report.Report;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User7.Goal3_Notice.Notice;
import mainpkg.Rayhan.User7.Goal5_CrimeFacts.CrimeFact;
import mainpkg.Rayhan.User7.Goal6_Duty.Duty;

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
    
        /**
     *
     * @param id
     * @param pw
     * @return
     */
    @Override
    public SecurityIncharge verifyLogin(int id , String pw) {
        int userId = this.getId() ;
        String userPw = this.getPassword() ;
        if (userId == id && userPw.equals(pw)) {
            this.setStatus("Active") ;
            return this ;
        }
        return null ;
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
    public CrimeFact addCrimeFact(String reporterName ,String des ,Integer id) {
        CrimeFact cf = new CrimeFact(reporterName , des , id)   ;
        return cf ;
    }
    public Notice notice(String id , ObservableList<Notice> l) {
        for (Notice nc: l) {
            if (nc.getId() == id) {
                return nc ;
            }
        }
        return null ;
    }
    
    public Duty setDuty(String time, String place, int amount, Date date) {
        if (amount <= this.getVolunteerFree()) {
            Duty duty = new Duty(time , place , amount , date) ;
            this.setVolunteerFree(this.getVolunteerFree() - amount) ;
            this.setVolunteerOnWork(this.getVolunteerOnWork() + amount) ;
            return duty ;
        }
        
        return null ;        
    }
    
    public RequestedItems request(int id , String userType , String name, int amount, Date apply, Date deadline) {
        RequestedItems req = new RequestedItems(id , userType , name, amount, apply, deadline) ;
        return req ;
    }
    
    public Campaign requestForCampaign(String time, String place, String subject, String userType, String des, String senderName, Date date, int senderId) {
        Campaign cam = new Campaign(time,  place,  subject,  userType, des, senderName, date, senderId) ;
        return cam ;
    }
    
    public Report report(Integer senderId, Integer receiverId, String subject, String description, Date applyDate) {
        Report rep = new Report(subject , description , applyDate) ;
        return rep ;
    }
    
}
