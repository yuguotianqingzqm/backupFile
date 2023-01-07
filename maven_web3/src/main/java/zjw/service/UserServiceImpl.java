package zjw.service;

import zjw.DAO.UserDao;
import zjw.DAO.UserDaoImpl;
import zjw.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAllByCondition(User user) {
        return userDao.findAllByCondition(user);
    }

    @Override
    public int findByName(String userName) {
       return userDao.findByName(userName);
    }
}
