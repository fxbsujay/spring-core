package com.susu.spring.test.ioc;

import cn.hutool.core.io.IoUtil;
import com.susu.spring.core.io.DefaultResourceLoader;
import com.susu.spring.core.io.FileSystemResource;
import com.susu.spring.core.io.Resource;
import com.susu.spring.core.io.UrlResource;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThat;

public class ResourceAndResourceLoaderTest {

    @Test
    public void resourceAndResourceLoaderTest() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assertThat(content).isEqualTo("hello world");

        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        assertThat(resource instanceof FileSystemResource).isTrue();
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assertThat(content).isEqualTo("hello world");

        resource = resourceLoader.getResource("https://github.com/fxbsujay/Sujay-Spring/blob/main/README.md");
        assertThat(resource instanceof UrlResource).isTrue();
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }
}
