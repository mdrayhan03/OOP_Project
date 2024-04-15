package mainpkg.Rayhan.User5.Goal4_VRequest;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.Time_Place;
import mainpkg.Rayhan.User5.DashBoard5SceneFxmlController;
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;
import mainpkg.Rayhan.User5.VolunteerCoordinator;

/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class VolunteerRequestSceneFxmlController implements Initializable {

    @FXML    private ComboBox<String> requestIdComboBox;
    @FXML    private TableView<RequestedVolunteer> requestTableView;
    @FXML    private TableColumn<RequestedVolunteer, String> idTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> timeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> placeTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Date> dateTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, Integer> amountTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> statusTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> nameTableColumn;
    @FXML    private TableColumn<RequestedVolunteer, String> uTypeTableColumn;
    private ComboBox<String> typeComboBox;
    @FXML    private CheckBox acceptedCheckBox;
    @FXML    private CheckBox rejectedCheckBox;
    @FXML    private CheckBox pendingCheckBox;
    @FXML    private Label freeLabel;
    @FXML    private Label onWorkLabel;
    @FXML    private TextArea showTextArea;
    
    VolunteerCoordinator user ;
    Time_Place tp = new Time_Place() ;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
//    public User get() {
//        return user ;
//    }
    public VolunteerCoordinator get() {
        return user ;
    }
    
    public void set(VolunteerCoordinator u) {
        user = u ; 
        System.out.println(user);
        tableShow() ;
    }
    
    public void tableShow() {
        ObservableList<RequestedVolunteer> list = fileRead() ;
        System.out.println(list) ;
        ObservableList<RequestedVolunteer> comlist = FXCollections.observableArrayList() ;
        ObservableList<RequestedVolunteer> reqList = FXCollections.observableArrayList() ;
        ObservableList<Volunteer> vclist = fileReadVC() ;
        System.out.println(vclist) ;
        int work = 0 , free = 0 ;
        for (Volunteer rv: vclist) {
            if ("Work".equals(rv.getStatus())) {
                work ++ ;
            }
            else if ("Free".equals(rv.getStatus())) {
                free ++ ;
            }
        }
        onWorkLabel.setText(Integer.toString(work)) ;
        freeLabel.setText(Integer.toString(free)) ;
        
        requestTableView.getItems().clear() ; 
        
//        String cb = "" ;
//        cb = typeComboBox.getValue() ;        
        comlist = list ;
//        if ("ALL User".equals(cb)|| cb.length() == 0)  {
//            comlist = list ;
//        }
//        else {
//            for (RequestedVolunteer rv : list) {
//                if (typeComboBox.getValue().equals(rv.getUserType())) {
//                    comlist.add(rv) ;
//                }
//            }
//        }
        if (acceptedCheckBox.isSelected()) {
            for (RequestedVolunteer rv : comlist) {
                if ("Accepted".equals(rv.getStatus())) {
                    reqList.add(rv) ;
                    System.out.println(reqList);
                }
            }
        }
        if (rejectedCheckBox.isSelected()) {
            for (RequestedVolunteer rv : comlist) {
                if ("Rejected".equals(rv.getStatus())) {
                    reqList.add(rv) ;
                }
            }
        }
        if (pendingCheckBox.isSelected()) {
            for (RequestedVolunteer rv : comlist) {
                if ("Pending".equals(rv.getStatus())) {
                    reqList.add(rv) ;
                }
            }
        }
        if (acceptedCheckBox.isSelected() && rejectedCheckBox.isSelected() && pendingCheckBox.isSelected() || !acceptedCheckBox.isSelected() && !rejectedCheckBox.isSelected() && !pendingCheckBox.isSelected()){
            reqList = comlist ;
        }
        requestTableView.setItems(reqList) ;
        for(RequestedVolunteer rv: reqList) {
            requestIdComboBox.getItems().add(rv.getId()) ;
        }
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        timeTableColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        placeTableColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("requesterId"));
        uTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("userType"));
        
