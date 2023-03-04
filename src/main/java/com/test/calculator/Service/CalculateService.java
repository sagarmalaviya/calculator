package com.test.calculator.Service;

import com.test.calculator.Model.Calculation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CalculateService {
    double calculate (double a,double b,char operation);
    boolean saveOrUpdateUserData(long id,String name,String reportName,String exp,double value);
    Optional<Calculation> getUserData(long id);
}
