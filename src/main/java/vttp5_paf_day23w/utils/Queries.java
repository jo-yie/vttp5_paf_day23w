package vttp5_paf_day23w.utils;

public class Queries {

    // public static final String SQL_GET_ORDER_BY_ID =
    // """
    //     SELECT * FROM orders
    //         WHERE id = ?
    // """;

    public static final String SQL_GET_ORDER_BY_ID = 
    """
        SELECT 
            o.id AS order_id, 
            o.order_date, 
            o.customer_id,
            SUM(od.quantity * od.unit_price * (1-od.discount)) AS total_price,
            SUM(od.quantity * p.standard_cost) AS cost_price
        FROM 
            orders o 
        JOIN 
            order_details od 
        ON 
            o.id=od.order_id 
        JOIN 
            products p 
        ON 
            od.product_id=p.id
        GROUP BY 
            o.id 
        HAVING
            o.id = ?
    """;
    
}
