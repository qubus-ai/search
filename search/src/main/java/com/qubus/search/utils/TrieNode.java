package com.qubus.search.utils;

import lombok.*;

import java.util.*;

import static java.util.Objects.isNull;

@NoArgsConstructor
public class TrieNode<T> implements Comparable<TrieNode> {
    private final HashMap<Character, TrieNode<T>> children = new HashMap<>();

    private PriorityQueue<TrieNode<T>> priorityQueue;

    private boolean isPrioritized = false;

    @Getter
    private String word;

    private final List<T> items = new ArrayList<>();

    public List<T> getItems() {
        return new ArrayList<>(items);
    }
    @Override
    public int compareTo(TrieNode o) {
        return o.items.size() - this.items.size();
    }

    void insert(final String word, final T index) {
        TrieNode<T> current = this;

        for (char l: word.toCharArray()) {
            current = current.children.computeIfAbsent(l, c -> new TrieNode<T>());
            current.isPrioritized = false;
        }
        current.items.add(index);
        current.word = word;
    }

    TrieNode<T> find(final String word) throws NoSuchElementException {
        TrieNode current = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            current = (TrieNode<T>)current.children.get(ch);
            if (isNull(current)) {
                throw new NoSuchElementException(word);
            }
        }
        return current;
    }

    List<String> getNWordsOfChildren(final Integer N) {
        List<String> words = new ArrayList<>();

        if(!isPrioritized) {
            prioritize();
        }
        PriorityQueue<TrieNode<T>> p = new PriorityQueue<>(priorityQueue);
        if(!isNull(getWord())) {
            words.add(getWord());
        }
        while (!p.isEmpty() && words.size() < N) {
            words.add(p.poll().getWord());
        }
        return words;
    }

    protected void prioritize() {
        if(!isPrioritized) {
            priorityQueue = new PriorityQueue<>();
        }
        if(!isNull(getWord())) {
            priorityQueue.add(this);
        }
        priorityQueue.addAll(getAllChildrenWithWords());
        children.forEach((character, node) ->{
            if(!node.isPrioritized)
            {
                node.prioritize();
            }
        });
        isPrioritized = true;
    }

    private Set<TrieNode<T>> getAllChildrenWithWords() {
        Set<TrieNode<T>> result = new HashSet<>();

        children.forEach((character, node) ->{
            if(!isNull(node.getWord())) {
                result.add(node);
            }
            result.addAll(node.getAllChildrenWithWords());
        });
        return result;
    }
}
