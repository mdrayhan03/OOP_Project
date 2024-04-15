package mainpkg.Rayhan.User7.Goal7_Holiday;

import java.io.IOException;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Holiday;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Rayhan.User7.DashBoard7SceneFxmlController;
import mainpkg.Rayhan.User7.SecurityIncharge;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class HolidaySceneFxmlController implements Initializable {

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
    @FXML    private CheckBox acceptedCheckBox;
    @FXML    private CheckBox rejectedCheckBox;
    @FXML    private CheckBox pendingCheckBox;
    
    ObservableList<Holiday> list = FXCollections.observableArrayList() ;
    SecurityIncharge user ;

    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    public SecurityIncharge get() {
        return user ;
    }
    
    public void set(SecurityIncharge u) {
        user = u ;
        listShow() ;
    }
    
    public void listShow() {
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
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id")) ;
        reasonTableColumn.setCellValueFactory(new PropertyValueFactory<>("reason")) ;
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("startDate")) ;
        sDTableColumn.setCellValueFactory(new PropertyValueFactory<>("startDate")) ;
        eDTableColumn.setCellValueFactory(new PropertyValueFactory<>("endDate")) ;
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date")) ;
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status")) ;
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
            listShow() ;
        }
    }
    
//    private ObservableList<Volunteer> fileRead() {
//        ObservableList<Volunteer> studList = FXCollections.observableArrayList() ;
//        
//        File f = null;
//        FileInputStream fis = null;      
//        ObjectInputStream ois = null;
//        
//        try {
//            f = new File("src/File/VCVolunteer.bin");
//            fis = new FileInputStream(f);
//            ois = new ObjectInputStream(fis);
//            Volunteer st ;
//            try {
//                while(true){
//                    st = (Volunteer)ois.readObject();
////                    System.out.println(st);
//                    studList.add(st) ;
//                }
//            }//end of nested try
//            catch(Exception e){
//                // handling code
//            }//nested catch     
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//        } 
//        finally {
//            try {
//                
//                if(ois != null) ois.close();
//            } catch (IOException ex) { }
//        }           
//        
//        return studList ;
//    }
//    
//    private void fileWrite(Volunteer stu) {
//        File f = null;
//        FileOutputStream fos = null;      
//        ObjectOutputStream oos = null;
//        
//        try {
//            f = new File("src/File/VCVolunteer.bin");
//            if(f.exists()){
//                fos = new FileOutputStream(f,true);
//                oos = new AppendableObjectOutputStream(fos);                
//            }
//            else{
//                fos = new FileOutputStream(f);
//                oos = new ObjectOutputStream(fos);               
//            }
//            oos.writeObject(stu);
//
//        } catch (IOException ex) {
//            Logger.getLogger(VolunteerInfoSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(oos != null) oos.close();
//            } catch (IOException ex) {
//                Logger.getLogger(VolunteerInfoSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }                
//    }
}
