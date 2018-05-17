package pl.mj.service;

import pl.mj.exception.IncorrectElementInListException;
import pl.mj.exception.IncorrectSizeOfListException;
import pl.mj.exception.NoPrimeFoundException;

import java.util.List;
import java.util.stream.Collectors;


public class PrimesFinderService {

    public List foundPrimes(List<Integer> list) throws IncorrectSizeOfListException, NoPrimeFoundException {
        if (list.size() < 2) {
            throw new IncorrectSizeOfListException("incorrect size of list");
        } else {
            List<Integer> primes = list.stream()
                    .filter(this::isPrime)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            if (primes.size() > 0) {
                return primes;
            } else {
                throw new NoPrimeFoundException("no primes found");
            }

        }

    }

    public boolean isPrime(Integer number) throws IncorrectElementInListException {
//    public boolean isPrime(Integer number)  {
        boolean prime = false;

        if (number < 2) {
            throw new IncorrectElementInListException("this number is incorrect");
        } else if (number == 2 || number == 3 || number == 5) {
            return true;
        } else if (number % 2 == 0
                || number % 3 == 0
                || number % 5 == 0
                ) {
            return false;
        } else {
            for (int i = 7; i < number; i++) {
                if (number % i == 0) {
                    return false;
                } else {
                    prime = true;
                }

            }
        }
        return prime;
    }
}
