package mainpkg.Rayhan.User8.Goal3_StockInfo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.Rayhan.User8.DashBoard8SceneFxmlController;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class StockInfoSceneFxmlController implements Initializable {

    @FXML    private Label riceLabel;
    @FXML    private Label potatoLabel;
    @FXML    private Label onionLabel;
    @FXML    private Label oilLabel;
    @FXML    private Label fishLabel;
    @FXML    private Label pulseLabel;
    @FXML    private Label napaLabel;
    @FXML    private Label napaExtraLabel;
    @FXML    private Label paracetmolLabel;
    @FXML    private Label painkillersLabel;
    @FXML    private Label sergelLabel;
    @FXML    private Label bookLabel;
    @FXML    private Label noteLabel;
    @FXML    private Label penLabel;
    @FXML    private Label pencilLabel;
    @FXML    private Label ruberLabel;
    @FXML    private Label pBoxLabel;
    @FXML    private Label chickenLabel;
    @FXML    private Label eggLabel;
    @FXML    private Label milkLabel;
    @FXML    private Label gBoxLabel;
   /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User8/DashBoard8SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard8SceneFxmlController dsc = myLoader.getController() ;
//        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator") ;
        stage.show() ;      
    }
    
}
