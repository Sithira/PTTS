package shu.cssd.transportsystem;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shu.cssd.transportsystem.models.SetOfUsers;
import shu.cssd.transportsystem.models.User;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        SetOfUsers sop = new SetOfUsers();

        User user = new User();

        sop.create(user);

        System.out.println("Size: " + sop.getRows().size());

        for (int i = 0; i < sop.getRows().size(); i++) {
            if (sop.getRows().get(i) instanceof User)
            {
                System.out.println("Instance Match the model");
            }
        }

        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
