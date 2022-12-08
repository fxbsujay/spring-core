package com.susu.spring.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>Description: 默认的资源加载器</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public class DefaultResourceLoader implements ResourceLoader {

    public static final String CLASSPATH_URL_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) {

        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }

        try {
            URL url = new URL(location);
            return new UrlResource(url);
        } catch (MalformedURLException ex) {
            return new FileSystemResource(location);
        }
    }
}
