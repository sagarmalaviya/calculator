package com.test.calculator.Repository;

import com.test.calculator.Model.Calculation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CalculationRepo extends CrudRepository<Calculation,Long> {
    List<Calculation> findByReportName(String name);
}
