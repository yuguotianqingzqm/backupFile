package zjw.service;


import zjw.DAO.FoodsDao;
import zjw.DAO.FoodsDaoImpl;
import zjw.domain.Foods;

import java.util.List;

public class FoodsServiceImpl implements FoodsService {
    private FoodsDao foodsDao=new FoodsDaoImpl();
    //添加
    @Override
    public void addFoods(Foods foods) {
        foodsDao.addFoods(foods);
    }
    //查询
    @Override
    public List<Foods> findAll() {
        return foodsDao.findAll();
    }
    //删除
    @Override
    public void deleteFood(String foodId) {
        foodsDao.deleteFood(foodId);
    }

    @Override
    public List<Foods> findFoodsByFoodName(String foodName) {
        return foodsDao.findFoodsByFoodName(foodName);
    }
}
