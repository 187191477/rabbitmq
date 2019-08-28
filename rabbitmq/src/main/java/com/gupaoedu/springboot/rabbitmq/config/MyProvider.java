package com.gupaoedu.springboot.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:lxc
 * @Date:9:18 2019/8/28
 * @Description:
 * @Modified By:
 * @Version:
 */
@Component
public class MyProvider {
    @Autowired
    AmqpTemplate amqpTemplate;
    public void send(){
        amqpTemplate.convertAndSend("DIRECT_EXCHANGE","gupao","a direct msg");
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","hello.gupao.haha","msg==>hello.gupao.haha");
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","gupao.java","msg==>gupao.java");

        amqpTemplate.convertAndSend("FANOUT_EXCHANGE","","fanout==>fanout msg");
    }
}
