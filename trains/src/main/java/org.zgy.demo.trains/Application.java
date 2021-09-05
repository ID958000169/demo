package org.zgy.demo.trains;

public class Application
{
    public static void main(String[] args)
    {
        //System.out.println(int2BitStr(120));
        System.out.println(-20 >>> 2);
    }
    static String int2BitStr(int value){
        String ibstr = Integer.toBinaryString(value);
        // 显示全部二进制字符，３２位
        while (ibstr.length() < 32){
            ibstr = "0" + ibstr;
        }
        String ibstr1 = ibstr.substring(0, 8) + " " + ibstr.substring(8, 16) + " " + ibstr.substring(16, 24) + " " + ibstr.substring(24, 32);

        return ibstr1;
    }
}
