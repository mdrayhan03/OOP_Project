package mainpkg.Rayhan.User7.Goal3_Notice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.Rayhan.User7.DashBoard7SceneFxmlController;
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
    
    
    SecurityIncharge user ;
    Notice nc ;
    Alert alert ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void set(SecurityIncharge u) {
        user = u ;
        tableShow() ;
    }
    
    public void tableShow() {
        ObservableList<Notice> list = fileRead() ;
        noticeTableView.setItems(list) ;
        setComboBox() ;
    }
    
    public void setComboBox() {
        ObservableList<Notice> list = fileRead() ;
        if (list.size() >= 0){
            for(Notice nc: list) {
                idComboBox.getItems().add(nc.getId()) ;
            }
            }
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
        
        DashBoard7SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

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
        nc = user.notice(idComboBox.getValue(), fileRead()) ;
        
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
    
    private ObservableList<Notice> fileRead() {
        ObservableList<Notice> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/Notice.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Notice st ;
            try {
                while(true){
                    st = (Notice)ois.readObject();
//                    System.out.println(st);
                    studList.add(st) ;
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch     
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
        finally {
            try {
                
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
        
        return studList ;
    }
    
    private void fileWrite(Notice stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/VCVolunteer.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(stu);

        } catch (IOException ex) {
            Logger.getLogger(GetNoticeSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(GetNoticeSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
}
