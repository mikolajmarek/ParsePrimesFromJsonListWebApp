package pl.mj.service;

import org.junit.Assert;
import org.junit.Test;
import pl.mj.exception.IncorrectElementInListException;
import pl.mj.exception.IncorrectSizeOfListException;
import pl.mj.exception.NoPrimeFoundException;
import pl.mj.service.PrimesFinderService;

import java.util.*;

public class PrimesFinderServiceTest {


    static final List<Integer> LIST_WITH_THREE_PRIMES = Collections.
            unmodifiableList(Arrays.asList(8, 90, 130, 109, 13, 38, 60, 677, 13, 999));
    static final List<Integer> LIST_WITH_NO_PRIMES = Collections.
            unmodifiableList(Arrays.asList(8, 90, 130, 112, 22, 38, 60, 56, 10, 999));
    static final List<Integer> EMPTY_LIST = Collections.emptyList();
    static final List<Integer> ONE_ELEMENT_LIST = Collections.
            unmodifiableList(Arrays.asList(8));

    PrimesFinderService primesFinderService = new PrimesFinderService();

    @Test(expected = IncorrectSizeOfListException.class)
    public void shouldReturnIncorrectSizeExceptionWhenListIsTooSmall() throws Exception {
        primesFinderService.foundPrimes(ONE_ELEMENT_LIST);
    }
    @Test(expected = IncorrectSizeOfListException.class)
    public void shouldReturnIncorrectSizeExceptionWhenListIsEmpty() throws Exception {
        primesFinderService.foundPrimes(EMPTY_LIST);
    }

    @Test(expected = NoPrimeFoundException.class)
    public void shouldReturnNoPrimesFoundException() throws Exception {
        primesFinderService.foundPrimes(LIST_WITH_NO_PRIMES);
    }

    @Test
    public void shouldCheckThatNumbersArePrimes() throws IncorrectElementInListException {
        Assert.assertTrue(primesFinderService.isPrime(13));
        Assert.assertTrue(primesFinderService.isPrime(239));
        Assert.assertTrue(primesFinderService.isPrime(1619));
        Assert.assertTrue(primesFinderService.isPrime(3221));
    }

    @Test
    public void shouldCheckThatNumbersAreNotPrimes() throws IncorrectElementInListException {
        Assert.assertFalse(primesFinderService.isPrime(14));
        Assert.assertFalse(primesFinderService.isPrime(238));
        Assert.assertFalse(primesFinderService.isPrime(1626));
        Assert.assertFalse(primesFinderService.isPrime(322772));
    }
    @Test(expected = IncorrectElementInListException.class)
    public void shouldThrowExceptionWhenElementIsSmallerThanTwo() throws IncorrectElementInListException{
        primesFinderService.isPrime(1);
    }

    @Test
    public void shouldFindThreePrimesFromGivenData() throws NoPrimeFoundException, IncorrectSizeOfListException {

        Assert.assertEquals(3,primesFinderService.foundPrimes(LIST_WITH_THREE_PRIMES).size());
        Assert.assertEquals(13,primesFinderService.foundPrimes(LIST_WITH_THREE_PRIMES).get(0));
        Assert.assertEquals(109,primesFinderService.foundPrimes(LIST_WITH_THREE_PRIMES).get(1));
        Assert.assertEquals(677,primesFinderService.foundPrimes(LIST_WITH_THREE_PRIMES).get(2));
    }


}