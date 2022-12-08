package com.susu.spring.beans.factory.config;

import com.susu.spring.beans.PropertyValues;
import java.util.Objects;

/**
 * <p>Description: 保存 Bean 的信息 </p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public class BeanDefinition {

    /**
     * <pre>
     *     所有对id或id匹配该bean定义的bean的请求都会导致Spring容器返回一个特定的bean实例 <br/>
     *     当定义一个singleton bean,Spring IoC容器将会创建一个由该Bean定义的对象实例 <br/>
     *     该单个实例存储在缓存中 <br/>
     *     对该bean所有以后请求和引用都将返回这个缓存中的对象实例.可以更好的重用对象 <br/>
     * </pre>
     */
    public static String SCOPE_SINGLETON = "singleton";

    /**
     * <pre>
     *     每次对该特定的Bean请求时创建一个新的Bean实例.从某种意义上来说 <br/>
     *     Spring容器在prototype bean上的作用等同于java的new操作符
     * </pre>
     */
    public static String SCOPE_PROTOTYPE = "prototype";

    private Class beanClass;

    /**
     *  Bean 附加额外的属性信息
     */
    private PropertyValues propertyValues;

    /**
     * 创建一个 Bean 之后调用该方法，初始化方法必须是一个无参方法
     */
    private String initMethodName;

    /**
     * 它的作用是在销毁 Bean 之前可以执行指定的方法，<br/>
     * 必须满足 scope=“singleton” ，并且destroy方法参数个数不能超过 1 ，并且参数类型只能为 boolean
     */
    private String destroyMethodName;


    /**
     * 默认为单例对象
     */
    private String scope = SCOPE_SINGLETON;

    /**
     * 是否创建单实例对象 <br/>
     * singleton在配置文件加载的时候就会创建一个单实例对象
     */
    private boolean singleton = true;

    /**
     * 是否创建多实例对象 <br/>
     * prototype在加载完spring配置文件，调用getBean的时候才会创建对象
     */
    private boolean prototype = false;

    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isSingleton() {
        return this.singleton;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeanDefinition that = (BeanDefinition) o;
        return beanClass.equals(that.beanClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beanClass);
    }
}
