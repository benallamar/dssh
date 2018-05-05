package com.bbles.automator.node.kernel;

import io.grpc.stub.StreamObserver;

public class ClientOutputStreamObserver<T> implements OutputStreamObserver {
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

    public void onNext(T o) {
        this.observer.onNext(o);
    }
}
