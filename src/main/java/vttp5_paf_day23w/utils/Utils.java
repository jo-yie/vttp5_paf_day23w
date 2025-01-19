package vttp5_paf_day23w.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import vttp5_paf_day23w.model.Order;

public class Utils {

    public static Order toOrder(SqlRowSet rs) {

        Order o = new Order(); 

        o.setOrderId(rs.getInt("order_id"));
        o.setCustomerId(rs.getInt("customer_id"));
        o.setTotalPrice(rs.getFloat("total_price"));
        o.setCostPrice(rs.getFloat("cost_price"));

        try { 
            String orderDate = rs.getString("order_date");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date orderDateNew = sdf.parse(orderDate);
            o.setOrderDate(orderDateNew);

        } catch (ParseException e) {
            System.out.println(e.getMessage());

        }

        return o;

    }
    
}
