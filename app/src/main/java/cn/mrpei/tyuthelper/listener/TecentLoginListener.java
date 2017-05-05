package cn.mrpei.tyuthelper.listener;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.Streams;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.mrpei.tyuthelper.gson.TecentLoginBean;
import cn.mrpei.tyuthelper.util.HttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 裴周宇 on 2017/4/26.
 */

//QQ 登录监听器
public class TecentLoginListener implements IUiListener {
    private String TAG;
    private Tencent mTencent;
    private Context context;
    private UserInfo mUserInfo;

    public TecentLoginListener(String TAG, Tencent mTencent, Context context, UserInfo mUserInfo) {
        this.TAG = TAG;
        this.mTencent = mTencent;
        this.context = context;
        this.mUserInfo = mUserInfo;
    }

    @Override
    public void onComplete(Object response) {
        Toast.makeText(context, "授权成功", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "response:" + response);
        JSONObject obj = (JSONObject) response;
        try {
            String openID = obj.getString("openid");
            String accessToken = obj.getString("access_token");
            String expires = obj.getString("expires_in");
            mTencent.setOpenId(openID);
            mTencent.setAccessToken(accessToken,expires);
            QQToken qqToken = mTencent.getQQToken();
            mUserInfo = new UserInfo(context,qqToken);
            mUserInfo.getUserInfo(new IUiListener() {
                @Override
                public void onComplete(Object response) {
                    Log.e(TAG,"登录成功"+response.toString());
                    Gson gson = new Gson();
                    TecentLoginBean bean = gson.fromJson(response.toString(),TecentLoginBean.class);

                    //Log.e(TAG,"22"+bean.getFigureurl_qq_2());

                }

                @Override
                public void onError(UiError uiError) {
                    Log.e(TAG,"登录失败"+uiError.toString());
                }

                @Override
                public void onCancel() {
                    Log.e(TAG,"登录取消");

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(UiError uiError) {
        Toast.makeText(context, "授权失败", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCancel() {
        Toast.makeText(context, "授权取消", Toast.LENGTH_SHORT).show();

    }

    //加载用户信息
    public void loadUserInfo(String requestUrl){
        HttpUtil.sendOkHttpRequest(requestUrl, new Callback() {
           @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String headImg = response.body().string();
               SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
               editor.putString("headImg", headImg);
               editor.apply();
               //runOnUiThread();

            }
            @Override
            public void onFailure(Call call, IOException e) {

            }
        });
    }

}
