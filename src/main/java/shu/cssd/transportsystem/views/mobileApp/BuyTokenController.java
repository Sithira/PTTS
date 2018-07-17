package shu.cssd.transportsystem.views.mobileApp;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.ui.MobileAppController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.foundation.exceptions.NotEnoughFundsException;
import shu.cssd.transportsystem.foundation.types.PaymentType;
import shu.cssd.transportsystem.helpers.CostCalculator;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BuyTokenController implements Initializable
{
	
	@FXML
	private AnchorPane buyPanel;
	
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
	
	private Stop originStop, destinationStop;
	
	private ArrayList<Stop> stopList = new ArrayList<>();
	
	private ArrayList<Route> rList = new ArrayList<>();
	
	private MobileAppController mobileAppController = new MobileAppController();
	
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		cost.setEditable(false);
		
		ArrayList<BaseModel> routesList;
		
		routesList = mobileAppController.getRoutes();
		
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
		
		payType.getItems().setAll(PaymentType.values());
	}
	
	@FXML
	private void backButtonClick(MouseEvent event) throws IOException
	{
		Parent tokenParent = FXMLLoader.load(getClass().getResource("/mobileApp/token/token.fxml"));
		Scene tokenScene = new Scene(tokenParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(tokenScene);
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
	private void journeyButtonClick(MouseEvent event) throws IOException
	{
		Parent journeyParent = FXMLLoader.load(getClass().getResource("/mobileApp/journey/journey.fxml"));
		Scene journeyScene = new Scene(journeyParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(journeyScene);
		window.show();
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
		
		this.loadEstimatedFare();
	}
	

	private void loadEstimatedFare()
	{
		float estimated = CostCalculator.getInstance()
				.calculate(originStop, destinationStop, destinationStop.getRoute());
		
		cost.setText("LKR :" + estimated);
	}
	
	@FXML
	public void buyTicket()
	{
		try {
			this.mobileAppController.getToken(originStop, destinationStop);
			
			clearFields();
		}
		catch (NotEnoughFundsException e)
		{
			AlertBox.getInstance()
					.alertWithHeader("Whoops", "Not Enough funds to create a token");
		}
	}
	
	/**
	 * Clear all the fields
	 */
	private void clearFields()
	{
		// loop through all the properties
		for (Node node : buyPanel.getChildren())
		{
			// get the nodes
			if (node instanceof JFXTextField)
			{
				((JFXTextField) node).clear();
			}
			
			
			if (node instanceof JFXComboBox)
			{
				JFXComboBox jfxComboBox = (JFXComboBox) node;
				
				jfxComboBox.getItems().clear();
			}
		}
	}
}
