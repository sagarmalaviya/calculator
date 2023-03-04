package com.test.calculator.Service;

import com.test.calculator.Model.Calculation;
import com.test.calculator.Repository.CalculationRepo;
import com.test.calculator.Service.Operations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CalculateServiceImpl implements CalculateService{

    @Autowired
    AdditionImpl addition;

    @Autowired
    SubtractionImpl subtraction;

    @Autowired
    MultiplicationImpl multiplication;

    @Autowired
    DivisionImpl division;

    List<Operation> getOperations(){

         return new ArrayList<>(Arrays.asList(addition,multiplication,division,subtraction));

    }


    CalculationRepo calculationRepo;

    @Override
    public double calculate(double a, double b, char operation) {
        double ans=0.0;
        List<Operation> operations=getOperations();
        for (Operation o:
             operations) {

             if(o.isValid(operation)) {
                 ans = o.apply(a, b);
                 break;
             }
        }
        return ans;
    }

    @Override
    public boolean saveOrUpdateUserData(long id, String name, String reportName, String exp, double value) {
        return false;
    }

    @Override
    public Optional<Calculation> getUserData(long id) {
        return calculationRepo.findById(id);
    }
}
