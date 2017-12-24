package com.springboot.studentmanagementsystem.types;

public enum Status {
    ACTIVE("active"),
    INACTIVE("inactive");

    private String name;

    private Status(String name){
        this.name = name;
    }
}
