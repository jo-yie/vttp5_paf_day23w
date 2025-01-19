package vttp5_paf_day23w.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {

    private int orderId; 
    private Date orderDate;
    private int customerId;
    private float totalPrice; 
    private float costPrice;
    public Order() {
    }
    public Order(int orderId, Date orderDate, int customerId, float totalPrice, float costPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.costPrice = costPrice;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public float getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    public float getCostPrice() {
        return costPrice;
    }
    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    } 

}
