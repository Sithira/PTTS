package shu.cssd.transportsystem.views.tokenMachine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class PaymentController {
    private String tokenURL = "/tokenMachine/smartcard/smartcard.fxml" ;
    private String smartCardURL = "/tokenMachine/smartcard/smartcard.fxml" ;

    @FXML
    private void backButtonClick(MouseEvent event) throws IOException {
        if(TokensController.previous){
            Parent smcParent = FXMLLoader.load(getClass().getResource("/tokenMachine/tokens/tokens.fxml"));
            Scene smcScene = new Scene(smcParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(smcScene);
            window.show();
            TokensController.previous = false;
        }
        else if(SmartCardController.previous){
            Parent smcParent = FXMLLoader.load(getClass().getResource("/tokenMachine/smartcard/smartcard.fxml"));
            Scene smcScene = new Scene(smcParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(smcScene);
            window.show();
            SmartCardController.previous = false;
        }

    }

    @FXML
    private void cashButtonClick(MouseEvent event) throws IOException {
        Parent cashParent = FXMLLoader.load(getClass().getResource("/tokenMachine/cashpayment/cashpayment.fxml"));
        Scene cashScene = new Scene(cashParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(cashScene);
        window.show();
    }

    @FXML
    private void creditButtonClick(MouseEvent event) throws IOException {
        Parent cardParent = FXMLLoader.load(getClass().getResource("/tokenMachine/cardpayment/cardpayment.fxml"));
        Scene cardScene = new Scene(cardParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(cardScene);
        window.show();
    }
}
