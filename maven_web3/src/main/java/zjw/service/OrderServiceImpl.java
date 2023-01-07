package zjw.service;

import zjw.DAO.OrderDao;
import zjw.DAO.OrderDaoImpl;
import zjw.domain.Order;
import zjw.domain.User;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public List<Order> findAllByCondition(String userId) {
        return orderDao.findAllByCondition(userId);
    }


}
