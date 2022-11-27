package org.zgy.demo.paycalculationsys.policy;

import org.zgy.demo.paycalculationsys.employee.HourlyEmployee;
import org.zgy.demo.paycalculationsys.util.PropertiesHelper;
import org.zgy.demo.paycalculationsys.welfare.Welfare;

import java.math.BigDecimal;
import java.util.List;

public class HourlyPayPolicy extends PayPolicy
{
    private final static double timeoutThreshold = PropertiesHelper.getAsDouble("timeout.threshold");
    private final static BigDecimal hourlyWage = PropertiesHelper.getAsBigDecimal("hourly.wage");
    private final static BigDecimal magnification = PropertiesHelper.getAsBigDecimal("timeout.wage.magnification");
    private final static BigDecimal minimumWage = PropertiesHelper.getAsBigDecimal("hourlyEmp.basicPay");

    private HourlyEmployee hourlyEmployee;

    public HourlyPayPolicy(HourlyEmployee employee, List<Welfare> welfareList, int month)
    {
        super(employee, minimumWage, welfareList, month);
        hourlyEmployee = employee;
    }

    @Override
    public BigDecimal getPay()
    {
        BigDecimal amount = basicPay;
        double workingHours = hourlyEmployee.getWorkingHours();
        if (timeoutThreshold > workingHours)
        {
            BigDecimal salary = hourlyWage.multiply(BigDecimal.valueOf(workingHours));
            return amount.add(salary);
        }
        else
        {
            double overTime = workingHours - timeoutThreshold;
            BigDecimal normalSalary = hourlyWage.multiply(BigDecimal.valueOf(timeoutThreshold));
            BigDecimal overTimeSalary = BigDecimal.valueOf(overTime).multiply(magnification).multiply(hourlyWage);
            return amount.add(normalSalary).add(overTimeSalary);
        }
    }
}
