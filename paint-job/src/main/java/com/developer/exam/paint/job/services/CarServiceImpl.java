package com.developer.exam.paint.job.services;

import com.developer.exam.paint.job.Dto.ShopPerformance;
import com.developer.exam.paint.job.models.Car;
import com.developer.exam.paint.job.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    @Override
    public void addCar(Car car) {
        if(car!=null){
            if(carRepository.getCarInProgress().size()<5){
                car.setAction("progress");
            }else{
                car.setAction("queue");
            }
            carRepository.save(car);
        }
    }

    @Override
    public ShopPerformance shopPerformance() {
        ShopPerformance shopPerfomance=new ShopPerformance();
        shopPerfomance.setTotalCarsPainted(carRepository.totalCarsPainted());
        shopPerfomance.setBlueCars(carRepository.totalBlueCars());
        shopPerfomance.setGreenCars(carRepository.totalGreenCars());
        shopPerfomance.setRedCars(carRepository.totalRedCars());
        return shopPerfomance;
    }
    @Override
    public List<Car> getCarInProgress() {
        return carRepository.getCarInProgress();
    }
    @Override
    public List<Car> getCarInQueue() {
        return carRepository.getCarInQueue();
    }

    @Override
    public void markAsCompleted(Long carId) {
        Car car=carRepository.findById(carId).get();
        car.setAction("completed");
        Car carMoveToProgress=carRepository.findFirstInCar();
        if(carMoveToProgress!=null){
            carMoveToProgress.setAction("progress");
            carRepository.save(carMoveToProgress);
        }
        carRepository.save(car);
    }
}
