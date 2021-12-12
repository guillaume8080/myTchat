package com.example.ynocchat2;

public class Message {

    String content;
    String created_at;
    User my_user;

    public Message(String content, String created_at, User my_user) {
        this.content = content;
        this.created_at = created_at;
        this.my_user = my_user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public User getMy_user() {
        return my_user;
    }

    public void setMy_user(User my_user) {
        this.my_user = my_user;
    }
}
