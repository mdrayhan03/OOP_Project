package mainpkg.CreateAccount;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.AbstractClass.User;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User6.EducationCoordinator;
import mainpkg.Rayhan.User7.SecurityIncharge;
import mainpkg.Rayhan.User8.NGOs;
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
    @FXML    private RadioButton maleRadioButton;
    @FXML    private RadioButton femaleRadioButton;
    
    Random rand ;
    Alert alert ;
    
    ToggleGroup tg = new ToggleGroup() ;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        maleRadioButton.setToggleGroup(tg) ;
        femaleRadioButton.setToggleGroup(tg) ;
        maleRadioButton.setSelected(true) ;
        rand = new Random() ;
        userTypeComboBox.getItems().addAll("Refugee Camp Manager" , "Aid Executive" , "Doctor" , "Volunteer Coordinator" , "Education Coordinator" , "Security Incharge" , "NGO") ;
        
    }    
    
    @FXML
    private void createOnMouseClick(MouseEvent event) {
        boolean rtn = true ;
        int id = 0 ;
        String strd ,strm , stry = "" ;
        int dd = 0 , mm = 0, yyyy = 0 ;
        String name = "" , phoneNo = "" , email = "" , pw = "" , cpw = "" , userType = "" , gender = "";
        
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
        
//        if (!maleRadioButton.isSelected() || !femaleRadioButton.isSelected()) {
//            alert = new Alert(Alert.AlertType.WARNING) ;
//            alert.setHeaderText("Gender Error.") ;
//            alert.setContentText("Gender Required.") ;
//            rtn = false ;
//            alert.showAndWait() ;
//        }
        if  (maleRadioButton.isSelected()) {
            gender = "Male" ;
        }
        else if  (femaleRadioButton.isSelected()) {
            gender = "Female" ;
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
        
        id = this.generateID(userType) ;
        
        User u  = null ;
        String str1 = null , str2 = null ;
        if (rtn == true) {  
            if (userType == "Volunteer Coordinator") {
                ObservableList<VolunteerCoordinator> vcList = fileReadVC() ;
                Boolean r = true ;
                for (VolunteerCoordinator v: vcList)
                {
                    if(v.getName() == name && v.getPhoneNo() == phoneNo && v.getEmail() == email) {
                        r = false ;
                        alert = new Alert(Alert.AlertType.WARNING) ;
                        alert.setHeaderText("Account Warning") ;
                        alert.setContentText("Already have an account.");
                        break ;
                    }
                    if (v.getId() == id) {
                        id = this.generateID(userType) ;
                    }
                }  
                if (r == true) {
                    VolunteerCoordinator vc = new VolunteerCoordinator(id , name , cpw , phoneNo , email , userType , gender , dob.toString()) ;
                    u = new VolunteerCoordinator(id , name , cpw , phoneNo , email , userType , gender , dob.toString()) ; 
                    fileWriteVC(vc) ;
                }   
                
            }
            else if (userType == "Education Coordinator") {
                   ObservableList<EducationCoordinator> ecList = fileReadEC() ;
                Boolean r = true ;
                for (EducationCoordinator v: ecList)
                {
                    if(v.getName() == name && v.getPhoneNo() == phoneNo && v.getEmail() == email) {
                        r = false ;
                        alert = new Alert(Alert.AlertType.WARNING) ;
                        alert.setHeaderText("Account Warning") ;
                        alert.setContentText("Already have an account.");
                        break ;
                    }
                    if (v.getId() == id) {
                        id = this.generateID(userType) ;
                    }
                }  
                if (r == true) {
                    EducationCoordinator vc = new EducationCoordinator(id , name , cpw , phoneNo , email , userType , gender , dob.toString()) ;
                    u = new EducationCoordinator(id , name , cpw , phoneNo , email , userType , gender , dob.toString()) ; 
                    fileWriteEC(vc) ;
                }
            }
            else if (userType == "Security Incharge") {
                   ObservableList<SecurityIncharge> siList = fileReadSI() ;
                Boolean r = true ;
                for (SecurityIncharge v: siList)
                {
                    if(v.getName() == name && v.getPhoneNo() == phoneNo && v.getEmail() == email) {
                        r = false ;
                        alert = new Alert(Alert.AlertType.WARNING) ;
                        alert.setHeaderText("Account Warning") ;
                        alert.setContentText("Already have an account.");
                        break ;
                    }
                    if (v.getId() == id) {
                        id = this.generateID(userType) ;
                    }
                }  
                if (r == true) {
                    SecurityIncharge vc = new SecurityIncharge(id , name , cpw , phoneNo , email , userType , gender , dob.toString()) ;
                    u = new SecurityIncharge(id , name , cpw , phoneNo , email , userType , gender , dob.toString()) ; 
                    fileWriteSI(vc) ;
                }
            }
            else if (userType == "NGOs") {
                   ObservableList<NGOs> ngList = fileReadNG() ;
                Boolean r = true ;
                for (NGOs v: ngList)
                {
                    if(v.getName() == name && v.getPhoneNo() == phoneNo && v.getEmail() == email) {
                        r = false ;
                        alert = new Alert(Alert.AlertType.WARNING) ;
                        alert.setHeaderText("Account Warning") ;
                        alert.setContentText("Already have an account.");
                        break ;
                    }
                    if (v.getId() == id) {
                        id = this.generateID(userType) ;
                    }
                }  
                if (r == true) {
                    NGOs vc = new NGOs(id , name , cpw , phoneNo , email , userType , gender , dob.toString()) ;
                    u = new NGOs(id , name , cpw , phoneNo , email , userType , gender , dob.toString()) ; 
                    fileWriteNG(vc) ;
                }
            }
                        
            FileWriter fw = null ;
            try {
                File f = new File("src/File/UserTextFile.txt") ;
            
                if (f.exists()) {
                    fw = new FileWriter(f , true) ;
                }
                else {
                    fw = new FileWriter("src/File/UserTextFile.txt") ;
                }
                String str = "" ;
                str += u.getId() + "," + u.getName() + "," + u.getUserType() + "," + u.getPhoneNo() + "," + u.getPassword() ;
                fw.write(str) ;
                fw.close() ;
            }
            catch(Exception e) {
        }
        
            str1 = "ID : " + u.getId() +"\n"+
                     "Name : " + u.getName() +"\n"+
                     "Phone No : " + u.getPhoneNo()+"\n" ;
        
            str2 = "Email : " + u.getEmail() +"\n"+
                     "Date of Birth : " + u.getDob() +"\n"+
                     "User Type : " + u.getUserType() ;
        
            showOutput1Label.setText(str1) ;
            showOutput2Label.setText(str2) ;
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
        else {
            alert = new Alert(Alert.AlertType.ERROR) ;
            alert.setHeaderText("User Error") ;
            alert.setContentText("Unable to Construct.") ;
            alert.showAndWait() ;
        }
        
        
    }
    
    private Integer generateID(String userType) {
        Integer id = 0 ;
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
        return id ;
    }
    
    private ObservableList<VolunteerCoordinator> fileReadVC() {
        ObservableList<VolunteerCoordinator> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/VolunteerCoordinator.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            VolunteerCoordinator st ;
            try {
                while(true){
                    st = (VolunteerCoordinator)ois.readObject();
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
    
    private void fileWriteVC(VolunteerCoordinator stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/VolunteerCoordinator.bin");
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
            Logger.getLogger(CreateAccountSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CreateAccountSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
    private ObservableList<EducationCoordinator> fileReadEC() {
        ObservableList<EducationCoordinator> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/EducationCoordinator.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            EducationCoordinator st ;
            try {
                while(true){
                    st = (EducationCoordinator)ois.readObject();
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
    
    private void fileWriteEC(EducationCoordinator stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/EducationCoordinator.bin");
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
            Logger.getLogger(CreateAccountSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CreateAccountSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
    private ObservableList<SecurityIncharge> fileReadSI() {
        ObservableList<SecurityIncharge> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/SecurityIncharge.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            SecurityIncharge st ;
            try {
                while(true){
                    st = (SecurityIncharge)ois.readObject();
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
    
    private void fileWriteSI(SecurityIncharge stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/SecurityIncharge.bin");
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
            Logger.getLogger(CreateAccountSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CreateAccountSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
    private ObservableList<NGOs> fileReadNG() {
        ObservableList<NGOs> studList = FXCollections.observableArrayList() ;
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("src/File/VCVolunteer.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            NGOs st ;
            try {
                while(true){
                    st = (NGOs)ois.readObject();
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
    
    private void fileWriteNG(NGOs stu) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("src/File/NGOs.bin");
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
            Logger.getLogger(CreateAccountSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CreateAccountSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
}
