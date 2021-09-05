package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper
{
    private static final Properties prop = new Properties();

    static
    {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("config.properties"))
        {
            prop.load(inputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String get(String key)
    {
        return prop.getProperty(key);
    }
}
