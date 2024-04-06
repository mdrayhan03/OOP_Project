/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import mainpkg.Rayhan.User5.Goal1_Volunteer.Volunteer;
import mainpkg.Rayhan.User5.VolunteerCoordinator;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void button(ActionEvent event) throws IOException {
        ObservableList<VolunteerCoordinator> listobj = FXCollections.observableArrayList() ;
        FileInputStream fis = null ;
        ObjectInputStream ois = null ;
        try {
            fis = new FileInputStream("src/File/VolunteerCoordinatorObjFile.bin") ;
            ois = new ObjectInputStream(fis) ;
            while (true) {
               listobj.add((VolunteerCoordinator) ois.readObject()) ;
               System.out.println("HI" +(VolunteerCoordinator) ois.readObject());
            } 
        }
        catch (Exception e) {
            ois.close() ;
//            alert = new Alert(Alert.AlertType.WARNING) ;
//            alert.setHeaderText("File Warning.");
//            alert.setContentText("File not found.") ;
//            alert.showAndWait() ;
        }
        String str = null ;
        for (VolunteerCoordinator vc: listobj) {
            str += vc.toString() + "\n" ;
        }
        show.setText(str) ;
        System.out.println(listobj);
    }
    
}
