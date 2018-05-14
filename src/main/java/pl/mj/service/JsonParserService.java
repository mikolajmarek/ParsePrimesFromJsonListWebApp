package pl.mj.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.mj.data.DownloadedData;
import pl.mj.exception.InvalidJsonInputException;

import java.io.IOException;

public class JsonParserService {

    ObjectMapper mapper = new ObjectMapper();
    DownloadedData downloadedData;

    public DownloadedData ParseJsonToDownloaedData(String jsonData) throws IOException, InvalidJsonInputException {
        DownloadedData data;

        data =  mapper.readValue(jsonData, DownloadedData.class);
        if (data.getSize() == data.getData().size()){
            return data;
        }else {
            throw new InvalidJsonInputException("incorrect data in json");
        }
    }


}
