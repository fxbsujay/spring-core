package com.susu.spring.context.annotation;


import cn.hutool.core.util.StrUtil;
import com.susu.spring.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import com.susu.spring.beans.factory.config.BeanDefinition;
import com.susu.spring.beans.factory.support.BeanDefinitionRegistry;
import com.susu.spring.core.stereotype.Component;
import java.util.Set;

/**
 * <p>Description: Bean 扫描器 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-12
 */
public class ClassPathBeanDefinitionScanner extends  ClassPathScanningCandidateComponentProvider {

    /**
     * 自动注入Bean注解
     */
    public static final String AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME = "org.springframework.context.annotation.internalAutowiredAnnotationProcessor";

    /**
     * 注册表
     */
    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition candidate : candidates) {
                // 解析bean的作用域
                String beanScope = resolveBeanScope(candidate);
                if (StrUtil.isNotEmpty(beanScope)) {
                    candidate.setScope(beanScope);
                }
                String beanName = determineBeanName(candidate);
                // 注册BeanDefinition
                registry.registerBeanDefinition(beanName, candidate);
            }
            // 生成bean的名称
        }

        // 注册处理@Autowired和@Value注解的BeanPostProcessor
        registry.registerBeanDefinition(AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME, new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));
    }

    /**
     * 获取bean的作用域
     */
    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (scope != null) {
            return scope.value();
        }

        return StrUtil.EMPTY;
    }

    /**
     * 生成bean的名称
     */
    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }

}
