package org.zgy.demo.springboot.annotation.dto;

public class Request
{
    private String annotationName;
    private String requestMethod;
    private String remarks;

    public String getAnnotationName()
    {
        return annotationName;
    }

    public void setAnnotationName(String annotationName)
    {
        this.annotationName = annotationName;
    }

    public String getRequestMethod()
    {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod)
    {
        this.requestMethod = requestMethod;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
}
