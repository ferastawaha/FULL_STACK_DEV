package com.developer.exam.paint.job.Dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopPerformance {
     Long totalCarsPainted;
     Long blueCars;
     Long redCars;
     Long greenCars;
}
