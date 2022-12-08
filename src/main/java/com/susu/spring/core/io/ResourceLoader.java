package com.susu.spring.core.io;

/**
 * <p>Description: 资源加载器接口</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface ResourceLoader {

    /**
     * <p>Description: 根据资源路径获取资源</p>
     * <pre>
     *     For Example:
     *          location = classpath:xxx.xml
     * </pre>
     *
     * @param location 资源路径
     * @return 资源
     */
    Resource getResource(String location);
}
