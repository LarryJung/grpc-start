package com.larry.grpcstart.client;

import com.larry.grpcstart.HelloRequest;
import com.larry.grpcstart.HelloResponse;
import com.larry.grpcstart.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
//                .useTransportSecurity()
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.sayHello(HelloRequest.newBuilder()
                .setFirstName("larry")
                .setLastName("charry")
                .build());

        System.out.println(helloResponse.toString());
        channel.shutdown();
    }
}
