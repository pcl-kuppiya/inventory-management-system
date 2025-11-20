package com.pcl.inventory.utill.tools;

public class IdSplitter {
    public static String splitId(String text){
        String[] split = text.split("-");
        return split[0]+"-"+split[1];
    }
}
