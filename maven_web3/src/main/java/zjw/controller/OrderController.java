package zjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zjw.domain.*;
import zjw.service.*;

import java.util.List;
//@RequestMapping("/addOrder")
@Controller
public class OrderController {
    @RequestMapping("/addOrder")
    @ResponseBody
    public String addOrderParamForJson(@RequestBody List<String> addOrder){
        System.out.println(addOrder);
        return "zjw";
    }
    @RequestMapping("/addOrder1")
    @ResponseBody
    public String addOrder(@RequestBody Order addOrder){
        System.out.println(addOrder);
        return "zjj";
    }
    @RequestMapping("/addOrder2")
    @ResponseBody
    public String listOrder(@RequestBody List<OrderDetail> orderDetails){
        OrderService orderService = new OrderServiceImpl();
        Order order = new Order();

        //处理订单详情
        OrderDetailServiceImpl orderDetailService = new OrderDetailServiceImpl();
        //判断该用户是否有地址
        AddressManageServiceImpl addressManageService = new AddressManageServiceImpl();
        if(orderDetails.size()==0){
            return "请添加商品";
        }else {
            List<AddressManage> address = addressManageService.findByUserId(orderDetails.get(0).getOrderId());
            if (address.size() == 0) {
                System.out.println(address);
                return "3";
            } else {

                for (OrderDetail orderDetail2 : orderDetails) {

                    order.setPrice(orderDetail2.getPrice());
                    //orderId就是userID

                    //添加订单
                    order.setUserId(orderDetail2.getOrderId());
                    orderService.addOrder(order);

                    //添加订单详情
                    orderDetailService.addOrderDetail(orderDetail2);
                }
            }
        }
        return "jj";
    }
}
