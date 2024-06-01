## 项目结构
```
RuoYi-Vue-Plus
├─ ruoyi-admin                         // 管理模块 [8080,9101]
│  └─ RuoYiApplication                 // 启动类
│  └─ RuoYiServletInitializer          // 容器部署初始化类
│  └─ resources                        // 资源文件
│      └─ i18n/messages.properties     // 国际化配置文件
│      └─ application.yml              // 框架总配置文件
│      └─ application-dev.yml          // 开发环境配置文件
│      └─ application-prod.yml         // 生产环境配置文件
│      └─ banner.txt                   // 框架启动图标
│      └─ logback.xml                  // 日志配置文件
│      └─ spy.properties               // p6spy配置文件
│      └─ ip2region.xdb                // IP区域地址库
├─ ruoyi-extend                        // 扩展模块
│  └─ ruoyi-monitor-admin              // admin监控模块 [9090]
├─ ruoyi-common                        // 通用模块
│  └─ ruoyi-common-bom                 // common依赖包管理
│  └─ ruoyi-common-core                // 核心模块
│  └─ ruoyi-common-doc                 // 系统接口模块
│  └─ ruoyi-common-encrypt             // 数据加解密模块
│  └─ ruoyi-common-excel               // excel模块
│  └─ ruoyi-common-idempotent          // 幂等功能模块
│  └─ ruoyi-common-json                // 序列化模块
│  └─ ruoyi-common-log                 // 日志模块
│  └─ ruoyi-common-mybatis             // 数据库模块
│  └─ ruoyi-common-oss                 // oss服务模块
│  └─ ruoyi-common-ratelimiter         // 限流功能模块
│  └─ ruoyi-common-redis               // 缓存服务模块
│  └─ ruoyi-common-satoken             // satoken模块
│  └─ ruoyi-common-security            // 安全模块
│  └─ ruoyi-common-sensitive           // 脱敏模块
│  └─ ruoyi-common-tenant              // 租户模块
│  └─ ruoyi-common-translation         // 通用翻译模块
│  └─ ruoyi-common-web                 // web模块
│  └─ ruoyi-common-websocket           // websocket服务集成模块
├─ ruoyi-modules                       // 模块组
│  └─ ruoyi-demo                       // 演示模块
│  └─ ruoyi-generator                  // 代码生成模块
│  └─ ruoyi-system                     // 业务模块
├─ ruoyi-web               // 前端框架 [80]
├─ script                // 系统脚本包
│  └─ docker                           // docker相关脚本
│  └─ sql                              // sql脚本
├─ .editorconfig        // 编辑器编码格式配置
├─ pom.xml              // 公共依赖
├─ README.md            // 框架说明文件
```