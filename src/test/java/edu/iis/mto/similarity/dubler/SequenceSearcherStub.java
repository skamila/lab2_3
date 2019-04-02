package edu.iis.mto.similarity.dubler;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import static edu.iis.mto.search.SearchResult.builder;

public class SequenceSearcherStub implements SequenceSearcher {

    private boolean[] theSameElementsInSetsTab;
    private int i;

    public SequenceSearcherStub(boolean[] tab) {

        this.theSameElementsInSetsTab = tab;
        this.i = 0;

    }

    @Override public SearchResult search(int key, int[] seq) {

        SearchResult.Builder builder = builder();

        if (theSameElementsInSetsTab[i]) {
            builder.withFound(true);
        }

        i++;

        return builder.build();

    }

}
