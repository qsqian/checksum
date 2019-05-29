# checksum

基于 java 注解生成加签验签 checksum。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/checksum/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/checksum)
[![Build Status](https://www.travis-ci.org/houbb/checksum.svg?branch=master)](https://www.travis-ci.org/houbb/checksum?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/houbb/checksum/badge.svg?branch=master)](https://coveralls.io/github/houbb/checksum?branch=master)

## 创作缘由

原来的代码中，checksum 的生成是用的工具类方法。

后来发现如下的问题：

1. 有些字段太大，不想参与验签，但是无法方便的调整。

2. 不同系统的 checksum 字段不同，只好把工具方法 copy 过去，改来改去。

感觉这样有很大的弊端，完全失去了灵活性。

## 特性

- 基于注解的 checksum 加签验签

- Fluent 流式语法

- 支持灵活的策略自定义

## 更新记录

> [更新记录](doc/CHANGE_LOG.md)

# 快速开始

## 环境要求

jdk7+

maven 3.x+

## 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>checksum</artifactId>
    <version>0.0.1</version>
</dependency>
```

## 定义待加签的示例对象

- User.java

```java
public class User {

    @CheckField
    private String name;

    @CheckField
    private String password;

    private String address;

    @Checksum
    private String checksum;

    //Getter & Setter
    //toString()
}
```

### 核心注解

`@CheckField` 表示参与加签的字段信息

`@Checksum` 表示加签结果存放的字段

## 调用测试

```java
package com.github.houbb.checksum.core;

import com.github.houbb.checksum.model.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 0.0.1
 */
public class ChecksumBsTest {

    @Test
    public void checksumTest() {
        User user = buildUser();
        final String checksum = ChecksumBs
                .newInstance(user)
                .checksum();

        Assert.assertEquals("8D62F2BC49A9AB51280C8F42A483ED54", checksum);
    }

    @Test
    public void fillTest() {
        User user = buildUser();
        ChecksumBs.newInstance(user).fill();

        Assert.assertEquals("User{name='ryo', password='1234', address='china', checksum='8D62F2BC49A9AB51280C8F42A483ED54'}",
                user.toString());
    }

    /**
     * 构建示例对象
     * @return 构建示例对象
     */
    private User buildUser() {
        User user = new User();
        user.name("ryo")
                .password("1234")
                .address("china");
        return user;
    }

}
```

# ChecksumBs 引导类

用来创建加签的相关配置及实现。

## 配置核心方法

| 方法 | 默认值 | 备注 |
|:--|:--|:--|
| newInstance() |  | 新建 ChecksumBs 实例(static) |
| newInstance(object) |  | 新建 ChecksumBs 实例，并且指定待加签的对象(static，建议使用) |
| target(Object) |  | 指定待加签的对象 |
| secret(ISecret) | DefaultMd5Secret | 指定加密的策略，默认使用 md5 加密 |
| sort(ISort) |  NameAscSort | 指定排序的策略，默认根据字段的名称正序排列表 |
| cache(ICache) |  DefaultFieldListCache | 指定字段的缓存策略，默认使用本地 map 进行字段信息缓存 |

## 调用核心方法

| 方法 | 返回值 | 备注 |
|:--|:--|:--|
| checksum() | String | 返回加签的结果 |
| fill() |  无 | 将上面 checksum 的结果设置到 @Checksum 标识的字段中 |

## 自定义

上述 ISecret/ISort/ICache 都是支持自定义的。

一般只需要重新定义 ISecret 即可。
