package edu.iis.mto.similarity.dubler;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import static edu.iis.mto.search.SearchResult.builder;

public class SequenceSearcherMock implements SequenceSearcher {

    private int counter;

    public SequenceSearcherMock() {
        counter = 0;
    }

    @Override public SearchResult search(int key, int[] seq) {

        counter++;

        SearchResult.Builder builder = builder();
        return builder.build();
    }

    public int getCounter() {

        return counter;

    }

}
