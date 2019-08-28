package com.gupaoedu.javaapi;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author:lxc
 * @Date:17:57 2019/8/25
 * @Description:
 * @Modified By:
 * @Version:
 */
public class MyConsumer {
//    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
//    private final static String QUEUE_NAME = "SIMPLE_QUEUE";
    private final static String EXCHANGE_NAME = "FIRST_EXCHANGE";
    private final static String QUEUE_NAME = "FIRST_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.10.67");
        factory.setPort(5672);
        factory.setVirtualHost("admin_vhost");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
//        1、channel.exchangeDeclare(EXCHANGE_NAME,"Fanout",false,false,null);
//        2、channel.exchangeDeclare(EXCHANGE_NAME,"topic",false,false,null);
//        channel.exchangeDeclare(EXCHANGE_NAME,"fanout",false,false,null);
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        System.out.println("Waiting for msg");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"UTF-8");
                System.out.println("Received message : '" + msg + "'");
                System.out.println("consumerTag : " + consumerTag );
                System.out.println("deliveryTag : " + envelope.getDeliveryTag() );
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }

}
