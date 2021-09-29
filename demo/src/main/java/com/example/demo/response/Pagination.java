package com.example.demo.response;

import lombok.Data;

@Data
public class Pagination {
    private long pageSize;
    private long page;
    private long total;
}
