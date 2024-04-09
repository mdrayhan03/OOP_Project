package mainpkg.AbstractClass;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author RayhaN
 */
public class Time_Place {
    ObservableList<String> campaignTime =  FXCollections.observableArrayList() ;
    ObservableList<String> campaignPlace =  FXCollections.observableArrayList() ;
    ObservableList<String> tuitionTime =  FXCollections.observableArrayList() ;
    ObservableList<String> tuitionPlace =  FXCollections.observableArrayList() ;
    ObservableList<String> educationCoordinatorItem =  FXCollections.observableArrayList() ;
    ObservableList<String> securityInchargeItem =  FXCollections.observableArrayList() ;
    ObservableList<String> securityTime =  FXCollections.observableArrayList() ;
    ObservableList<String> securityPlace =  FXCollections.observableArrayList() ;
    
    public Time_Place() {
    }



    public ObservableList<String> getCampaignTime() {
        return campaignTime;
    }

    public ObservableList<String> getCampaignPlace() {
        return campaignPlace;
    }

    public ObservableList<String> getTuitionTime() {
        return tuitionTime;
    }

    public ObservableList<String> getTuitionPlace() {
        return tuitionPlace;
    }

    public ObservableList<String> getEducationCoordinatorItem() {
        return educationCoordinatorItem;
    }

    public ObservableList<String> getSecurityInchargeItem() {
        return securityInchargeItem;
    }

    public ObservableList<String> getSecurityTime() {
        return securityTime;
    }

    public ObservableList<String> getSecurityPlace() {
        return securityPlace;
    }

    public void setCampaignTime() {
        campaignTime.addAll("09:00-12:00" , "15:00-18:00" , "18:00-21:00") ;
    }

    public void setCampaignPlace() {
        campaignPlace.addAll("Campaign Site 1" , "Campaign Site 2" , "Campaign Site 3" , "Campaign Site 4" , "Campaign Site 5") ;
    }
    
    
    public void setTuitionTime() {
        tuitionTime.addAll("09:00-12:00" , "15:00-18:00" , "18:00-21:00") ;
    }

    public void setTuitionPlace() {
        tuitionPlace.addAll("Plot 1" , "Plot 2" , "Plot 3" , "Plot 4" , "Plot 5") ;
    }

    public void setEducationCoordinatorItem() {
        educationCoordinatorItem.addAll("Book" , "Note" ,"Pen" , "Pencil" , "Rubber" , "Pencil Box" , "Geometry Box" ) ;
    }

    public void setSecurityInchargeItem() {
        securityInchargeItem.addAll("Camera", "Speaker", "Alarm", "Fire alarm", "Fingerprint reader") ;
    }

    public void setSecurityTime() {
        securityTime.addAll("00:00-06:00" , "06:00-12:00" , "12:00-18:00" , "18:00-00:00") ;
    }

    public void setSecurityPlace(ObservableList<String> securityPlace) {
        securityPlace.addAll("Border 1", "Border 2", "Border 3", "Gate 1", "Gate 2", "Gate 3") ;;
    }
    
    
    
}
