package pl.mj.service;

import org.junit.Assert;
import org.junit.Test;
import pl.mj.exception.InvalidJsonInputException;

import java.io.IOException;

import static org.junit.Assert.*;

public class JsonParserServiceTest {
    JsonParserService jsonParserService = new JsonParserService();


    final static String CORRECT_JSON_IN_STRING = "{\"id\":\"a2a77bc3-f6fb-469b-ab02-b9833e7a550f\",\"size\":10,\"data\":[8,90,130,109,13,38,60,677,13,999]}";
    final static String INCORRECT_JSON_IN_STRING = "{\"id\":\"a2a77bc3-f6fb-469b-ab02-b9833e7a550f\",\"size\":3,\"data\":[8,90,130,109]}";


    @Test
    public void shouldGetInformationAboutListSizeAndValidate() throws IOException, InvalidJsonInputException {

        Assert.assertEquals(10, jsonParserService.ParseJsonToDownloadedData(CORRECT_JSON_IN_STRING).getSize());
        Assert.assertEquals(10, jsonParserService.ParseJsonToDownloadedData(CORRECT_JSON_IN_STRING).getData().size());
    }

    @Test(expected = InvalidJsonInputException.class)
    public void shouldThrowExceptionWhenGivenSizeDifferentFromListSize() throws IOException, InvalidJsonInputException {
        jsonParserService.ParseJsonToDownloadedData(INCORRECT_JSON_IN_STRING);

    }


}