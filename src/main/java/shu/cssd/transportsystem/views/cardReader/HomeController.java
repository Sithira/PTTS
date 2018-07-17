package shu.cssd.transportsystem.views.cardReader;

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
import shu.cssd.transportsystem.controllers.GateController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.Gate;
import shu.cssd.transportsystem.models.SmartCard;
import shu.cssd.transportsystem.models.Stop;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfStops;
import shu.cssd.transportsystem.models.collections.SetOfUsers;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements Initializable
{
	
	@FXML
	private JFXTextField username;
	
	@FXML
	private JFXComboBox stops;
	
	@FXML
	private JFXComboBox gates;
	
	@FXML
	private Label gateType;
	
	private SetOfStops setOfStops = new SetOfStops();
	
	private SetOfUsers setOfUsers = new SetOfUsers();
	
	private ArrayList<Stop> stopsList = new ArrayList<>();
	
	private Stop currentStop;
	
	private User currentUser;
	
	private GateController gateController = new GateController();
	private ArrayList<Gate> gateList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
		for (BaseModel model: setOfStops.all())
		{
			Stop stop = (Stop) model;
			
			stopsList.add(stop);
			
			stops.getItems().add(stop.name);
			
		}
		
	}
	
	@FXML
	private void scanButtonClick(MouseEvent event) throws IOException
	{
		Parent empParent = FXMLLoader.load(getClass().getResource("/cardReader/success/success.fxml"));
		Scene empScene = new Scene(empParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(empScene);
		window.show();
	}
	
	@FXML
	private void onStopSelect()
	{
	
		String selectedItem = this.stops.getSelectionModel().getSelectedItem().toString();
		
		for (Stop stop: this.stopsList)
		{
			if (selectedItem.equals(stop.name))
			{
				this.currentStop = stop;
				
				this.loadGates();
			}
		}
	
	}
	
	private void loadGates()
	{
		this.gateList = null;
		
		this.gateList = this.currentStop.getGates();
		
		this.gates.getItems().clear();
		
		for (Gate gate: gateList)
		{
			System.out.println("|-->" + gate.gateType + " - " + gate.id);
			
			this.gates.getItems().add(gate.id);
		}
	}
	
	@FXML
	private void onGateSelect()
	{
	
		String selectedGateId = this.gates.getSelectionModel().getSelectedItem().toString();
		
		for (Gate gate: this.gateList)
		{
			if (selectedGateId.equals(gate.id))
			{
				this.gateType.setText("Gate Type :" + gate.gateType);
			}
		}
		
	}
	
	@FXML
	private void openCard()
	{
	
		for (BaseModel model : this.setOfUsers.all())
		{
			
			User user = (User) model;
			
			if (user.username.equals(this.username.getText()))
			{
				this.currentUser = user;
			}
			
		}
		
		if (this.currentUser == null)
		{
			AlertBox.getInstance().alertDanger("Whoops !", "Invalid login. Please check");
			
			return;
		}
		
		try
		{
			SmartCard card = this.currentUser.getCard();
			
			String gateId =  this.gates.getSelectionModel().getSelectedItem().toString();
			
			boolean gateStats = this.gateController.readSmartCard(card.id, gateId);
			
			if (!gateStats)
			{
				AlertBox.getInstance().alertDanger("Whoops", this.gateController.REASON);
			}
			
			if (this.gateController.amountCharged != 0)
			{
				AlertBox.getInstance().alertSuccess("Come again to ride with us", "You have been charged LKR: " + this.gateController.amountCharged);
			}
			
		}
		catch (NullPointerException e)
		{
			AlertBox.getInstance().alertDanger("Whoops !", "Its seems like your card is not readable. Please contact admins");
			
			return;
		}
		
	
	}
	
}
