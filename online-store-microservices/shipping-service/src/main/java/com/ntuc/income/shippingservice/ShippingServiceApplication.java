package com.ntuc.income.shippingservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
@EnableBinding(Sink.class)
@Slf4j
public class ShippingServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShippingServiceApplication.class, args);
  }

  @StreamListener(Sink.INPUT)
  public void listen(@Payload String itemNumber){
    log.info("Item received {}", itemNumber);
  }
}
