package zjw.service;

import zjw.domain.User;

import java.util.List;

public interface UserService {
    //添加
    public void addUser(User user);
    //查询全部记录
    public List<User> findAll();
    //查询条件记录
    public List<User> findAllByCondition(User user);
    //查询全部记录
    public int findByName(String userName);
}
