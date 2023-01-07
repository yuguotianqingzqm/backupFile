package zjw.DAO;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zjw.domain.Sort;
import zjw.util.druidutils.DruidDemo;

import java.util.List;

public class SortDaoImpl implements SortDao {
    private JdbcTemplate template=new JdbcTemplate(DruidDemo.getDataSource());
    @Override
    public void addSort(Sort sort) {
        //定义SQL
        String sql=" insert into sort values(?,?)";
        //执行SQL
        template.update(sql,sort.getSortId(),sort.getSortName());
    }
    //查询
    @Override
    public List<Sort> findAll() {
        String sql="select * from sort";
        List<Sort> list = template.query(sql, new BeanPropertyRowMapper<Sort>(Sort.class));
        return list;
    }
    //删除
    @Override
    public void deleteSort(String sortId) {
        //定义SQL
        String sql=" delete from sort where sortId=? ";
        //执行SQL
        template.update(sql,sortId);
    }
    //更新
    @Override
    public void updateSort(String sortId, String content) {
        //定义SQL
        String sql=" update sort set sortName=? where sortId=? ";
        //执行SQL
        template.update(sql,sortId,content);
    }
}
