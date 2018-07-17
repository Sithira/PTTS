package shu.cssd.transportsystem.views.mobileApp.content;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;
import shu.cssd.transportsystem.models.Token;

import java.io.IOException;

public class TokenListCell extends ListCell<Token>
{
	private VBox root;
	
	private TokenTabController tokenTabController;
	
	public TokenListCell()
	{
		
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/mobileApp/tokenWallet/tokenWalletItem.fxml"));
			root = loader.load();
			tokenTabController = loader.getController();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void updateItem(Token item, boolean empty)
	{
		if (item != null)
		{
			this.tokenTabController.setToken(item);
			setGraphic(root);
			setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		}
	}
}
