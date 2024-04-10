    package mainpkg.Rayhan.User5;

import java.io.Serializable;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Rayhan.User5.Goal2_SIReport.SIReport;
import mainpkg.Rayhan.User5.Goal3_AEReport.AEReport;
import mainpkg.Rayhan.User5.Goal8_Report.Report;

/**
 *
 * @author RayhaN
 */
public class VolunteerCoordinator extends User implements Serializable{
    int volunteerAmount = 0 ;
    int volunteerOnWork = 0 ;
    int volunteerFree = 0 ;

    public VolunteerCoordinator(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
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
        return super.toString() + "volunteerAmount=" + volunteerAmount + ", volunteerOnWork=" + volunteerOnWork + ", volunteerFree=" + volunteerFree + '}';
    }
    
    public SIReport reportToSecurityIncharge(String subject , String des , Date doa){
        SIReport sir = new SIReport(subject , des , doa) ;
        return sir ;
    }
    
    public AEReport reportToAidExecutive(String subject , String des , Date doa){
        AEReport aer = new AEReport(subject , des , doa) ;
        return aer ;
    }
    
    public boolean getRequestForVolunteer(int amount) {
        this.setVolunteerOnWork(this.getVolunteerOnWork() + amount) ;
        this.setVolunteerFree(this.getVolunteerFree() - amount) ;
        return true ;
    }
    
    public void addVolunteer(int volunteer){
        this.setVolunteerAmount(this.getVolunteerAmount() + volunteer) ;
        this.setVolunteerFree(this.getVolunteerFree() + volunteer) ;                
    }
    
    public Campaign requestForCampaign(String time, String place, String subject, String userType, String des, String senderName, Date date, int senderId) {
        Campaign cam = new Campaign(time,  place,  subject,  userType, des, senderName, date, senderId) ;
        return cam ;
    }
    
    public boolean getEmergencyRequestForVolunteer(int amount) {
        this.setVolunteerOnWork(this.getVolunteerOnWork() + amount) ;
        this.setVolunteerFree(this.getVolunteerFree() - amount) ;
        return true ;
    }
    
    public Report report(String subject , String des , Date doa) {
        Report rep = new Report(subject , des , doa) ;
        return rep ;
    }
       
    
}
