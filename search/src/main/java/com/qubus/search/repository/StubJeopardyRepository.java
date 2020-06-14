package com.qubus.search.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qubus.search.controller.dto.JeopardyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Repository
public class StubJeopardyRepository implements JeopardyRepository {

    private List<Jeopardy> jeopardies;

    @PostConstruct
    public void initialize() throws IOException {
        File file = ResourceUtils.getFile("classpath:data/JEOPARDY_QUESTIONS.json");

        ObjectMapper objectMapper = new ObjectMapper();

        JeopardyDto jeopardyDto = objectMapper.readValue(file, JeopardyDto.class);

        log.info("Jeopardy data successfully read from local file");
        jeopardies =  jeopardyDto.getJeopardies();
    }

    @Override
    public List<Jeopardy> findAll() {
        return jeopardies;
    }

    @Override
    public boolean save(Jeopardy jeopardy) {
        return jeopardies.add(jeopardy);
    }

}
