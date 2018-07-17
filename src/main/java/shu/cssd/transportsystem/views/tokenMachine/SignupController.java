package shu.cssd.transportsystem.views.tokenMachine;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import shu.cssd.transportsystem.MainApp;
import shu.cssd.transportsystem.foundation.validation.Validator;
import shu.cssd.transportsystem.models.User;
import shu.cssd.transportsystem.views.helpers.AlertBox;

import java.io.IOException;

public class SignupController {

    private Validator validator = Validator.getInstance();

    @FXML
    AnchorPane anchorpane;

    @FXML
    JFXTextField name;

    @FXML
    JFXTextField username;

    @FXML
    JFXTextField email;

    @FXML
    JFXPasswordField password;

    @FXML
    JFXTextField address;

    @FXML
    JFXTextField city;

    @FXML
    JFXTextField postalCode;

    @FXML
    public void sign_up(ActionEvent event) throws IOException
    {
        // loop through all the properties
        for (Node node : anchorpane.getChildren())
        {
            // get the nodes
            if (node instanceof JFXTextField)
            {
                // for the email
                if (node.getId().equals("email"))
                {
                    // add the special validation
                    if (!this.validator.isEmail(((JFXTextField) node).getText()))
                    {
                        AlertBox.getInstance().alertWithHeader("Validation Error", "Email is not in the correct format");
                        return;
                    }
                }
                // validate for empty fields
                if (this.validator.isEmpty((JFXTextField) node))
                {
                    AlertBox.getInstance().alertWithHeader("Validation Error", "Field " + node.getId() + " is empty");

                    System.out.println("Failed on:" + node.getId());

                    return;
                }
            }
        }
        this.createUser();

        Parent homeParent = FXMLLoader.load(getClass().getResource("/tokenMachine/home/home.fxml"));

        Scene homeScene = new Scene(homeParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(homeScene);

        window.show();
    }

    private User createUser()
    {
        return new User.Builder(name.getText(), email.getText(), address.getText(),
                city.getText(), postalCode.getText(), username.getText(), password.getText())
                .create();
    }

    @FXML
    private void backClick(MouseEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/login/Scene.fxml"));
        MainApp.stage.getScene().setRoot(root);
    }
}
