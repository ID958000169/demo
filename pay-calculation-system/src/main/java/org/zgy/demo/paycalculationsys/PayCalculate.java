package org.zgy.demo.paycalculationsys;

import org.dom4j.DocumentException;
import org.zgy.demo.paycalculationsys.employee.Employee;
import org.zgy.demo.paycalculationsys.employee.FixedSalaryEmployee;
import org.zgy.demo.paycalculationsys.employee.HourlyEmployee;
import org.zgy.demo.paycalculationsys.employee.SaleEmployee;
import org.zgy.demo.paycalculationsys.policy.FixedSalaryPayPolicy;
import org.zgy.demo.paycalculationsys.policy.HourlyPayPolicy;
import org.zgy.demo.paycalculationsys.policy.SalaryPayPolicy;
import org.zgy.demo.paycalculationsys.util.DataParser;
import org.zgy.demo.paycalculationsys.util.PropertiesHelper;
import org.zgy.demo.paycalculationsys.welfare.BirthdayWelfare;
import org.zgy.demo.paycalculationsys.welfare.Welfare;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayCalculate
{
    private static BigDecimal birtCashAmount = PropertiesHelper.getAsBigDecimal("birthday.cash.amount");

    public static Map<String, BigDecimal> getTotalPay() throws DocumentException
    {
        List<MonthlyPayInformation> monthlyPayInformations = DataParser.parseData();
        Map<String, BigDecimal> map = new HashMap();
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal monthlyTotal = null;
        List<Employee> employeeList;
        for (MonthlyPayInformation monthlyPayInfor : monthlyPayInformations)
        {
            employeeList = monthlyPayInfor.getEmployeeList();
            monthlyTotal = calculateMonthly(employeeList, monthlyPayInfor.getMonth());
            map.put(String.valueOf(monthlyPayInfor.getMonth()) + "Mon", monthlyTotal);
            total = total.add(monthlyTotal);
        }
        map.put("total", formatNum(total));
        return map;
    }

    private static BigDecimal calculateMonthly(List<Employee> employeeList, int month)
    {
        BigDecimal monthlyTotal = BigDecimal.ZERO;
        List<Welfare> welfareList = new ArrayList();
        registerWelfare(welfareList);
        for (Employee emp : employeeList)
        {
            if (emp instanceof FixedSalaryEmployee)
                monthlyTotal = monthlyTotal.add(new FixedSalaryPayPolicy((FixedSalaryEmployee) emp, welfareList, month).getPay());
            if (emp instanceof HourlyEmployee)
                monthlyTotal = monthlyTotal.add(new HourlyPayPolicy((HourlyEmployee) emp, welfareList, month).getPay());
            if (emp instanceof SaleEmployee)
                monthlyTotal = monthlyTotal.add(new SalaryPayPolicy((SaleEmployee) emp, welfareList, month).getPay());
        }

        return monthlyTotal;
    }

    private static void registerWelfare(List<Welfare> welfareList)
    {
        welfareList.add(new BirthdayWelfare("Birthday Welfare", "cash", birtCashAmount));
    }

    private static BigDecimal formatNum(BigDecimal num)
    {
        DecimalFormat format = new DecimalFormat("#.00");
        return new BigDecimal(format.format(num));
    }
}
