package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class stock {
    private final StringProperty item;
    private final StringProperty quantity;
    private final DoubleProperty price;
    private final DoubleProperty stock;
    private final DoubleProperty sum;



    public stock(String item, String quantity, Double price, Double stock, Double sum) {
        this.item = new SimpleStringProperty(item);
        this.quantity = new SimpleStringProperty(quantity);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleDoubleProperty(stock);
        this.sum = new SimpleDoubleProperty(sum);


    }



    //getters
    public String getItem(){
        return item.get();
    }
    public String getQuantity(){
        return quantity.get();
    }
    public Double getPrice(){
        return price.get();
    }
    public Double getStock(){
        return stock.get();
    }
    public Double getSum(){
        return sum.get();
    }
    //setters
    public void setItem(String value){
        item.set(value);
    }
    public void setQuantity(String value){
        quantity.set(value);
    }
    public void setPrice(Double value){
        price.set(value);
    }
    public void setStock(Double value){
        stock.set(value);
    }
    public void setSum(Double value){
        sum.set(value);
    }
    //property values


    public StringProperty itemProperty() {
        return item;
    }

    public StringProperty quantityProperty() {
        return quantity;
    }
    public DoubleProperty priceProperty(){
        return price;
    }

    public DoubleProperty stockProperty() {
        return stock;
    }

}
