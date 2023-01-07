package zjw.domain;

public class Foods {
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String vipPrice;
    private String sortId;
    private String foodSaleNumber;
    private String addTime;
    private String hotSale;
    private String foodImage;
    private String specialHint;

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }


    @Override
    public String toString() {
        return "Foods{" +
                "foodId='" + foodId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodPrice='" + foodPrice + '\'' +
                ", vipPrice='" + vipPrice + '\'' +
                ", sortId='" + sortId + '\'' +
                ", foodSaleNumber='" + foodSaleNumber + '\'' +
                ", addTime='" + addTime + '\'' +
                ", hotSale='" + hotSale + '\'' +
                ", foodImage='" + foodImage + '\'' +
                ", specialHint='" + specialHint + '\'' +
                '}';
    }





    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }



    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public void setHotSale(String hotSale) {
        this.hotSale = hotSale;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }


    public void setVipPrice(String vipPrice) {
        this.vipPrice = vipPrice;
    }

    public void setFoodSaleNumber(String foodSaleNumber) {
        this.foodSaleNumber = foodSaleNumber;
    }

    public void setSpecialHint(String specialHint) {
        this.specialHint = specialHint;
    }

    public String getVipPrice() {
        return vipPrice;
    }

    public String getFoodSaleNumber() {
        return foodSaleNumber;
    }

    public String getSpecialHint() {
        return specialHint;
    }

    public String getAddTime() {
        return addTime;
    }

    public String getHotSale() {
        return hotSale;
    }

    public String getFoodImage() {
        return foodImage;
    }
}
