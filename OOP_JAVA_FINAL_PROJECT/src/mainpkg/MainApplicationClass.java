package mainpkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author RayhaN
 */
public class MainApplicationClass extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Opening/OpeningSceneFxml.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("Login/LoginSceneFxml.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("ForgetPW/ForgetPWFxml.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("Rayhan/User5/DashBoardSceneFxml.fxml")) ;
//        Parent root = FXMLLoader.load(getClass().getResource("Rayhan/User5/Goal1_Volunteer/VolunteerInfoSceneFxml.fxml")) ;
//        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root) ;
        
        stage.setScene(scene) ;
        stage.setTitle("Rohinga Refugee Camp") ;
        stage.getIcons().add(new Image("/image/campIcon.png")) ;
        stage.show() ;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
