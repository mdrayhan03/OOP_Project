package mainpkg.Rayhan.User7.Goal3_Notice;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.Rayhan.User7.SecurityIncharge;
import mainpkg.Rayhan.User7.Goal3_Notice.ReplySceneFxmlController;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class GetNoticeSceneFxmlController implements Initializable {

    @FXML    private Label reasonLabel;
    @FXML    private Label dateLabel;
    @FXML    private TextArea descriptionTextArea;
    @FXML    private TableView<Notice> noticeTableView;
    @FXML    private TableColumn<Notice , String> idTableColumn;
    @FXML    private TableColumn<Notice , String> reasonTableColumn;
    @FXML    private TableColumn<Notice , String> descriptionTableColumn;
    @FXML    private TableColumn<Notice , Date> dateTableColumn;
    @FXML    private TableColumn<Notice , String> replyTableColumn;
    @FXML    private ComboBox<String> idComboBox;
    
    ObservableList<Notice> list = FXCollections.observableArrayList() ;
    SecurityIncharge user ;
    Notice nc ;
    Alert alert ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void tableShow() {
        noticeTableView.setItems(list) ;
    }
    
    public void setComboBox() {
        for(Notice nc: list) {
            idComboBox.getItems().add(nc.getId()) ;
        }
        idComboBox.setValue(list.get(0).getId()) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/DashBoard7SceneFxml.fxml")) ;
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
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User7/Goal3_Notice/ReplySceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ReplySceneFxmlController rsc = myLoader.getController() ;
        rsc.set(nc) ;

        Stage stage = new Stage() ;
        stage.setScene(myScene) ;
        stage.getIcons().add(new Image("/image/campIcon.jpg")) ;
        stage.setTitle("Reply") ;
        stage.show() ;
    }

    @FXML
    private void idComboBoxOnMouseClick(MouseEvent event) {
        nc = user.notice(idComboBox.getValue(), list) ;
        
        if (nc != null) {
            reasonLabel.setText(nc.getReason()) ;
            descriptionTextArea.setText(nc.getDes()) ;
            dateLabel.setText(nc.getDate().toString()) ;
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("NOT FOUND") ;
            alert.setContentText("Notice not found.") ;
            alert.showAndWait() ;
        }
    }
    
}
