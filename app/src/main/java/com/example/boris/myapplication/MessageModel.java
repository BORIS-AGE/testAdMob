package com.example.boris.myapplication;

public class MessageModel {
    private int image;
    private String text;
    private MessageType messageType;
    private long date;

    public MessageModel(int image, String text, MessageType messageType, long date) {
        this.image = image;
        this.text = text;
        this.messageType = messageType;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
