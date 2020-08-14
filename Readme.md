# Spring Cloud Netflix

![GitHub](https://img.shields.io/github/license/Learn-Architecture-the-Hard-Way/Spring-Cloud-Netflix)
[![Github](https://img.shields.io/badge/orginzation_project-Learn_Architecture_the_Hard_Way-brightgreen)](https://github.com/Learn-Architecture-the-Hard-Way)
[![Github](https://img.shields.io/badge/author-Jover_Zhang-brightgreen)](https://www.joverzhang.com)

### Dependencies

- [![Docker Image Version (tag latest semver)](https://img.shields.io/docker/v/ttmo/listen-dog/11?label=ttmo/listen-dog&logo=docker)](https://github.com/ttmo-ms/test-toolkit)

# Introduction

此项目主要是为了使得更多的人能够快速地了解**Spring Cloud Netflix**的主要功能及其**存在的意义**。  
并以现实业务需求为导向，以微服务架构为核心，使用多个案例**循序推进**架构的样貌。

但也因微服务架构涉及多个服务，若每个独立部署，较为繁琐且容易出错。该项目为使读者能够更轻易地在自己本地部署微服务环境，引用了**Docker**与**Docker-Compose**作为部署工具。
当你在你的计算机安装了**Docker**与**Docker-Compose**之后( [下方有安装链接](https://github.com/Learn-Architecture-the-Hard-Way/Spring-Cloud-Netflix#technology-used) )，
你最多只需要执行**两行指令即可运行**一个案例。

在**Docker-Compose**的控制台信息，可清晰看到负载均衡与链路调用的真实情景。

# Technology Used

- [Docker](https://www.docker.com/get-started)
- [Docker-Compose](https://docs.docker.com/compose/install/)
- [Spring Boot](https://spring.io/projects/spring-boot#overview)
- [Netflix/Ribbon](https://docs.spring.io/spring-cloud-netflix/docs/2.2.4.RELEASE/reference/html/#spring-cloud-ribbon)
- [Netflix/Feign](https://docs.spring.io/spring-cloud-netflix/docs/2.2.4.RELEASE/reference/html/#spring-cloud-ribbon-without-eureka)
- [~~Spring Cloud Config~~](https://spring.io/projects/spring-cloud-config)
- [~~Netflix/Zuul~~](https://docs.spring.io/spring-cloud-netflix/docs/2.2.4.RELEASE/reference/html/#router-and-filter-zuul)

# Usage

Run **Part** with:
```shell script
# Choice Part
cd {part_number}

# Run Part
./pack.sh
docker-compose up
```
Then open your browser [http://localhost](http://localhost)

Close **Part** use ``Ctrl + C`` and with: 
```shell script
docker-compose down
```

# Developments

### Part 1 Simple Server
##### Router:
- [http://localhost](http://localhost)

```
+-------------+
| spring boot |
+-------------+
```

### Part 2 Load Balance
##### Router:
- [http://localhost](http://localhost)

```
             +---------------+
           / | spring boot A |
+-------+ /  +---------------+
| nginx |  
+-------+ \  +---------------+
           \ | spring boot A |
             +---------------+
```

### Part 3 Distributed Architecture
##### Router:
- [http://localhost/a](http://localhost/a)
- [http://localhost/b](http://localhost/b)
- [http://localhost/a/b](http://localhost/a/b)

```
             +---------------+
           / | spring boot A | ----+
+-------+ /  +---------------+     |
| nginx |                        ribbon
+-------+ \  +---------------+     |
           \ | spring boot B | <---+
             +---------------+
```

### Part 4 Add Registry Center (Eureka)
##### Router:
- [http://localhost/a](http://localhost/a)
- [http://localhost/b](http://localhost/b)
- [http://localhost/a/b](http://localhost/a/b)
- [http://localhost:8761](http://localhost:8761)

```
                   +----------------fetch registry-------------+
                   |                                           v
             +---------------+ -----+                     +--------+
           / | spring boot A |      |                     | eureka |
+-------+ /  +--------------++    ribbon(load balance)    +--------+
| nginx |                       /   |                          ^
+-------+ \  +---------------+/     |                          |
           \ | spring boot B |----------+                      |
             +----------+----+ng boot B | -------register------+
                        +---------------+
```

### Part 5 Interface Oriented Programing (Feign)
##### Router:
- [http://localhost/a](http://localhost/a)
- [http://localhost/b](http://localhost/b)
- [http://localhost/a/b](http://localhost/a/b)
- [http://localhost:8761](http://localhost:8761)

```
                   +----------------fetch registry-------------+
                   |                                           v
             +---------------+ -----+                     +--------+
           / | spring boot A |      |                     | eureka |
+-------+ /  +--------------++    feign(override ribbon)  +--------+
| nginx |                       /   |                          ^
+-------+ \  +---------------+/     |                          |
           \ | spring boot B |----------+                      |
             +----------+----+ng boot B | -------register------+
                        +---------------+
```
