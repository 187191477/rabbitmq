package com.gupaoedu.javaapi;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author:lxc
 * @Date:17:47 2019/8/25
 * @Description:
 * @Modified By:
 * @Version:
 */
public class MyProducer {
    private final static String EXCHANGE_NAME = "FIRST_EXCHANGE";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.10.67");
        factory.setPort(5672);
        factory.setVirtualHost("admin_vhost");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        String msg = "hello rabbitmq";
//        1、channel.basicPublish(EXCHANGE_NAME,"gupao.best",null,msg.getBytes());
        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());
        channel.close();
        conn.close();
    }
}
