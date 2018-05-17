package pl.mj.ConsoleApp;

import okhttp3.OkHttpClient;
import pl.mj.exception.IncorrectSizeOfListException;
import pl.mj.exception.InvalidJsonInputException;
import pl.mj.exception.NoPrimeFoundException;
import pl.mj.service.AuthenticationService;
import pl.mj.service.JsonParserService;
import pl.mj.service.PrimesFinderService;

import java.io.IOException;
import java.util.List;

import static pl.mj.service.AuthenticationService.createAuthenticatedClient;
import static pl.mj.service.AuthenticationService.collectStringDataFromUrl;

public class ConsoleApp {
    public static void main(String[] args) throws IOException, InvalidJsonInputException, NoPrimeFoundException, IncorrectSizeOfListException {

        String login = "candidate";
        String password = "abc123";
        String url = "http://dt-gwitczak-recruitment.westeurope.cloudapp.azure.com:8080/rest/task";
        String downloadedJson = null;


        AuthenticationService authenticationService = new AuthenticationService();

        OkHttpClient okHttpClient;
        okHttpClient = createAuthenticatedClient(login, password);
        downloadedJson = collectStringDataFromUrl(okHttpClient, url);

        System.out.println(downloadedJson);

        JsonParserService jsonParserService = new JsonParserService();

        List<Integer> list = jsonParserService.ParseJsonToDownloadedData(downloadedJson).getData();
        PrimesFinderService primesFinderService = new PrimesFinderService();

        // primesFinderService.foundPrimes(list).stream().forEach(e-> System.out.println(e));
        System.out.println(primesFinderService.foundPrimes(list).toString());
    }
}
