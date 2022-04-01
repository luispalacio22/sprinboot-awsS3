package test.aws.com.co.PoCServiceAWS.service;

import org.json.JSONException;
import test.aws.com.co.PoCServiceAWS.model.Request;

import java.io.IOException;

public interface ServiceS3 {
    String savefile(Request request) throws JSONException;

    String downloadFile(Request request) throws IOException, JSONException;

    String deleteFile(Request request) throws JSONException;
}
