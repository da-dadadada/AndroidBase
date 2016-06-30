package com.lht.chuangyiyun.mvp.model.pojo;

/**
 * <p><b>Package</b> com.lht.chuangyiyun.mvp.model.pojo
 * <p><b>Project</b> Chuangyiyun
 * <p><b>Classname</b> VerifyInfo
 * <p><b>Description</b>: 身份认证信息
 * Created by leobert on 2016/5/5.
 */
public class VerifyInfo {
    private String username;
    private String accessToken;
    private String accessId;

    public VerifyInfo() {
    }

    public VerifyInfo(String username, String accessToken, String accessId) {
        this.username = username;
        this.accessToken = accessToken;
        this.accessId = accessId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String toString() {
        return "user:" + getUsername() + ",id:" + getAccessId() + ",token:" + getAccessToken();
    }
}
