package pl.mj.service;

import okhttp3.*;
import pl.mj.exception.WrongCredentialException;

import java.io.IOException;


public class AuthenticationService {

    public static OkHttpClient createAuthenticatedClient(String username, String password) {
        OkHttpClient client = new OkHttpClient.Builder().authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws WrongCredentialException {
                String credential = Credentials.basic(username, password);
                if (responseCount(response) >= 3) {
                    throw new WrongCredentialException("wrong login or password");

                }
                return response.request().newBuilder().header("Authorization", credential).build();
            }
        }).build();
        return client;


    }

    public static String collectStringDataFromUrl(OkHttpClient client, String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private static int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            ++result;
        }
        return result;
    }
}
