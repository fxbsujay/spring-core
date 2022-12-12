package com.susu.spring.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.susu.spring.beans.factory.config.BeanDefinition;
import com.susu.spring.core.stereotype.Component;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>Description: 搜索添加 Component 注解的类 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-12
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        // 扫描有org.springframework.stereotype.Component注解的类
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            candidates.add(beanDefinition);
        }
        return candidates;
    }
}
