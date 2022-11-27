package org.zgy.demo.paycalculationsys.employee;

import java.time.LocalDate;

public class FixedSalaryEmployee extends Employee
{
    public FixedSalaryEmployee(String name, String type, LocalDate birthday)
    {
        super(name, type, birthday);
    }
}
