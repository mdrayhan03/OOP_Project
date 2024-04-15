/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal5_RequestVolunteer;

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
import mainpkg.Rayhan.User5.Goal4_VRequest.RequestedVolunteer;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RequestVolunteerSceneFxmlController implements Initializable {

    @FXML    private TextField reasonTextField;
    @FXML    private TextArea descriptionTextArea;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextField amountTextField;
    @FXML    private ComboBox<String> timeComboBox;
    @FXML    private ComboBox<String> placeComboBox;
    @FXML private TableView<RequestedVolunteer> requestVolunteertTableView;
    @FXML    private TableColumn<RequestedVolunteer, String> requestIdTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> reasonTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> descriptionTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> placeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> timeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Date> dateTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Integer> amountTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    ObservableList<RequestedVolunteer> list = FXCollections.observableArrayList() ;
    Doctor user ;
    Time_Place tp = new Time_Place() ;
    Alert alert ;
   
 
    
    public Doctor get() {
        return user ;
    }
    public void set(Doctor u) {
        user = u ;
        tableShow() ;
    }
    public void tableShow() {
        ObservableList<RequestedVolunteer> list = fileRead() ;
        requestVolunteertTableView.setItems(list) ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         timeComboBox.setItems(tp.getCampaignTime()) ;
        timeComboBox.setValue(tp.getCampaignTime().get(0)) ;
        placeComboBox.setItems(tp.getCampaignPlace()) ;
        placeComboBox.setValue(tp.getCampaignPlace().get(0)) ;
        
        requestIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason")) ;
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description")) ;
        placeTableColumn.setCellValueFactory(new PropertyValueFactory<>("place")) ;
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<>("name")) ;
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("name")) ;
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status")) ;
    }    

    @FXML
    private void backOnMouseClicked(MouseEvent event) throws IOException {
        
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DoctorDashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void requestOnMouseClicked(MouseEvent event) {
        Boolean rtn = true ;
        String reason = "" , des = "" , sdd = "" , smm = "" , syyyy = "" , time = "" , place = "" ;
        int amount = 0 , dd = 0 , mm = 0 , yyyy = 0 ;
        
        reason = reasonTextField.getText() ;
        if (reason.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error");
            alert.setContentText("Reason must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        des = descriptionTextArea.getText() ;
        if (des.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error");
            alert.setContentText("Description must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        amount = Integer.parseInt(amountTextField.getText()) ;
        
        sdd = ddTextField.getText() ;
        smm = mmTextField.getText() ;
        syyyy = yyyyTextField.getText() ;
        System.out.println(sdd + "," + smm + "," + syyyy) ;
        if (sdd.length() == 0 || smm.length() == 0 || syyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error");
            alert.setContentText("Date must.");
            rtn = false ;
            alert.showAndWait() ;
        }
        else {
            dd = Integer.parseInt(sdd) ;
            mm = Integer.parseInt(smm) ;
            yyyy = Integer.parseInt(syyyy) ;
        }
        
        Date date = new Date(dd , mm , yyyy) ;
        if (date.isValid() == false) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error");
            alert.setContentText("Date is not Valid.");
            rtn = false ;
            alert.showAndWait() ;
        }
        
        time = timeComboBox.getValue() ;
        place = placeComboBox.getValue() ;
        
        if (rtn == true) {
            RequestedVolunteer rq = user.requestForVolunteer(user.getId(), user.getName(), amount, reason, des, user.getUserType(), time, place, date) ;
            fileWrite(rq) ;
            tableShow() ;
            
            reasonTextField.clear() ;
            descriptionTextArea.clear() ;
            ddTextField.clear() ;
            mmTextField.clear() ;
            yyyyTextField.clear() ;
            amountTextField.clear() ;
        }
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
                    if (st.getRequesterId() == user.getId()) {
                    System.out.println(st);
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
        Logger.getLogger(RequestVolunteerSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if(oos != null) oos.close();
        } catch (IOException ex) {
            Logger.getLogger(RequestVolunteerSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                
}
    
}
