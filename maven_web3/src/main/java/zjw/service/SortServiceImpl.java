package zjw.service;



import zjw.DAO.SortDao;
import zjw.DAO.SortDaoImpl;
import zjw.domain.Sort;

import java.util.List;

public class SortServiceImpl implements SortService {
    private SortDao sortDao=new SortDaoImpl();
    @Override
    public void add(Sort sort) {
        sortDao.addSort(sort);
    }

    @Override
    public List<Sort> findAll() {
        return sortDao.findAll();
    }

    @Override
    public void deleteSort(String sortId) {
        sortDao.deleteSort(sortId);
    }

    @Override
    public void updateSort(String sortId, String content) {
        sortDao.updateSort(sortId,content);
    }
}
