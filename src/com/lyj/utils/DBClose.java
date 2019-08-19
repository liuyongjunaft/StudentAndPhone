package com.lyj.utils;

public class DBClose {
    public static void closeAll(AutoCloseable...closeables){
        for(AutoCloseable c:closeables){
            if(c!=null){
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
