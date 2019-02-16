package sample;

import connectivity.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class stockController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private TableView<stock> tableStock;
    @FXML
    private TableColumn<stock, String> columnItem;
    @FXML
    private TableColumn<stock, String> columnQuantity;
    @FXML
    private TableColumn<stock, Double> columnPrice;
    @FXML
    private TableColumn<stock, Double> columnStock;

    @FXML
    private Button btnload;

    //Initialize observable list to hold out database data
    private ObservableList<stock> data;
    private database dc;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        dc = new database();

    }
    @FXML
    private void loadDataFromDatabase(javafx.event.ActionEvent event){
        try {
            Connection conn = dc.getConnecton();
            data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT *FROM STOCK");
            while(rs.next()){
                data.add(new stock(rs.getString(1),rs.getString(2), rs.getDouble(3),rs.getDouble(4),0.0));
            }

        } catch (SQLException ex){
            System.err.println("Error occured");
        }
        //set cell value factory for table
        columnItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tableStock.setItems(null);
        tableStock.setItems(data);


    }

    public void changeScreenWhenPushed(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sellitems.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    public void changeScreenWhenPush(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("addStock.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


}
