package com.spotqa.virtuoso;

import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;

@WebSocket(path = "/virt-agent")
public class VirtAgentWebSocket {

    private final VirtAgent virtAgent;

    public VirtAgentWebSocket(VirtAgent virtAgent) {
        this.virtAgent = virtAgent;
    }

    @OnOpen
    public String onOpen() {
        return "I am Virt! How can I help you today?";
    }

    @OnTextMessage
    public String onTextMessage(String message) {
        return virtAgent.chat(message);
    }
}
