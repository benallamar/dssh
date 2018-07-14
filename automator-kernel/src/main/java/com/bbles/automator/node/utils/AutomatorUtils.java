package com.bbles.automator.node.utils;

import java.util.ArrayList;
import java.util.Date;

public class AutomatorUtils {
    public static Date parseStringDate(String s) {
        return new Date();
    }

    public static ArrayList<String> mergeStringWithAnArray(String s, String[] as) {
        ArrayList<String> sb = new ArrayList();
        //TODO: Check if manipulating this structure of data is safe or not
        sb.add(s);
        for (String _s : as) {
            sb.add(_s);
        }
        return sb;
    }
}
