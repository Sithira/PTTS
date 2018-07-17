package shu.cssd.transportsystem.views.mobileApp.content;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import shu.cssd.transportsystem.models.Journey;

public class JourneyTabController
{
	@FXML
	private VBox root;
	
	@FXML
	private Label origin_destination;
	
	public void setJourney(Journey journey)
	{
		if (journey != null)
		{
			this.origin_destination.setText(journey.getOrigin().name + " - " + journey.getDestination().name);
		}
	}
}
