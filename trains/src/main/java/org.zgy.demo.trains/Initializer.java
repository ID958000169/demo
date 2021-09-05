package org.zgy.demo.trains;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Initializer
{
    public static List<String> readData(String fileName) throws IOException
    {
        return Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
    }
}
