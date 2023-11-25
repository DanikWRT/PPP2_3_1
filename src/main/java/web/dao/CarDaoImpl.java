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
        carList.add(new Car(1, "KIA", 2013));
        carList.add(new Car(2, "bajaj", 2023));
        carList.add(new Car(3, "Jarvus", 1997));
        carList.add(new Car(4, "TOYOTA", 1995));
        carList.add(new Car(5, "TOYOTA", 1995));
    }


    @Override
    public List<Car> getCarByNumber(int count) {
        System.out.println(IntStream.range(0, carList.size())
                .filter(l -> l < count)
                .mapToObj(carList::get)
                .toList());
        return IntStream.range(0, carList.size())
                .filter(l -> l < count)
                .mapToObj(carList::get)
                .toList();
    }
}