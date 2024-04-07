package mainpkg.Rayhan.User5;

import java.io.Serializable;
import mainpkg.AbstractClass.User;
import mainpkg.Rayhan.User5.Goal2_SIReport.SIReport;
import mainpkg.Rayhan.User5.Goal3_AEReport.AEReport;

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
        this.volunteerAmount += volunteerAmount;
    }

    public void setVolunteerOnWork(int volunteerOnWork) {
        this.volunteerOnWork += volunteerOnWork;
    }

    public void setVolunteerFree(int volunteerFree) {
        this.volunteerFree += volunteerFree;
    }

    @Override
    public String toString() {
        return super.toString() + "volunteerAmount=" + volunteerAmount + ", volunteerOnWork=" + volunteerOnWork + ", volunteerFree=" + volunteerFree + '}';
    }
    
    public SIReport reportToSecurityIncharge(){
        SIReport sir = null ;
        return sir ;
    }
    
    public AEReport reportToAidExecutive(){
        AEReport aer = null ;
        return aer ;
    }
    
//#getRequestForVolunteer(RequestedVolunteer):Integer   
    public int addVolunteer(int volunteer){
        this.volunteerAmount += volunteer ;
        return this.volunteerAmount ;                
    }
//#campaignSchedule(ArrayList<Campaign>):Boolean
//#requestForCampaign(Campaign):Boolean
//#report():Report
    
    
    
}
