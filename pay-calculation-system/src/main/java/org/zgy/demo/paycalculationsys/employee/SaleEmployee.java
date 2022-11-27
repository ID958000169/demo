package org.zgy.demo.paycalculationsys.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SaleEmployee extends Employee
{
    private BigDecimal salesAmount;

    public SaleEmployee(String name, String type, BigDecimal salesAmount, LocalDate birthday)
    {
        super(name, type, birthday);
        this.salesAmount = salesAmount;
    }

    public BigDecimal getSalesAmount()
    {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount)
    {
        this.salesAmount = salesAmount;
    }
}
