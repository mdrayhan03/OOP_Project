package mainpkg.Rayhan.User8;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javax.sound.midi.MidiDevice.Info;
import mainpkg.AbstractClass.User;
import mainpkg.Rasel.Refugee.Refugee;

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
//#donationToCamp():Boolean
//#requestForCampaign():Boolean
//#educationFacilities():Boolean
//#medicalFacilities():Boolean
//#report():Boolean
    
}
