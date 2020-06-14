package com.qubus.search.utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@NoArgsConstructor
public class Trie<T> {

    private final TrieNode root = new TrieNode();

    public void insert(final String word, final T index) {
        root.insert(word, index);
    }

    public TrieNode<T> find(final String word) {
       return root.find(word);
    }

    public void prioritize() {
        root.prioritize();
    }

    public List<String> getNMostFrequentWords(final String word, final Integer N) {
        List<String> words = new ArrayList<>();

        TrieNode<T> node = find(word);
        if(isNull(node)){
            log.info("Node not found");
            return words;
        }

        words.addAll(node.getNWordsOfChildren(N));
        return words;
    }

}
