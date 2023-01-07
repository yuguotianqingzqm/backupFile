package zjw.domain;

public class OrderDetail {
    private String orderId;
    private String foodName;
    private String number;
    private String price;
    private String createTime;
    private String overTime;
    private String state;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId='" + orderId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", createTime='" + createTime + '\'' +
                ", overTime='" + overTime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getNumber() {
        return number;
    }

    public String getPrice() {
        return price;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getOverTime() {
        return overTime;
    }

    public String getState() {
        return state;
    }
}
