package zjw.domain;

public class Order {
    private String orderId;
    private String userId;
    private String price;
    private String createTime;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", price=" + price +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public String getCreateTime() {
        return createTime;
    }
}
