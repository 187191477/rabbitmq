package com.gupaoedu.springboot.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:lxc
 * @Date:21:23 2019/8/27
 * @Description:
 * @Modified By:
 * @Version:
 */
@Configuration
public class RabbitConfig {
    @Bean("topicExchange")
    public TopicExchange getTopicExchange(){
        return new TopicExchange("TOPIC_EXCHANGE");
    }
    @Bean("fanoutExchange")
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange("FANOUT_EXCHANGE");
    }
    @Bean("directExchange")
    public DirectExchange getDirectExchange(){
        return new DirectExchange("DIRECT_EXCHANGE");
    }
    @Bean("firstQueue")
    public Queue getFirstQueue(){
        Map<String,Object> args = new HashMap<String,Object>();
        args.put("x-message-ttl",600000);
        Queue queue = new Queue("FIRST_QUEUE",false,false,false,args);
        return queue;
    }
    @Bean("secondQueue")
    public Queue getSecondQueue(){
        return new Queue("SECOND_QUEUE");
    }
    @Bean("thirdQueue")
    public Queue getThirdQueue(){return new Queue("THIRD_QUEUE");}
    @Bean
    public Binding bindFirst(@Qualifier("firstQueue") Queue queue,@Qualifier("directExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("gupao");
    }
    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue,@Qualifier("topicExchange") TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("gupao.#");
    }
    @Bean
    public Binding bindThird(@Qualifier("thirdQueue") Queue queue,@Qualifier("fanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }
}
