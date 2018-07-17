package shu.cssd.transportsystem.views.mobileApp;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shu.cssd.transportsystem.MainApp;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.foundation.validation.Validator;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable
{
	@FXML
	public JFXTextField topUpAmount;
	
	private UserController userController;
	
	private Validator validator = Validator.getInstance();
	
	@FXML
	private Label balance;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.userController = UserController.getInstance();
		
		balance.setText("LKR " +Float.toString(UserController.currentUser.balance));
	}
	
	@FXML
	public void loadDashBoard(javafx.event.ActionEvent event) throws IOException
	{

		
		Parent parent = FXMLLoader.load(getClass().getResource("/mobileApp/dashboard/Dashboard.fxml"));

		Scene scene = new Scene(parent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	@FXML

	private void logout_buttonClick(MouseEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("/mobileApp/login/Scene.fxml"));
		MainApp.stage.getScene().setRoot(root);
	}
	
	@FXML
	private void smartCardButtonClick(MouseEvent event) throws IOException
	{
		Parent paymentParent = FXMLLoader.load(getClass().getResource("/mobileApp/payment/Payment.fxml"));
		Scene paymentScene = new Scene(paymentParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(paymentScene);
		window.show();
	}
	
	@FXML
	private void journeyButtonClick(MouseEvent event) throws IOException
	{
		Parent journeyParent = FXMLLoader.load(getClass().getResource("/mobileApp/journey/journey.fxml"));
		Scene journeyScene = new Scene(journeyParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(journeyScene);
		window.show();
	}

	@FXML
	private void purchaseButtonClick(MouseEvent event) throws IOException {
		Parent purchaseParent = FXMLLoader.load(getClass().getResource("/mobileApp/purchase/purchase.fxml"));
		Scene purchaseScene = new Scene(purchaseParent);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

		window.setScene(purchaseScene);
		window.show();
	}
	
	@FXML
	private void timetableButtonClick(MouseEvent event) throws IOException
	{
		Parent timetableParent = FXMLLoader.load(getClass().getResource("/mobileApp/timetable/timetable.fxml"));
		Scene timetableScene = new Scene(timetableParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(timetableScene);
		window.show();
	}
	
	@FXML

	private void profileButtonClick(MouseEvent event) throws IOException
	{
		Parent profileParent = FXMLLoader.load(getClass().getResource("/mobileApp/profile/profile.fxml"));

		Scene profileScene = new Scene(profileParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(profileScene);
		window.show();
	}

	
	@FXML
	private void tokenButtonClick(MouseEvent event) throws IOException
	{
		Parent tokenParent = FXMLLoader.load(getClass().getResource("/mobileApp/token/token.fxml"));
		Scene tokenScene = new Scene(tokenParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(tokenScene);
		window.show();
	}
	
	@FXML
	private void routeButtonClick(MouseEvent event) throws IOException
	{
		Parent routeParent = FXMLLoader.load(getClass().getResource("/mobileApp/route/route.fxml"));

		Scene routeScene = new Scene(routeParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(routeScene);
		window.show();
	}
	
	public void topupButtonClick(MouseEvent mouseEvent)
	{
		
		if (!AlertBox.getInstance().confirm("Are you sure to top up ?"))
		{
			return;
		}
		
		if (this.validator.isEmpty(topUpAmount)
				|| !this.validator.isNumeric(topUpAmount)
				|| !this.validator.isPositive(topUpAmount))
		{
			AlertBox.getInstance().alertWithHeader("Whoops !", "Please check your input");
			
			return;
		}
		
		float amount = Float.valueOf(topUpAmount.getText());
		
		float newBalance = userController.topUpBalance(amount);
		
		balance.setText("LKR " + Float.toString(newBalance));
		
		topUpAmount.clear();
		
	}
}
