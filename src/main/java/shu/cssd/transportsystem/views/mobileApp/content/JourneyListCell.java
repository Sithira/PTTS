package shu.cssd.transportsystem.views.mobileApp.content;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;
import shu.cssd.transportsystem.models.Journey;

import java.io.IOException;

public class JourneyListCell extends ListCell<Journey>
{

	private VBox root;

	private JourneyTabController journeyTabController;
	
	public JourneyListCell()
	{
		
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/mobileApp/journey/journeyTab.fxml"));
			root = loader.load();
			journeyTabController = loader.getController();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void updateItem(Journey item, boolean empty)
	{
		
		if (item != null)
		{
			journeyTabController.setJourney(item);
			setGraphic(root);
			setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		}
	}
}
