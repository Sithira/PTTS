package shu.cssd.transportsystem.views.tokenMachine;

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
    private void ticketsButtonClick(MouseEvent event) throws IOException {
        Parent ticketsParent = FXMLLoader.load(getClass().getResource("/tokenMachine/smartcard/smartcard.fxml"));
        Scene ticketsScene = new Scene(ticketsParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(ticketsScene);
        window.show();
    }

    @FXML
    private void tokensButtonClick(MouseEvent event) throws IOException {
        Parent tokensParent = FXMLLoader.load(getClass().getResource("/tokenMachine/tokens/tokens.fxml"));
        Scene tokensScene = new Scene(tokensParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tokensScene);
        window.show();
    }

    @FXML
    private void logoutButtonClick(MouseEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("/tokenMachine/login/login.fxml"));
        Scene loginScene = new Scene(loginParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(loginScene);
        window.show();
    }
}
