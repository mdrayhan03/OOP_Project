/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Goal7_RequestExtraHoliday;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Holiday;
import mainpkg.Saima.User4_Doctor.Doctor;
import mainpkg.Saima.User4_Doctor.DoctorDashBoardSceneFxmlController;

/**
 * FXML Controller class
 *
 * @author HP
 */
   

public class RequestExtraHolidaySceneFxmlController implements Initializable {

    @FXML    private TextField startddTextField;
    @FXML    private TextField startmmTextField;
    @FXML    private TextField startyyyyTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TextField endddTextField;
    @FXML    private TextField endmmTextField;
    @FXML    private TextField endyyyyTextField;
    @FXML    private TableView<Holiday> holidayTableView;
    @FXML    private TableColumn<Holiday , String> idTableColumn;
    @FXML    private TableColumn<Holiday , String> reasonTableColumn;
    @FXML    private TableColumn<Holiday , Date> sDTableColumn;
    @FXML    private TableColumn<Holiday , Date> eDTableColumn;
    @FXML    private TableColumn<Holiday , Date> dateTableColumn;
    @FXML    private TableColumn<Holiday , String> statusTableColumn;
    @FXML    private TextField reasonTextField;
    
    ObservableList<Holiday> list = FXCollections.observableArrayList() ;
    Doctor user ;
    Alert alert ;
    @FXML
    private CheckBox acceptedCheckBox;
    @FXML
    private CheckBox rejectedCheckBox;
    @FXML
    private CheckBox pendingCheckBox;
    

    public Doctor get() {
        return user ;
    }
    public void set(Doctor u) {
        user = u ;
//        tableShow();
    }
    
    public void tableShow() {
       ObservableList<Holiday> reqList = user.getHolidayList() ;
        if (acceptedCheckBox.isSelected()) {
            for (Holiday rv : list) {
                if (rv.getStatus() == "Accepted") {
                    reqList.add(rv) ;
                }
            
            }
        }
        
           else if (rejectedCheckBox.isSelected()) {
            for (Holiday rv : list) {
                if (rv.getStatus() == "Rejected") {
                    reqList.add(rv) ;
                }
            }
        }
        else if (pendingCheckBox.isSelected()) {
            for (Holiday rv : list) {
                if (rv.getStatus() == "Pending") {
                    reqList.add(rv) ;
                }
            }
        }
        else {
                reqList = list ;
             }
        holidayTableView.setItems(user.getHolidayList()) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason")) ;
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("startDate")) ;
        sDTableColumn.setCellValueFactory(new PropertyValueFactory<>("startDate")) ;
        eDTableColumn.setCellValueFactory(new PropertyValueFactory<>("endDate")) ;
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date")) ;
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status")) ;
        // TODO
    }    


    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
       Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DoctorDashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DoctorDashBoardSceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor") ;
        stage.show() ;
    }

    
    @FXML
    private void applyOnMouseClick(MouseEvent event) {
         Boolean rtn = true ;
        String reason , ssdd , ssmm , ssyyyy , sedd , semm , seyyyy , sadd , samm , sayyyy ;
        Integer sdd , smm , syyyy , edd , emm , eyyyy , add , amm , ayyyy ;
        
        reason = reasonTextField.getText() ;
        
        ssdd = startddTextField.getText() ;
        ssmm = startmmTextField.getText() ;
        ssyyyy = startyyyyTextField.getText() ;
        sdd = Integer.parseInt(ssdd) ;
        smm = Integer.parseInt(ssmm) ;
        syyyy = Integer.parseInt(ssyyyy) ;
        Date start = new Date(sdd , smm , syyyy) ;
        
        sedd = endddTextField.getText() ;
        semm = endmmTextField.getText() ;
        seyyyy = endyyyyTextField.getText() ;
        edd = Integer.parseInt(sedd) ;
        emm = Integer.parseInt(semm) ;
        eyyyy = Integer.parseInt(seyyyy) ;
        Date end = new Date(edd , emm , eyyyy) ;
        
        sadd = ddTextField.getText() ;
        samm = mmTextField.getText() ;
        sayyyy = yyyyTextField.getText() ;
        add = Integer.parseInt(sadd) ;
        amm = Integer.parseInt(samm) ;
        ayyyy = Integer.parseInt(sayyyy) ;
        Date apply = new Date(add , amm , ayyyy) ;
        System.out.println(start.isValid() + "," + end.isValid() + "," + apply.isValid()) ;
        if(start.isValid() && end.isValid() && apply.isValid()) {
            rtn = user.requestToLeave(reason, start , end) ;
            tableShow() ;
        }
    }
    
        private ObservableList<Holiday> fileRead() {
        ObservableList<Holiday> holiList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/DocHoliday.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Holiday hd ;
            try {
                while(true){
                    hd = (Holiday)ois.readObject();
//                    System.out.println(st);
                    holiList.add(hd) ;
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
        
        return holiList ;
    }
    
    private void fileWrite(Holiday holiday) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/DocHoliday.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(holiday);

        } catch (IOException ex) {
            Logger.getLogger(RequestExtraHolidaySceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(RequestExtraHolidaySceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    private void fileUpdate(Holiday s) {
        ObservableList<Holiday> sList = fileRead() ;
        File f = new File("DocHoliday.bin") ;
       
        if(f.exists()) {
            f.delete() ;
        }
       
        for(Holiday st: sList) {
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

    

