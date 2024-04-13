package mainpkg.Rasel.CampManager.Goal1_CampInfo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rasel.CampManager.Goal5_Supply.FoodInfo;

/**
 * FXML Controller class
 *
 * @author Rasel
 */
public class ViewCampInfoController implements Initializable {

    @FXML
    private PieChart refugeePieChart;
    @FXML
    private Label campCapacityLabel;
    @FXML
    private Label totalRefugeeLabel;
    @FXML
    private Label currentfoodStockLabel;
    
    private CampCapacity campCapacity;
    private FoodInfo foodInfo;
    FoodInfo foodInfo2; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        campCapacity = new CampCapacity(500, 100);
        foodInfo = new FoodInfo(1000, "Rice", new Date(2024, 4, 13), new Date(2024, 12, 31));
       
        foodInfo2 = new FoodInfo(3000, "Potato", new Date(2024, 4, 10), new Date(2024, 6, 31));
        updateLabels();
    }    

    @FXML
    private void campInfoBackButton(ActionEvent event) throws IOException {
    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rasel/CampManager/CampManagerDashboardScene.fxml"));
    Parent myPage = myLoader.load();
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
    Scene myScene = new Scene(myPage);
    stage.setScene(myScene);
    stage.show();
    }
    
    private void updateLabels() {
        campCapacityLabel.setText(Integer.toString(campCapacity.getMaxCapacity()));
        
        //campCapacity.getCurrentOccupants());

        String totalRefugees = Integer.toString(campCapacity.getCurrentOccupants());
        totalRefugeeLabel.setText(totalRefugees);
        
        String foodStock = Integer.toString(foodInfo.getFoodStock());
        String foodStock2 = Integer.toString(foodInfo2.getFoodStock());
        currentfoodStockLabel.setText("Name: "+foodInfo.getFoodName()+" - "+foodStock+"\n"+"Name: "+foodInfo2.getFoodName()+" - "+foodStock2);
    }
    
}
