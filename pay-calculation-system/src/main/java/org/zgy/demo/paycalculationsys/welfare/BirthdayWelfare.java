package org.zgy.demo.paycalculationsys.welfare;

import java.math.BigDecimal;

public class BirthdayWelfare extends Welfare
{
    private BigDecimal amount;

    public BirthdayWelfare(String type, String form, BigDecimal amount)
    {
        super(type, form);
        this.amount = amount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
}
