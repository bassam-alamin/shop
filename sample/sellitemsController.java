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
import java.sql.Statement;
import java.util.ResourceBundle;

public class sellitemsController implements Initializable {
    @FXML
    private TableView<stock> tableStock;
    @FXML
    private javafx.scene.control.TextField textFind;
    @FXML
    private javafx.scene.control.TextField textQuantity;
    @FXML
    private javafx.scene.control.TextField textTotal;
    @FXML
    private javafx.scene.control.TextField textAmount;
    @FXML
    private javafx.scene.control.TextField textBalance;

    @FXML
    private TableColumn<stock, Double> columnPrice;
    @FXML
    private TableColumn<stock, Double> columnQuantity;
    @FXML
    private TableColumn<stock, Double> columnItem;
    @FXML
    private TableColumn<stock, Double> columnSum;

    @FXML
    private Button btnload;

    //Initialize observable list to hold out database data
    private ObservableList<stock> data;
    private database dc;
    private Double ans;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        dc = new database();
        //set cell value factory for table
        columnItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnSum.setCellValueFactory(new PropertyValueFactory<>("sum"));



        data = FXCollections.observableArrayList();
        tableStock.setItems(null);
        tableStock.setItems(data);
        ans = 0.0;




    }

    @FXML
    private void loadDataFromDatabase(javafx.event.ActionEvent event){
        try {
            Double total;
            Double transit;


            Connection conn = dc.getConnecton();


            String sql = "SELECT *FROM STOCK WHERE ITEMS = '" + textFind.getText() + "'";
            ResultSet rs =conn.prepareStatement(sql).executeQuery();

            //sql = "UPDATE STOCK SET STOCK=STOCK-Double.parseDouble(textQuantity.getText()) WHERE ITEMS = '" + textFind.getText() + "'";
            //Statement statement = conn.createStatement();
            //statement.executeUpdate(sql);

            while(rs.next()){
                data.add(new stock(rs.getString(1),rs.getString(2), rs.getDouble(3),rs.getDouble(4), rs.getDouble(3)*Double.parseDouble(textQuantity.getText())));
                 total = rs.getDouble(3)*Double.parseDouble(textQuantity.getText());
                 transit = total;

                 ans += transit;

            }
            textTotal.setText(String.format("%f",ans));




        } catch (SQLException ex){
            System.err.println("Error occured");
        }

    }


    @FXML
    private void calculatebalance(javafx.event.ActionEvent event){
        Double diff = Double.parseDouble(textAmount.getText())-ans;
        textBalance.setText(String.format("%f",diff));

    }








    public void changeScreenWhenPushed(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("customer.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


}
