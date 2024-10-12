# rocketmq-default-config

## synopsis
Print default config(namesrv, broker, controller, proxy ) from rocketmq source. 

To solve similar problems like [Documentation Related: Is there a page listing all the parameters available in the config file?](https://github.com/apache/rocketmq/issues/8775).

- [org.apache.rocketmq.common.NamesrvConfig](https://github.com/apache/rocketmq/blob/rocketmq-all-5.3.0/common/src/main/java/org/apache/rocketmq/common/namesrv/NamesrvConfig.java)
- [org.apache.rocketmq.common.BrokerConfig](https://github.com/apache/rocketmq/blob/rocketmq-all-5.3.0/common/src/main/java/org/apache/rocketmq/common/BrokerConfig.java)
- [org.apache.rocketmq.common.ControllerConfig](https://github.com/apache/rocketmq/blob/rocketmq-all-5.3.0/common/src/main/java/org/apache/rocketmq/common/ControllerConfig.java)
- [org.apache.rocketmq.common.JraftConfig](https://github.com/apache/rocketmq/blob/rocketmq-all-5.3.0/common/src/main/java/org/apache/rocketmq/common/JraftConfig.java)
- [org.apache.rocketmq.proxy.config.ProxyConfig](https://github.com/apache/rocketmq/blob/rocketmq-all-5.3.0/proxy/src/main/java/org/apache/rocketmq/proxy/config/ProxyConfig.java)
- [org.apache.rocketmq.auth.config.AuthConfig](https://github.com/apache/rocketmq/blob/rocketmq-all-5.3.0/auth/src/main/java/org/apache/rocketmq/auth/config/AuthConfig.java)

## config

<!-- TOC -->
- [4.8.0](#4-8-0)
  - [4.8.0/mqadmin.md](4.8.0/mqadmin.md)
- [4.9.0](#4-9-0)
  - [4.9.0/mqadmin.md](4.9.0/mqadmin.md)
- [4.9.1](#4-9-1)
  - [4.9.1/mqadmin.md](4.9.1/mqadmin.md)
- [4.9.2](#4-9-2)
  - [4.9.2/mqadmin.md](4.9.2/mqadmin.md)
- [4.9.3](#4-9-3)
  - [4.9.3/broker.conf](4.9.3/broker.conf)
  - [4.9.3/broker.md](4.9.3/broker.md)
  - [4.9.3/mqadmin.md](4.9.3/mqadmin.md)
  - [4.9.3/namesrv.conf](4.9.3/namesrv.conf)
  - [4.9.3/namesrv.md](4.9.3/namesrv.md)
- [4.9.4](#4-9-4)
  - [4.9.4/broker.conf](4.9.4/broker.conf)
  - [4.9.4/broker.md](4.9.4/broker.md)
  - [4.9.4/mqadmin.md](4.9.4/mqadmin.md)
  - [4.9.4/namesrv.conf](4.9.4/namesrv.conf)
  - [4.9.4/namesrv.md](4.9.4/namesrv.md)
- [4.9.5](#4-9-5)
  - [4.9.5/broker.conf](4.9.5/broker.conf)
  - [4.9.5/broker.md](4.9.5/broker.md)
  - [4.9.5/mqadmin.md](4.9.5/mqadmin.md)
  - [4.9.5/namesrv.conf](4.9.5/namesrv.conf)
  - [4.9.5/namesrv.md](4.9.5/namesrv.md)
- [4.9.6](#4-9-6)
  - [4.9.6/broker.conf](4.9.6/broker.conf)
  - [4.9.6/broker.md](4.9.6/broker.md)
  - [4.9.6/mqadmin.md](4.9.6/mqadmin.md)
  - [4.9.6/namesrv.conf](4.9.6/namesrv.conf)
  - [4.9.6/namesrv.md](4.9.6/namesrv.md)
- [4.9.7](#4-9-7)
  - [4.9.7/broker.conf](4.9.7/broker.conf)
  - [4.9.7/broker.md](4.9.7/broker.md)
  - [4.9.7/mqadmin.md](4.9.7/mqadmin.md)
  - [4.9.7/namesrv.conf](4.9.7/namesrv.conf)
  - [4.9.7/namesrv.md](4.9.7/namesrv.md)
- [4.9.8](#4-9-8)
  - [4.9.8/broker.conf](4.9.8/broker.conf)
  - [4.9.8/broker.md](4.9.8/broker.md)
  - [4.9.8/mqadmin.md](4.9.8/mqadmin.md)
  - [4.9.8/namesrv.conf](4.9.8/namesrv.conf)
  - [4.9.8/namesrv.md](4.9.8/namesrv.md)
- [5.0.0](#5-0-0)
  - [5.0.0/broker.conf](5.0.0/broker.conf)
  - [5.0.0/broker.md](5.0.0/broker.md)
  - [5.0.0/controller.conf](5.0.0/controller.conf)
  - [5.0.0/controller.md](5.0.0/controller.md)
  - [5.0.0/mqadmin.md](5.0.0/mqadmin.md)
  - [5.0.0/namesrv.conf](5.0.0/namesrv.conf)
  - [5.0.0/namesrv.md](5.0.0/namesrv.md)
  - [5.0.0/proxy.json](5.0.0/proxy.json)
  - [5.0.0/proxy.md](5.0.0/proxy.md)
- [5.1.0](#5-1-0)
  - [5.1.0/broker.conf](5.1.0/broker.conf)
  - [5.1.0/broker.md](5.1.0/broker.md)
  - [5.1.0/controller.conf](5.1.0/controller.conf)
  - [5.1.0/controller.md](5.1.0/controller.md)
  - [5.1.0/mqadmin.md](5.1.0/mqadmin.md)
  - [5.1.0/namesrv.conf](5.1.0/namesrv.conf)
  - [5.1.0/namesrv.md](5.1.0/namesrv.md)
  - [5.1.0/proxy.json](5.1.0/proxy.json)
  - [5.1.0/proxy.md](5.1.0/proxy.md)
- [5.1.1](#5-1-1)
  - [5.1.1/broker.conf](5.1.1/broker.conf)
  - [5.1.1/broker.md](5.1.1/broker.md)
  - [5.1.1/controller.conf](5.1.1/controller.conf)
  - [5.1.1/controller.md](5.1.1/controller.md)
  - [5.1.1/mqadmin.md](5.1.1/mqadmin.md)
  - [5.1.1/namesrv.conf](5.1.1/namesrv.conf)
  - [5.1.1/namesrv.md](5.1.1/namesrv.md)
  - [5.1.1/proxy.json](5.1.1/proxy.json)
  - [5.1.1/proxy.md](5.1.1/proxy.md)
- [5.1.2](#5-1-2)
  - [5.1.2/broker.conf](5.1.2/broker.conf)
  - [5.1.2/broker.md](5.1.2/broker.md)
  - [5.1.2/controller.conf](5.1.2/controller.conf)
  - [5.1.2/controller.md](5.1.2/controller.md)
  - [5.1.2/mqadmin.md](5.1.2/mqadmin.md)
  - [5.1.2/namesrv.conf](5.1.2/namesrv.conf)
  - [5.1.2/namesrv.md](5.1.2/namesrv.md)
  - [5.1.2/proxy.json](5.1.2/proxy.json)
  - [5.1.2/proxy.md](5.1.2/proxy.md)
- [5.1.3](#5-1-3)
  - [5.1.3/broker.conf](5.1.3/broker.conf)
  - [5.1.3/broker.md](5.1.3/broker.md)
  - [5.1.3/controller.conf](5.1.3/controller.conf)
  - [5.1.3/controller.md](5.1.3/controller.md)
  - [5.1.3/mqadmin.md](5.1.3/mqadmin.md)
  - [5.1.3/namesrv.conf](5.1.3/namesrv.conf)
  - [5.1.3/namesrv.md](5.1.3/namesrv.md)
  - [5.1.3/proxy.json](5.1.3/proxy.json)
  - [5.1.3/proxy.md](5.1.3/proxy.md)
- [5.1.4](#5-1-4)
  - [5.1.4/broker.conf](5.1.4/broker.conf)
  - [5.1.4/broker.md](5.1.4/broker.md)
  - [5.1.4/controller.conf](5.1.4/controller.conf)
  - [5.1.4/controller.md](5.1.4/controller.md)
  - [5.1.4/mqadmin.md](5.1.4/mqadmin.md)
  - [5.1.4/namesrv.conf](5.1.4/namesrv.conf)
  - [5.1.4/namesrv.md](5.1.4/namesrv.md)
  - [5.1.4/proxy.json](5.1.4/proxy.json)
  - [5.1.4/proxy.md](5.1.4/proxy.md)
- [5.2.0](#5-2-0)
  - [5.2.0/broker.conf](5.2.0/broker.conf)
  - [5.2.0/broker.md](5.2.0/broker.md)
  - [5.2.0/controller.conf](5.2.0/controller.conf)
  - [5.2.0/controller.md](5.2.0/controller.md)
  - [5.2.0/mqadmin.md](5.2.0/mqadmin.md)
  - [5.2.0/namesrv.conf](5.2.0/namesrv.conf)
  - [5.2.0/namesrv.md](5.2.0/namesrv.md)
  - [5.2.0/proxy.json](5.2.0/proxy.json)
  - [5.2.0/proxy.md](5.2.0/proxy.md)
- [5.3.0](#5-3-0)
  - [5.3.0/auth.conf](5.3.0/auth.conf)
  - [5.3.0/auth.md](5.3.0/auth.md)
  - [5.3.0/broker.conf](5.3.0/broker.conf)
  - [5.3.0/broker.md](5.3.0/broker.md)
  - [5.3.0/controller.conf](5.3.0/controller.conf)
  - [5.3.0/controller.md](5.3.0/controller.md)
  - [5.3.0/mqadmin.md](5.3.0/mqadmin.md)
  - [5.3.0/namesrv.conf](5.3.0/namesrv.conf)
  - [5.3.0/namesrv.md](5.3.0/namesrv.md)
  - [5.3.0/proxy.json](5.3.0/proxy.json)
  - [5.3.0/proxy.md](5.3.0/proxy.md)
- [5.3.1](#5-3-1)
  - [5.3.1/auth.conf](5.3.1/auth.conf)
  - [5.3.1/auth.md](5.3.1/auth.md)
  - [5.3.1/broker.conf](5.3.1/broker.conf)
  - [5.3.1/broker.md](5.3.1/broker.md)
  - [5.3.1/controller.conf](5.3.1/controller.conf)
  - [5.3.1/controller.md](5.3.1/controller.md)
  - [5.3.1/mqadmin.md](5.3.1/mqadmin.md)
  - [5.3.1/namesrv.conf](5.3.1/namesrv.conf)
  - [5.3.1/namesrv.md](5.3.1/namesrv.md)
  - [5.3.1/proxy.json](5.3.1/proxy.json)
  - [5.3.1/proxy.md](5.3.1/proxy.md)
<!-- /TOC -->

## build and run local

### clone project

```bash
git clone git@github.com:dyrnq/rocketmq-default-config.git
cd rocketmq-default-config
```

### build

```bash
## build current version
./mvnw clean package

## gen all version
./run.sh

## gen specific version
./run.sh --ver 5.3.0

```