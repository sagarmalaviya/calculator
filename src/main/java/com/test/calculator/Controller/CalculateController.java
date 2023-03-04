package com.test.calculator.Controller;

import com.test.calculator.DTO.CalculateExpressionDTO;
import com.test.calculator.Model.Calculation;
import com.test.calculator.Service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CalculateController {

    @Autowired
    CalculateService calculateService;
    @GetMapping("/calculateExpression")
    public double calculateExpression(@RequestBody CalculateExpressionDTO calculateExpressionDTO){
        return calculateService.calculate(calculateExpressionDTO.getInput1(),calculateExpressionDTO.getInput2(),calculateExpressionDTO.getOperation());
    }

    @PostMapping("/saveDetails")
    public ResponseEntity<HttpStatus> saveUserData(long userId,String userName,String reportName, String expression, double result){
        boolean saveUserCalculations=calculateService.saveOrUpdateUserData(userId,userName,reportName,expression,result);
       return saveUserCalculations? new ResponseEntity(HttpStatus.CREATED): new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getUserCalculations")
    public Optional<Calculation> getCalculations(long userId)

    {
        return calculateService.getUserData(userId);
    }

}
