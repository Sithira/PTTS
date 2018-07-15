package shu.cssd.transportsystem.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import shu.cssd.transportsystem.MainApp;
import shu.cssd.transportsystem.controllers.UserController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable
{
	@FXML
	public TextField topUpAmount;

	@FXML
	public Label balanceLbl;

	@FXML
	AnchorPane rootPane;

	private UserController user = new UserController();

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		System.out.println(Float.toString(user.getBalanace()));

		balanceLbl.setText("LKR "+Float.toString(user.getBalanace()));
		//topPane.setEffect(new DropShadow(2d, 0d, +2d, Color.BLACK));
	}
	@FXML
	public void loadDashBoard(javafx.event.ActionEvent event) throws IOException
	{
		Parent dashboardParent = FXMLLoader.load(getClass().getResource("/dashboard/Dashboard.fxml"));
		Scene dashboardScene = new Scene(dashboardParent);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

		window.setScene(dashboardScene);
		window.show();

	}

	@FXML
	private void logout_buttonClick(MouseEvent event) throws IOException {
		Parent root =FXMLLoader.load(getClass().getResource("/login/Scene.fxml"));
		MainApp.stage.getScene().setRoot(root);
	}

    @FXML
    private void smartCardButtonClick(MouseEvent event) throws IOException {
        Parent paymentParent = FXMLLoader.load(getClass().getResource("/payment/Payment.fxml"));
        Scene paymentScene = new Scene(paymentParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(paymentScene);
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

	@FXML
	private void timetableButtonClick(MouseEvent event) throws IOException {
		Parent timetableParent = FXMLLoader.load(getClass().getResource("/timetable/timetable.fxml"));
		Scene timetableScene = new Scene(timetableParent);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

		window.setScene(timetableScene);
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

	public void topupButtonClick(MouseEvent mouseEvent)
	{
		//UserController user = new UserController();

		System.out.println(user.currentUser.name);

		float amount = Float.valueOf(topUpAmount.getText());

		float newBalance = user.topUpBalance(amount);

		System.out.println(Float.toString(newBalance));

		balanceLbl.setText("LKR "+Float.toString(newBalance));

	}
}
