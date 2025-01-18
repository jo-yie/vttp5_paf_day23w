package vttp5_paf_day23w.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp5_paf_day23w.model.Order;
import vttp5_paf_day23w.utils.Queries;

@Repository
public class OrderRepo {

    @Autowired
    private JdbcTemplate template;

    public Optional<Order> getOrderById(int order_id) { 

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_ORDER_BY_ID, order_id);

        if (!rs.next()) {
            return Optional.empty();

        }

        Order o = Order.toOrder(rs); 
        return Optional.of(o);

    }
    
}
