package com.example.phone;


import android.os.Build;
import android.telephony.TelephonyManager;

import java.io.File;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class IXposedHookLoadPackageImpl implements IXposedHookLoadPackage {
    @Override public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {

        this.setProductdata();

        XC_LoadPackage.LoadPackageParam lpparam = loadPackageParam;
        findAndHookMethod(TelephonyManager.class, "getDeviceId", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                param.setResult("1024_" + (int) (Math.random() * 1000));
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
        findAndHookMethod(TelephonyManager.class, "getSimSerialNumber", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("DIY");
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
        findAndHookMethod(TelephonyManager.class, "getSubscriberId", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("DIY");
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
        findAndHookMethod(TelephonyManager.class, "getLine1Number", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("+8617611111111");
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("+8617611111111");
            }
        });
        findAndHookMethod(TelephonyManager.class, "getSimCountryIso", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("HK");
            }
        });
        findAndHookMethod(TelephonyManager.class, "getSimOperator", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("1111");
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("1111");
            }
        });
        findAndHookMethod(TelephonyManager.class, "getSimOperatorName", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("DIY");
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult("DIY");
            }
        });
        findAndHookMethod(TelephonyManager.class, "getNetworkCountryIso", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("DIY");
            }
        });
        findAndHookMethod(TelephonyManager.class, "getNetworkOperator", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("111");
            }
        });
        findAndHookMethod(TelephonyManager.class, "getNetworkOperatorName", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("111");
            }
        });
