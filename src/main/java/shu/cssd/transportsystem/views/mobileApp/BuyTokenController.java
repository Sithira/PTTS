package shu.cssd.transportsystem.views.mobileApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.ui.MobileAppController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.types.PaymentType;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class BuyTokenController implements Initializable {

    @FXML
    private ComboBox origin;

    @FXML
    private ComboBox destination;

    @FXML
    private ComboBox payType;

    @FXML
    private ComboBox route;

    @FXML
    private TextField cost;

    private ArrayList rList = new ArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        MobileAppController routes = new MobileAppController();

        ArrayList<BaseModel> routesList;

        routesList = routes.getRoutes();

        //System.out.println(routesList);
        for(BaseModel model: routesList) {

            //String rList =  model.toString();

            System.out.println(model);
        }


        payType.getItems().setAll(PaymentType.values());

        //route.getItems().setAll(StringUtils.join(list, );
    }

    @FXML
    private void backButtonClick(MouseEvent event) throws IOException {
        Parent tokenParent = FXMLLoader.load(getClass().getResource("/mobileApp/token/token.fxml"));
        Scene tokenScene = new Scene(tokenParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tokenScene);
        window.show();
    }

    @FXML
    private void paymentButtonClick(MouseEvent event) throws IOException {
        Parent paymentParent = FXMLLoader.load(getClass().getResource("/mobileApp/payment/Payment.fxml"));
        Scene paymentScene = new Scene(paymentParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(paymentScene);
        window.show();
    }

    @FXML
    private void profileButtonClick(MouseEvent event) throws IOException {
        Parent profileParent = FXMLLoader.load(getClass().getResource("/mobileApp/profile/profile.fxml"));
        Scene profileScene = new Scene(profileParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(profileScene);
        window.show();
    }



    @FXML
    private void routeButtonClick(MouseEvent event) throws IOException {
        Parent routeParent = FXMLLoader.load(getClass().getResource("/mobileApp/route/route.fxml"));
        Scene routeScene = new Scene(routeParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(routeScene);
        window.show();
    }

    @FXML
    private void purchaseButtonClick(MouseEvent event) throws IOException {

        Parent purchaseParent = FXMLLoader.load(getClass().getResource("/mobileApp/purchase/purchase.fxml"));
        Scene purchaseScene = new Scene(purchaseParent);

        //UserController user = new UserController();

        MobileAppController stop = new MobileAppController();

        payType.getItems().setAll(PaymentType.values());

        //TokenCreator.getInstance().createToken(user.currentUser, payType.getValue(), ori)


//        Parent purchaseParent = FXMLLoader.load(getClass().getResource("/purchase/purchase.fxml"));
//        Scene purchaseScene = new Scene(purchaseParent);
//
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//
//        window.setScene(purchaseScene);
//        window.show();
    }


    @FXML
    private void journeyButtonClick(MouseEvent event) throws IOException {
        Parent journeyParent = FXMLLoader.load(getClass().getResource("/mobileApp/journey/journey.fxml"));
        Scene journeyScene = new Scene(journeyParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(journeyScene);
        window.show();
    }
}
