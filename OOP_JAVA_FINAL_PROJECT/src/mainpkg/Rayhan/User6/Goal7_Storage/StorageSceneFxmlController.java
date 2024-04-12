package mainpkg.Rayhan.User6.Goal7_Storage;

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.RequestedItems;
import mainpkg.Rayhan.User6.DashBoard6SceneFxmlController;
import mainpkg.Rayhan.User6.EducationCoordinator;
import mainpkg.Rayhan.User6.Goal5_Needs.NeedsSceneFxmlController;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class StorageSceneFxmlController implements Initializable {

    @FXML    private Label gBoxDLabel;
    @FXML    private Label bookStockLabel;
    @FXML    private Label noteStockLabel;
    @FXML    private Label penStockLabel;
    @FXML    private Label pBoxStockLabel;
    @FXML    private Label rubberStockLabel;
    @FXML    private Label pencilStockLabel;
    @FXML    private Label gBoxStockLabel;
    @FXML    private Label bookDLabel;
    @FXML    private Label noteDLabel;
    @FXML    private Label penDLabel;
    @FXML    private Label pBoxDLabel;
    @FXML    private Label rubberDLabel;
    @FXML    private Label pencilDLabel;
    @FXML    private ComboBox<String> itemComboBox;
    @FXML    private TextField amountTextField;
    
    Time_Place tp = new Time_Place() ;
    EducationCoordinatorStorage st ;
    EducationCoordinator user ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public EducationCoordinator get() {
        return user ;
    }
    
    public void set(EducationCoordinator u) {
        user = u ;
//        st = fileRead().get(0) ;
        show() ;
    }
    
    public void show() {
        st = fileRead().get(0) ;
        gBoxDLabel.setText(Integer.toString(st.getdGeometryBox())) ;
        bookStockLabel.setText(Integer.toString(st.getsBook())) ;
        noteStockLabel.setText(Integer.toString(st.getsNote())) ;
        penStockLabel.setText(Integer.toString(st.getsPen())) ;
        pBoxStockLabel.setText(Integer.toString(st.getsPencilBox())) ;
        rubberStockLabel.setText(Integer.toString(st.getsRubber())) ;
        pencilStockLabel.setText(Integer.toString(st.getsPencil())) ;
        gBoxStockLabel.setText(Integer.toString(st.getsGeometryBox())) ;
        bookDLabel.setText(Integer.toString(st.getdBook())) ;
        noteDLabel.setText(Integer.toString(st.getdNote())) ;
        penDLabel.setText(Integer.toString(st.getdPen())) ;
        pBoxDLabel.setText(Integer.toString(st.getdPencilBox())) ;
        rubberDLabel.setText(Integer.toString(st.getdRubber())) ;
        pencilDLabel.setText(Integer.toString(st.getdPencil())) ;
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        itemComboBox.setItems(tp.getEducationCoordinatorItem()) ;
        itemComboBox.setValue(tp.getEducationCoordinatorItem().get(0)) ;
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User6/DashBoard6SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard6SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Education Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void distributionOnMouseClick(MouseEvent event) {
        Boolean rtn = true ;
        String name , samount = "" ;
        int amount = 0 ;
        
        name = itemComboBox.getValue() ;
        
        samount = amountTextField.getText() ;
        if (samount.length() == 0) {
            
        }
        if (rtn = true) {
            st.update(name, amount) ;
            fileWrite(st) ;
        }
    }
    
    private ObservableList<EducationCoordinatorStorage> fileRead() {
        ObservableList<EducationCoordinatorStorage> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/RequestedItems.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            EducationCoordinatorStorage st ;
            try {
                while(true){
                    st = (EducationCoordinatorStorage)ois.readObject();                    
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
    
    private void fileWrite(EducationCoordinatorStorage stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/RequestedItems.bin");
            if(f.exists()){
//                fos = new FileOutputStream(f,true);
//                oos = new AppendableObjectOutputStream(fos); 
                f.delete() ;
            }
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);               
            
            oos.writeObject(stu);

        } catch (IOException ex) {
            Logger.getLogger(NeedsSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(NeedsSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }

    
    
    
}
