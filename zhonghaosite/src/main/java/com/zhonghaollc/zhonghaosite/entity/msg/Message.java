package com.zhonghaollc.zhonghaosite.entity.msg;

public class Message {

    private String status;
    private String message;

    public Message(){
        status = "success";
        message = "";
    }

    public Message(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