//        findAndHookMethod(TelephonyManager.class, "getNetworkType", new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                param.setResult("111");
//            }
//        });
//        findAndHookMethod(TelephonyManager.class, "getPhoneType", new XC_MethodHook() {
//          @Override
//          protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//              super.beforeHookedMethod(param);
//              param.setResult("1");
//          }
//          @Override
//          protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//              super.afterHookedMethod(param);
//              param.setResult("1");
//          }
//        });
//        findAndHookMethod(TelephonyManager.class, "hasIccCard", new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                param.setResult("111");
//            }
//        });

        /*

        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getDeviceId", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getSimSerialNumber", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getSubscriberId", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getLine1Number", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getSimCountryIso", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getSimOperator", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getSimOperatorName", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getNetworkCountryIso", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getNetworkOperator", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getNetworkOperatorName", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getNetworkType", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "getPhoneType", new Object[0]);
        this.addHook(lpparam.packageName, TelephonyManager.class.getName(), lpparam.classLoader, "hasIccCard", new Object[0]);

        this.addHook(lpparam.packageName, WifiInfo.class.getName(), lpparam.classLoader, "getMacAddress", new Object[0]);
        this.addHook(lpparam.packageName, WifiInfo.class.getName(), lpparam.classLoader, "getSSID", new Object[0]);
        this.addHook(lpparam.packageName, WifiInfo.class.getName(), lpparam.classLoader, "getBSSID",new Object[0]);
        //this.addHook(v1, "android.os.SystemProperties", v3, "get", v5);

        this.addHook(lpparam.packageName, "android.os.SystemProperties", lpparam.classLoader, "get", new Object[]{String.class});

        this.addHook(lpparam.packageName, GsmCellLocation.class.getName(), lpparam.classLoader, "getLac", new Object[0]);
        this.addHook(lpparam.packageName, GsmCellLocation.class.getName(), lpparam.classLoader, "getCid", new Object[0]);
        this.addHook(lpparam.packageName, CdmaCellLocation.class.getName(), lpparam.classLoader,"getNetworkId", new Object[0]);
        this.addHook(lpparam.packageName, CdmaCellLocation.class.getName(), lpparam.classLoader,"getBaseStationId", new Object[0]);

        this.addHook(lpparam.packageName, NeighboringCellInfo.class.getName(), lpparam.classLoader,"getLac", new Object[0]);
        this.addHook(lpparam.packageName, NeighboringCellInfo.class.getName(), lpparam.classLoader,"getCid", new Object[0]);
        //this.addHook(v1, v2, v3, "getLong", v5);

        this.addHook(lpparam.packageName, Display.class.getName(), lpparam.classLoader, "getMetrics", new Object[]{DisplayMetrics.class.getName()});
        this.addHook(lpparam.packageName, Display.class.getName(), lpparam.classLoader, "getWidth", new Object[0]);
        this.addHook(lpparam.packageName, Display.class.getName(), lpparam.classLoader, "getHeight",new Object[0]);

        this.addHook(lpparam.packageName, Location.class.getName(), lpparam.classLoader, "getLatitude", new Object[0]);
        this.addHook(lpparam.packageName, Location.class.getName(), lpparam.classLoader, "getLongitude",new Object[0]);
        this.addHook(lpparam.packageName, WifiManager.class.getName(), lpparam.classLoader, "getScanResults", new Object[0]);

        this.addHook(lpparam.packageName, NetworkInfo.class.getName(), lpparam.classLoader, "getTypeName", new Object[0]);
        this.addHook(lpparam.packageName, ConnectivityManager.class.getName(), lpparam.classLoader, "getNetworkInfo", new Object[]{Integer.TYPE.getName()});
        this.addHook(lpparam.packageName, Runtime.class.getName(), lpparam.classLoader, "exec", new Object[]{String.class.getName()});
        */
    }
    public  void addHook(String targetPackage,String className,ClassLoader classLoader,String methodName,Object[] paramterTypesAndCallback)
    {
        findAndHookMethod(targetPackage,classLoader,methodName,className,new XC_MethodHook()
        {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable
            {
                super.beforeHookedMethod(param);
                //XposedBridge.log("Enter->beforeHookedMethod");
                //XposedBridge.log("original token: " + (String)param.args[0]);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable
            {
                super.afterHookedMethod(param);
                //XposedBridge.log("Enter->afterHookedMethod");
                //XposedBridge.log("original token: " + (String)param.args[0]);
            }
        });
    }
    private void setProductdata()
    {
        XposedHelpers.setStaticObjectField(Build.class,"BRAND","diY");
        XposedHelpers.setStaticObjectField(Build.class, "PRODUCT", "diY");
        XposedHelpers.setStaticObjectField(Build.class, "MODEL", "diY");
        XposedHelpers.setStaticObjectField(Build.class, "MANUFACTURER", "diY");
        XposedHelpers.setStaticObjectField(Build.class, "DEVICE","diY");
        XposedHelpers.setStaticObjectField(Build.VERSION.class, "RELEASE", "diY");
        XposedHelpers.setStaticObjectField(Build.VERSION.class, "SDK", "diY");
        XposedHelpers.setStaticObjectField(Build.class, "CPU_ABI", "diY");
        XposedHelpers.setStaticObjectField(Build.class, "CPU_ABI2", "diY");
        XposedHelpers.setStaticObjectField(Build.class, "FINGERPRINT", "diY");
        XposedHelpers.setStaticObjectField(Build.class, "HARDWARE", "diY");
    }

    //劫持构造方法
    public void addHookConstructor(final String packageName,String className,ClassLoader classLoader,Object[] parameterTypesAndCallback){

        XC_MethodHook xc_methodHook = new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

                //监听File实例构建，实现监听文件的操作
                if (XposeUtil.configMap.optBoolean(XposeUtil.FileRecordPackageNameSwitch) && XposeUtil.configMap.optString(XposeUtil.FileRecordPackageName).contains(packageName)) {
                    String attr = "";
                    if(param.args[0]instanceof File){
                        attr = ((File) param.args[0]).getAbsolutePath();
                    }else if(param.args.length > 1 && param.args[1] != null ){
                        String separator = "";
                        if(!param.args[0].toString().endsWith("/"))
                            separator = "/";
                        attr =  param.args[0].toString() + separator + param.args[1].toString();
                    }else{
                        attr = (String) param.args[0];
                    }
//                    if (attr.contains(RecordFileUtil.ExternalStorage) && !attr.contains("xpose")
//                            && !(attr.startsWith(RecordFileUtil.ExternalStorage+RecordFileUtil.FILE_PATH_RECORD))
//                            && RecordFileUtil.addFileRecord(packageName, attr)) ;
                }
            }
        };

        //执行hook方法findAndHookConstructor的param值为参数+回调的可变参数，故要将回调加入进去
        Object [] param = new Object[parameterTypesAndCallback.length + 1];
        for (int i = 0; i < param.length; i++) {
            if(i == param.length-1){
                param[param.length - 1] = xc_methodHook;
                XposedHelpers.findAndHookConstructor(className,classLoader,param);
                return ;
            }
            param[i] = parameterTypesAndCallback[i];
        }
    }
}






















