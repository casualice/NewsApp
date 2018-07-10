package com.newsApp.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class newsLike {
    private int NLNO;
    private int userNo;
    private int newsNo;

}
