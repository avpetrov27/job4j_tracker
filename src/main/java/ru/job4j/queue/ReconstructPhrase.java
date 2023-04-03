package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder s = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                s.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return String.valueOf(s);
    }

    private String getDescendingElements() {
        StringBuilder s = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            s.append(iterator.next());
        }
        return String.valueOf(s);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
