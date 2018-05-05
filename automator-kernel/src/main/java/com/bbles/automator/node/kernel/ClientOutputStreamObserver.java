package com.bbles.automator.node.kernel;

import io.grpc.stub.StreamObserver;

public class ClientOutputStreamObserver<T> implements OutputStreamObserver<T> {
    private StreamObserver<T> observer;

    public ClientOutputStreamObserver(StreamObserver<T> observer) {
        this.observer = observer;
    }

    public void onCompleted() {
        this.observer.onCompleted();
    }

    public void onError(Throwable throwable) {
        this.observer.onError(throwable);
    }

    @Override
    public void onNext(T t) {
        this.observer.onNext(t);
    }
}
