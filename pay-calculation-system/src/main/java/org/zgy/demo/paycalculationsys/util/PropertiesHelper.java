package org.zgy.demo.paycalculationsys.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

public class PropertiesHelper
{
    private static final Properties prop = new Properties();

    static
    {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("application.properties"))
        {
            prop.load(inputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String get(String key)
    {
        return prop.getProperty(key);
    }

    public static String getPath(String key)
    {
        return ClassLoader.getSystemResource(get(key)).getPath().replaceAll("%20", " ");
    }

    public static BigDecimal getAsBigDecimal(String key)
    {
        return new BigDecimal(get(key));
    }

    public static Integer getAsInteger(String key)
    {
        return Integer.valueOf(get(key));
    }

    public static Double getAsDouble(String key)
    {
        return Double.valueOf(get(key));
    }
}
