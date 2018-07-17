package shu.cssd.transportsystem.views.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    private void logoutButtonClick(MouseEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("/admin/login/login.fxml"));
        Scene loginScene = new Scene(loginParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(loginScene);
        window.show();
    }

    @FXML
    private void empButtonClick(MouseEvent event) throws IOException {
        Parent empParent = FXMLLoader.load(getClass().getResource("/admin/employee/employee.fxml"));
        Scene empScene = new Scene(empParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(empScene);
        window.show();
    }

    @FXML
    private void routeButtonClick(MouseEvent event) throws IOException {
        Parent rtParent = FXMLLoader.load(getClass().getResource("/admin/routes/routes.fxml"));
        Scene rtScene = new Scene(rtParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(rtScene);
        window.show();
    }

    @FXML
    private void stopButtonClick(MouseEvent event) throws IOException {
        Parent stParent = FXMLLoader.load(getClass().getResource("/admin/stops/stops.fxml"));
        Scene stScene = new Scene(stParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(stScene);
        window.show();
    }

    @FXML
    private void zoneButtonClick(MouseEvent event) throws IOException {
        Parent znParent = FXMLLoader.load(getClass().getResource("/admin/zone/zone.fxml"));
        Scene znScene = new Scene(znParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(znScene);
        window.show();
    }
}
