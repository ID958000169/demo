package org.zgy.demo.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test
{
    private static Field[] fields;

    public static void main(String[] args) throws IllegalAccessException
    {
        List<String> arrList = new ArrayList<>();
        System.out.println("ArrayList: " + System.identityHashCode(arrList));
        for (int i = 0; i < 7; i++)
        {
            arrList.add(String.valueOf(i + 1));
            System.out.println("ArrayList index " + i + ": " + System.identityHashCode(arrList.get(i)));
        }
        Field[] fields = arrList.getClass().getDeclaredFields();
        Object[] elementData = null;
        for (Field f : fields)
        {
            if ("elementData".equals(f.getName()))
            {
                f.setAccessible(true);
                elementData = (Object[]) f.get(arrList);
            }
        }
        System.out.println("============================================================");
        System.out.println("elementData: " + System.identityHashCode(elementData));
        for (int i = 0; i < arrList.size(); i++)
        {
            System.out.println("elementData index " + i + ": " + System.identityHashCode(elementData[i]));
        }
        System.out.println("========================LinkedList====================================");
        List<String> linkedList = new LinkedList();
        System.out.println("LinkedList: " + System.identityHashCode(linkedList));
        linkedList.add("A");
        System.out.println("LinkedList 0: " + System.identityHashCode(linkedList.get(0)));
        linkedList.add("B");
        System.out.println("LinkedList 1: " + System.identityHashCode(linkedList.get(1)));
        linkedList.add("C");
        System.out.println("LinkedList: 2" + System.identityHashCode(linkedList.get(2)));
    }
}

