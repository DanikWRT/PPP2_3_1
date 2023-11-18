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
        carList.add(new Car("Wrrrrrrr", "Yellow", 9123));
        carList.add(new Car("VrumVrumw", "Blue", 12848912));
        carList.add(new Car("Wruuurururu", "Red", 32978));
        carList.add(new Car("RRRRRRRRurww", "White", 10));
        carList.add(new Car("WvwvrVWrauwvrr", "Pink", 30038128));
    }


    @Override
    public List<Car> getCarByNumber(int count) {
        return IntStream.range(0, carList.size())
                .filter(l -> l < count)
                .mapToObj(carList::get)
                .toList();
    }
}