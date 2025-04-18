/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal1_AddMedicine;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rasel.CampManager.Goal5_Supply.Medicine;
import mainpkg.Saima.User4_Doctor.Doctor;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddMedicineSceneFxmlController implements Initializable {

    @FXML
    private Label mmLabel;
    @FXML
    private Label yyyyLabel;
    @FXML
    private ComboBox<String> itemComboBox;
    @FXML
    private TextField amountTextField;
    @FXML
    private TextField ddTextField;
    @FXML
    private TextField mmTextField;
    @FXML
    private TextField yyyyTextField;
    @FXML
    private TableColumn<Medicine, String> idTableColumn;
    @FXML
    private TableColumn<Medicine, String> nameTableColumn;
    @FXML
    private TableColumn<Medicine, Integer> amountTableColumn;
    @FXML
    private TableColumn<Medicine, Date> dateTableColumn;

    /**
     * Initializes the controller class.
     */
    
    ObservableList<Medicine> rlist =  FXCollections.observableArrayList() ;
    Time_Place tp = new Time_Place() ;
    Doctor user ;
    Alert alert ;
    @FXML
    private TableView<Medicine> addMedicineTableView;
    

    
    public Doctor get() {
        return user ;
    }
    
    public void set(Doctor u) {
        user = u ;
        tableShow() ;
    }
    
    public void tableShow() {
        ObservableList<Medicine> list =  fileRead() ;
        ObservableList<Medicine> rList = FXCollections.observableArrayList() ;
        

       addMedicineTableView.setItems(rlist) ;
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("apply"));
       
        
        itemComboBox.setItems(tp.getAidexcutivefoodName()) ;
        itemComboBox.setValue(tp.getAidexcutivefoodName().get(0)) ;
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DoctorDashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        AddMedicineSceneFxmlController psc = myLoader.getController() ;
        psc.set(user) ;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void addOnMouseClick(MouseEvent event) {
        
        Boolean rtn = true ;
        String name = "" , samount = "" , sadd = "" , samm = "" , sayyyy = "" , sddd = "" , sdmm = "" , sdyyyy = "" ;
        int add = 0 , amm = 0 , ayyyy = 0 , ddd = 0 , dmm = 0 , dyyyy = 0 , amount = 0 ;
        
        samount=amountTextField.getText();
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
        Date date = new Date(add , amm , ayyyy) ;
        
        
        
        if (rtn == true && this.checkDate(date)) {
            Medicine ad= user.addMedicine(user.getId() , user.getUserType() , name, amount, date) ;
            fileWrite(ad) ;
            tableShow() ;
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText(" Error") ;
            alert.setContentText("Addtion is not Valid.") ;
            alert.showAndWait() ;
        }
    }
    
        public boolean checkDate (Date d) {
        Boolean rtn = false ;
        if(d.getYyyy() > d.getYyyy()) {
            rtn = true ;
        }
        else if (d.getYyyy() == d.getYyyy()) {
            if (d.getMm() > d.getMm()) {
                rtn = true ;
            }
            else if (d.getMm() == d.getMm()) {
                if (d.getDd() >= d.getDd()) {
                    rtn = true ;
                }
            }
            
        }
        
        return rtn ;
    }
        
        private ObservableList<Medicine> fileRead() {
        ObservableList<Medicine> fdList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/DcAddMedicine.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Medicine m;
            try {
                while(true){
                    m= (Medicine)ois.readObject();
//                    System.out.println(st);
                    fdList.add(m) ;
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
        
        return fdList ;
    }
    
    private void fileWrite(Medicine me) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/DcAddMedicine.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(me);

        } catch (IOException ex) {
            Logger.getLogger(AddMedicineSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddMedicineSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }

    private void fileUpdate(Medicine s) {
        ObservableList<Medicine> sList = fileRead() ;
        File f = new File("DcAddMedicine.bin") ;
       
        if(f.exists()) {
            f.delete() ;
        }
       
        for(Medicine st: sList) {
            if(st.getId() != s.getId()) {
                fileWrite(st) ;
            }
           
            else if (st.getId() == s.getId()) {
                System.out.println("Found");
                fileWrite(s) ;
            }
        }
    }
    
    }
    

