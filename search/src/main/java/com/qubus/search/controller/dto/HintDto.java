package com.qubus.search.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HintDto {

    private List<String> items;
}
