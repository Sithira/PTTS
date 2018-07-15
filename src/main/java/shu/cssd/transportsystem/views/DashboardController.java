package shu.cssd.transportsystem.views;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import shu.cssd.transportsystem.MainApp;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable
{
	AnchorPane rootPane;



	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//topPane.setEffect(new DropShadow(2d, 0d, +2d, Color.BLACK));
	}
	
	public void loadDashBoard(ActionEvent event) throws IOException
	{
		Parent parent = FXMLLoader.load(getClass().getResource("dashboard/Dashboard.fxml"));

		Scene scene = new Scene(parent);

		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

		window.setScene(scene);

		window.show();

	}

	@FXML
	private void logout_buttonClick(MouseEvent event) throws IOException {
		Parent root =FXMLLoader.load(getClass().getResource("/login/Scene.fxml"));
		MainApp.stage.getScene().setRoot(root);
	}

    @FXML
    private void paymentButtonClick(MouseEvent event) throws IOException {
        Parent paymentParent = FXMLLoader.load(getClass().getResource("/payment/Payment.fxml"));
        Scene paymentScene = new Scene(paymentParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(paymentScene);
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
        Parent tokenParent = FXMLLoader.load(getClass().getResource("/tokens/token.fxml"));
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

}
