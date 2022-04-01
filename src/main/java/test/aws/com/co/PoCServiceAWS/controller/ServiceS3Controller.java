package test.aws.com.co.PoCServiceAWS.controller;

import org.json.JSONException;
import org.springframework.web.bind.annotation.*;
import test.aws.com.co.PoCServiceAWS.model.Request;
import test.aws.com.co.PoCServiceAWS.service.ServiceS3;

import java.io.IOException;

@RestController
public class ServiceS3Controller {

    private ServiceS3 serviceS3;

    public ServiceS3Controller(ServiceS3 serviceS3) {
        this.serviceS3 = serviceS3;
    }

    @PostMapping(value = "/s3/save-file",produces = {"application/json"})
    public String saveFile(@RequestBody Request request) throws JSONException {

        return serviceS3.savefile(request);
    }

    @GetMapping(value = "/s3/get-file",produces = {"application/json"} )
    public String getFile(@RequestBody Request request) throws JSONException, IOException {
        return  serviceS3.downloadFile(request);
    }

    @DeleteMapping(value = "/s3/delete-file",produces = {"application/json"})
    public String deleteFile(@RequestBody Request request) throws JSONException {
        return serviceS3.deleteFile(request);
    }
}
