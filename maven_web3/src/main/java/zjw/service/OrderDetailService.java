package zjw.service;

import zjw.domain.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    //添加
    public void addOrderDetail(OrderDetail orderDetail);

    //查询全部记录
    public List<OrderDetail> findAll();

    //根据orderId查询记录
    public List<OrderDetail> findAllByOrderId(String orderId);
}
