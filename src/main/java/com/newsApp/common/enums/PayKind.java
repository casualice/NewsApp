package com.newsApp.common.enums;

/**
 * 支付方式的类型
 */
public enum PayKind {
    ali_pay(0,"支付宝支付"),wechat_pay(1,"微信支付");
    public int code;
    public String name;

    private PayKind(int code, String name){
        this.code=code;
        this.name=name;
    }

    /**
     * 支付方式名称
     * @param code
     * @return
     */
    public static String fetchPayName(int code){
        if(code<0){
            return null;
        }
       for(PayKind type :PayKind.values()){
            if(type.code==code){
                return type.name;
            }
       }
       return null;
    }
}
