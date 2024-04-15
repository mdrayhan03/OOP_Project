/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import mainpkg.AbstractClass.AppendableObjectOutputStream;
import mainpkg.AbstractClass.Date;
import mainpkg.Rasel.CampManager.Goal7_AllRequests.Campaign;
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;
import mainpkg.Rayhan.User5.Goal4_VRequest.RequestedVolunteer;
import mainpkg.Rayhan.User5.Goal8_Report.Report;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
import mainpkg.Rayhan.User6.Goal5_Needs.NeedsSceneFxmlController;
import mainpkg.Rayhan.User6.Goal7_Storage.EducationCoordinatorStorage;
/**
 * FXML Controller class
 *
 * @author RayhaN
 */
public class FXMLController implements Initializable {


    @FXML
    private Label show;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void button(ActionEvent event) throws IOException {
        
//        VolunteerCoordinator v = new VolunteerCoordinator(5500000 , "MD.Rayhan Hossain" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Volunteer Coordinator" , "Male" , "04/04/2003") ;
//        fileWrite(v) ;
//        VolunteerCoordinator e = new VolunteerCoordinator(5555555 , "MD.Rayhan Hossain" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Volunteer Coordinator" , "Male" , "04/04/2003") ;
//        fileWrite(e) ;

        
        
        
        
        ObservableList<VolunteerCoordinator> listobj = fileRead() ;
        String str = "" ;
        for (VolunteerCoordinator vc: listobj) {
            
//            str += vc.getdGeometryBox() + "\n" ;
        }
        
        System.out.println(listobj);
        show.setText(listobj.toString());
        
    }
    private ObservableList<VolunteerCoordinator> fileRead() {
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
                    System.out.println(st);
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
//    
//    private void fileWrite(Report stu) {
//        File f = null;
//        FileOutputStream fos = null;      
//        ObjectOutputStream oos = null;
//        
//        try {
//            f = new File("src/File/Report.bin");
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
//            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(oos != null) oos.close();
//            } catch (IOException ex) {
//                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }                
//    }

//        ObservableList<Campaign> listobj = FXCollections.observableArrayList();
//        VolunteerCoordinator v = new VolunteerCoordinator(5500000 , "MD.Rayhan Hossain" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Volunteer Coordinator" , "Male" , "04/04/2003") ;
//        listobj.add(v) ;
//        VolunteerCoordinator e = new VolunteerCoordinator(5555555 , "MD.Rayhan Hossain" , "asdfghjk" , "01312961737" , "rayhan@gmail.com" , "Volunteer Coordinator" , "Male" , "04/04/2003") ;
//        listobj.add(v) ;

//            Campaign("0101", "Place", "Subjectjj", "User", "Descripotioksjfkl", "Name", new Date(01 , 01 , 2024), 1234) ;
        
//            System.out.println(listobj) ;
//        EducationCoordinatorStorage stu = new EducationCoordinatorStorage() ;
//        File f = null;
//        FileOutputStream fos = null;      
//        ObjectOutputStream oos = null;
//        
//        try {
//            f = new File("src/File/EducationCoordinatorStorage.bin");
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
//            Logger.getLogger(NeedsSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if(oos != null) oos.close();
//            } catch (IOException ex) {
//                Logger.getLogger(NeedsSceneFxmlController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }                
//        
}
