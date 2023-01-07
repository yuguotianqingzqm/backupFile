package zjw.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zjw.domain.Order;
import zjw.domain.OrderDetail;
import zjw.util.druidutils.DruidDemo;

import java.util.Date;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    private JdbcTemplate template=new JdbcTemplate(DruidDemo.getDataSource());
    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        //定义SQL
        String sql=" insert into orderDetail(foodName,number,price,createTime,state) values(?,?,?,?,?)";
        Date date = new Date();
        //执行SQL
        template.update(sql,orderDetail.getFoodName(),orderDetail.getNumber(),orderDetail.getPrice(),date,"0");
    }

    @Override
    public List<OrderDetail> findAll() {
        String sql="select * from orderDetail";
        List<OrderDetail> list = template.query(sql, new BeanPropertyRowMapper<OrderDetail>(OrderDetail.class));
        return list;
    }

    @Override
    public List<OrderDetail> findAllByOrderId(String orderId) {
        String sql="select * from orderDetail where orderId = ?";
        List<OrderDetail> list = template.query(sql, new BeanPropertyRowMapper<OrderDetail>(OrderDetail.class),orderId);
        return list;
    }
}
