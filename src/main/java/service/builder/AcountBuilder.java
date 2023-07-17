package service.builder;

import entity.Acount;

public class AcountBuilder {
    private int id;
    private String name;
    private String email;
    private String password;
    private String state;
    public AcountBuilder withId(int id){
        this.id = id;
        return this;
    }
    public AcountBuilder withName(String name){
        this.name = name;
        return this;
    }
    public AcountBuilder withEmail(String email){
        this.email = email;
        return this;
    }
    public AcountBuilder withPassword(String password){
        this.password = password;
        return this;
    }
    public AcountBuilder withState(String state){
        this.state = state;
        return this;
    }
    public Acount builder(){
        return new Acount(id,name,email,password,state);
    }
}
