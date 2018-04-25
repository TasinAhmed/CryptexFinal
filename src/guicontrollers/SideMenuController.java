package guicontrollers;

import coin.CoinList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.APINotRespondingException;
import util.graph.CoinExchange;
import util.graph.CoinGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SideMenuController implements Initializable {
    @FXML private Label name;

    @FXML private void tradeCoins() throws IOException, APINotRespondingException {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/TradeCoins.fxml"));
        Scene window = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Trade Coins");
        stage.setScene(window);
        stage.show();
    }

    private String getName(){
        Scanner x = null;
        String[] nameFull;
        try {
            x = new Scanner(new File("info.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(Objects.requireNonNull(x).hasNext()){
            nameFull = x.nextLine().split(",");
            if(nameFull[0].equals(MainScreenController.getTemp())){
                return nameFull[2];
            }
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(getName());
    }
}
