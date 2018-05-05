package com.bbles.automator.server;

import com.google.protobuf.DynamicMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ServerChannel;
import io.netty.util.concurrent.Future;
import protobuf.CommandProtocol;
import protobuf.CommandProtocol.CommandExecution;

import java.io.IOException;

import io.netty.util.concurrent.EventExecutor;

public class ClientCli extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client " + ctx.channel().remoteAddress() + " is connected to the local server");
    }

    public void run() {
        while (true) {
            try {
                Channel i = new ServerChannel() {}
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

    }

    public static void main(String[] args) {
        ClientCli c = new ClientCli();
    }
}
