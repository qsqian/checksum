# 核心流程

（1）对象是否需要验签。

提供工具类：

```java
CheckSums.checksum(Object object)
```

对对象执行加签操作。

## 处理

如果没有 `@CheckSum` 字段，则什么都不做。

fast-fail。

## 核心加签过程

哪些字段，以什么方式，结果放在 checksum 字段上。

# 注解

## @CheckSum

指定字段

指定用什么加签方式。

默认 md5 + 字段排序（salt）

## @CheckField

加签的字段。

require 属性。

## @CheckEntry

是否递归处理 map/array/list/object

# condition

可以暂时不考虑

# converter

# 自定义注解

意义不大，不考虑支持。

