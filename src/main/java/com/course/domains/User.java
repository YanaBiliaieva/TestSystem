package com.course.domains;

import com.course.dto.UserDTO;

import java.io.Serializable;

public class User implements Serializable{

    private Long id;

    private String name;

    private String login;

    private String password;

    public User() {
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    ///for transformation UserDTO -> User
    public static class Builder{

        User user = new User();

        public User.Builder setName(UserDTO userDTO){
            user.setName(userDTO.getName());
            return this;
        }

        public User.Builder setLogin(UserDTO userDTO){
            user.setLogin(userDTO.getLogin());
            return this;
        }

        public User.Builder setPassword(UserDTO userDTO){
            user.setPassword(userDTO.getPassword());
            return this;
        }

        public User build(){
            return user;
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
