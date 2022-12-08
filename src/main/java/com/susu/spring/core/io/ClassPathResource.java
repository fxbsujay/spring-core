package com.susu.spring.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Description: classpath下的资源</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public class ClassPathResource implements Resource {

    private final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if (in == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return in;
    }
}
