package com.qubus.search.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    private Trie<Integer> trie;

    @BeforeEach
    void setUp() {
        trie = new Trie<>();
    }

    @Test
    void should_find_data() {
        trie.insert("form", 0);
        trie.insert("word", 1);
        trie.insert("dat", 2);
        trie.insert("data",3);
        trie.insert("data",4);

        TrieNode<Integer> data = trie.find("data");
        assertEquals("data", data.getWord());
        assertEquals(2, data.getItems().size());
        assertEquals(3 , data.getItems().get(0));

        TrieNode<Integer> dat = trie.find("dat");
        assertEquals("dat", dat.getWord());
        assertEquals(1, dat.getItems().size());
        assertEquals(2 , dat.getItems().get(0));

        TrieNode<Integer> word = trie.find("word");
        assertEquals("word", word.getWord());
        assertEquals(1, word.getItems().size());
        assertEquals(1 , word.getItems().get(0));

        TrieNode<Integer> form = trie.find("form");
        assertEquals("form", form.getWord());
        assertEquals(1, form.getItems().size());
        assertEquals(0 , form.getItems().get(0));

    }

    @Test()
    void should_throw_exception(){
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            TrieNode<Integer> sword = trie.find("sword");
        });
    }

    @Test
    void should_prioritize_nodes() {
        trie.insert("form", 2);
        trie.insert("form", 2);
        trie.insert("form", 2);
        trie.insert("form", 2);

        trie.insert("former", 1);
        trie.insert("former", 1);
        trie.insert("former", 1);
        trie.insert("former", 1);
        trie.insert("former", 1);

        trie.insert("forest", 2);
        trie.insert("forest", 2);
        trie.insert("forest", 2);

        trie.insert("for", 0);
        trie.insert("for", 0);
        trie.insert("for", 0);
        trie.insert("for", 0);
        trie.insert("for", 0);
        trie.insert("for", 0);

        trie.insert("fort", 2);
        trie.insert("fort", 2);

        trie.insert("forever",3);

        trie.insert("word",3);
        trie.prioritize();

        List<String> fWords = trie.getNMostFrequentWords("f", 10);
        assertEquals("for", fWords.get(0));
        assertEquals("former", fWords.get(1));
        assertEquals("form", fWords.get(2));
        assertEquals("forest", fWords.get(3));
        assertEquals("fort", fWords.get(4));
        assertEquals("forever", fWords.get(5));

    }

    @Test
    void should_reprioritize_nodes() {
        trie.insert("form", 2);
        trie.insert("form", 2);
        trie.insert("form", 2);
        trie.insert("form", 2);

        trie.insert("former", 1);
        trie.insert("former", 1);
        trie.insert("former", 1);
        trie.insert("former", 1);
        trie.insert("former", 1);

        trie.prioritize();

        trie.insert("forest", 2);
        trie.insert("forest", 2);
        trie.insert("forest", 2);

        trie.prioritize();

        trie.insert("forest", 2);
        trie.insert("forest", 2);
        trie.insert("forest", 2);
        trie.insert("forest", 2);

        trie.insert("for", 0);
        trie.insert("for", 0);
        trie.insert("for", 0);
        trie.insert("for", 0);
        trie.insert("for", 0);
        trie.insert("for", 0);

        trie.insert("fort", 2);
        trie.insert("fort", 2);

        trie.insert("forever",3);

        trie.insert("word",3);


        List<String> fWords = trie.getNMostFrequentWords("f", 10);
        assertEquals("forest", fWords.get(0));
        assertEquals("for", fWords.get(1));
        assertEquals("former", fWords.get(2));
        assertEquals("form", fWords.get(3));
        assertEquals("fort", fWords.get(4));
        assertEquals("forever", fWords.get(5));

    }

    @Test
    void should_get__N_most_pupular_words() {
        Trie<Integer> trie = new Trie<>();
        trie.insert("data", 0);
        trie.insert("date", 1);
        trie.insert("datum", 2);
        trie.insert("datum", 2);
        trie.insert("datum", 2);

        trie.insert("delete",3);
        trie.insert("delete",3);

        List<String> d = trie.getNMostFrequentWords("d", 2);

        assertEquals(2, d.size());

        List<String> d1 = trie.getNMostFrequentWords("d", 10);
        assertEquals(4, d1.size());
    }

}