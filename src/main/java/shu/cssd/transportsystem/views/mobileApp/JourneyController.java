package shu.cssd.transportsystem.views.mobileApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.UserController;
import shu.cssd.transportsystem.models.Journey;
import shu.cssd.transportsystem.views.mobileApp.content.JourneyListCell;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JourneyController implements Initializable
{
	
	@FXML
	private ScrollPane pastJourney;
	
	@FXML
	private AnchorPane pastList;
	
	ArrayList<Journey> journeys;

	@FXML
	private ListView<Journey> journeyList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
		this.journeyList.setCellFactory(param -> new JourneyListCell());
		
		journeys = UserController.currentUser.getJourney();
		
		System.out.println("Journey Count:" + journeys.size());
		
		for (Journey journey : journeys)
		{
			System.out.println("Fire");
			journeyList.getItems().add(journey);
		}
		
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
	private void routeButtonClick(MouseEvent event) throws IOException
	{
		Parent routeParent = FXMLLoader.load(getClass().getResource("/mobileApp/route/route.fxml"));
		Scene routeScene = new Scene(routeParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(routeScene);
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
}
