package com.newsApp.entity;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private int userNo;

    private String wechatId;

    private String userName;

    private Date userTime;
}
