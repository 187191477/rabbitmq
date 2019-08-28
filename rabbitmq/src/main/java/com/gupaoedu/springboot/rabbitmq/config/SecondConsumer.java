package com.gupaoedu.springboot.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author:lxc
 * @Date:9:30 2019/8/28
 * @Description:
 * @Modified By:
 * @Version:
 */
@Component
@RabbitListener(queues = "SECOND_QUEUE")
public class SecondConsumer {
    @RabbitHandler
    public void process(String msg){
        System.out.println("second queue received msg:" + msg);
    }
}
