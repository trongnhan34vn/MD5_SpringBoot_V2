package com.md5_ss15_baitap.dto.response;

public class ResponseMessenger {
    private String messenger;

    public ResponseMessenger(String messenger) {
        this.messenger = messenger;
    }

    public ResponseMessenger() {
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }
}
