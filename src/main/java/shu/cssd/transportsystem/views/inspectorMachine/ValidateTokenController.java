package shu.cssd.transportsystem.views.inspectorMachine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ValidateTokenController {
    @FXML
    private void backbuttonClick(MouseEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/home/home.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.show();
    }

    @FXML
    private void issuebuttonClick(MouseEvent event) throws IOException {
        Parent iTParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/issueToken/issueToken.fxml"));
        Scene iTScene = new Scene(iTParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(iTScene);
        window.show();
    }
}
