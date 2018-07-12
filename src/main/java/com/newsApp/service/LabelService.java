package com.newsApp.service;

import com.newsApp.common.JsonData;

public interface LabelService {
    JsonData addLabel(String labelName);

    JsonData deleteLabel(String labelName);

    JsonData getAllLabels();
}
