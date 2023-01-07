package zjw.domain;

public class AddressManage {
    private String addressId;
    private String userId;
    private String contactAddress;
    private String contactName;
    private String contactTelephone;
    private String defaultAddress;
    @Override
    public String toString() {
        return "AddressManage{" +
                "addressId='" + addressId + '\'' +
                ", userId='" + userId + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTelephone='" + contactTelephone + '\'' +
                ", defaultAddress='" + defaultAddress + '\'' +
                '}';
    }

    public void setDefaultAddress(String defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getUserId() {
        return userId;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }
}
