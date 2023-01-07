package zjw.DAO;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zjw.domain.Foods;
import zjw.util.druidutils.DruidDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FoodsDaoImpl implements FoodsDao {
    private JdbcTemplate template=new JdbcTemplate(DruidDemo.getDataSource());
    @Override
    public void addFoods(Foods foods) {
        //定义SQL
        String sql=" insert into foods (foodName,foodPrice,vipPrice,specialHint,sortId,foodSaleNumber,addTime,hotSale,foodImage) values(?,?,?,?,?,?,?,?,?)";
        //格式化时间
        Date date = new Date();
        //执行SQL
        template.update(sql,foods.getFoodName(),foods.getFoodPrice(),foods.getVipPrice(),foods.getSpecialHint(),foods.getSortId(),0,date,0,foods.getFoodImage());
    }
    //查询
    @Override
    public List<Foods> findAll() {
        String sql="select * from foods";
        List<Foods> list = template.query(sql, new BeanPropertyRowMapper<Foods>(Foods.class));
        return list;
    }

    @Override
    public List<Foods> findFoodsByFoodName(String foodName) {
        String sql="select * from foods where foodName = ? ";
        List<Foods> list = template.query(sql, new BeanPropertyRowMapper<Foods>(Foods.class),foodName);
        return list;
    }

    //删除
    @Override
    public void deleteFood(String foodId) {
        //定义SQL
        String sql=" delete from foods where sortId=? ";
        //执行SQL
        template.update(sql,foodId);
    }
}
