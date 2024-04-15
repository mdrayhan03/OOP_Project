/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User3_AidExcutive.Goal2_DistributeFood;

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

public class DistributeFoodSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> foodNameComboBox;
    @FXML    private TextField foodQuantityTextField;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    @FXML    private TableColumn<Food, String> distributeIdTableColumn;
    @FXML    private TableColumn<Food, String> foodNameTableColumn;
    @FXML    private TableColumn<Food, String> foodQuantityTableColumn;
    @FXML    private TableColumn<Food, Date> distributeDateTableColumn;
    @FXML    private TableColumn<Food, String> distributeByTableColumn;

    Alert alert ;
    AidExcutive user ;
    ObservableList<Food> list = FXCollections.observableArrayList() ;
    @FXML    private TableView<Food> distributeFoodTableView;
    Time_Place tp = new Time_Place() ;
    public AidExcutive get() {
        return user ;
    }
    
    public void set(AidExcutive u) {
        user = u ;
        tableShow() ;
    }
    
    public void tableShow() {
        ObservableList<Food> list = fileRead() ;
        distributeFoodTableView.setItems(list) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        distributeIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("distributeFoodId")) ;
        foodNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("foodName")) ;
        foodQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("foodQuantity")) ;
        distributeDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("distributeDate")) ;
        distributeByTableColumn.setCellValueFactory(new PropertyValueFactory<>("distributeBy")) ;
        
        foodNameComboBox.setItems(tp.getAidexcutivefoodName()) ;
    }    

    @FXML
    private void backButtonOnMouseClicked(MouseEvent event) throws IOException {
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
    private void distributeOnMouseClicked(MouseEvent event) {
        String amount= "" ;
        String name = ""  , dd = "" , mm = "" , yyyy = ""  ;
        int add = 0 , amm = 0 , ayyyy = 0,amu=0  ;
        Boolean rtn = true ;
        
        amount = foodQuantityTextField.getText();
        amu=Integer.parseInt(amount);
        dd= ddTextField.getText();
        mm=mmTextField.getText();
        yyyy=yyyyTextField.getText();
        
        add=Integer.parseInt(dd);
        amm=Integer.parseInt(mm);
        ayyyy=Integer.parseInt(yyyy);
        
        Date date=new Date(add,amm,ayyyy);
        
        name=foodNameComboBox.getValue();
        if (rtn == true && this.checkDate(date)) {
        
          Food food = user.distributeFood(user.getId() , user.getUserType() , name, amu, date);
            fileWrite(food) ;
            
            tableShow() ;
            foodQuantityTextField.clear() ;
            ddTextField.clear() ;
            mmTextField.clear() ;
            yyyyTextField.clear() ;
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText(" Error") ;
            alert.setContentText("Distribution is not Valid.") ;
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
        ObservableList<Food> list = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/AEDistributeFood.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Food food ;
            try {
                while(true){
                    food  = (Food)ois.readObject();
                    list.add(food ) ;
                }
            } catch(Exception e){
                // handling code
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
        
        return list ;
    }
    
    private void fileWrite(Food fd) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/AEDistributeFood.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(fd);

        } catch (IOException ex) {
            Logger.getLogger(DistributeFoodSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(DistributeFoodSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
}
    

