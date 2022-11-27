package org.zgy.demo.paycalculationsys;

import org.dom4j.DocumentException;

import java.math.BigDecimal;
import java.util.Map;

public class MainApplication
{
    public static void main(String[] args)
    {
        try
        {
            Map<String, BigDecimal> map = PayCalculate.getTotalPay();
            for (Map.Entry<String, BigDecimal> entry : map.entrySet())
            {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
        catch (DocumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
