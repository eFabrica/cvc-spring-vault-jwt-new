package br.com.service.doit.model;

import lombok.Data;

@Data
public class AuthToken {

    private String token;

    public AuthToken(){
    }

    public AuthToken(String token){
        this.token = token;
    }


}