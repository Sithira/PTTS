package shu.cssd.transportsystem.views;


import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


public class purchaseController {
    @FXML
    public ComboBox monthBox;

    public void setData(){

        monthBox.getItems().clear();

        monthBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");

    }
}
