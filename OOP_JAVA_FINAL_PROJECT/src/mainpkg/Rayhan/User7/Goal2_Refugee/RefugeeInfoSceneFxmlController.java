package mainpkg.Rayhan.User7.Goal2_Refugee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.Rasel.Refugee.Refugee;
import mainpkg.Rayhan.User7.DashBoard7SceneFxmlController;
import mainpkg.Rayhan.User7.SecurityIncharge;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class RefugeeInfoSceneFxmlController implements Initializable {

    @FXML    private ComboBox<Integer> idComboBox;
    @FXML    private Label nameLabel;
    @FXML    private Label pNLabel;
    @FXML    private Label emailLabel;
    @FXML    private Label dobLabel;
    @FXML    private Label shelterLabel;
    @FXML    private Label showLabel;
    
    
    SecurityIncharge user ;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public void set(SecurityIncharge u) {
        user = u ;
    }
    
    public void setComboBox() {
        ObservableList<Refugee> list = fileRead() ;
        for(Refugee ref: list) {
            idComboBox.getItems().add(ref.getId()) ;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        stage.setTitle("Security Incharge") ;
        stage.show() ;
    }

    @FXML
    private void idOnMouseClick(MouseEvent event) {
        Refugee ref = user.refugeeInfo(idComboBox.getValue(), fileRead()) ;
        if (ref != null) {
            nameLabel.setText(ref.getName()) ;
            pNLabel.setText(ref.getPhoneNo()) ;
            emailLabel.setText(ref.getEmail()) ;
            dobLabel.setText(ref.getDob()) ;
            shelterLabel.setText(ref.getName()) ;
            showLabel.setText(ref.getName()) ;
        }
        else {
            try{}
            catch(Exception e) {
                System.out.println(e.getClass().getName());
            }
        }
    }
    
    private ObservableList<Refugee> fileRead() {
        ObservableList<Refugee> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/Refugee.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Refugee st ;
            try {
                while(true){
                    st = (Refugee)ois.readObject();
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
    
}
