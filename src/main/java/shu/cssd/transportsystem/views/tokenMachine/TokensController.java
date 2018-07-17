package shu.cssd.transportsystem.views.tokenMachine;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.controllers.ui.MobileAppController;
import shu.cssd.transportsystem.controllers.ui.TokenMachineController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.NotEnoughFundsException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.helpers.CostCalculator;
import shu.cssd.transportsystem.helpers.TokenCreator;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.Token;
import shu.cssd.transportsystem.models.collections.SetOfTokens;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TokensController implements Initializable {
    public static boolean previous = false;

    public static String from;

    public static float costAmount;

    @FXML
    private JFXComboBox route;

    @FXML
    private JFXComboBox origin;

    @FXML
    private JFXComboBox destination;

    @FXML
    private Label cost;

    @FXML
    private Label date;

    private Stop originStop, destinationStop;

    private ArrayList<Stop> stopList = new ArrayList<>();

    private ArrayList<Route> rList = new ArrayList<>();

    private TokenMachineController tokenMachineController = new TokenMachineController();

    UserController userController = UserController.getInstance();

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<BaseModel> routesList;


        routesList = tokenMachineController.getRoutes();

        for (BaseModel model : routesList)
        {
            Route rout = (Route) model;

            rList.add(rout);
        }

        route.getSelectionModel().selectFirst();

        for (Route r: rList)
        {
            route.getItems().add(r.name);
        }
    }

    @FXML
    public void getSelectedRoute()
    {

        String selectedValue = route.getSelectionModel()
                .getSelectedItem().toString();

        for (Route model: rList)
        {
            if (model.name.equals(selectedValue))
            {
                loadOriginAndDestination(model);
            }
        }
    }

    private void loadOriginAndDestination(Route route)
    {

        origin.getItems().clear();

        destination.getItems().clear();

        stopList = route.getStops();

        for (Stop stop: route.getStops())
        {
            origin.getItems().add(stop.name);
            destination.getItems().add(stop.name);
        }

    }

    @FXML
    public void onOriginSelect()
    {
        String selectedValue = origin.getSelectionModel()
                .getSelectedItem().toString();

        for (Stop stop: this.stopList)
        {
            if (stop.name.equals(selectedValue))
            {
                this.originStop = stop;
            }
        }
    }

    @FXML
    public void onDestinationSelect()
    {
        String selectedValue = destination.getSelectionModel()
                .getSelectedItem().toString();

        for (Stop stop: this.stopList)
        {
            if (origin.getSelectionModel().getSelectedItem().equals(selectedValue))
            {
                AlertBox.getInstance().alertWithHeader("Whoops", "Origin and the Destination cant be the same");

                destination.getSelectionModel().clearSelection();

                return;
            }

            if (stop.name.equals(selectedValue))
            {
                this.destinationStop = stop;
            }
        }
    }



    @FXML
    private void backButtonClick(MouseEvent event) throws IOException {
        Parent homeParent = FXMLLoader.load(getClass().getResource("/tokenMachine/home/home.fxml"));
        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(homeScene);
        window.show();
    }

    @FXML
    private void paymentButtonClick(MouseEvent event) throws IOException {
        previous = true;

        SmartCardController.from = "token";

        MobileAppController mobileAppController = new MobileAppController();

        try {

            mobileAppController.getToken(originStop, destinationStop);

        }
        catch (NotEnoughFundsException e)
        {

        }

        Parent payParent = FXMLLoader.load(getClass().getResource("/tokenMachine/payment/payment.fxml"));

        Scene payScene = new Scene(payParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(payScene);

        window.show();
    }

    @FXML
    private void checkFareButtonClicked(MouseEvent event) throws IOException {
        costAmount = CostCalculator.getInstance()
                .calculate(originStop, destinationStop, destinationStop.getRoute());

        userController.topUpBalance(costAmount);

        cost.setText("LKR " + costAmount);

    }

}
