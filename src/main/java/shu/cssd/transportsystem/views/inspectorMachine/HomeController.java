package shu.cssd.transportsystem.views.inspectorMachine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private void logoutbuttonClick(MouseEvent event) throws IOException {
        Parent logParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/login/login.fxml"));
        Scene logScene = new Scene(logParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(logScene);
        window.show();
    }

    @FXML
    private void validateTokenbuttonClick(MouseEvent event) throws IOException {
        Parent vtParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/validateToken/validateToken.fxml"));
        Scene vtScene = new Scene(vtParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(vtScene);
        window.show();
    }

    @FXML
    private void issueTokenbuttonClick(MouseEvent event) throws IOException {
        Parent itParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/issueToken/issueToken.fxml"));
        Scene itScene = new Scene(itParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(itScene);
        window.show();
    }
}
