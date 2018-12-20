package com.example.grpcportbug;

import com.example.grpc.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FailingTest {

    @Test
    public void can_get_greeting() {
        // Given
        GreetingTestClient testClient = new GreetingTestClient("localhost", 6565);

        // When
        Greeting greeting = testClient.sayHello("Bob");

        // Then
        assertThat(greeting.getMessage()).isEqualTo("Hello Bob");
    }

}

