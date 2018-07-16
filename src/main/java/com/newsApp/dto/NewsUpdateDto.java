package com.newsApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsUpdateDto {
    private int NewsNO;
    private String NewsTitle;
    private String NewsIntro;
    private String NewsLable;
}
