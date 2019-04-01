package edu.iis.mto.similarity.dubler;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import static edu.iis.mto.search.SearchResult.builder;

public class SequenceSearcherDubler implements SequenceSearcher {

    private int counter;

    public SequenceSearcherDubler() {
        counter = 0;
    }

    @Override public SearchResult search(int key, int[] seq) {

        SearchResult.Builder builder = builder();
        counter++;

        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == key) {
                builder.withPosition(i);
                builder.withFound(true);
                return builder.build();
            }
        }

        builder.withFound(false);
        return builder.build();
    }

    public int getCounter() {

        return counter;

    }

}
