package com.susu.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Description: 资源的抽象和访问接口</p>
 *
 * @author fxbsujay@gmail.com
 * @version 1.0.0
 * @since 2022-12-08
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
