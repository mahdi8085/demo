package com.example.demo.application.util.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public class PaginationDTO implements Serializable {

    public static Pageable pageable(int page, int pageSize) {
        return PageRequest.of(page - 1, pageSize);
    }
}
