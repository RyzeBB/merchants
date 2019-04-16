package com.imooc.passbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class MerchantsApplication{

    public static void main(String[] args) {
        SpringApplication.run(MerchantsApplication.class, args);
    }
}
