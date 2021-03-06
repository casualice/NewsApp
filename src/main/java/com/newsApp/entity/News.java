package com.newsApp.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {

    private int newsNo;

    private String newsTitle;

    private String newsUrl;

    private String newsSource;

    private String newsIntro;
}
