package zjw.service;


import zjw.domain.Foods;

import java.util.List;

public interface FoodsService {
    void addFoods(Foods foods);
    //查询全部记录
    public List<Foods> findAll();

    //删除某条记录
    public void deleteFood(String foodId);
    //根据食物名字查询
    public List<Foods> findFoodsByFoodName(String foodName);
}
