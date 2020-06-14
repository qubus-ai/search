package com.qubus.search.controller.dto;

import com.qubus.search.repository.Jeopardy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JeopardyDto {

    private List<Jeopardy> jeopardies;
}
