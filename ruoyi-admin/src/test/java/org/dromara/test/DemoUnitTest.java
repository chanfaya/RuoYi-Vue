package org.dromara.test;

import jakarta.annotation.Resource;
import org.dromara.common.mq.product.DirectProducter;
import org.dromara.common.mq.product.FanoutProducer;
import org.dromara.common.mq.product.SimpleProducer;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 单元测试案例
 *
 * @author Lion Li
 */
@SpringBootTest // 此注解只能在 springboot 主包下使用 需包含 main 方法与 yml 配置文件
@DisplayName("单元测试案例")
public class DemoUnitTest {

    @Resource
    private SimpleProducer simpleProducer;

    @Resource
    private FanoutProducer fanoutProducer;

    @Resource
    private DirectProducter directProducter;

    @DisplayName("测试 @SpringBootTest @Test @DisplayName 注解")
    @Test
    public void testTest() {
        // 这里是线程要执行的代码
//        simpleProducer.send(1);

        fanoutProducer.send(1);

    }

}
