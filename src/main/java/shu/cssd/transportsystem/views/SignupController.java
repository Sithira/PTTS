package shu.cssd.transportsystem.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import shu.cssd.transportsystem.MainApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    @FXML
    private void backClick(MouseEvent event) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("/login/Scene.fxml"));
        MainApp.stage.getScene().setRoot(root);
    }
}
