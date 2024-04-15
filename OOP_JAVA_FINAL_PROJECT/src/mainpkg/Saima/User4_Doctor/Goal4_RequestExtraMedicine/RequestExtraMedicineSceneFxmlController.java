/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal4_RequestExtraMedicine;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.RequestedItems;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;
import mainpkg.Saima.User3_AidExcutive.AidExcutiveDashBoardSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Goal4_RequestExtraFood.RequestExtraFoodSceneFxmlController;

import mainpkg.Saima.User4_Doctor.Doctor;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class RequestExtraMedicineSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> itemComboBox;
    @FXML    private TextField amountTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextField ddDeadlineTextField;
    @FXML    private TextField mmDeadlineTextField;
    @FXML    private TextField yyyyDeadlineTextField;
    @FXML    private TableView<RequestedItems> requestTableView;
    @FXML    private TableColumn<RequestedItems , String> idTableColumn;
    @FXML    private TableColumn<RequestedItems , String> nameTableColumn;
    @FXML    private TableColumn<RequestedItems , Integer> amountTableColumn;
    @FXML    private TableColumn<RequestedItems , Date> dateTableColumn;
    @FXML    private TableColumn<RequestedItems , Date> deadLineTableColumn;
    @FXML    private TableColumn<RequestedItems , String> statusTableColumn;
    @FXML    private CheckBox acceptedCheckBox;
    @FXML    private CheckBox rejectedCheckBox;
    @FXML    private CheckBox pendingCheckBox;
    @FXML    private ComboBox<String> iComboBox;
    
    ObservableList<RequestedItems> list =  FXCollections.observableArrayList() ;
    Time_Place tp = new Time_Place() ;
    Doctor user ;
    Alert alert ;
    

    
    public Doctor get() {
        return user ;
    }
    
    public void set(Doctor u) {
        user = u ;
        tableShow() ;
    }
    
    public void tableShow() {
        ObservableList<RequestedItems> list =  fileRead() ;
        ObservableList<RequestedItems> rList = FXCollections.observableArrayList() ;
        ObservableList<RequestedItems> reqList = FXCollections.observableArrayList() ;

        requestTableView.setItems(list) ;
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("apply"));
        deadLineTableColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        itemComboBox.setItems(tp.getAidexcutivefoodName()) ;
        itemComboBox.setValue(tp.getAidexcutivefoodName().get(0)) ;
        iComboBox.setItems(tp.getAidexcutivefoodName()) ;
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/AidExcutiveDashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        AidExcutiveDashBoardSceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("AidExcutive DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void requestOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String name = "" , samount = "" , sadd = "" , samm = "" , sayyyy = "" , sddd = "" , sdmm = "" , sdyyyy = "" ;
        int add = 0 , amm = 0 , ayyyy = 0 , ddd = 0 , dmm = 0 , dyyyy = 0 , amount = 0 ;
        
        samount=amountTableColumn.getText();
         if (samount.length() == 0 ) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Apply Amount must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
         else{
        amount=Integer.parseInt(samount);
         }
        name = itemComboBox.getValue() ;
        if (name.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Item name ");
        }
        
        sadd = ddTextField.getText() ;
        samm = mmTextField.getText() ;
        sayyyy = yyyyTextField.getText() ;
        if (sadd.length() == 0 || samm.length() == 0 || sayyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Apply Date must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        else {
            add = Integer.parseInt(sadd) ;
            amm = Integer.parseInt(samm) ;
            ayyyy = Integer.parseInt(sayyyy) ;
        }
        Date apply = new Date(add , amm , ayyyy) ;
        
        sddd = ddDeadlineTextField.getText() ;
        sdmm = mmDeadlineTextField.getText() ;
        sdyyyy = yyyyDeadlineTextField.getText() ;
        if (sddd.length() == 0 || sdmm.length() == 0 || sdyyyy.length() == 0) {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Error") ;
            alert.setContentText("Apply Date must.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        else {
            ddd = Integer.parseInt(sddd) ;
            dmm = Integer.parseInt(sdmm) ;
            dyyyy = Integer.parseInt(sdyyyy) ;
        }
        Date deadline = new Date(ddd , dmm , dyyyy) ;
        
        if (rtn == true && this.checkDate(apply, deadline)) {
            RequestedItems req = user.request(user.getId() , user.getUserType() , name, amount, apply, deadline) ;
            fileWrite(req) ;
            tableShow() ;
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("Request Error") ;
            alert.setContentText("Request is not Valid.") ;
            alert.showAndWait() ;
        }
    }
    
        public boolean checkDate (Date d , Date a) {
        Boolean rtn = false ;
        if(a.getYyyy() > d.getYyyy()) {
            rtn = true ;
        }
        else if (a.getYyyy() == d.getYyyy()) {
            if (a.getMm() > d.getMm()) {
                rtn = true ;
            }
            else if (a.getMm() == d.getMm()) {
                if (a.getDd() >= d.getDd()) {
                    rtn = true ;
                }
            }
            
        }
        
        return rtn ;
    }
        
        private ObservableList<RequestedItems> fileRead() {
        ObservableList<RequestedItems> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/AErequestFood.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            RequestedItems st ;
            try {
                while(true){
                    st = (RequestedItems)ois.readObject();
                    if (st.getSenderId() == user.getId()) {
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
    
    private void fileWrite(RequestedItems stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/AErequestFood.bin");
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
            Logger.getLogger(RequestExtraFoodSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(RequestExtraFoodSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
    
