package br.com.rest.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Pessoa {

    private String Id;
    private String name;
    private String email;
    private String password;

    public Pessoa(String name, String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
