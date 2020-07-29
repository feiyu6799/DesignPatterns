package com.feiyu.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 适配器（转换器）
 * @author feiyu
 *转换器把两脚插头能在三角插座上使用
 */
public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("c:/test.text");//相当于三角插座
        InputStreamReader isr = new InputStreamReader(fis);//相当于转换器
        BufferedReader br = new BufferedReader(isr);//相当于两角插头
        String line = br.readLine();
        while (line != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();
    }
}
