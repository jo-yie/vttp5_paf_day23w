package vttp5_paf_day23w.utils;

public class Queries {

    public static final String SQL_GET_ORDER_BY_ID =
    """
        SELECT * FROM orders
            WHERE id = ?
    """;
    
}
