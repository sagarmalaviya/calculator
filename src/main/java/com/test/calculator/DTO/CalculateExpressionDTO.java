package com.test.calculator.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateExpressionDTO {
    double input1;
    double input2;
    char operation;
}
