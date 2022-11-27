package org.zgy.demo.paycalculationsys.policy;

import org.zgy.demo.paycalculationsys.employee.FixedSalaryEmployee;
import org.zgy.demo.paycalculationsys.util.PropertiesHelper;
import org.zgy.demo.paycalculationsys.welfare.Welfare;

import java.math.BigDecimal;
import java.util.List;

public class FixedSalaryPayPolicy extends PayPolicy
{
    private final static BigDecimal hourlyWage = PropertiesHelper.getAsBigDecimal("fixedSalaryEmp.basicPay");

    public FixedSalaryPayPolicy(FixedSalaryEmployee employee, List<Welfare> welfareList, int month)
    {
        super(employee, hourlyWage, welfareList, month);
    }

    @Override
    public BigDecimal getPay()
    {
        return this.basicPay;
    }
}
