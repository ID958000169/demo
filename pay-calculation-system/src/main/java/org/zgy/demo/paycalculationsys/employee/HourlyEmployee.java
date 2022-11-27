package org.zgy.demo.paycalculationsys.employee;

import java.time.LocalDate;

public class HourlyEmployee extends Employee
{
    private double workingHours;

    public HourlyEmployee(String name, String type, double workingHours, LocalDate birthday)
    {
        super(name, type, birthday);
        this.workingHours = workingHours;
    }

    public double getWorkingHours()
    {
        return workingHours;
    }

    public void setWorkingHours(double workingHours)
    {
        this.workingHours = workingHours;
    }
}
