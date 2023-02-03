package com.developer.exam.paint.job.services;

import com.developer.exam.paint.job.Dto.ShopPerformance;
import com.developer.exam.paint.job.models.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    ShopPerformance shopPerformance();
    List<Car> getCarInProgress();
    List<Car> getCarInQueue();
    void  markAsCompleted(Long carId);
}
