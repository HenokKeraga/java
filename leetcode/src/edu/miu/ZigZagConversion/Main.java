package edu.miu.ZigZagConversion;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String s="PAYPALISHIRING";
      System.out.println(convert(s,3));

    }
    public static String convert(String s, int numRows) {
        if(numRows==1 || numRows >= s.length())
            return s;

        Map<Integer,StringBuilder> map= new HashMap<>();
        int row=0;
        int direction=-1;
        StringBuilder str= new StringBuilder();


        for(int i=0;i<s.length();i++){
            final char ch=(s.charAt(i));

            if(map.containsKey(row))
                map.computeIfPresent(row,(k, v)->v.append(ch));
            else
                map.put(row,new StringBuilder().append(ch));

            if(row == 0|| row == numRows-1)
                direction*=-1;
            row+=direction;

        }

        for(int j=0;j<numRows;j++){
            str.append(map.get(j));
        }

        return str.toString();
    }
}
