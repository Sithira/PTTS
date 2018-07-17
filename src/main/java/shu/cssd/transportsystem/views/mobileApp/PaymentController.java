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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.SmartCardController;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.foundation.validation.Validator;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class PaymentController implements Initializable
{
	
	@FXML
	AnchorPane rootPane;
	
	@FXML
	public JFXTextField topUpAmount1;
	
	private UserController userController;
	
	private SmartCardController smartCardController = new SmartCardController();
	
	private Validator validator = Validator.getInstance();
	
	@FXML
	private Label balance1;
	
	@FXML
	private Label cardId;
	
	@FXML
	private Label expiryDate;
	Format formatter;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.userController = UserController.getInstance();
		
		balance1.setText("LKR " + Float.toString(UserController.currentUser.getCard().balance));
		
		cardId.setText(UserController.currentUser.getCard().id);
		
		formatter = new SimpleDateFormat("MM/yyyy");
		
		String date = formatter.format(UserController.currentUser.getCard().expiryDate);
		
		expiryDate.setText(date);
	}
	
	@FXML
	private void backButtonClick(MouseEvent event) throws IOException
	{
		Parent dashboardParent = FXMLLoader.load(getClass().getResource("/mobileApp/dashboard/Dashboard.fxml"));
		Scene dashboardScene = new Scene(dashboardParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(dashboardScene);
		window.show();
	}
	
	@FXML
	private void paymentButtonClick(MouseEvent event) throws IOException
	{
		Parent paymentParent = FXMLLoader.load(getClass().getResource("/mobileApp/payment/Payment.fxml"));
		Scene paymentScene = new Scene(paymentParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(paymentScene);
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
	
	@FXML
	private void purchaseButtonClick(MouseEvent event) throws IOException
	{
		Parent purchaseParent = FXMLLoader.load(getClass().getResource("/mobileApp/purchase/purchase.fxml"));
		Scene purchaseScene = new Scene(purchaseParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(purchaseScene);
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
	
	public void topupButton1Click(MouseEvent mouseEvent)
	{
		
		if (!AlertBox.getInstance().confirm("Are you sure to top up ?"))
		{
			return;
		}
		
		if (this.validator.isEmpty(topUpAmount1)
				|| !this.validator.isNumeric(topUpAmount1)
				|| !this.validator.isPositive(topUpAmount1))
		{
			AlertBox.getInstance().alertWithHeader("Whoops !", "Please check your input");
			
			return;
		}
		
		float amount = Float.valueOf(topUpAmount1.getText());
		
		float newBalance = smartCardController.topUpBalance(userController.currentUser.getCard(), amount);
		
		balance1.setText("LKR " + Float.toString(newBalance));
		
		topUpAmount1.clear();
	}
}
