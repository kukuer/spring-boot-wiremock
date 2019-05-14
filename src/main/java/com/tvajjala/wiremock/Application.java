package com.tvajjala.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * Entry point to WireMock Server
 *
 * @author ThirupathiReddy Vajjala
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    WireMockServer wireMockServer;

    @Override
    public void run(String... args) {

        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));

        wireMockServer.start();
    }
}
