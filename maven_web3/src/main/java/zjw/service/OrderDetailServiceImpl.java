package zjw.service;

import zjw.DAO.OrderDetailDao;
import zjw.DAO.OrderDetailDaoImpl;
import zjw.domain.OrderDetail;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailDao.addOrderDetail(orderDetail);
    }

    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public List<OrderDetail> findAllByOrderId(String orderId) {
        return orderDetailDao.findAllByOrderId(orderId);
    }
}
