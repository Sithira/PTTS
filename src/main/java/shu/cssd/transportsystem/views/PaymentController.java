package shu.cssd.transportsystem.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    AnchorPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //topPane.setEffect(new DropShadow(2d, 0d, +2d, Color.BLACK));
    }

    @FXML
    private void backButtonClick(MouseEvent event) throws IOException {
        Parent dashboardParent = FXMLLoader.load(getClass().getResource("/dashboard/Dashboard.fxml"));
        Scene dashboardScene = new Scene(dashboardParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(dashboardScene);
        window.show();
    }

    @FXML
    private void paymentButtonClick(MouseEvent event) throws IOException {
        Parent paymentParent = FXMLLoader.load(getClass().getResource("/payment/Payment.fxml"));
        Scene paymentScene = new Scene(paymentParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(paymentScene);
        window.show();
    }

    @FXML
    private void profileButtonClick(MouseEvent event) throws IOException {
        Parent profileParent = FXMLLoader.load(getClass().getResource("/profile/profile.fxml"));
        Scene profileScene = new Scene(profileParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(profileScene);
        window.show();
    }

    @FXML
    private void tokenButtonClick(MouseEvent event) throws IOException {
        Parent tokenParent = FXMLLoader.load(getClass().getResource("/token/token.fxml"));
        Scene tokenScene = new Scene(tokenParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tokenScene);
        window.show();
    }

    @FXML
    private void routeButtonClick(MouseEvent event) throws IOException {
        Parent routeParent = FXMLLoader.load(getClass().getResource("/route/route.fxml"));
        Scene routeScene = new Scene(routeParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(routeScene);
        window.show();
    }

    @FXML
    private void purchaseButtonClick(MouseEvent event) throws IOException {
        Parent purchaseParent = FXMLLoader.load(getClass().getResource("/purchase/purchase.fxml"));
        Scene purchaseScene = new Scene(purchaseParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(purchaseScene);
        window.show();
    }

    @FXML
    private void journeyButtonClick(MouseEvent event) throws IOException {
        Parent journeyParent = FXMLLoader.load(getClass().getResource("/journey/journey.fxml"));
        Scene journeyScene = new Scene(journeyParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(journeyScene);
        window.show();
    }
}
