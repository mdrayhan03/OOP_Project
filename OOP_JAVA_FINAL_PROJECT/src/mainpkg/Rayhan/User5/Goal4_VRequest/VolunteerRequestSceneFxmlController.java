package mainpkg.Rayhan.User5.Goal4_VRequest;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rayhan.User5.VolunteerCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class VolunteerRequestSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> requestIdComboBox;
    @FXML    private TableView<RequestedVolunteer> requestTableView;
    @FXML    private TableColumn<RequestedVolunteer, String> idTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> timeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> placeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Date> dateTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Integer> amountTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> statusTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> nameTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> uTypeTableColumn;
    @FXML    private ComboBox<String> typeComboBox;
    @FXML    private CheckBox acceptedCheckBox;
    @FXML    private CheckBox rejectedCheckBox;
    @FXML    private CheckBox pendingCheckBox;
    @FXML    private Label freeLabel;
    @FXML    private Label onWorkLabel;
    @FXML    private TextArea showTextArea;
    
    ObservableList<RequestedVolunteer> list = FXCollections.observableArrayList() ;
    VolunteerCoordinator user ;
    Time_Place tp = new Time_Place() ;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
//    public User get() {
//        return user ;
//    }
    public VolunteerCoordinator get() {
        return user ;
    }
    
    public void set(VolunteerCoordinator u) {
        user = u ; 
        System.out.println(user);
        tableShow() ;
    }
    
    public void tableShow() {
        onWorkLabel.setText(Integer.toString(user.getVolunteerOnWork())) ;
        freeLabel.setText(Integer.toString(user.getVolunteerFree())) ;
        
        requestTableView.getItems().clear() ; 
        ObservableList<RequestedVolunteer> reqList = fileRead() ;
        if (typeComboBox.getValue() == "ALL User") {
            reqList = list ;
        }
        else {
            for (RequestedVolunteer rv : list) {
                if (typeComboBox.getValue() == rv.getUserType()) {
                    reqList.add(rv) ;
                }
            }
        }
        if (acceptedCheckBox.isSelected()) {
            for (RequestedVolunteer rv : list) {
                if (rv.getStatus() == "Accepted") {
                    reqList.add(rv) ;
                }
            }
        }
        else if (rejectedCheckBox.isSelected()) {
            for (RequestedVolunteer rv : list) {
                if (rv.getStatus() == "Rejected") {
                    reqList.add(rv) ;
                }
            }
        }
        else if (pendingCheckBox.isSelected()) {
            for (RequestedVolunteer rv : list) {
                if (rv.getStatus() == "Pending") {
                    reqList.add(rv) ;
                }
            }
        }
        else {
            for (RequestedVolunteer rv : list) {
                if (rv.getStatus() == "Accepted") {
                    reqList.add(rv) ;
                }
            }
        }
        requestTableView.setItems(reqList) ;
        for(RequestedVolunteer rv: reqList) {
            requestIdComboBox.getItems().add(rv.getId()) ;
        }
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        placeTableColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("requesterId"));
        uTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("userType"));
        
        for (String s: tp.getVolunteerRequester()) {
            typeComboBox.getItems().add(s) ;
        }
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoard5SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void acceptOnMouseClick(MouseEvent event) {
        for (RequestedVolunteer rv: list) {
            if (rv.getId().equals(requestIdComboBox.getValue())) {
                if(user.getRequestForVolunteer(rv.getAmount())) {
                    rv.setStatus("Accepted") ;
                    rv.setAccepterId(user.getId()) ;
                    break ;
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR) ;
                    alert.setHeaderText("Sorry!") ;
                    alert.setContentText("Not enough free volunteer for work.");
                    alert.showAndWait() ;
                }
            }
        }
    }

    @FXML
    private void rejectOnMouseClick(MouseEvent event) {
        for (RequestedVolunteer rv: list) {
            if (rv.getId() == requestIdComboBox.getValue()) {
                rv.setStatus("Rejected");
                break ;
            }
        }
    }

    @FXML
    private void comboBoxOnMouseClick(MouseEvent event) {
        for (RequestedVolunteer rv: list) {
            if (rv.getId() == requestIdComboBox.getValue()) {
                showTextArea.setText(rv.toString()) ;
                break ;
            }
        }
    }
    
    @FXML
    private void checkBoxOnMouseClick(MouseEvent event) {
        tableShow() ;
    }
    
    private ObservableList<RequestedVolunteer> fileRead() {
        ObservableList<RequestedVolunteer> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/RequestVolunteer.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            RequestedVolunteer st ;
            try {
                while(true){
                    st = (RequestedVolunteer)ois.readObject();
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
    
      private void fileWrite(RequestedVolunteer stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/RequestVolunteer.bin");
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
            Logger.getLogger(VolunteerRequestSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(VolunteerRequestSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
      }
}
