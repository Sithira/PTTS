package shu.cssd.transportsystem.views.inspectorMachine;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shu.cssd.transportsystem.controllers.ui.InspectorMachineController;
import shu.cssd.transportsystem.controllers.ui.TokenMachineController;
import shu.cssd.transportsystem.foundation.BaseModel;
import shu.cssd.transportsystem.models.Route;
import shu.cssd.transportsystem.models.Token;
import shu.cssd.transportsystem.models.collections.SetOfRoutes;
import shu.cssd.transportsystem.models.collections.SetOfTokens;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ValidateTokenController implements Initializable
{
	SetOfRoutes setOfRoutes = new SetOfRoutes();
	
	SetOfTokens setOfTokens = new SetOfTokens();
	
	ArrayList<Route> routesList = new ArrayList<>();
	
	ArrayList<Token> tokenList = new ArrayList<>();
	
	private Token currentToken;
	
	@FXML
	private JFXTextField token;
	
	@FXML
	private JFXComboBox routes;
	
	@FXML
	private JFXTextField stopOrigin;
	
	@FXML
	private JFXTextField stopDestination;
	
	private InspectorMachineController inspectorMachineController = new InspectorMachineController();
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	
		
		for (BaseModel model: setOfTokens.all())
		{
			System.out.println("Token ID: " + model.id);
		}
		
		for (BaseModel model: setOfRoutes.all())
		{
			
			Route route = (Route) model;
			
			routesList.add(route);
			
			routes.getItems().add(route.name);
		}
		
		for (BaseModel model: setOfTokens.all())
		{
			tokenList.add((Token) model);
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
	private void issuebuttonClick(MouseEvent event) throws IOException
	{
		Parent iTParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/issueToken/issueToken.fxml"));
		Scene iTScene = new Scene(iTParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(iTScene);
		window.show();
	}
	
	@FXML
	public void onRouteList()
	{
		String selectedRoute = this.routes.getSelectionModel()
				.getSelectedItem().toString();
		
		for (Route route: routesList)
		{
			if (route.name.equals(selectedRoute))
			{
				this.inspectorMachineController.route = route;
			}
		}
	}
	
	@FXML
	public void validateToken(ActionEvent event) throws IOException
	{
		
		String tokenId = this.token.getText();
		
		for (Token token : tokenList)
		{
			if (tokenId.equals(token.id))
			{
				
				if (token.getOriginStop().routeId.equals(this.inspectorMachineController.route.id))
				{
					this.currentToken = token;
					
					Parent empParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/validateToken/success/success.fxml"));
					Scene empScene = new Scene(empParent);
					
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
					
					window.setScene(empScene);
					window.show();
					
					return;
				}
				
			}
		}
		
		Parent empParent = FXMLLoader.load(getClass().getResource("/inspectorMachine/validateToken/fail/failed.fxml"));
		Scene empScene = new Scene(empParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(empScene);
		window.show();
		
		
	}
}
