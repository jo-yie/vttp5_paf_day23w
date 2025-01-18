package vttp5_paf_day23w.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {

    // from orders
    private int orderId; 
    private Date orderDate;
    private int customerId;
    public Order() {
    }
    public Order(int orderId, Date orderDate, int customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
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

    public static Order toOrder(SqlRowSet rs) {

        Order o = new Order(); 

        o.setOrderId(rs.getInt("id"));
        System.out.println("testing");
        System.out.println(rs.getObject("order_date"));

        // Convert order_date to Date (handles both Timestamp and LocalDateTime)
        Object orderDateObject = rs.getObject("order_date");

        if (orderDateObject instanceof Timestamp) {
            o.setOrderDate(new Timestamp(((Timestamp) orderDateObject).getTime()));
        } else if (orderDateObject instanceof LocalDateTime) {
            o.setOrderDate(Date.from(((LocalDateTime) orderDateObject).atZone(ZoneId.systemDefault()).toInstant()));
        }


        o.setCustomerId(rs.getInt("customer_id"));

        return o;

    }

    // // order_details --> quantity * unit_price * discount
    // private float totalPrice; 

    // // (order_details --> quantity) * (product --> standard_cost)
    // private float costPrice; 

    

    
}
