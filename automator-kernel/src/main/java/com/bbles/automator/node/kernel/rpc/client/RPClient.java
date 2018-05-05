package com.bbles.automator.node.kernel.rpc.client;

import com.bbles.automator.node.kernel.action.SystemCallHandler;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.AbstractStub;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * Abstract class to abstract an RPC Client
 */
public class RPClient<T extends AbstractStub> {

    private Log logger = LogFactory.getLog(RPClient.class);
    private T stub;

    public RPClient(String host, int port, Class<? extends AbstractStub> klass, boolean blocking) {
        this(ManagedChannelBuilder.forAddress(host, port), klass, blocking);
        logger.info("Starting RPC Client rpc://" + host + ":" + port);
    }

    private RPClient(ManagedChannelBuilder builder, Class<? extends AbstractStub> klass, boolean blocking) {
        try {
            this.stub = (T) klass.getMethod("newBlockingStub", ManagedChannel.class).invoke(builder.build());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public T getChannel() {
        return stub;
    }

}