package zjw.domain;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String telephone;
    private String sex;
    private String addressId;
    private String birthTime;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sex='" + sex + '\'' +
                ", addressId='" + addressId + '\'' +
                ", birthTime='" + birthTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSex() {
        return sex;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    private String createTime;
}
