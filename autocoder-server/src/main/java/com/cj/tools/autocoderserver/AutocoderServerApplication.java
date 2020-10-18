package com.cj.tools.autocoderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cj.tools.**"})
public class AutocoderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutocoderServerApplication.class, args);
    }

}
