package org.zgy.demo.paycalculationsys.policy;

import org.apache.commons.lang3.tuple.Pair;
import org.zgy.demo.paycalculationsys.employee.SaleEmployee;
import org.zgy.demo.paycalculationsys.util.PropertiesHelper;
import org.zgy.demo.paycalculationsys.welfare.Welfare;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SalaryPayPolicy extends PayPolicy
{
    private SaleEmployee saleEmployee;

    private final static BigDecimal mandatoryAmount = PropertiesHelper.getAsBigDecimal("mandatory.amount");
    private final static BigDecimal saleEmpBasicPay = PropertiesHelper.getAsBigDecimal("saleEmp.basicPay");
    private final static String rangeMagnification = PropertiesHelper.get("range.magnification");
    private static boolean havaMinimumWage = false;
    private static Map<Pair<BigDecimal, BigDecimal>, Double> magnification = getMagnification();

    public SalaryPayPolicy(SaleEmployee employee, List<Welfare> welfareList, int month)
    {
        super(employee, getBasicPay(employee), welfareList, month);
        saleEmployee = employee;
    }

    @Override
    public BigDecimal getPay()
    {
        BigDecimal amount = this.basicPay;
        if (!havaMinimumWage)
        {
            return amount;
        }
        else
        {
            BigDecimal saleAmount = saleEmployee.getSalesAmount();
            BigDecimal left;
            BigDecimal right;
            for (Map.Entry<Pair<BigDecimal, BigDecimal>, Double> entry : magnification.entrySet())
            {
                left = entry.getKey().getLeft();
                right = entry.getKey().getRight();
                if (saleAmount.compareTo(left) == 1 && (Objects.nonNull(right) ? saleAmount.compareTo(right) == -1 : true))
                {
                    BigDecimal overAmount = saleAmount.subtract(mandatoryAmount);
                    BigDecimal commission = overAmount.multiply(BigDecimal.valueOf(entry.getValue()));
                    amount = amount.add(commission);
                }
            }
            return amount;
        }
    }

    private static Map<Pair<BigDecimal, BigDecimal>, Double> getMagnification()
    {
        Map<Pair<BigDecimal, BigDecimal>, Double> map = null;
        if (Objects.nonNull(rangeMagnification))
        {
            map = new HashMap();
            String[] strArr = rangeMagnification.split(",");
            for (String str : strArr)
            {
                String[] strArrSub = str.split(":");
                map.put(wrapperPair(strArrSub[0]), Double.valueOf(strArrSub[1]));
            }
        }
        return map;
    }

    private static Pair<BigDecimal, BigDecimal> wrapperPair(String str)
    {
        Pair<BigDecimal, BigDecimal> pair = null;
        if (Objects.nonNull(str))
        {
            String[] strArr = str.split("-");
            if (strArr.length > 1)
                pair = Pair.of(new BigDecimal(strArr[0]), new BigDecimal(strArr[1]));
            else
                pair = Pair.of(new BigDecimal(strArr[0]), null);
        }
        return pair;
    }

    private static BigDecimal getBasicPay(SaleEmployee saleEmployee)
    {
        havaMinimumWage = saleEmployee.getSalesAmount().compareTo(mandatoryAmount) >= 0;
        if (havaMinimumWage)
            return saleEmpBasicPay;
        else
            return BigDecimal.ZERO;
    }
}
