package shu.cssd.transportsystem.views.inspectorMachine;

import com.jfoenix.controls.JFXComboBox;
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
import shu.cssd.transportsystem.controllers.ui.InspectorMachineController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.helpers.CostCalculator;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;
import shu.cssd.transportsystem.models.collections.SetOfUsers;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IssueTokenController implements Initializable
{
	
	@FXML
	private JFXComboBox routes;
	
	@FXML
	private JFXComboBox stopOrigin;
	
	@FXML
	private JFXComboBox stopDestination;
	
	@FXML
	private JFXTextField username;
	
	@FXML
	private Label fare;
	
	private SetOfRoutes setOfRoutes = new SetOfRoutes();
	
	private SetOfUsers setOfUsers = new SetOfUsers();
	
	private ArrayList<Route> routeList = new ArrayList<>();
	
	private ArrayList<Stop> stops;
	
	private Route selectedRoute;
	private Stop origin;
	private Stop destination;
	private User user;
	
	private InspectorMachineController inspectorMachineController = new InspectorMachineController();
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
		for (BaseModel model : setOfRoutes.all())
		{
			Route route = (Route) model;
			
			routeList.add(route);
			
			routes.getItems().add(route.name);
		}
		
	}
	
	@FXML
	private void backbuttonClick(MouseEvent event) throws IOException
	{
		Parent homeParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/home/home.fxml"));
		Scene homeScene = new Scene(homeParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(homeScene);
		window.show();
	}
	
	@FXML
	public void onRouteSelect()
	{
		String selected = routes.getSelectionModel().getSelectedItem().toString();
		
		for (Route route : routeList)
		{
			if (route.name.equals(selected))
			{
				this.selectedRoute = route;
				
				populate(route);
			}
		}
	}
	
	private void populate(Route route)
	{
		
		this.stops = route.getStops();
		
		for (Stop stop : stops)
		{
			this.stopOrigin.getItems().add(stop.name);
			this.stopDestination.getItems().add(stop.name);
		}
		
	}
	
	@FXML
	public void setOrigin()
	{
		for (Stop stop : this.stops)
		{
			this.origin = stop;
		}
	}
	
	@FXML
	public void setDestination()
	{
		for (Stop stop : this.stops)
		{
			this.destination = stop;
		}
		
		float fee = CostCalculator.getInstance().calculate(this.origin, this.destination, this.origin.getRoute());
		
		this.fare.setText(Float.toString(fee));
	}
	
	@FXML
	private void issueToken()
	{
		
		for (BaseModel model : setOfUsers.all())
		{
			User user = (User) model;
			
			if (this.username.getText().equals(user.username))
			{
				this.user = user;
			}
		}
		
		if (user == null)
		{
			AlertBox.getInstance().alertDanger("Whoops !", "User not found");
			
			return;
		}
		
		this.inspectorMachineController.createToken(this.user, this.origin, this.destination);
		
		AlertBox.getInstance().alertSuccess("Token Created", "Token was successfully created");
		
	}
}
