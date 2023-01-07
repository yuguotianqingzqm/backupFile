package zjw.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zjw.domain.Order;
import zjw.domain.Sort;
import zjw.domain.User;
import zjw.util.druidutils.DruidDemo;

import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate template=new JdbcTemplate(DruidDemo.getDataSource());
    @Override
    public void addOrder(Order order) {
        //定义SQL
        String sql=" insert into orderForm(userId,price,createTime) values(?,?,?)";
        Date date = new Date();
        //执行SQL
        template.update(sql,order.getUserId(),order.getPrice(),date);
    }

    @Override
    public List<Order> findAll() {
        String sql="select * from sort";
        List<Order> list = template.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
        return list;
    }

    @Override
    public List<Order> findAllByCondition(String userId) {
        String sql="select * from orderForm where userId=?";
        List<Order> list = template.query(sql,new BeanPropertyRowMapper<Order>(Order.class),userId);
        return list;
    }
}
