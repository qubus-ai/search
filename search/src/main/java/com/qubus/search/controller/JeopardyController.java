package com.qubus.search.controller;

import com.qubus.search.controller.dto.HintDto;
import com.qubus.search.controller.dto.JeopardyDto;
import com.qubus.search.repository.Jeopardy;
import com.qubus.search.service.JeopardyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class JeopardyController {

    private final JeopardyService jeopardyService;

    @GetMapping(value = "/search/{word}")
    public HintDto getSearch(@PathVariable @NotBlank @Size(max = 20) final String word) {
        return jeopardyService.getSearch(word);
    }

    @GetMapping(value = "/jeopardy/{word}")
    public Page<Jeopardy> getJeopardy(@PathVariable  @NotBlank @Size(max = 20) final String word, Pageable pageable) throws NoSuchElementException {
        log.info("Received request for" + word + " " + pageable);
        JeopardyDto jeopardy = this.jeopardyService.getJeopardy(word);
        int startIndex = pageable.getPageNumber()*pageable.getPageSize();
        int endIndex = startIndex + pageable.getPageSize();
        List<Jeopardy> jeopardies = jeopardy.getJeopardies();
        if(startIndex > jeopardies.size()) {
            throw new NoSuchElementException("Page requested exceeds results count");
        }
        if(endIndex > jeopardies.size()) {
            endIndex = jeopardies.size();
        }
        return new PageImpl<>(jeopardies.subList(startIndex, endIndex), pageable, jeopardy.getJeopardies().size()); //;
    }
}
