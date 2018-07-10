package com.newsApp.entity;

import lombok.*;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMessage {
    private int userNo;

    private String wechatId;

    private String userName;

    private Date userTime;

    private List<Area> areas;

    private List<Label> labels;
}
