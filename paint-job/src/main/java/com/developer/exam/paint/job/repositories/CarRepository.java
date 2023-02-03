package com.developer.exam.paint.job.repositories;

import com.developer.exam.paint.job.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query(value = "SELECT COUNT(*) FROM car WHERE action = 'completed'",nativeQuery = true)
    Long totalCarsPainted();
    @Query(value = "SELECT COUNT(*) FROM car WHERE action = 'completed' AND target_color='blue'",nativeQuery = true)
    Long totalBlueCars();
    @Query(value = "SELECT COUNT(*) FROM car WHERE action = 'completed' AND target_color='red'",nativeQuery = true)
    Long totalRedCars();
    @Query(value = "SELECT COUNT(*) FROM car WHERE action = 'completed' AND target_color='green'",nativeQuery = true)
    Long totalGreenCars();
    @Query(value = "SELECT * FROM car WHERE action = 'progress'",nativeQuery = true)
    List<Car>getCarInProgress();
    @Query(value = "SELECT * FROM car WHERE action = 'queue'",nativeQuery = true)
    List<Car>getCarInQueue();
    @Query(value = "SELECT * FROM car WHERE car_id=(SELECT MAX(car_id) FROM car WHERE action = 'queue') ",nativeQuery = true)
    Car findFirstInCar();
}
