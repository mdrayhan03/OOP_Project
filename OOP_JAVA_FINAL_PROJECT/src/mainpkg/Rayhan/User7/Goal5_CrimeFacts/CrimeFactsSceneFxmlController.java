package mainpkg.Rayhan.User7.Goal5_CrimeFacts;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.Rayhan.User7.DashBoard7SceneFxmlController;
import mainpkg.Rayhan.User7.SecurityIncharge;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class CrimeFactsSceneFxmlController implements Initializable {

    @FXML    private TextArea descriptionTextArea;
    @FXML    private ComboBox<String> crimeIdComboBox;
    @FXML    private TableView<CrimeFact> crimeTableView;
    @FXML    private TableColumn<CrimeFact , String> idTableColumn;
    @FXML    private TableColumn<CrimeFact , Integer> reporterIdTableColumn;
    @FXML    private TableColumn<CrimeFact , String> nameTableColumn;
    @FXML    private TableColumn<CrimeFact , String> descriptionTableColumn;
    @FXML    private Label reporterIdLabel;
    
    
    
    SecurityIncharge user ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void set (SecurityIncharge u) {
        user = u ;
        tableShow() ;
    }
    
    public void tableShow() {
        ObservableList<CrimeFact> list = fileRead() ;
        crimeTableView.setItems(list) ;
    }
    
    public void setComboBox() {
        ObservableList<CrimeFact> list = fileRead() ;
        for (CrimeFact cf: list) {
            crimeIdComboBox.getItems().add(cf.getId()) ;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("reporterName")) ;
        reporterIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("reporterId")) ;
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("des")) ;
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
        stage.setTitle("Security Incharge DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void idComboBoxOnMouseClick(MouseEvent event) {
        ObservableList<CrimeFact> list = fileRead() ;
        for (CrimeFact cf: list) {
            if (cf.getId() == crimeIdComboBox.getValue()) {
                reporterIdLabel.setText(cf.getReporterName()) ;
                descriptionTextArea.setText(cf.getDes()) ;
                break ;
            }
        }
    }
    
    private ObservableList<CrimeFact> fileRead() {
        ObservableList<CrimeFact> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/CrimeFact.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            CrimeFact st ;
            try {
                while(true){
                    st = (CrimeFact)ois.readObject();
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
    
       private void fileWrite(CrimeFact stu) {
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
            Logger.getLogger(CrimeFactsSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CrimeFactsSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
}
