package com.example.grpcportbug;


import com.example.grpc.GreeterGrpc;
import com.example.grpc.Greeting;
import com.example.grpc.Name;
import io.grpc.ManagedChannelBuilder;

public class GreetingTestClient {

    private final GreeterGrpc.GreeterBlockingStub stub;

    public GreetingTestClient(String address, int port) {
        stub = GreeterGrpc.newBlockingStub(ManagedChannelBuilder.forAddress(address, port)
                .usePlaintext()
                .build());
    }

    public Greeting sayHello(String name) {
        return stub.greet(Name.newBuilder().setName(name).build());
    }
}
