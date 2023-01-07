package zjw.service;
import zjw.domain.Sort;

import java.util.List;

public interface SortService {
    //添加
    void add(Sort sort);

    //查询全部记录
    public List<Sort> findAll();

    //删除某条记录
    public void deleteSort(String sortId);

    //更新某条记录
    public void updateSort(String sortId, String content);
}
