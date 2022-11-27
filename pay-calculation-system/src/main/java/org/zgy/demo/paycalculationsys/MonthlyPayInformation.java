package org.zgy.demo.paycalculationsys;

import org.zgy.demo.paycalculationsys.employee.Employee;

import java.util.List;

public class MonthlyPayInformation
{
    private int month;
    private List<Employee> employeeList;

    public MonthlyPayInformation(int month, List<Employee> employeeList)
    {
        this.month = month;
        this.employeeList = employeeList;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public List<Employee> getEmployeeList()
    {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList)
    {
        this.employeeList = employeeList;
    }
}
