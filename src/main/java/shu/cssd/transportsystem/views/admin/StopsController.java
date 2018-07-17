package shu.cssd.transportsystem.views.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StopsController {
    @FXML
    private void backButtonClick(MouseEvent event) throws IOException {
        Parent dashboardParent = FXMLLoader.load(getClass().getResource("/admin/dashboard/dashboard.fxml"));
        Scene dashboardScene = new Scene(dashboardParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(dashboardScene);
        window.show();
    }

    @FXML
    private void addButtonClick(MouseEvent event) throws IOException {
        Parent addParent = FXMLLoader.load(getClass().getResource("/admin/addStops/addStops.fxml"));
        Scene addScene = new Scene(addParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(addScene);
        window.show();
    }

    @FXML
    private void modButtonClick(MouseEvent event) throws IOException {
        Parent modParent = FXMLLoader.load(getClass().getResource("/admin/modifyStops/modifyStops.fxml"));
        Scene modScene = new Scene(modParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(modScene);
        window.show();
    }
}
