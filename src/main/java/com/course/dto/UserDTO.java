package com.course.dto;

import com.course.domains.User;


///class for working with data from db
public class UserDTO {

    private Long id;

    private String name;

    private String login;

    private String password;

    public UserDTO() {
    }

    public UserDTO(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    ///for transformation User -> UserDTO
    public static class Builder{

        UserDTO userDTO = new UserDTO();

        public Builder setName(User user){
            userDTO.setName(user.getName());
            return this;
        }

        public Builder setLogin(User user){
            userDTO.setLogin(user.getLogin());
            return this;
        }

        public Builder setPassword(User user){
            userDTO.setPassword(user.getPassword());
            return this;
        }

        public UserDTO build(){
            return userDTO;
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

}
