package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("ВАЗ2101", "Yellow", 1000));
        carList.add(new Car("Lexus GS300", "Blue", 30000));
        carList.add(new Car("Toyota Cresta", "Red", 9000));
        carList.add(new Car("Daewoo matiz", "Blue", 1200 ));
        carList.add(new Car("Toyota Vista", "Pink", 3000 ));
    }


    @Override
    public List<Car> getCarByNumber(int count) {
        return IntStream.range(0, carList.size())
                .filter(l -> l < count)
                .mapToObj(carList::get)
                .toList();
    }
}