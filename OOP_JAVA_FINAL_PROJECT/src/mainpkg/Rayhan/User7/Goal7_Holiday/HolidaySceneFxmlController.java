package mainpkg.Rayhan.User7.Goal7_Holiday;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class HolidaySceneFxmlController implements Initializable {

    @FXML    private TextField startddTextField;
    @FXML    private TextField startmmTextField;
    @FXML    private TextField startyyyyTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextField endddTextField;
    @FXML    private TextField endmmTextField;
    @FXML    private TextField endyyyyTextField;
    @FXML    private TableView<?> holidayTableView;
    @FXML    private TableColumn<?, ?> idTableColumn;
    @FXML    private TableColumn<?, ?> reasonTableColumn;
    @FXML    private TableColumn<?, ?> sDTableColumn;
    @FXML    private TableColumn<?, ?> eDTableColumn;
    @FXML    private TableColumn<?, ?> dateTableColumn;
    @FXML    private TableColumn<?, ?> statusTableColumn;

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
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Security Incharge") ;
        stage.show() ;
    }
    
}
