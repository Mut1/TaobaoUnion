package com.mut.taobaounion.utils;

import android.util.Log;

public class LogUtils  {
    private static  int currentlev=4;
    private static  final  int infolev=3;
    private static  final int warninglev=2;
    private static  final  int errorlev=1;
    private static final  int debuglev=4;
    public static void d(Object clazz,String log)
    {
        if(currentlev>=debuglev)
            Log.d(clazz.getClass().getSimpleName(),log);
    }
    public static void i(Object clazz,String log)
    {
        if(currentlev>=infolev)
            Log.i(clazz.getClass().getSimpleName(),log);
    }
    public static void w(Object clazz,String log)
    {
        if(currentlev>=warninglev)
            Log.w(clazz.getClass().getSimpleName(),log);
    }
    public static void e(Object clazz,String log)
    {
        if(currentlev>=errorlev)
            Log.e(clazz.getClass().getSimpleName(),log);
    }
}
