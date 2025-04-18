/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal6_RequestMedicalCampaign;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Saima.User4_Doctor.Doctor;
import mainpkg.Saima.User4_Doctor.DoctorDashBoardSceneFxmlController;


public class RequestMedicalCampaignSceneFxmlController implements Initializable {

    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private ComboBox<String> timeComboBox;
    @FXML    private ComboBox<String> placeComboBox;
    @FXML    private TextField reasonTextField;
    @FXML    private TextArea descriptionTextArea;
    @FXML    private TableView<Campaign> campaignTableView;
    @FXML    private TableColumn<Campaign, String> idTableColumn;
    @FXML    private TableColumn<Campaign, String> reasonTableColumn;
    @FXML    private TableColumn<Campaign, Date> dateTableColumn;
    @FXML    private TableColumn<Campaign, String> timeTableColumn;
    @FXML    private TableColumn<Campaign, String> placeTableColumn;
    @FXML    private TableColumn<Campaign, String> descriptionTableColumn;
    @FXML    private TableColumn<Campaign, String> statusTableColumn;
    @FXML    private CheckBox acceptedCheckBox;
    @FXML    private CheckBox rejectedCheckBox;
    @FXML    private CheckBox pendingCheckBox;
    
    Doctor user ;
    Alert alert ;
    Time_Place tp = new Time_Place() ;

    

    
     public Doctor get() {
        return user ;
    }
    
    public void set(Doctor u) {
        user = u ;
        setTable() ;
    }
    
    public void setTable() {
        campaignTableView.getItems().clear() ; 
        
        ObservableList<Campaign> table = fileRead() ;
        ObservableList<Campaign> reqList = FXCollections.observableArrayList() ;
        if (acceptedCheckBox.isSelected()) {
            for (Campaign rv : table) {
                if (rv.getStatus() == "Accepted") {
                    reqList.add(rv) ;
                }
            }
        }
        if (rejectedCheckBox.isSelected()) {
            for (Campaign rv : table) {
                if (rv.getStatus() == "Rejected") {
                    reqList.add(rv) ;
                }
            }
        }
        if (pendingCheckBox.isSelected()) {
            for (Campaign rv : table) {
                if (rv.getStatus() == "Pending") {
                    reqList.add(rv) ;
                }
            }
        }
        else {
            reqList = table ;
        }
        campaignTableView.setItems(reqList) ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        timeComboBox.setItems(tp.getCampaignTime()) ;
        placeComboBox.setItems(tp.getCampaignPlace()) ;
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason")) ;
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date")) ;
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<>("time")) ;
        placeTableColumn.setCellValueFactory(new PropertyValueFactory<>("place")) ;
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("des")) ;
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status")) ;
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DoctorDashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DoctorDashBoardSceneFxmlController ddsc = myLoader.getController() ;
        ddsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void applyOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String reason = "" , des = "" , time = "" , place = "" , sdd = "" , smm = "" , syyyy = "" ;
        int dd = 0 , mm = 0 , yyyy = 0 ;
        
        reason = reasonTextField.getText() ;
        if (reason.length() == 0){
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Reason must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        des = descriptionTextArea.getText() ;
        if (des.length() == 0){
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Description must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        time = timeComboBox.getValue() ;
        if (time.length() == 0){
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Time must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        place = placeComboBox.getValue() ;
        if (place.length() == 0){
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Place must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        if (sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Date must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        else {
            dd = Integer.parseInt(sdd) ;
            mm = Integer.parseInt(smm) ;
            yyyy = Integer.parseInt(syyyy) ;
        }
        Date date = new Date(dd , mm , yyyy) ;
            if (date.isValid() == false){
                alert = new Alert(Alert.AlertType.ERROR) ;
                alert.setHeaderText("Error") ;
                alert.setContentText("Invalid Date.") ;
                rtn = false ;
                alert.showAndWait() ;
        }            
        
     
        
        if (rtn == true) {
            Campaign cam = user.requestForMedicalCampaign(time,  place,  reason,  user.getUserType(), des, user.getName(), date, user.getId()) ;
            fileWrite(cam) ;
            setTable() ;
            System.out.println("Pressed");
            alert = new Alert(Alert.AlertType.INFORMATION) ;
            alert.setHeaderText("Done") ;
            alert.setContentText("Apply for Campaign is sucessfull.") ;
            alert.showAndWait() ;
            setTable() ;
        }
    }
    
    @FXML
    private void checkBoxOnMouseClick(MouseEvent event) {
        setTable() ;
    }
    
    private ObservableList<Campaign> fileRead() {
        ObservableList<Campaign> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/MedicalCampaign.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Campaign st ;
            try {
                while(true){
                    st = (Campaign)ois.readObject();
                    if (st.getSenderId()== user.getId()) {
                        studList.add(st) ;
                    }
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
    
    private void fileWrite(Campaign stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/MedicalCampaign.bin");
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
            Logger.getLogger(RequestMedicalCampaignSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(RequestMedicalCampaignSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
  
    
}
