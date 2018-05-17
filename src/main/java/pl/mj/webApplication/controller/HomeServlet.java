package pl.mj.webApplication.controller;

import okhttp3.OkHttpClient;
import pl.mj.exception.IncorrectSizeOfListException;
import pl.mj.exception.InvalidJsonInputException;
import pl.mj.exception.NoPrimeFoundException;
import pl.mj.service.JsonParserService;
import pl.mj.service.PrimesFinderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static pl.mj.service.AuthenticationService.collectStringDataFromUrl;
import static pl.mj.service.AuthenticationService.createAuthenticatedClient;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    String listOfPrimes = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String url = "http://dt-gwitczak-recruitment.westeurope.cloudapp.azure.com:8080/rest/task";


        OkHttpClient client = createAuthenticatedClient(login, password);
        String data = null;

        data = collectStringDataFromUrl(client, url);

        JsonParserService jsonParserService = new JsonParserService();

        List<Integer> list = null;
        try {
            list = jsonParserService.ParseJsonToDownloadedData(data).getData();
        } catch (InvalidJsonInputException e) {
            e.printStackTrace();
        }
        PrimesFinderService primesFinderService = new PrimesFinderService();

        try {
            listOfPrimes = primesFinderService.foundPrimes(list).toString();
        } catch (IncorrectSizeOfListException e) {
            e.printStackTrace();
        } catch (NoPrimeFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("listOfPrimes", listOfPrimes);
        request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("index.jsp").forward(request, response);


    }
}
