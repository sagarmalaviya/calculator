package com.test.calculator.Model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table
public class Calculation {

    @Id
    long userId;

    @Column
    String userName;

    @Column
    String ReportName;

    @Column
    String expression;

}
