package guicontrollers;

import coin.CoinList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import util.APINotRespondingException;
import util.graph.CoinExchange;
import util.graph.CoinGraph;

import java.net.URL;
import java.util.ResourceBundle;

public class TradeController{
    @FXML private AnchorPane tradeScreen;
    @FXML private Label tradeResult;
    @FXML private Label pathLabel;
    @FXML private TextField coin1;
    @FXML private TextField coin2;

    @FXML private void tradeSubmit() throws APINotRespondingException {
        CoinGraph G = new CoinGraph();
        CoinExchange bfs = new CoinExchange(G, CoinList.getByCode(coin1.getText()));
        if(bfs.hasPathTo(CoinList.getByCode(coin2.getText())))
        {
            tradeResult.setText("The coins can be traded!");
            String path = bfs.pathToString(bfs.tradesTo(CoinList.getByCode(coin2.getText())));
            pathLabel.setText(path.substring(0,path.length()-2));
        }
        else{
            tradeResult.setText("The coins cannot be traded!");
        }
    }
}
