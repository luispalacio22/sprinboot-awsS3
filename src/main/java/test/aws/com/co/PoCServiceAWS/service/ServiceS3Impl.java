package test.aws.com.co.PoCServiceAWS.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import test.aws.com.co.PoCServiceAWS.model.Request;
import test.aws.com.co.PoCServiceAWS.parameter.Parameter;

import java.io.File;
import java.io.IOException;

@Service
public class ServiceS3Impl implements ServiceS3 {

    private Parameter parameter;
    private AmazonS3 setS3;

    public ServiceS3Impl(Parameter parameter, AmazonS3 setS3) {
        this.parameter = parameter;
        this.setS3 = setS3;
    }

    @Override
    public String savefile(Request request) throws JSONException {
        PutObjectResult putObjectResult = setS3.putObject(parameter.getBucketName(), request.getFileName(), new File(request.getUrlFile()));
        JSONObject json = new JSONObject();
        if (null != putObjectResult) {
            json.append("status", "ok");
        } else {
            json.append("status", "error");
        }
        return json.toString();
    }

    @Override
    public String downloadFile(Request request) throws IOException, JSONException {
        S3Object s3Object = setS3.getObject(parameter.getBucketName(), request.getFileName());
        S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent();
        FileUtils.copyInputStreamToFile(s3ObjectInputStream, new File(request.getUrlFile()));
        JSONObject json = new JSONObject();
        json.append("status", "ok");
        return json.toString();
    }

    @Override
    public String deleteFile(Request request) throws JSONException {
        setS3.deleteObject(parameter.getBucketName(),request.getFileName());
        JSONObject json = new JSONObject();
        json.append("status", "ok");
        return json.toString();

    }


}
