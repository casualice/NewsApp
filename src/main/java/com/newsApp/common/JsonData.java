package com.newsApp.common;

import com.newsApp.common.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 数据传输
 * @author tanhao
 * @date 2018-5-15
 */
@Setter
@Getter
public class JsonData<T> implements Serializable {
    private static final long serialVersionUID = 8180111500772663731L;
    //是否成功  默认成功
    private int resultCode=ResultCode.SUCCESS.getCode();
    //信息 默认返回"成功"
    private String resultMsg =ResultCode.SUCCESS.getDesc();
    //携带数据
    private T resultData;
    public JsonData(int resultCode) {
        this.resultCode = resultCode;
    }
    public JsonData(){

    }
    public static  JsonData success(Object data,String msg){
        JsonData jsonData=new JsonData(ResultCode.SUCCESS.getCode());
        jsonData.setResultMsg(msg);
        jsonData.setResultData(data);
        return jsonData;
    }
    public  static  JsonData success(String msg){
        JsonData jsonData=new JsonData(ResultCode.SUCCESS.getCode());
        jsonData.setResultMsg(msg);
        return jsonData;
    }
    public  static  JsonData success(){
        JsonData jsonData=new JsonData(ResultCode.SUCCESS.getCode());
        jsonData.setResultMsg(ResultCode.SUCCESS.getDesc());
        return jsonData;
    }
    public  static  JsonData fail(String msg){
        JsonData jsonData=new JsonData(ResultCode.FAIL.getCode());
        jsonData.setResultMsg(msg);
        return jsonData;
    }
    public  static  JsonData fail(){
        JsonData jsonData=new JsonData(ResultCode.FAIL.getCode());
        jsonData.setResultMsg(ResultCode.FAIL.getDesc());
        return jsonData;
    }
    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode.getCode();

    }
}
