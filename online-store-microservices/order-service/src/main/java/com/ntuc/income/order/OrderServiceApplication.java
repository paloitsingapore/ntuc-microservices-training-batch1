package com.ntuc.income.order;

import com.ntuc.income.order.service.OrderService;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients  // 1
@RestController   // 2
@Slf4j
public class OrderServiceApplication {

  @Autowired              // 3
      OrderService.ItemServiceClient itemServiceClient;

  public static void main(String[] args) {
    SpringApplication.run(OrderServiceApplication.class, args);
  }

  @GetMapping("/hello")       //4
  public String sayHello(HttpServletRequest request){
    log.info("Server Name : {}, Server Port: {}", request.getServerName(), request.getServerPort());
    return itemServiceClient.greetFromItemService() + " from " + request.getServerPort() ;
  }

  //@FeignClient(name="item-service")       //5
  //interface ItemServiceClient {
  //
  //  @GetMapping("/greet")
  //  public String greetFromItemService();
  //}
}
