package com.newsApp.common.enums;
import java.util.HashMap;
import java.util.Map;

public enum  ResultCode {

   SUCCESS(1000, "成功"),

   PARAMETER_ERROR(2000,"参数错误"),

   UPDATE_ERROR(2001,"更新失败"),

   INSERT_ERROR(2002,"添加失败"),

   DELETE_ERROR(2003,"删除失败"),

   ROLE_NOT_EXISTS(2004,"用户角色不存在"),

   ROLE_NAME_REPET(2005,"角色名称重复"),

   ADMIN_NOT_EXISTS(2006,"管理员不存在"),

   TOTAL_SCORE_ERROR(2007,"综合测评满分100"),

   PASS_WORD_ERROR(2008,"登录密码错误"),

   NOT_LOGIN(2009,"未登录,请登录后操作"),

   ORDER_NOT_EXIST(2010,"订单不存在"),

   CHART_TO_LONG(2011,"字符太长"),

    TIME_SETUP_EXIST(2022,"该年分已存在"),

    TIME_SETUP_REPET(2013,"修改的年分存在重复"),

    OLD_PASS_WORD(2014,"输入的密码与老密码不一致"),

    UPLOAD_FIAL(2015,"上传失败"),

    UPLOAD_SUCCESS(2016,"上传成功"),

    LOG_OUT(2017,"您已退出登录"),

    NOT_PERMISSION(2018,"您没有操作权限"),

    ADMIN_USER_NAME_REPET(2019,"用户名重复"),

    TOKEN_NOT_EXIST(2020,"请求头参数不存在"),

    FETCH_ADMIN_INFO_FAIL(2021,"获取用户信息失败"),

    FAIL(9999, "系统异常，请刷新后重试" );

   // 成员变量
   private int                         code;   // 编码
   private String                      desc;   // 中文描述

   /**
    *  返回码MAP
    */
   private static Map<Integer, String> map;

   static {
       //初始化
       map = new HashMap<>(values().length);
       for (ResultCode code : ResultCode.values()) {
           map.put(code.getCode(), code.getDesc());
       }
   }

   private ResultCode(int code, String desc) {
       this.code = code;
       this.desc = desc;
   }


   public static ResultCode getType(int code) {
       if (code <= 0) {
           return null;
       }
       for (ResultCode resultCode : ResultCode.values()) {
           if (resultCode.code == code) {
               return resultCode;
           }
       }
       return null;
   }

   public int getCode() {
       return code;
   }

   public void setCode(int code) {
       this.code = code;
   }

   public String getDesc() {
       return desc;
   }

   public void setDesc(String desc) {
       this.desc = desc;
   }

   /**
    *   获取返回码反描述
    *
    * @param code
    * @return
    */
   public static String getDesc(int code) {
       return map.get(code);
   }




}
