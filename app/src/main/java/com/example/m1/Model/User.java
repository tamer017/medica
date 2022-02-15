package com.example.m1.Model;

public class User {

    private String f_name;
    private String l_name;

    private String email;
    private String gender;
    private String phone_number;
    private int age;
    private String doPa;
    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(String f_name, String l_name, String email, String gender, String phone_number, int age, String doPa) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.gender = gender;
        this.phone_number = phone_number;
        this.age = age;
        this.doPa = doPa;
    }

    public String getGender() {
        return gender;
    }

    public String getDoPa() {
        return doPa;
    }

    public void setDoPa(String doPa) {
        this.doPa = doPa;
    }

    @Override
    public String toString() {
        return "User{" +
                "f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", age=" + age +
                ", doPa='" + doPa + '\'' +
                '}';
    }





    public String getEmail() {
        return email;
    }



    public int getAge() {
        return age;
    }





    public String getF_name() {
        return f_name;
    }



    public String getL_name() {
        return l_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setAge(int age) {
        this.age = age;
    }

}
