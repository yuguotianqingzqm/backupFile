package zjw.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zjw.domain.AddressManage;
import zjw.domain.Foods;
import zjw.util.druidutils.DruidDemo;

import java.util.Date;
import java.util.List;

public class AddressManageDaoImpl implements AddressManageDao {
    private JdbcTemplate template=new JdbcTemplate(DruidDemo.getDataSource());

    @Override
    public void addAddressManage(AddressManage addressManage) {
//        定义SQL
        //定义SQL
        String sql=" insert into addressManage(userId,contactAddress,contactName,contactTelephone,defaultAddress) values(?,?,?,?,?)";

        //执行SQL
        template.update(sql,addressManage.getUserId(),addressManage.getContactAddress(),addressManage.getContactName(),addressManage.getContactTelephone(),addressManage.getDefaultAddress());
    }

    @Override
    public List<AddressManage> findAll() {
        return null;
    }

    @Override
    public List<AddressManage> findByUserId(String userId) {
        //定义SQL
//
        String sql="select * from addressManage WHERE userId=? ";
        return template.query(sql,new BeanPropertyRowMapper<AddressManage>(AddressManage.class),userId);
    }

    @Override
    public void updateAll(AddressManage addressManage) {
        String sql="update addressManage set contactAddress = ?,  contactName = ? ,contactTelephone =? , defaultAddress = ? WHERE userId = ? ";
        template.update(sql,addressManage.getContactAddress(),addressManage.getContactName(),addressManage.getContactTelephone(),addressManage.getDefaultAddress(),addressManage.getUserId());
    }


}
