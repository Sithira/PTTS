package shu.cssd.transportsystem.views.tokenMachine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SmartCardController {

    public static boolean previous = false;
    public static String from ;
    @FXML
    private void backButtonClick(MouseEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("/tokenMachine/home/home.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.show();
    }


    @FXML
    private void topUpButtonClick(MouseEvent event) throws IOException {
        previous = true;
        Parent payParent = FXMLLoader.load(getClass().getResource("/tokenMachine/payment/payment.fxml"));
        Scene payScene = new Scene(payParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(payScene);
        window.show();
    }

    @FXML
    private void newCardButtonClick(MouseEvent event) throws IOException {
        previous = true;
        Parent payParent = FXMLLoader.load(getClass().getResource("/tokenMachine/payment/payment.fxml"));
        Scene payScene = new Scene(payParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(payScene);
        window.show();
    }
}
