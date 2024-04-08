package mainpkg.Rayhan.User7.Goal3_Notice;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class GetNoticeSceneFxmlController implements Initializable {

    @FXML    private Label reasonLabel;
    @FXML    private Label dateLabel;
    @FXML    private TextArea descriptionTextArea;
    @FXML    private TableView<?> noticeTableView;
    @FXML    private TableColumn<?, ?> idTableColumn;
    @FXML    private TableColumn<?, ?> reasonTableColumn;
    @FXML    private TableColumn<?, ?> descriptionTableColumn;
    @FXML    private TableColumn<?, ?> dateTableColumn;
    @FXML    private ComboBox<?> idComboBox;

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

    @FXML
    private void replyOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal3_Notice/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = new Stage() ;
        stage.setScene(myScene) ;
        stage.getIcons().add(new Image("/image/campIcon.jpg")) ;
        stage.setTitle("Reply") ;
        stage.show() ;
    }
    
}
