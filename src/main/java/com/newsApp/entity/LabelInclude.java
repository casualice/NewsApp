package com.newsApp.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabelInclude {
    private int LINO;
    private int newsNo;
    private int labelNo;
}
