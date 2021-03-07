package grps.example;

import grps.example.serrvice.HelloServiceImplementation;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloServiceImplementation())
                .build();

        System.out.println("trying to start server");
        server.start();
        System.out.println("server started successful");
        server.awaitTermination();
        System.out.println("server stopped successful");

    }
}
