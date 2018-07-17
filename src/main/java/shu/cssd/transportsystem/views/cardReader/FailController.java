package shu.cssd.transportsystem.views.cardReader;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class FailController {
    @FXML
    private void homeButtonClick(MouseEvent event) throws IOException {
        Parent empParent = FXMLLoader.load(getClass().getResource("/cardReader/home/home.fxml"));
        Scene empScene = new Scene(empParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(empScene);
        window.show();
    }
}
