package zjw.domain;

public class Host {
    private String hostId;
    private String hostName;
    private String password;
    private String telephone;
    private String sex;
    private String addressId;
    private String birthTime;
    private String createTime;

    @Override
    public String toString() {
        return "host{" +
                "hostId='" + hostId + '\'' +
                ", hostName='" + hostName + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sex='" + sex + '\'' +
                ", addressId='" + addressId + '\'' +
                ", birthTime='" + birthTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

    public String getHostId() {
        return hostId;
    }

    public String getHostName() {
        return hostName;
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
}
