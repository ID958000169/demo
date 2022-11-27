package org.zgy.demo.paycalculationsys.policy;

import org.zgy.demo.paycalculationsys.employee.Employee;
import org.zgy.demo.paycalculationsys.welfare.BirthdayWelfare;
import org.zgy.demo.paycalculationsys.welfare.Welfare;

import java.math.BigDecimal;
import java.util.List;

public abstract class PayPolicy
{
    BigDecimal basicPay = BigDecimal.ZERO;
    List<Welfare> welfareList;
    Employee employee;
    int month;

    public PayPolicy(Employee employee, BigDecimal basicPay, List<Welfare> welfareList, int month)
    {
        this.employee = employee;
        this.basicPay = basicPay;
        this.welfareList = welfareList;
        this.month = month;
        appendBirthdayWelfare();
    }

    public abstract BigDecimal getPay();

    void appendBirthdayWelfare()
    {
        for (Welfare welfare : welfareList)
        {
            if (welfare instanceof BirthdayWelfare && month == employee.getBirthday().getMonthValue())
                basicPay = basicPay.add(((BirthdayWelfare) welfare).getAmount());
        }
    }
}
