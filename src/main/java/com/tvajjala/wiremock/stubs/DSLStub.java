package com.tvajjala.wiremock.stubs;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Writing stubs using DSL syntax
 *
 * @author ThirupathiReddy Vajjala
 */
@Component
public class DSLStub implements CommandLineRunner {


    @Autowired
    WireMockServer wireMockServer;


    @Override
    public void run(String... args) {

        wireMockServer.stubFor(get(urlEqualTo("/welcome"))
                .willReturn(aResponse()
                        .withBodyFile("welcome.html")));

    }


}
