package zjw.service;

import zjw.DAO.AddressManageDao;
import zjw.DAO.AddressManageDaoImpl;
import zjw.domain.AddressManage;

import java.util.List;

public class AddressManageServiceImpl implements AddressManageService {
    private AddressManageDao addressManageDao=new AddressManageDaoImpl();
    @Override
    public void addAddressManage(AddressManage addressManage) {
        addressManageDao.addAddressManage(addressManage);
    }

    @Override
    public List<AddressManage> findAll() {
        return null;
    }

    @Override
    public List<AddressManage> findByUserId(String userId) {
        return addressManageDao.findByUserId(userId);
    }

    @Override
    public void updateAll(AddressManage addressManage) {
    addressManageDao.updateAll(addressManage);
    }
}
