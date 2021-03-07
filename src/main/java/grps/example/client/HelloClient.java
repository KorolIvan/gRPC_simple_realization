package grps.example.client;

import grps.example.service.HelloRequest;
import grps.example.service.HelloResponse;
import grps.example.service.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub =
                HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse response =    stub.greeting(
                HelloRequest.newBuilder()
                        .setFirstName("FirstName")
                        .setLastName("LastName")
                        .build()
        );

        System.out.printf("Received response from the server: %s%n", response);

        channel.shutdown();
    }
}
