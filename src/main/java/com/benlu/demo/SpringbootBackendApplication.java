package com.benlu.demo;

import com.benlu.demo.service.FilesStorageService;
import com.benlu.demo.tools.TsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benlu.demo.repository.UserRepository;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {
    @Resource
    FilesStorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception {
        storageService.clearFiles();
        storageService.init();
    }
}