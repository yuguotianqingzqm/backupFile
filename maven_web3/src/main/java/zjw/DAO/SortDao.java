package zjw.DAO;


import zjw.domain.Sort;

import java.util.List;

public interface SortDao {
    //添加
    public void addSort(Sort sort);

     //查询全部记录
        public List<Sort> findAll();
        //删除某条记录
    public void deleteSort(String sortId);
    //更新某条记录
    public void updateSort(String sortId, String content);
}