//        for (String s: tp.getVolunteerRequester()) {
//            typeComboBox.getItems().add(s) ;
//        }
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Rayhan/User5/DashBoard5SceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;
        
        DashBoard5SceneFxmlController dsc = myLoader.getController() ;
        dsc.set(user) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Volunteer Coordinator DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void acceptOnMouseClick(MouseEvent event) {
        System.out.println("Accept") ;
        ObservableList<RequestedVolunteer> list = fileRead() ;
        for (RequestedVolunteer rv: list) {
            System.out.println(rv.getId().equals(requestIdComboBox.getValue())) ;
            if (rv.getId().equals(requestIdComboBox.getValue())) {
                if(user.getRequestForVolunteer(Integer.parseInt(freeLabel.getText()) , rv.getAmount())) {
                    rv.setStatus("Accepted") ;
                    System.out.println(rv) ;
                    fileUpdate(rv) ;
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
                    alert.setHeaderText("Acception") ;
                    alert.setContentText("Accepted Sucessfully.");
                    alert.showAndWait() ;
                    int amount = 0 ;
                    ObservableList<Volunteer> vclist = fileReadVC() ;
                    for (Volunteer vc: vclist) {
                        if (rv.getAmount() >= amount) {
                            if (vc.getStatus() == "Free") {
                                System.out.println(vc) ;
                                vc.setStatus("Work") ;
                                fileUpdateVC(vc) ;
                                amount ++ ;
                            }
                        }
                    }
                    break ;
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR) ;
                    alert.setHeaderText("Sorry!") ;
                    alert.setContentText("Not enough free volunteer for work.");
                    alert.showAndWait() ;
                }
            }
        }
        tableShow() ;
    }

    @FXML
    private void rejectOnMouseClick(MouseEvent event) {
        System.out.println("Reject") ;
        ObservableList<RequestedVolunteer> list = fileRead() ;
        for (RequestedVolunteer rv: list) {
            System.out.println(rv.getId().equals(requestIdComboBox.getValue())) ;
            if (rv.getId().equals(requestIdComboBox.getValue())) {
                rv.setStatus("Rejected");
                fileUpdate(rv) ;
                break ;
            }
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION) ;
        alert.setHeaderText("Rejection") ;
        alert.setContentText("Rejected Sucessfully.");
        alert.showAndWait() ;
        tableShow() ;
    }

    @FXML
    private void comboBoxOnMouseClick(MouseEvent event) {
        ObservableList<RequestedVolunteer> list = fileRead() ;
        for (RequestedVolunteer rv: list) {
            if (rv.getId() == requestIdComboBox.getValue()) {
                showTextArea.setText(rv.toString()) ;
                break ;
            }
        }
    }
    
    @FXML
    private void checkBoxOnMouseClick(MouseEvent event) {
        tableShow() ;
    }
    
    private ObservableList<RequestedVolunteer> fileRead() {
        ObservableList<RequestedVolunteer> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/RequestVolunteer.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            RequestedVolunteer st ;
            try {
                while(true){
                    st = (RequestedVolunteer)ois.readObject();
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
    
    private void fileWrite(RequestedVolunteer stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/RequestVolunteer.bin");
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
            Logger.getLogger(VolunteerRequestSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(VolunteerRequestSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
      }
      
    private ObservableList<Volunteer> fileReadVC() {
        ObservableList<Volunteer> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/VCVolunteer.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Volunteer st ;
            try {
                while(true){
                    st = (Volunteer)ois.readObject();
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
    
      private void fileWriteVC(Volunteer stu) {
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
            Logger.getLogger(VolunteerRequestSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(VolunteerRequestSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
      }
      
       private void fileUpdate(RequestedVolunteer s) {
        ObservableList<RequestedVolunteer> sList = fileRead() ;
        File f = new File("src/File/RequestVolunteer.bin") ;
       
        if(f.exists()) {
            f.delete() ;
        }
       
        for(RequestedVolunteer st: sList) {
            if(st.getId() != s.getId()) {
                fileWrite(st) ;
            }
           
            else if (st.getId() == s.getId()) {
                System.out.println("Found");
                fileWrite(s) ;
            }
        }
       }
        private void fileUpdateVC(Volunteer s) {
        ObservableList<Volunteer> sList = fileReadVC() ;
        File f = new File("src/File/VCVolunteer.bin") ;
       
        if(f.exists()) {
            f.delete() ;
        }
       
        for(Volunteer st: sList) {
            System.out.println("update" + st.getId() != s.getId());
            if(!st.getId().equals(s.getId())) {
                fileWriteVC(st) ;
            }
           
            else if (st.getId() == s.getId()) {
                System.out.println("Found");
                fileWriteVC(s) ;
            }
        }
    }
}
