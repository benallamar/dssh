package com.bbles.automator.node.kernel;

import com.bbles.automator.node.protobuf.ClientMasterProtocol;

/**
 * <b>{@docRoot com.bbles.automator.node.protobuf.MasterFollowerProtocol}</b>
 * @param <T>
 */
public interface OutputStreamObserver<T> {
    public void onError(Throwable throwable);

    public void onNext(T t);

    public void onCompleted();
}
