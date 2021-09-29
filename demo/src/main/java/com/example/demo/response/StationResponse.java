package com.example.demo.response;

import lombok.Data;

import java.util.List;

@Data
public class StationResponse {

    private Pagination pagination;
    private List<StationResult> results;
}