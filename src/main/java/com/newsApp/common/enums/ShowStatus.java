package com.newsApp.common.enums;

/**
 * 显示状态
 */
public enum ShowStatus {
    show(0,"显示"),hiden(1,"隐藏");
    public int code;
    public String name;

    private ShowStatus(int code,String name){
        this.code=code;
        this.name=name;
    }



}
