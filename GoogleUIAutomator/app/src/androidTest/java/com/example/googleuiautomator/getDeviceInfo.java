package com.example.googleuiautomator;

import android.os.Build;
import android.os.Environment;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class getDeviceInfo {
    @Test
    public void testBuild_DeviceInfo(){
        //Build类
        System.out.println("Build:"+ Build.BOARD);
        System.out.println("Build:"+ Build.BOOTLOADER);
        System.out.println("Build:"+Build.CPU_ABI);
        System.out.println("Build:"+Build.CPU_ABI2);
        System.out.println("Build:"+Build.DEVICE);
        System.out.println("Build:"+Build.DISPLAY);
        System.out.println("Build:"+Build.FINGERPRINT);
        System.out.println("Build:"+Build.HARDWARE);
        System.out.println("Build:"+Build.HOST);
        System.out.println("Build:"+Build.ID);
        System.out.println("Build:"+Build.MANUFACTURER);
        System.out.println("Build:"+Build.MODEL);
        System.out.println("Build:"+Build.PRODUCT);
        System.out.println("Build:"+Build.RADIO);
        System.out.println("Build:"+Build.SERIAL);
        System.out.println("Build:"+Build.TAGS);
        System.out.println("Build:"+Build.TIME);
        System.out.println("Build:"+Build.TYPE);
        System.out.println("Build:"+Build.USER);
        System.out.println("Build:"+Build.BOARD);
        //Build.VERSION类
        System.out.println("Build.VERSION:"+Build.VERSION.CODENAME);
        System.out.println("Build.VERSION:"+Build.VERSION.INCREMENTAL);
        System.out.println("Build.VERSION:"+Build.VERSION.RELEASE);
        System.out.println("Build.VERSION:"+Build.VERSION.SDK_INT);
        //Build.VERSION_CODES类
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.BASE);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.BASE_1_1);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.CUPCAKE);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.CUR_DEVELOPMENT);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.ECLAIR);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.ECLAIR_0_1);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.ECLAIR_MR1);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.FROYO);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.GINGERBREAD);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.GINGERBREAD_MR1);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.HONEYCOMB);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.HONEYCOMB_MR1);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.HONEYCOMB_MR2);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.ICE_CREAM_SANDWICH);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.JELLY_BEAN);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.JELLY_BEAN_MR1);
        System.out.println("Build.VERSION_CODES:"+Build.VERSION_CODES.JELLY_BEAN_MR2);

        //SDK version
        System.out.println("Build.VERSION.SDK_INT:"+Build.VERSION.SDK_INT);

        //输出指定目录
        System.out.println("------指定目录------");
        System.out.println(Environment.getDataDirectory());//数据目录
        System.out.println(Environment.getDownloadCacheDirectory());//下载缓存目录
        System.out.println(Environment.getExternalStorageDirectory());//外部存储目录
        System.out.println(Environment.getRootDirectory());//Root目录
        //输出特定目录
        System.out.println("------特定目录------");
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS));
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS));
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
        System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES));
        //列出下载目录下的文件
        System.out.println("------下载目录下的文件------");
        File downloadFile=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File[] file=downloadFile.listFiles();

        try {
            for (File f : file) {
                System.out.println(f.getAbsolutePath());
            }
        }
        catch (Exception e){
            System.out.println(" *** Failed to get the file paths *** ");
        }

        //调用设定的方法，传入key输出键值
        System.out.println("硬件平台:"+getProp("ro.board.platform"));
        System.out.println("SN号:"+getProp("ro.boot.serialno"));
        System.out.println("系统android版本号:"+getProp("ro.build.version.release"));
        System.out.println("SDK级别:"+getProp("ro.build.bersion.sdk"));
        System.out.println("手机当前运营商信息:"+getProp("gsm.operator.alpha"));
        System.out.println("系统版本:"+getProp("ro.build.version.inscremental"));
        System.out.println("手机制造商信息:"+getProp("ro.product.manufacturer"));
        System.out.println("手机型号:"+getProp("ro.product.model"));
        System.out.println("手机名子:"+getProp("ro.product.name"));
        System.out.println("系统语言:"+getProp("ro.product.local.language"));

    }

    //解析系统属性的方法
    private String getProp(String key){
        try{
            //命令窗口输入命令
            Process p=Runtime.getRuntime().exec("getprop");
            //从命令中提取的输入流
            InputStream in=p.getInputStream();
            InputStreamReader reader=new InputStreamReader(in);
            BufferedReader buff=new BufferedReader(reader);
            //逐行读取并输出
            String line="";
            while((line=buff.readLine())!=null){
                if(line.contains("["+key+"]")){
                    String[] s=line.split("\\[");
                    //调试用的
//                  for(String ss:s){
//                      System.out.println("**："+ss);
//                  }
                    //返回值
                    return s[2].replaceAll("\\].*", "");
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        //如果没取到就返回这个
        return "未找到对应KEY";
    }
}
