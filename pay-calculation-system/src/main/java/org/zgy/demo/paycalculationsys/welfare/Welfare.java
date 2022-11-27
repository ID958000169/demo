package org.zgy.demo.paycalculationsys.welfare;

public class Welfare
{
    String type;
    String form;

    public Welfare(String type, String form)
    {
        this.type = type;
        this.form = form;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getForm()
    {
        return form;
    }

    public void setForm(String form)
    {
        this.form = form;
    }
}
