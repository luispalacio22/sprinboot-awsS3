package test.aws.com.co.PoCServiceAWS.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.aws.com.co.PoCServiceAWS.parameter.Parameter;

@Configuration
public class ConfigConnection {

    private Parameter parameter;

    public ConfigConnection(Parameter parameter) {
        this.parameter = parameter;
    }

    @Bean
    public AmazonS3 setS3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(parameter.getAccessKey(), parameter.getSecretKey());
        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.US_EAST_1).build();
    }
}
