package org.dromara.test;

import jakarta.annotation.Resource;
import org.dromara.common.core.config.RuoYiConfig;
import org.dromara.common.mq.product.DirectSender;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * 单元测试案例
 *
 * @author Lion Li
 */
@SpringBootTest // 此注解只能在 springboot 主包下使用 需包含 main 方法与 yml 配置文件
@DisplayName("单元测试案例")
public class DemoUnitTest {

    @Resource
    private DirectSender directSender;

    @DisplayName("测试 @SpringBootTest @Test @DisplayName 注解")
    @Test
    public void testTest() {

        // 这里是线程要执行的代码
        for (int i = 1; i < 20000; i++) {
            directSender.send(i);

        }
    }

}
