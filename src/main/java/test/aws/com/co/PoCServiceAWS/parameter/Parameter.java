package test.aws.com.co.PoCServiceAWS.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Parameter {

    @Value("${parameter.access.key}")
    private String accessKey;

    @Value("${parameter.secret.key}")
    private String secretKey;

    @Value("${parameter.name.bucket}")
    private String bucketName;

    public String getBucketName() {
        return bucketName;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
