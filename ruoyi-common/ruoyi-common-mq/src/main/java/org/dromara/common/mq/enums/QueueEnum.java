package org.dromara.common.mq.enums;

import lombok.Getter;

@Getter
public enum QueueEnum {
    /**
     * 订单取消
     */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    QUEUE_ORDER_FANOUTA("mall.order. fanout", "mall.order. fanoutA", "mall.order. fanout"),
    QUEUE_ORDER_FANOUTB("mall.order.fanout", "mall.order.fanoutB", "mall.order.fanout")

    ;

    /**
     * 交换名称
     */
    private final String exchange;
    /**
     * 队列名称
     */
    private final String name;
    /**
     * 路由键
     */
    private final String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
