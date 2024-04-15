/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal1_AddFood;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rasel.CampManager.Goal5_Supply.Food;
import mainpkg.Saima.User3_AidExcutive.AidExcutive;
import mainpkg.Saima.User3_AidExcutive.AidExcutiveDashBoardSceneFxmlController;
import mainpkg.Saima.User3_AidExcutive.Goal8_Report.ReportSceneFxmlController;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AddFoodSceneFxmlController implements Initializable {

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
    private TableView<Food> addFoodTableView;
    @FXML
    private TableColumn<Food, String> idTableColumn;
    @FXML
    private TableColumn<Food, String> nameTableColumn;
    @FXML
    private TableColumn<Food, Integer> amountTableColumn;
    @FXML
    private TableColumn<Food, Date> dateTableColumn;
    @FXML
    private TableColumn<Food, String> statusTableColumn;

    /**
     * Initializes the controller class.
     */
    
    
      
    ObservableList<Food> rlist =  FXCollections.observableArrayList() ;
    Time_Place tp = new Time_Place() ;
    AidExcutive user ;
    Alert alert ;
    

    
    public AidExcutive get() {
        return user ;
    }
    
    public void set(AidExcutive u) {
        user = u ;
        tableShow() ;
    }
    
    public void tableShow() {
        ObservableList<Food> list =  fileRead() ;
        ObservableList<Food> rList = FXCollections.observableArrayList() ;
        

        addFoodTableView.setItems(rlist) ;
    }
        
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("apply"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        itemComboBox.setItems(tp.getAidexcutivefoodName()) ;
        itemComboBox.setValue(tp.getAidexcutivefoodName().get(0)) ;
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User3_AidExcutive/AidExcutiveDashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        ReportSceneFxmlController psc = myLoader.getController() ;

        psc.set(user) ;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("AidExcutive DashBoard") ;
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
            Food ad= user.addFood(user.getId() , user.getUserType() , name, amount, date) ;
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
        
        private ObservableList<Food> fileRead() {
        ObservableList<Food> fdList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/AEAddFood.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Food food ;
            try {
                while(true){
                    food = (Food)ois.readObject();
//                    System.out.println(st);
                    fdList.add(food) ;
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
    
    private void fileWrite(Food fD) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/AEAddFood.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(fD);

        } catch (IOException ex) {
            Logger.getLogger(AddFoodSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddFoodSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }

    private void fileUpdate(Food s) {
        ObservableList<Food> sList = fileRead() ;
        File f = new File("AEAddFood.bin") ;
       
        if(f.exists()) {
            f.delete() ;
        }
       
        for(Food st: sList) {
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
