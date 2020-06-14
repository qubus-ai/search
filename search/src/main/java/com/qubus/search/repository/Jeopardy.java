package com.qubus.search.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jeopardy {

    private String category;

    private Date air_date;

    private String question;

    private String value;

    private String answer;

    private String round;

    private Integer show_number;
}
