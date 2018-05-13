package pl.mj;

import org.junit.Assert;
import org.junit.Test;
import pl.mj.exception.IncorrectElementInListException;
import pl.mj.exception.IncorrectSizeOfListException;
import pl.mj.exception.NoPrimeFoundException;
import pl.mj.service.PrimesFounderService;

import java.util.*;

public class PrimesFounderServiceTest {


    static final List<Integer> LIST_WITH_THREE_PRIMES = Collections.
            unmodifiableList(Arrays.asList(8, 90, 130, 109, 13, 38, 60, 677, 13, 999));
    static final List<Integer> LIST_WITH_NO_PRIMES = Collections.
            unmodifiableList(Arrays.asList(8, 90, 130, 112, 22, 38, 60, 56, 10, 999));
    static final List<Integer> EMPTY_LIST = Collections.emptyList();
    static final List<Integer> ONE_ELEMENT_LIST = Collections.
            unmodifiableList(Arrays.asList(8));

    PrimesFounderService primesFounderService = new PrimesFounderService();

    @Test(expected = IncorrectSizeOfListException.class)
    public void shouldReturnIncorrectSizeExceptionWhenListIsTooSmall() throws Exception {
        primesFounderService.foundPrimes(ONE_ELEMENT_LIST);
    }
    @Test(expected = IncorrectSizeOfListException.class)
    public void shouldReturnIncorrectSizeExceptionWhenListIsEmpty() throws Exception {
        primesFounderService.foundPrimes(EMPTY_LIST);
    }

    @Test(expected = NoPrimeFoundException.class)
    public void shouldReturnNoPrimesFoundException() throws Exception {
        primesFounderService.foundPrimes(LIST_WITH_NO_PRIMES);
    }

    @Test
    public void shouldCheckThatNumbersArePrimes() throws IncorrectElementInListException {
        Assert.assertTrue(primesFounderService.isPrime(13));
        Assert.assertTrue(primesFounderService.isPrime(239));
        Assert.assertTrue(primesFounderService.isPrime(1619));
        Assert.assertTrue(primesFounderService.isPrime(3221));
    }

    @Test
    public void shouldCheckThatNumbersAreNotPrimes() throws IncorrectElementInListException {
        Assert.assertFalse(primesFounderService.isPrime(14));
        Assert.assertFalse(primesFounderService.isPrime(238));
        Assert.assertFalse(primesFounderService.isPrime(1626));
        Assert.assertFalse(primesFounderService.isPrime(322772));
    }
    @Test(expected = IncorrectElementInListException.class)
    public void shouldThrowExceptionWhenElementIsSmallerThanTwo() throws IncorrectElementInListException{
        primesFounderService.isPrime(1);
    }

    @Test
    public void shouldFindThreePrimesFromGivenData() throws NoPrimeFoundException, IncorrectSizeOfListException {

        Assert.assertTrue(primesFounderService.foundPrimes(LIST_WITH_THREE_PRIMES).contains(13));
        Assert.assertTrue(primesFounderService.foundPrimes(LIST_WITH_THREE_PRIMES).contains(109));
        Assert.assertTrue(primesFounderService.foundPrimes(LIST_WITH_THREE_PRIMES).contains(677));
    }


}