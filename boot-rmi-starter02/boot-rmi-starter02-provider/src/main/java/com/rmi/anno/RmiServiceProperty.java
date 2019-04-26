package com.rmi.anno;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.rmi.registry.Registry;

/**
 * 指定服务端口号
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RmiServiceProperty {
    int registryPort() default Registry.REGISTRY_PORT;
}