package edu.iis.mto.similarity.dubler;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import static edu.iis.mto.search.SearchResult.builder;

public class SequenceSearcherMockCorrectParameters implements SequenceSearcher {

    private int[] seq;

    public SequenceSearcherMockCorrectParameters(int[] seq) {
        this.seq = seq;
    }

    @Override public SearchResult search(int key, int[] seq) {

        this.seq = seq;

        SearchResult.Builder builder = builder();
        return builder.build();

    }

    public int[] getSeq() {
        return seq;
    }

}
