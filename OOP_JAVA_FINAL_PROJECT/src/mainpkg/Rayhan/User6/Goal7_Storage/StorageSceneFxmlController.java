package mainpkg.Rayhan.User6.Goal7_Storage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import mainpkg.AbstractClass.Time_Place;

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
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public void show() {
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
        }
    }
    
}
