package shu.cssd.transportsystem.views.tokenMachine;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.SmartCardController;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.foundation.validation.Validator;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CashPaymentController implements Initializable {

    @FXML
    private JFXTextField amount;

    private UserController userController;

    private SmartCardController smartCardController = new SmartCardController();

    private Validator validator = Validator.getInstance();

    public static float newBalance;

    @FXML
    public void initialize(URL location, ResourceBundle resources)
    {
        this.userController = UserController.getInstance();

        if (shu.cssd.transportsystem.views.tokenMachine.SmartCardController.from.equals("newCard"))
        {
            amount.setPromptText("Amount LKR 100.0");

            amount.setEditable(false);
        }

        else if (shu.cssd.transportsystem.views.tokenMachine.SmartCardController.from.equals("token"))
        {
            amount.setPromptText("Amount LKR " + Float.toString(TokensController.costAmount));

            amount.setEditable(false);
        }
    }

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

        if(shu.cssd.transportsystem.views.tokenMachine.SmartCardController.from.equals("token"))
        {
            Parent yesParent = FXMLLoader.load(getClass().getResource("/tokenMachine/received/received.fxml"));

            Scene yesScene = new Scene(yesParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(yesScene);

            window.show();
        }
        else if(shu.cssd.transportsystem.views.tokenMachine.SmartCardController.from.equals("newCard"))
        {
            Parent yesParent = FXMLLoader.load(getClass().getResource("/tokenMachine/received/received.fxml"));

            Scene yesScene = new Scene(yesParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(yesScene);

            window.show();
        }
        else if (this.validator.isEmpty(amount) || !this.validator.isNumeric(amount))
        {
            Parent noParent = FXMLLoader.load(getClass().getResource("/tokenMachine/error/error.fxml"));

            Scene noScene = new Scene(noParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(noScene);

            window.show();
        }
        else
        {
            float amountFloat = Float.valueOf(amount.getText());

            newBalance = smartCardController.topUpBalance(userController.currentUser.getCard(),amountFloat);

            Parent yesParent = FXMLLoader.load(getClass().getResource("/tokenMachine/received/received.fxml"));

            Scene yesScene = new Scene(yesParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(yesScene);

            window.show();
        }
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
