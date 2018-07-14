package com.bbles.automator.node.kernel.security;

public class Token {
    public static Token getInstance(byte[] token) {
        return new Token();
    }

    public byte[] toByte() {
        return new byte[5];
    }
}
