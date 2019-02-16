package sample;

import connectivity.database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class addStockController implements Initializable {
    @FXML
    private TextField columnItem;
    @FXML
    private TextField columnQuantity;
    @FXML
    private TextField columnPrice;

    @FXML
    private TextField columnStock;

    private database dc;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        dc = new database();

    }

    @FXML
    private void addDataToDatabase(javafx.event.ActionEvent event){
        try {
            Connection conn = dc.getConnecton();
            String sql = "INSERT INTO STOCK VALUES ('"+columnItem.getText()+"','"+columnQuantity.getText()+"','"+columnPrice.getText()+"','"+columnStock.getText()+"')";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("stock.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();


        } catch (SQLException ex){
            System.err.println("Error occured"+ex);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
