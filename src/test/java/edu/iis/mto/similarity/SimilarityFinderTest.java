package edu.iis.mto.similarity;

import edu.iis.mto.similarity.dubler.*;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimilarityFinderTest {

    @Test public void jaccardIndexForEmptySets() {

        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherStub(new boolean[] {}));

        int[] setA = {};
        int[] setB = {};

        double result = similarityFinder.calculateJackardSimilarity(setA, setB);

        assertThat(result, Is.is(1.0));

    }

    @Test public void jaccardIndexForTheSameSets() {

        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherStub(new boolean[] {true, true, true}));

        int[] setA = {1, 2, 3};
        int[] setB = {1, 2, 3};

        double result = similarityFinder.calculateJackardSimilarity(setA, setB);

        assertThat(result, Is.is(1.0));

    }

    @Test public void jaccardIndexForAbsolutelyVariousSets() {

        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherStub(new boolean[] {false, false, false}));

        int[] setA = {1, 1, 1};
        int[] setB = {2, 2, 2};

        double result = similarityFinder.calculateJackardSimilarity(setA, setB);

        assertThat(result, Is.is(0.0));

    }

    @Test public void jaccardIndexForVariousSets() {

        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherStub(new boolean[] {false, true, false}));

        int[] setA = {1, 2, 3};
        int[] setB = {2, 2, 2};

        double result = similarityFinder.calculateJackardSimilarity(setA, setB);

        assertThat(result, Is.is(0.2));

    }

    @Test public void amountOfMethodSearchCall() {

        SequenceSearcherMock sequenceSearcher = new SequenceSearcherMock();
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int[] setA = {1, 2, 3};
        int[] setB = {2, 2, 2};

        similarityFinder.calculateJackardSimilarity(setA, setB);

        assertThat(sequenceSearcher.getCounter(), Is.is(3));
    }

}
