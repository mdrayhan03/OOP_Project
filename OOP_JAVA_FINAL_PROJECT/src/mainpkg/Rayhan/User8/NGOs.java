package mainpkg.Rayhan.User8;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javax.sound.midi.MidiDevice.Info;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Rayhan.User5.Goal8_Report.Report;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User8.Goal4_Donation.Donation;
import mainpkg.Rayhan.User8.Goal5_Education.EducationFacilities;
import mainpkg.Rayhan.User8.Goal6_Medical.MedicalFacilities;

/**
 *
 * @author RayhaN
 */
public class NGOs extends User implements Serializable{
    
    public NGOs(int id, String name, String password, String phoneNo, String email, String userType, String gender, String dob) {
        super(id, name, password, phoneNo, email, userType, gender, dob);
    }
    public ArrayList<Integer> campInfo(ObservableList<Refugee> refList) {
        ArrayList<Integer> rtn = new ArrayList<>() ;
        Integer refugee = 0 , male = 0 , female = 0 ;
        for(Refugee ref: refList) {
            refugee ++ ;
            if ("Male".equals(ref.getGender())) {male ++ ;}
            else if ("Female".equals(ref.getGender())) {female ++ ;}
        }
        rtn.add(refugee) ;
        rtn.add(male) ;
        rtn.add(female) ;
        
        return rtn ;
    }
    
//public ObservableAList<Info> managementInfo() {
//    
//}
//#capacityInfo():void
    
        /**
     *
     * @param id
     * @param pw
     * @return
     */
    @Override
    public NGOs verifyLogin(int id , String pw) {
        int userId = this.getId() ;
        String userPw = this.getPassword() ;
        if (userId == id && userPw.equals(pw)) {
            this.setStatus("Active") ;
            return this ;
        }
        return null ;
    }
    
    public Donation donationToCamp(Integer donerid, Integer amount, String name, Date date) {
        Donation don = new Donation(donerid, amount, name, date) ;
        
        return don ;
    }
    
    public Campaign requestForCampaign(String time, String place, String subject, String userType, String des, String senderName, Date date, int senderId) {
        Campaign cam = new Campaign(time,  place,  subject,  userType, des, senderName, date, senderId) ;
        return cam ;
    }
    
    public EducationFacilities educationFacilities(Integer id , String donerName , String name, Integer amount, Date date) {
        EducationFacilities efc = new EducationFacilities(id , donerName , name, amount, date) ;
        
        return efc ;
    }
//#medicalFacilities():Boolean
    public MedicalFacilities medicalFacilities(Integer id , String donerName , String name, Integer amount, Date date) {
        MedicalFacilities efc = new MedicalFacilities(id , donerName , name, amount, date) ;
        
        return efc ;
    }
    
    
    public Report report(Integer senderId, Integer receiverId, String subject, String description, Date applyDate) {
        Report rep = new Report(subject,  description,  applyDate) ;
        return rep ;
    }
    
}
