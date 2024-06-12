package org.dromara.common.mq.config;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.dromara.common.mq.enums.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq 配置类
 */
@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Bean
    //@Primary
    public AmqpTemplate amqpTemplate(){
        Logger LOG = LoggerFactory.getLogger(AmqpTemplate.class);
        //使用jackson 消息转换器(发送对象时候才开启)
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
        rabbitTemplate.setMandatory(true);
        // 开启returncallback    yml 需要配置publisher-returns: true
//        rabbitTemplate.setReturnCallback(((message,  replyCode, replyText, exchange, routingKey) -> {
//            String correlationId = message.getMessageProperties().getCorrelationId();
//            LOG.info("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
//        }));
        //开启消息确认  yml 需要配置   publisher-returns: true
        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) ->{
            if (ack) {
                LOG.info("消息发送到交换机成功,correlationId:{}",correlationData.getId());
            } else {
                LOG.info("消息发送到交换机失败,原因:{}",cause);
            }
        } ));
        return rabbitTemplate;
    }

    /**
     * 声明直连交换机 支持持久化.
     * @return the exchange
     */
    @Bean("orderDirect")
    public DirectExchange  directExchange() {
        return ExchangeBuilder.directExchange(QueueEnum.QUEUE_ORDER_CANCEL.getExchange()).durable(true).build();
    }

    @Bean("orderQueue")
    public Queue directQueue(){
        return new Queue(QueueEnum.QUEUE_ORDER_CANCEL.getName(), true, false, false);
    }

    @Bean
    public Binding directBinding(DirectExchange orderDirect,Queue orderQueue){
        return BindingBuilder
            .bind(orderQueue)
            .to(orderDirect)
            .with(QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey());
    }

    // 订阅模式
    @Bean("fanoutQueueA")
    public Queue fanoutExchangeQueueA(){
        return new Queue(QueueEnum.QUEUE_ORDER_FANOUTA.getName(), true, false, false);
    }

    @Bean("fanoutQueueB")
    public Queue fanoutExchangeQueueB(){
        return new Queue(QueueEnum.QUEUE_ORDER_FANOUTB.getName(), true, false, false);
    }

    @Bean
    public FanoutExchange rabbitmqDemoFanoutExchange() {
        //创建FanoutExchange类型交换机
        return new FanoutExchange(QueueEnum.QUEUE_ORDER_FANOUTA.getExchange(), true, false);
    }

    @Bean
    public Binding bindFanoutA(FanoutExchange fanoutExchange, Queue fanoutQueueA) {
        //队列A绑定到FanoutExchange交换机
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindFanoutB(FanoutExchange fanoutExchange, Queue fanoutQueueB) {
        //队列B绑定到FanoutExchange交换机
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }
}
