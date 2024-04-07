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

    public Time_Place() {
    }



    public ObservableList<String> getCampaignTime() {
        return campaignTime;
    }

    public ObservableList<String> getCampaignPlace() {
        return campaignPlace;
    }

    public void setCampaignTime() {
        campaignTime.addAll("09:00-12:00" , "15:00-18:00" , "18:00-21:00") ;
    }

    public void setCampaignPlace() {
        campaignPlace.addAll("Campaign Site1" , "Campaign Site2" , "Campaign Site3" , "Campaign Site4" , "Campaign Site5") ;
    }
    
    
    
}
