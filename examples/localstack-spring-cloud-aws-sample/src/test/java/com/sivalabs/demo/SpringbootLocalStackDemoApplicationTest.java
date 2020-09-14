package com.sivalabs.demo;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.github.sivalabs.localstack.LocalStackProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("integration-test")
public class SpringbootLocalStackDemoApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void shouldAutoConfigureLocalStackServices() {
        assertThat(context.getBean(LocalStackProperties.class)).isNotNull();
        assertThat(context.getBean(AmazonS3.class)).isNotNull();
        assertThat(context.getBean(AmazonSQSAsync.class)).isNotNull();
    }
}
