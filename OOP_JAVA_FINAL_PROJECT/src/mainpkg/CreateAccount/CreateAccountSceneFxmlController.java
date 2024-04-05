package mainpkg.CreateAccount;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User6.EducationCoordinator;
/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class CreateAccountSceneFxmlController implements Initializable {


    @FXML    private TextField phoneNoTextField;
    @FXML    private TextField nameTextField;
    @FXML    private TextField emailTextField;
    @FXML    private PasswordField pwPasswordField;
    @FXML    private PasswordField cpwPasswordField;
    @FXML    private ComboBox<String> userTypeComboBox;
    @FXML    private Label showOutput1Label;
    @FXML    private Label showOutput2Label;
    @FXML    private TextField ddTextField;
    @FXML    private TextField mmTextField;
    @FXML    private TextField yyyyTextField;
    
    Random rand ;
    Alert alert ;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rand = new Random() ;
        userTypeComboBox.getItems().addAll("Refugee Camp Manager" , "Aid Executive" , "Doctor" , "Volunteer Coordinator" , "Education Coordinator" , "Security Incharge" , "NGO") ;
        
    }    
    
    @FXML
    private void createOnMouseClick(MouseEvent event) {
        boolean rtn = true ;
        int id = 0 ;
        String strd ,strm , stry = "" ;
        int dd = 0 , mm = 0, yyyy = 0 ;
        String name = "" , phoneNo = "" , email = "" , pw = "" , cpw = "" , userType = "" ;
        
        name = nameTextField.getText() ;
        if (name.length() == 0) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Name Error.") ;
            alert.setContentText("Name Required.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        phoneNo = phoneNoTextField.getText() ;
        if (phoneNo.length() != 11) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Phone No Error.") ;
            if (phoneNo.length() == 0) {
                alert.setContentText("Phone No Required.") ;
            }
            alert.setContentText("Phone No must be 11 digit.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        email = emailTextField.getText() ;
        if (email.length() == 0) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Email Error.") ;
            alert.setContentText("Email Required.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        strd = ddTextField.getText() ;
        strm = mmTextField.getText() ;
        stry = yyyyTextField.getText() ;
        if (strd.length()!= 0 && strm.length()!= 0 && stry.length()!= 0) {
            dd = Integer.parseInt(strd) ;
            mm = Integer.parseInt(strm) ;
            yyyy = Integer.parseInt(stry) ;
        }
        
        if (dd == 0 || mm == 0 || yyyy == 0) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Date Error.") ;           
            alert.setContentText("DD/MM/YYYY Required.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        userType = userTypeComboBox.getValue() ;
        pw = pwPasswordField.getText() ;
        if (pw.length() < 8) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            if (pw.length() == 0) {
                alert.setContentText("Password Required.") ;
            }
            alert.setContentText("Password must be more than 8 character.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        cpw = cpwPasswordField.getText() ;
        if (cpw.length() < 8) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            if (pw.length() == 0) {
                alert.setContentText("Confirm Passwor Required.") ;
            }
            alert.setContentText("Confirm Password must be more than 8 character.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (!cpw.equals(pw)) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Password Error.") ;
            alert.setContentText("Password and Confirm Password is not same.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        Date dob = new Date(dd , mm , yyyy) ;
        if (dob.isValid() == false) {
            alert = new Alert(Alert.AlertType.WARNING) ;
            alert.setHeaderText("Date Error.") ;
            alert.setContentText("Date is not Valid.") ;
            rtn = false ;
            alert.showAndWait() ;
        }
        
        if (null != userType) switch (userType) {
            case "Refugee Camp Manager":{
                int ra = rand.nextInt(99999) ;
                id = 1100000 + ra ;
                    break;
                }
            case "Aid Executive":{
                int ra = rand.nextInt(99999) ;
                id = 3300000 + ra ;
                    break;
                }
            case "Doctor":{
                int ra = rand.nextInt(99999) ;
                id = 4400000 + ra ;
                    break;
                }
            case "Volunteer Coordinator":{
                int ra = rand.nextInt(99999) ;
                id = 5500000 + ra ;
                    break;
                }
            case "Education Coordinator":{
                int ra = rand.nextInt(99999) ;
                id = 6600000 + ra ;
                    break;
                }
            case "Security Incharge":{
                int ra = rand.nextInt(99999) ;
                id = 7700000 + ra ;
                    break;
                }
            case "NGO":{
                int ra = rand.nextInt(99999) ;
                id = 8800000 + ra ;
                    break;
                }
            default:
                break;
        }
        User u = null ;
        String str1 = null , str2 = null ;
        if (rtn == true) {  
            if (userType == "Volunteer Coordinator") {
                   u = new VolunteerCoordinator(id , name , cpw , phoneNo , email , userType , dob.toString()) ;           
            }
            else if (userType == "Education Coordinator") {
                   u = new EducationCoordinator(id , name , cpw , phoneNo , email , userType , dob.toString()) ;
            }
            
            try {
                FileOutputStream fos = new FileOutputStream("src/File/UserObjFile.bin" , true) ;
                ObjectOutputStream oos = new ObjectOutputStream(fos) ;
                
                oos.writeObject(u) ;
                
                oos.close() ;
            }
            catch (Exception e) {
                alert = new Alert(Alert.AlertType.ERROR) ;
                alert.setHeaderText("File Error") ;
                alert.setContentText("Unable to open file for Exception : " + e.getClass().getName()) ;
                alert.showAndWait() ;
            }
        
            str1 = "ID : " + u.getId() +"\n"+
                     "Name : " + u.getName() +"\n"+
                     "Phone No : " + u.getPhoneNo()+"\n" ;
        
            str2 = "Email : " + u.getEmail() +"\n"+
                     "Date of Birth : " + u.getDob() +"\n"+
                     "User Type : " + u.getUserType() ;
        
            showOutput1Label.setText(str1) ;
            showOutput2Label.setText(str2) ;
            }
        else {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("User Error") ;
            alert.setContentText("Unable to Construct.") ;
            alert.showAndWait() ;
        }
        
        nameTextField.clear() ;
        phoneNoTextField.clear() ;
        emailTextField.clear() ;
        ddTextField.clear() ;
        mmTextField.clear() ;
        yyyyTextField.clear() ;
        userTypeComboBox.getSelectionModel().clearSelection();
        pwPasswordField.clear() ;
        cpwPasswordField.clear() ;
    }
}
