package shu.cssd.transportsystem.views.tokenMachine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class receivedController implements Initializable {

    @FXML
    private Label successMessage;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        CashPaymentController cashPaymentController = new CashPaymentController();
        successMessage.setText("Current SmartCard Balance: LKR "+ cashPaymentController.newBalance);
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
