package org.dromara.common.mq.consumer;

import org.dromara.common.mq.enums.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "mall.order.cancel")
public class DirectReceiver {
    Logger LOG = LoggerFactory.getLogger(DirectReceiver.class);

    @RabbitHandler
    public void receiverMsg(String msg){
        LOG.info("class:{},message:{}","DirectReceiver",msg);
    }
}
