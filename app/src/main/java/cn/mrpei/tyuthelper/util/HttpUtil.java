package cn.mrpei.tyuthelper.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 裴周宇 on 2017/4/26.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        //System.out.print("执行send方法");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        //System.out.println(request);
        client.newCall(request).enqueue(callback);
    }
}
