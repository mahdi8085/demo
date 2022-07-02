package com.example.demo.presentation.responseentity.response;

import com.example.demo.presentation.responseentity.ResponseEntityMessageAndCode;

public class SuccessfulRequestResponseEntity<T> extends BaseResponseEntity<T> {

    public SuccessfulRequestResponseEntity(T content) {
        super(
                ResponseEntityMessageAndCode.OK.getTitle(),
                ResponseEntityMessageAndCode.OK.getCode(),
                content);
    }
}
