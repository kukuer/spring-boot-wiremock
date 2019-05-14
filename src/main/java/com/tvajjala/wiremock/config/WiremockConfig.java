package com.tvajjala.wiremock.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Wiremock configuration server for optimum performance
 *
 * @author ThirupathiReddy Vajjala
 */
@Configuration
public class WiremockConfig {


    @Value("${wiremock.port}")
    private int mockServerPort;


    private static final Logger LOGGER = LoggerFactory.getLogger(WiremockConfig.class);


    @Bean
    public WireMockServer wireMockServer() {
        WireMockConfiguration configuration = WireMockConfiguration.wireMockConfig()
                // .bindAddress() //bindToSpecific IP address
                .port(mockServerPort)
                .preserveHostHeader(true)
                //TODO: Typically it is only necessary to tweak these settings if you are doing performance testing under significant loads.
                //Set the number of request handling threads in Jetty. Defaults to 10.
                .containerThreads(100)
                // Set the number of connection acceptor threads in Jetty. Defaults to 2.
                .jettyAcceptors(10)
                // Set the Jetty accept queue size. Defaults to Jetty's default of unbounded.
                .jettyAcceptQueueSize(100)
                // Set the size of Jetty's header buffer (to avoid exceptions when very large request headers are sent). Defaults to 8192.
                .jettyHeaderBufferSize(16834)
                .enableBrowserProxying(true)
                //.notifier(new Slf4jNotifier(true))
                .usingFilesUnderClasspath("contracts");// can be read from property file but no benefit with that

        LOGGER.info("Creating instance of WireMockServer with stubs location {}  ", "/root/contracts");//specific to docker image
        return new WireMockServer(configuration);
    }


}