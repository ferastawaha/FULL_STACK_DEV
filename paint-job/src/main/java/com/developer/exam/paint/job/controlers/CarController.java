package com.developer.exam.paint.job.controlers;

import com.developer.exam.paint.job.Dto.ShopPerformance;
import com.developer.exam.paint.job.models.Car;
import com.developer.exam.paint.job.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping
    public ResponseEntity<Void> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/shopPerformance")
    public ResponseEntity<ShopPerformance> shopPerformance() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body( carService.shopPerformance());
    }
    @GetMapping(value = "/carInProgress")
    public ResponseEntity<List<Car>> carInProgress() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body( carService.getCarInProgress());
    }
    @GetMapping(value = "/carInQueue")
    public ResponseEntity<List<Car>> carInQueue() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body( carService.getCarInQueue());
    }
    @PostMapping(value = "/markAsCompleted/{carId}")
    public ResponseEntity<Void> markAsCompleted(@PathVariable Long carId) {
        carService.markAsCompleted(carId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
