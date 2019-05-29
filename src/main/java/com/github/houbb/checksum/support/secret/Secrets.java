package com.github.houbb.checksum.support.secret;

import com.github.houbb.checksum.api.secret.ISecret;
import com.github.houbb.heaven.support.instance.impl.InstanceFactory;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public class Secrets {

    private Secrets(){}

    /**
     * 默认的加签策略
     * @return 加签策略
     */
    public static ISecret defaultMd5Secret() {
        return InstanceFactory.getInstance().singleton(DefaultMd5Secret.class);
    }

}
