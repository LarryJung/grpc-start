package com.larry.grpcstart.server;

import com.larry.grpcstart.HelloRequest;
import com.larry.grpcstart.HelloResponse;
import com.larry.grpcstart.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request,
                         StreamObserver<HelloResponse> responseObserver) {
        System.out.println("request comming : " + request.toString());
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response); // 이렇게 하면 단일만 보내고 끝내나?
        responseObserver.onCompleted();
    }
}
