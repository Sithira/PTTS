package shu.cssd.transportsystem.views.tokenMachine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.UserController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    private UserController user;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        user = UserController.getInstance();
    }

    @FXML
    private void loginButtonClick(MouseEvent event) throws IOException {
        String currentUsername = username.getText();
        String currentPassword = password.getText();

        if (user.checkCredentials(currentUsername, currentPassword))
        {
            Parent homeParent = FXMLLoader.load(getClass().getResource("/tokenMachine/home/home.fxml"));
            Scene homeScene = new Scene(homeParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(homeScene);
            window.show();
        }
        else
        {
            Parent dashboardParent = FXMLLoader.load(getClass().getResource("/tokenMachine/login/login.fxml"));
            Scene dashboardScene = new Scene(dashboardParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(dashboardScene);
            window.show();
        }
    }

    @FXML
    private void signUpButtonClick(MouseEvent event) throws IOException {
        Parent sgnParent = FXMLLoader.load(getClass().getResource("/tokenMachine/signup/signup.fxml"));
        Scene sgnScene = new Scene(sgnParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(sgnScene);
        window.show();
    }
}
