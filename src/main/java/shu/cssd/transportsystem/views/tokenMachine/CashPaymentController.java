package shu.cssd.transportsystem.views.tokenMachine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CashPaymentController {

    @FXML
    private void backButtonClick(MouseEvent event) throws IOException {
        Parent ncParent = FXMLLoader.load(getClass().getResource("/tokenMachine/payment/payment.fxml"));
        Scene ncScene = new Scene(ncParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(ncScene);
        window.show();
    }


    @FXML
    private void successButtonClick(MouseEvent event) throws IOException {
        Parent yesParent = FXMLLoader.load(getClass().getResource("/tokenMachine/received/received.fxml"));
        Scene yesScene = new Scene(yesParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(yesScene);
        window.show();
    }

    @FXML
    private void errorButtonClick(MouseEvent event) throws IOException {
        Parent noParent = FXMLLoader.load(getClass().getResource("/tokenMachine/error/error.fxml"));
        Scene noScene = new Scene(noParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(noScene);
        window.show();
    }
}
