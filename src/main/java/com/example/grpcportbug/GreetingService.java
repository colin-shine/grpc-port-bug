package com.example.grpcportbug;

import com.example.grpc.GreeterGrpc;
import com.example.grpc.Greeting;
import com.example.grpc.Name;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GreetingService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void greet(Name request, StreamObserver<Greeting> responseObserver) {
        Greeting greeting = Greeting.newBuilder()
                .setMessage("Hello " + request.getName())
                .build();
        responseObserver.onNext(greeting);
        responseObserver.onCompleted();
    }
}