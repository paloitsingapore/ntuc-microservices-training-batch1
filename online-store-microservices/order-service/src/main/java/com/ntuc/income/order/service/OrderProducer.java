package com.ntuc.income.order.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@EnableBinding(Source.class)
@Component
public class OrderProducer {

  private final Source source;

  public OrderProducer(Source source){
    this.source =source;
  }

  public void sendOrder(String itemNumber){
    Message<String> message = MessageBuilder.withPayload(itemNumber)
        .build();
    source.output().send(message);
  }

}
