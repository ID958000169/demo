package org.zgy.demo.paycalculationsys.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.zgy.demo.paycalculationsys.MonthlyPayInformation;
import org.zgy.demo.paycalculationsys.employee.Employee;
import org.zgy.demo.paycalculationsys.employee.FixedSalaryEmployee;
import org.zgy.demo.paycalculationsys.employee.HourlyEmployee;
import org.zgy.demo.paycalculationsys.employee.SaleEmployee;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataParser
{
    public static List<MonthlyPayInformation> parseData() throws DocumentException
    {
        List<MonthlyPayInformation> monthlyPayList = new ArrayList();
        try
        {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(PropertiesHelper.getPath("data.path")));
            Element rootEle = document.getRootElement();
            List<Element> monthEles = rootEle.elements();
            MonthlyPayInformation monthlyPay = null;
            for (Element monthEle : monthEles)
            {
                monthlyPay = new MonthlyPayInformation(attributeValueAsInt("value", monthEle), getEmployeeList(monthEle.elements()));
                monthlyPayList.add(monthlyPay);
            }
        }
        catch (DocumentException e)
        {
            throw new DocumentException("An exception occurred while parsing the data file...");
        }
        return monthlyPayList;
    }

    private static List<Employee> getEmployeeList(List elements)
    {
        List<Element> elementList = elements;
        List<Employee> employeeList = new ArrayList<>();
        for (Element element : elementList)
        {
            if ("salary".equals(element.attributeValue("type").trim()))
                employeeList.add(new FixedSalaryEmployee(element.attributeValue("name"), element.attributeValue("type")
                        , attributeValueAsDate("birthday", element)));
            if ("hour".equals(element.attributeValue("type").trim()))
                employeeList.add(new HourlyEmployee(element.attributeValue("name"), element.attributeValue("type"),
                        attributeValueAsDouble("workingHours", element), attributeValueAsDate("birthday", element)));
            if ("sale".equals(element.attributeValue("type").trim()))
                employeeList.add(new SaleEmployee(element.attributeValue("name"), element.attributeValue("type"),
                        attributeValueAsBigDecimal("amount", element), attributeValueAsDate("birthday", element)));
        }
        return employeeList;
    }

    private static int attributeValueAsInt(String name, Element ele)
    {
        return Integer.valueOf(ele.attributeValue(name));
    }

    private static LocalDate attributeValueAsDate(String name, Element ele)
    {
        return LocalDate.parse(ele.attributeValue(name), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private static double attributeValueAsDouble(String name, Element ele)
    {
        return Double.valueOf(ele.attributeValue(name));
    }

    private static BigDecimal attributeValueAsBigDecimal(String name, Element ele)
    {
        return new BigDecimal(ele.attributeValue(name));
    }
}
