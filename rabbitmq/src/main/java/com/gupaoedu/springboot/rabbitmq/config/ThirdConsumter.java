package com.gupaoedu.springboot.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author:lxc
 * @Date:9:32 2019/8/28
 * @Description:
 * @Modified By:
 * @Version:
 */
@Component
@RabbitListener(queues = "THIRD_QUEUE")
public class ThirdConsumter {
    @RabbitHandler
    public void process(String msg){
        System.out.println("third queue received msg:" + msg);
    }
}
