package grps.example.serrvice;

import grps.example.service.HelloRequest;
import grps.example.service.HelloResponse;
import grps.example.service.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImplementation extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String stringBuilder = new StringBuilder()
                .append("Hey")
                .append(" ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .append("!")
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(stringBuilder)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
