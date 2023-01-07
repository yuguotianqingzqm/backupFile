package zjw.DAO;


import zjw.domain.Foods;

import java.util.List;

public interface FoodsDao {

    //添加
    public void addFoods(Foods foods);

    //查询全部记录
    public List<Foods> findAll();

    //根据食物名字查询
    public List<Foods> findFoodsByFoodName(String foodName);

    //删除某条记录
    public void deleteFood(String foodId);
}
