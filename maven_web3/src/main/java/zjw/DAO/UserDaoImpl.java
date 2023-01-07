package zjw.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zjw.domain.Sort;
import zjw.domain.User;
import zjw.util.druidutils.DruidDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(DruidDemo.getDataSource());
    @Override
    public void addUser(User user) {
        //定义SQL
        String sql=" insert into user(userName,password,createTime) values(?,?,?)";

        //
        Date date = new Date();
        //执行SQL
        template.update(sql,user.getUserName(),user.getPassword(),date);
    }

    @Override
    public List<User> findAll() {
        String sql="select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public List<User> findAllByCondition(User user) {
        String sql="select * from user where userName=? and password=?";
        List<User> list = template.query(sql,new BeanPropertyRowMapper<User>(User.class),user.getUserName(),user.getPassword());
        return list;

    }

    @Override
    public int findByName(String userName) {
        //定义SQL
//        根据用户名查询，注册时使用

        String sql="select count(*) from user WHERE userName=?";

        return template.queryForObject(sql,Integer.class,userName);

    }
}
