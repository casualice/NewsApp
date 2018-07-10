package com.newsApp.common.enums;

public enum  HelpStatus {
    wait_solve(0,"待处理"), solved(1,"已处理");
    public int code;
    public String name;
    private HelpStatus(int code,String name){
        this.code=code;
        this.name=name;
    }
    public static String FetchStatusName(int code){
        if(code<0){
            return null;
        }
        for(OrderStatus status : OrderStatus.values()){
            if(status.code==code){
                return status.name;
            }
        }
        return null;
    }
}
