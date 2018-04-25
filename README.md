# Nest Message Spring Boot
[![Build Status](https://travis-ci.org/XDean/nest-message-spring-boot.svg?branch=master)](https://travis-ci.org/XDean/nest-message-spring-boot)
[![codecov.io](http://codecov.io/github/XDean/nest-message-spring-boot/coverage.svg?branch=master)](https://codecov.io/gh/XDean/nest-message-spring-boot/branch/master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.XDean/nest-message-spring-boot/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.XDean/nest-message-spring-boot)

Nest Message Spring Boot

# Motivation

Reduce duplicate string in message source.

# Get Start

1. If you are using `@EnableAutoConfiguration`, just add the dependency:

```xml
<dependency>
  <groupId>com.github.XDean</groupId>
  <artifactId>nest-message-spring-boot-starter</artifactId>
  <version>x.x</version>
</dependency>
```

2. If you are not using `@EnableAutoConfiguration`, add the dependency:

```xml
<dependency>
  <groupId>com.github.XDean</groupId>
  <artifactId>nest-message-spring-boot</artifactId>
  <version>x.x</version>
</dependency>
```

and add `@EnableNestMessageSource` on your configuration class:

```java
@Configuration
@EnableNestMessageSource
public class MyApplication{
  ...
}
```

# Usage

### Use nest message expression

```csv
hello.guy=Hello {0}!
hello.world=$(hello.guy,world)
```

`hello.world` will be `Hello World!`

### Use argument placeholder

```csv
hello.two=Hello {0} and {1}!
hello.owt=$(hello.two,$1,$0)
``` 

`hello.world` with `{a, b}` will be `Hello b and a!`

### Complex expression with escaper and quoter

```csv
book.name=<{0}>
book.price=\${0,number,#.#}
book.promote=Come to buy {0} with $(book.price,$1)
java.promote=Hello guys! $(book.promote,$(book.name,java)"(2nd edition)",{0})
```

`java.promote` with `{123}` will be 
`Hello guys! Come to buy <java>(2nd edition) with $123`


# Configuration

Properties prefix is `xdean.message.nest`

Property | Description | Effect out of expression | Default Value
--- | --- | --- | ---
`prefix` | start a nest message expression | true | `$(`
`suffix` | end a nest message expression | false | `)`
`splitor` | splitor in nest message expression | false | `,`
`escaper` | escaper in nest message expression | true | `\`
`quoter` | quoter in nest message expression | false | `"`
`argPrefix` | argument placeholder prefix in nest message expression | false | `$`
