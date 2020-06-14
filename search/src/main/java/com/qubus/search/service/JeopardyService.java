package com.qubus.search.service;

import com.qubus.search.controller.dto.HintDto;
import com.qubus.search.controller.dto.JeopardyDto;
import com.qubus.search.repository.Jeopardy;
import com.qubus.search.repository.JeopardyRepository;
import com.qubus.search.utils.Trie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class JeopardyService {

    private final JeopardyRepository jeopardyRepository;
    private final Trie<Jeopardy> trie = new Trie();

    @PostConstruct
    public void initialize() {
        List<Jeopardy> jeopardies = this.jeopardyRepository.findAll();

        jeopardies.forEach(jeopardy -> {
            Arrays.stream(jeopardy.getQuestion().split(" ")).forEach(word -> {
                trie.insert(word, jeopardy);
            });
        });
        trie.prioritize();
        log.info("JeopardyService initialized");
    }


    public HintDto getSearch(final String word) {
        return HintDto.builder()
                .items(trie.getNMostFrequentWords(word,10)).build();
    }

    public JeopardyDto getJeopardy(final String word) {
        return JeopardyDto.builder()
                .jeopardies(trie.find(word).getItems()).build();
    }
}
