package shu.cssd.transportsystem.views.mobileApp.content;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import shu.cssd.transportsystem.models.Token;

public class TokenTabController
{
	
	@FXML
	private Label routeName;
	
	public void setToken(Token token)
	{
		String route;
		
		if (token != null)
		{
			route = token.getOriginStop().name;
			
			if (token.getDestinationStop() != null)
			{
				route += " - " + token.getDestinationStop().name;
			}
			
			this.routeName.setText(route);
		}
	}
	
}
