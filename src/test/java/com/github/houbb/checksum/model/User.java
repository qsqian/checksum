package com.github.houbb.checksum.model;

import com.github.houbb.checksum.annotation.CheckField;
import com.github.houbb.checksum.annotation.Checksum;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public class User {

    @CheckField
    private String name;

    @CheckField
    private String password;

    private String address;

    @Checksum
    private String checksum;

    public String name() {
        return name;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public String password() {
        return password;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public String address() {
        return address;
    }

    public User address(String address) {
        this.address = address;
        return this;
    }

    public String checksum() {
        return checksum;
    }

    public User checksum(String checksum) {
        this.checksum = checksum;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", checksum='" + checksum + '\'' +
                '}';
    }

}
