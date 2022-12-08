package com.susu.spring.context;

import com.susu.spring.beans.BeansException;

/**
 * <p>Description: 配置应用上下文和控制应用上下文生命周期</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * <p>Description: 加载资源配置文件（XML、properties,Whatever）</p>
     * <pre>
     *     由于此方法是一个初始化方法，因此如果调用此方法失败的情况下，要将其已经创建的Bean销毁 <br/>
     *     换句话说，调用此方法以后，要么所有的Bean都实例化好了，要么就一个都没有实例化
     * </pre>
     */
    void refresh() throws BeansException;

    /**
     * <p>Description: 加关闭此应用上下文 </p>
     * <pre>
     *     关闭此应用上下文，释放其所占有的所有资源和锁。并销毁其所有创建好的 Bean <br/>
     *     实现的时候，此方法不应该调用其父上下文的close方法，因为其父上下文具有自己独立的生命周期 <br/>
     *     次调用此方法，除了第一次，后面的调用应该被忽略 <br/>
     * </pre>
     */
    void close();

    /**
     * <p>Description: 向JVM注册一个回调函数，用以在JVM关闭时，销毁此应用上下文 </p>
     */
    void registerShutdownHook();
}
