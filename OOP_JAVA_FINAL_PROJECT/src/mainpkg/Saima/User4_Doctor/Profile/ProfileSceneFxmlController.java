/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg.Saima.User4_Doctor.Profile;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mainpkg.AbstractClass.User;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ProfileSceneFxmlController implements Initializable {

    @FXML    private Label statusLabel;
    @FXML    private Label nameLabel;
    @FXML    private Label idLabel;
    @FXML    private Label userTypeLabel;
    @FXML    private Label pNLabel;
    @FXML    private Label emailLabel;
    @FXML    private Label genderLabel;

    /**
     * Initializes the controller class.
     */
      User user ;
     
     public User get() {
        return user ;
    }
     public void set(User u) {
        user = u ;
        statusLabel.setText(user.getStatus()) ;
        nameLabel.setText(user.getName()) ;
        idLabel.setText(Integer.toString(user.getId())) ;
        userTypeLabel.setText(user.getUserType()) ;
        pNLabel.setText(user.getPhoneNo()) ;
        emailLabel.setText(user.getEmail()) ;
        genderLabel.setText(user.getGender()) ;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backOnMouseClick(MouseEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/mainpkg/Saima/User4_Doctor/DashBoardSceneFxml.fxml")) ;
        root = (Parent) myLoader.load() ;
        Scene myScene = new Scene(root) ;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow() ;
        stage.setScene(myScene) ;
        stage.setTitle("Doctor DashBoard") ;
        stage.show() ;
    }

    @FXML
    private void changePWOnMouseClick(MouseEvent event) {
    }
    
}
