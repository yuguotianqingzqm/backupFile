package zjw.service;

import zjw.domain.AddressManage;

import java.util.List;

public interface AddressManageService {
    //添加
    public void addAddressManage(AddressManage addressManage);

    //查询全部记录
    public List<AddressManage> findAll();

    //根据userId查询某条记录,用来判断该用户是否填了地址
    public List<AddressManage> findByUserId(String userId);

    //更新
    public void updateAll(AddressManage addressManage);
}
