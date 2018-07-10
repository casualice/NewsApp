package com.newsApp.common.enums;

/**
 * 订单状态
 */
 public  enum  OrderStatus {

    WAIT_PAY(0,"等待支付"),

    PAY_SUCCESS(1,"支付成功"),

    PAY_FAIL(2,"支付失败");

    public int code;
    public String name;
    private OrderStatus(int code,String name){
        this.code=code;
        this.name=name;
    };

    /**
     * 获取订单状态名称
     * @param code
     * @return
     */
    public static String getStatusName(int code){
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
