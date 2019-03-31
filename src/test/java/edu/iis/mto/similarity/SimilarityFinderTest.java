package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static edu.iis.mto.search.SearchResult.builder;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private SimilarityFinder similarityFinder;

    @Before public void initialize() {

        similarityFinder = new SimilarityFinder((key, seq) -> {

            SearchResult.Builder builder = builder();

            for(int i = 0; i < seq.length; i++){
                if (seq[i] == key){
                    builder.withPosition(i);
                    builder.withFound(true);
                    return builder.build();
                }
            }

            builder.withFound(false);
            return builder.build();

        });

    }

    @Test public void jaccardIndexForEmptySets() {

        int[] setA = {};
        int[] setB = {};

        double result = similarityFinder.calculateJackardSimilarity(setA, setB);

        assertThat(result, Is.is(1.0));

    }

    @Test public void jaccardIndexForTheSameSets() {

        int[] setA = {1, 2, 3};
        int[] setB = {1, 2, 3};

        double result = similarityFinder.calculateJackardSimilarity(setA, setB);

        assertThat(result, Is.is(1.0));

    }

    @Test public void jaccardIndexForAbsolutelyVariousSets() {

        int[] setA = {1, 1, 1};
        int[] setB = {2, 2, 2};

        double result = similarityFinder.calculateJackardSimilarity(setA, setB);

        assertThat(result, Is.is(0.0));

    }

    @Test public void jaccardIndexForVariousSets() {

        int[] setA = {1, 2, 3};
        int[] setB = {2, 2, 2};

        double result = similarityFinder.calculateJackardSimilarity(setA, setB);

        assertThat(result, Is.is(0.2));

    }
}
