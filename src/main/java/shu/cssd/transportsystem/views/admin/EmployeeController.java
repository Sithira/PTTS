package shu.cssd.transportsystem.views.admin;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.models.collections.SetOfUsers;

import javax.swing.table.TableColumn;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable
{
	
	@FXML
	private JFXTreeTableView employeeTable;
	
	private SetOfUsers setOfUsers = new SetOfUsers();
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		
		JFXTreeTableColumn<User, String> id = new JFXTreeTableColumn<>("id");
		
	}
	
	@FXML
	private void backButtonClick(MouseEvent event) throws IOException
	{
		Parent dashboardParent = FXMLLoader.load(getClass().getResource("/admin/dashboard/dashboard.fxml"));
		Scene dashboardScene = new Scene(dashboardParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(dashboardScene);
		window.show();
	}
	
	@FXML
	private void addButtonClick(MouseEvent event) throws IOException
	{
		Parent addParent = FXMLLoader.load(getClass().getResource("/admin/addEmployee/addEmployee.fxml"));
		Scene addScene = new Scene(addParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(addScene);
		window.show();
	}
	
	
	@FXML
	private void modButtonClick(MouseEvent event) throws IOException
	{
		Parent modParent = FXMLLoader.load(getClass().getResource("/admin/modifyEmployee/modifyEmployee.fxml"));
		Scene modScene = new Scene(modParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(modScene);
		window.show();
	}
}
