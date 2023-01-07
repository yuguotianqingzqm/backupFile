package zjw.DAO;

import zjw.domain.Sort;
import zjw.domain.User;

import java.util.List;

public interface UserDao {
    //添加
    public void addUser(User user);
    //查询全部记录
    public List<User> findAll();
    //    根据条件查询
    public List<User> findAllByCondition(User user);
    //查询某条记录
    public int findByName(String userName);

}
