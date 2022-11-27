package org.zgy.demo.paycalculationsys.employee;

import java.time.LocalDate;

public class Employee
{
    private String name;
    private String type;
    private LocalDate birthday;

    public Employee(String name, String type, LocalDate birthday)
    {
        this.name = name;
        this.type = type;
        this.birthday = birthday;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public LocalDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }
}
