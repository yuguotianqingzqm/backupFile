package zjw.service;

import zjw.domain.Order;
import zjw.domain.User;

import java.util.List;

public interface OrderService {
    //添加
    public void addOrder(Order order);

    //查询全部记录
    public List<Order> findAll();
    //    根据条件查询
    public List<Order> findAllByCondition(String userId);
}
