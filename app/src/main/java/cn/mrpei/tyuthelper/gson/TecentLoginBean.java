package cn.mrpei.tyuthelper.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 裴周宇 on 2017/4/26.
 */

//解析腾讯返回的QQ用户信息
public class TecentLoginBean {

    @SerializedName("ret")
    private String ret;
    @SerializedName("msg")
    private String msg;
    @SerializedName("is_lost")
    private String is_lost;
    //昵称
    @SerializedName("nickname")
    private String nickname;
    //性别
    @SerializedName("gender")
    private String sex;
    //所在省份
    @SerializedName("province")
    private String province;
    //所在市
    @SerializedName("city")
    private String city;

    //QQ空间头像 不同分辨率
    @SerializedName("figureurl")
    private String figureurl;
    @SerializedName("figureurl_1")
    private String figureurl_1;
    @SerializedName("figureurl_2")
    private String figureurl_2;

    //QQ头像  不同分辨率
    @SerializedName("figureurl_qq_1")
    private String figureurl_qq_1;
    @SerializedName("figureurl_qq_2")
    private String figureurl_qq_2;
    @SerializedName("is_yellow_vip")
    private String is_yellow_vip;
    @SerializedName("vip")
    private String vip;
    @SerializedName("yellow_vip_level")
    private String yellow_vip_level;
    @SerializedName("level")
    private String level;
    @SerializedName("is_yellow_year_vip")
    private String is_yellow_year_vip;


    public String getRet() {
        return ret;
    }

    public String getMsg() {
        return msg;
    }

    public String getIs_lost() {
        return is_lost;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSex() {
        return sex;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getFigureurl() {
        return figureurl;
    }

    public String getFigureurl_1() {
        return figureurl_1;
    }

    public String getFigureurl_2() {
        return figureurl_2;
    }

    public String getFigureurl_qq_1() {
        return figureurl_qq_1;
    }

    public String getFigureurl_qq_2() {
        return figureurl_qq_2;
    }

    public String getIs_yellow_vip() {
        return is_yellow_vip;
    }

    public String getVip() {
        return vip;
    }

    public String getYellow_vip_level() {
        return yellow_vip_level;
    }

    public String getLevel() {
        return level;
    }

    public String getIs_yellow_year_vip() {
        return is_yellow_year_vip;
    }
}
