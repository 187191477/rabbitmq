package com.gupaoedu.springboot.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author:lxc
 * @Date:9:28 2019/8/28
 * @Description:
 * @Modified By:
 * @Version:
 */
@Component
@RabbitListener(queues = "FIRST_QUEUE")
public class FirstConsumer {
    @RabbitHandler
    public void process(String msg){
        System.out.println("first queue received msg:" + msg);
    }
}
