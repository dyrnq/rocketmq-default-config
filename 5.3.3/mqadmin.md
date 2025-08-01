# mqadmin

<!-- TOC -->
- [updateTopic](#updateTopic) 
- [updateTopicList](#updateTopicList) 
- [deleteTopic](#deleteTopic) 
- [updateSubGroup](#updateSubGroup) 
- [updateSubGroupList](#updateSubGroupList) 
- [setConsumeMode](#setConsumeMode) 
- [deleteSubGroup](#deleteSubGroup) 
- [updateBrokerConfig](#updateBrokerConfig) 
- [updateTopicPerm](#updateTopicPerm) 
- [topicRoute](#topicRoute) 
- [topicStatus](#topicStatus) 
- [topicClusterList](#topicClusterList) 
- [addBroker](#addBroker) 
- [removeBroker](#removeBroker) 
- [resetMasterFlushOffset](#resetMasterFlushOffset) 
- [brokerStatus](#brokerStatus) 
- [queryMsgById](#queryMsgById) 
- [queryMsgByKey](#queryMsgByKey) 
- [queryMsgByUniqueKey](#queryMsgByUniqueKey) 
- [queryMsgByOffset](#queryMsgByOffset) 
- [queryMsgTraceById](#queryMsgTraceById) 
- [printMsg](#printMsg) 
- [printMsgByQueue](#printMsgByQueue) 
- [sendMsgStatus](#sendMsgStatus) 
- [brokerConsumeStats](#brokerConsumeStats) 
- [producerConnection](#producerConnection) 
- [consumerConnection](#consumerConnection) 
- [consumerProgress](#consumerProgress) 
- [consumerStatus](#consumerStatus) 
- [cloneGroupOffset](#cloneGroupOffset) 
- [producer](#producer) 
- [clusterList](#clusterList) 
- [topicList](#topicList) 
- [updateKvConfig](#updateKvConfig) 
- [deleteKvConfig](#deleteKvConfig) 
- [wipeWritePerm](#wipeWritePerm) 
- [addWritePerm](#addWritePerm) 
- [resetOffsetByTime](#resetOffsetByTime) 
- [skipAccumulatedMessage](#skipAccumulatedMessage) 
- [updateOrderConf](#updateOrderConf) 
- [cleanExpiredCQ](#cleanExpiredCQ) 
- [deleteExpiredCommitLog](#deleteExpiredCommitLog) 
- [cleanUnusedTopic](#cleanUnusedTopic) 
- [startMonitoring](#startMonitoring) 
- [statsAll](#statsAll) 
- [allocateMQ](#allocateMQ) 
- [checkMsgSendRT](#checkMsgSendRT) 
- [clusterRT](#clusterRT) 
- [getNamesrvConfig](#getNamesrvConfig) 
- [updateNamesrvConfig](#updateNamesrvConfig) 
- [getBrokerConfig](#getBrokerConfig) 
- [getConsumerConfig](#getConsumerConfig) 
- [queryCq](#queryCq) 
- [sendMessage](#sendMessage) 
- [consumeMessage](#consumeMessage) 
- [updateStaticTopic](#updateStaticTopic) 
- [remappingStaticTopic](#remappingStaticTopic) 
- [exportMetadata](#exportMetadata) 
- [exportConfigs](#exportConfigs) 
- [exportMetrics](#exportMetrics) 
- [exportMetadataInRocksDB](#exportMetadataInRocksDB) 
- [exportPopRecord](#exportPopRecord) 
- [haStatus](#haStatus) 
- [getSyncStateSet](#getSyncStateSet) 
- [getBrokerEpoch](#getBrokerEpoch) 
- [getControllerMetaData](#getControllerMetaData) 
- [getControllerConfig](#getControllerConfig) 
- [updateControllerConfig](#updateControllerConfig) 
- [electMaster](#electMaster) 
- [cleanBrokerMetadata](#cleanBrokerMetadata) 
- [dumpCompactionLog](#dumpCompactionLog) 
- [getColdDataFlowCtrInfo](#getColdDataFlowCtrInfo) 
- [updateColdDataFlowCtrGroupConfig](#updateColdDataFlowCtrGroupConfig) 
- [removeColdDataFlowCtrGroupConfig](#removeColdDataFlowCtrGroupConfig) 
- [setCommitLogReadAheadMode](#setCommitLogReadAheadMode) 
- [createUser](#createUser) 
- [updateUser](#updateUser) 
- [deleteUser](#deleteUser) 
- [getUser](#getUser) 
- [listUser](#listUser) 
- [copyUser](#copyUser) 
- [createAcl](#createAcl) 
- [updateAcl](#updateAcl) 
- [deleteAcl](#deleteAcl) 
- [getAcl](#getAcl) 
- [listAcl](#listAcl) 
- [copyAcl](#copyAcl) 
- [rocksDBConfigToJson](#rocksDBConfigToJson) 
- [checkRocksdbCqWriteProgress](#checkRocksdbCqWriteProgress) 

<!-- /TOC -->


## updateTopic

```bash
usage: mqadmin updateTopic [-a <arg>] -b <arg> | -c <arg>  [-h] [-n <arg>] [-o <arg>] [-p <arg>] [-r <arg>]
       [-s <arg>] -t <arg> [-u <arg>] [-w <arg>]
 -a,--attributes <arg>       attribute(+a=b,+c=d,-e)
 -b,--brokerAddr <arg>       create topic to which broker
 -c,--clusterName <arg>      create topic to which cluster
 -h,--help                   Print help
 -n,--namesrvAddr <arg>      Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -o,--order <arg>            set topic's order(true|false)
 -p,--perm <arg>             set topic's permission(2|4|6), intro[2:W 4:R; 6:RW]
 -r,--readQueueNums <arg>    set read queue nums
 -s,--hasUnitSub <arg>       has unit sub (true|false)
 -t,--topic <arg>            topic name
 -u,--unit <arg>             is unit topic (true|false)
 -w,--writeQueueNums <arg>   set write queue nums
```

## updateTopicList

```bash
usage: mqadmin updateTopicList -b <arg> | -c <arg>  -f <arg> [-h] [-n <arg>]
 -b,--brokerAddr <arg>    create topic to which broker
 -c,--clusterName <arg>   create topic to which cluster
 -f,--filename <arg>      Path to a file with list of org.apache.rocketmq.common.TopicConfig in json format
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## deleteTopic

```bash
usage: mqadmin deleteTopic -c <arg> [-h] [-n <arg>] -t <arg>
 -c,--clusterName <arg>   delete topic from which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>         topic name
```

## updateSubGroup

```bash
usage: mqadmin updateSubGroup [-a <arg>] [--attributes <arg>] [-b <arg>] [-c <arg>] [-d <arg>] -g <arg> [-h]
       [-i <arg>] [-m <arg>] [-n <arg>] [-o <arg>] [-p <arg>] [-q <arg>] [-r <arg>] [-s <arg>] [-w <arg>]
 -a,--notifyConsumerIdsChanged <arg>       notify consumerId changed
    --attributes <arg>                     attribute(+a=b,+c=d,-e)
 -b,--brokerAddr <arg>                     create subscription group to which broker
 -c,--clusterName <arg>                    create subscription group to which cluster
 -d,--consumeBroadcastEnable <arg>         broadcast
 -g,--groupName <arg>                      consumer group name
 -h,--help                                 Print help
 -i,--brokerId <arg>                       consumer from which broker id
 -m,--consumeFromMinEnable <arg>           from min offset
 -n,--namesrvAddr <arg>                    Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -o,--consumeMessageOrderly <arg>          consume message orderly
 -p,--groupRetryPolicy <arg>               the json string of retry policy ( exp:
                                           {"type":"EXPONENTIAL","exponentialRetryPolicy":{"initial":5000,"max
                                           ":7200000,"multiplier":2}}
                                           {"type":"CUSTOMIZED","customizedRetryPolicy":{"next":[1000,5000,100
                                           00]}} )
 -q,--retryQueueNums <arg>                 retry queue nums
 -r,--retryMaxTimes <arg>                  retry max times
 -s,--consumeEnable <arg>                  consume enable
 -w,--whichBrokerWhenConsumeSlowly <arg>   which broker id when consume slowly
```

## updateSubGroupList

```bash
usage: mqadmin updateSubGroupList -b <arg> | -c <arg>  -f <arg> [-h] [-n <arg>]
 -b,--brokerAddr <arg>    create groups to which broker
 -c,--clusterName <arg>   create groups to which cluster
 -f,--filename <arg>      Path to a file with a list of
                          org.apache.rocketmq.remoting.protocol.subscription.SubscriptionGroupConfig in json
                          format
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## setConsumeMode

```bash
usage: mqadmin setConsumeMode [-b <arg>] [-c <arg>] -g <arg> [-h] -m <arg> [-n <arg>] [-q <arg>] -t <arg>
 -b,--brokerAddr <arg>         create subscription group to which broker
 -c,--clusterName <arg>        create subscription group to which cluster
 -g,--groupName <arg>          consumer group name
 -h,--help                     Print help
 -m,--mode <arg>               consume mode. PULL/POP
 -n,--namesrvAddr <arg>        Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -q,--popShareQueueNum <arg>   num of queue which share in pop mode
 -t,--topicName <arg>          topic name
```

## deleteSubGroup

```bash
usage: mqadmin deleteSubGroup [-b <arg>] [-c <arg>] -g <arg> [-h] [-n <arg>] [-r <arg>]
 -b,--brokerAddr <arg>     delete subscription group from which broker
 -c,--clusterName <arg>    delete subscription group from which cluster
 -g,--groupName <arg>      subscription group name
 -h,--help                 Print help
 -n,--namesrvAddr <arg>    Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -r,--removeOffset <arg>   remove offset
```

## updateBrokerConfig

```bash
usage: mqadmin updateBrokerConfig [-a <arg>] [-b <arg>] [-c <arg>] [-h] -k <arg> [-n <arg>] -v <arg>
 -a,--updateAllBroker <arg>   update all brokers include slave
 -b,--brokerAddr <arg>        update which broker
 -c,--clusterName <arg>       update which cluster
 -h,--help                    Print help
 -k,--key <arg>               config key
 -n,--namesrvAddr <arg>       Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -v,--value <arg>             config value
```

## updateTopicPerm

```bash
usage: mqadmin updateTopicPerm [-b <arg>] [-c <arg>] [-h] [-n <arg>] -p <arg> -t <arg>
 -b,--brokerAddr <arg>    create topic to which broker
 -c,--clusterName <arg>   create topic to which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -p,--perm <arg>          set topic's permission(2|4|6), intro[2:W; 4:R; 6:RW]
 -t,--topic <arg>         topic name
```

## topicRoute

```bash
usage: mqadmin topicRoute [-h] [-l] [-n <arg>] -t <arg>
 -h,--help                Print help
 -l,--list                Use list format to print data
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>         topic name
```

## topicStatus

```bash
usage: mqadmin topicStatus [-c <arg>] [-h] [-n <arg>] -t <arg>
 -c,--cluster <arg>       cluster name or lmq parent topic, lmq is used to find the route.
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>         topic name
```

## topicClusterList

```bash
usage: mqadmin topicClusterList [-h] [-n <arg>] -t <arg>
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>         topic name
```

## addBroker

```bash
usage: mqadmin addBroker -b <arg> -c <arg> [-h] [-n <arg>]
 -b,--brokerConfigPath <arg>      Broker config path
 -c,--brokerContainerAddr <arg>   Broker container address
 -h,--help                        Print help
 -n,--namesrvAddr <arg>           Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## removeBroker

```bash
usage: mqadmin removeBroker -b <arg> -c <arg> [-h] [-n <arg>]
 -b,--brokerIdentity <arg>        Information to identify a broker: clusterName:brokerName:brokerId(dLedgerId
                                  for dLedger)
 -c,--brokerContainerAddr <arg>   Broker container address
 -h,--help                        Print help
 -n,--namesrvAddr <arg>           Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## resetMasterFlushOffset

```bash
usage: mqadmin resetMasterFlushOffset [-b <arg>] [-h] [-n <arg>] [-o <arg>]
 -b,--brokerAddr <arg>    which broker to reset
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -o,--offset <arg>        the offset to reset at
```

## brokerStatus

```bash
usage: mqadmin brokerStatus -b <arg> | -c <arg>  [-h] [-n <arg>]
 -b,--brokerAddr <arg>    Broker address
 -c,--clusterName <arg>   which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## queryMsgById

```bash
usage: mqadmin queryMsgById [-c <arg>] [-d <arg>] [-f <arg>] [-g <arg>] [-h] -i <arg> [-n <arg>] [-s <arg>] -t
       <arg> [-u <arg>]
 -c,--cluster <arg>         Cluster name or lmq parent topic, lmq is used to find the route.
 -d,--clientId <arg>        The consumer's client id
 -f,--bodyFormat <arg>      print message body by the specified format
 -g,--consumerGroup <arg>   consumer group name
 -h,--help                  Print help
 -i,--msgId <arg>           Message Id
 -n,--namesrvAddr <arg>     Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--sendMessage <arg>     resend message
 -t,--topic <arg>           topic name
 -u,--unitName <arg>        unit name
```

## queryMsgByKey

```bash
usage: mqadmin queryMsgByKey [-b <arg>] [-c <arg>] [-e <arg>] [-h] -k <arg> [-m <arg>] [-n <arg>] -t <arg>
 -b,--beginTimestamp <arg>   Begin timestamp(ms). default:0, eg:1676730526212
 -c,--cluster <arg>          Cluster name or lmq parent topic, lmq is used to find the route.
 -e,--endTimestamp <arg>     End timestamp(ms). default:Long.MAX_VALUE, eg:1676730526212
 -h,--help                   Print help
 -k,--msgKey <arg>           Message Key
 -m,--maxNum <arg>           The maximum number of messages returned by the query, default:64
 -n,--namesrvAddr <arg>      Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>            Topic name
```

## queryMsgByUniqueKey

```bash
usage: mqadmin queryMsgByUniqueKey [-a] [-c <arg>] [-d <arg>] [-g <arg>] [-h] -i <arg> [-n <arg>] -t <arg>
 -a,--showAll               Print all message, the limit is 32
 -c,--cluster <arg>         Cluster name or lmq parent topic, lmq is used to find the route.
 -d,--clientId <arg>        The consumer's client id
 -g,--consumerGroup <arg>   consumer group name
 -h,--help                  Print help
 -i,--msgId <arg>           Message Id
 -n,--namesrvAddr <arg>     Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>           The topic of msg
```

## queryMsgByOffset

```bash
usage: mqadmin queryMsgByOffset -b <arg> [-f <arg>] [-h] -i <arg> [-n <arg>] -o <arg> -t <arg>
 -b,--brokerName <arg>    Broker Name
 -f,--bodyFormat <arg>    print message body by the specified format
 -h,--help                Print help
 -i,--queueId <arg>       Queue Id
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -o,--offset <arg>        Queue Offset
 -t,--topic <arg>         topic name
```

## queryMsgTraceById

```bash
usage: mqadmin queryMsgTraceById [-b <arg>] [-c <arg>] [-e <arg>] [-h] -i <arg> [-n <arg>] [-t <arg>]
 -b,--beginTimestamp <arg>   Begin timestamp(ms). default:0, eg:1676730526212
 -c,--maxNum <arg>           The maximum number of messages returned by the query, default:64
 -e,--endTimestamp <arg>     End timestamp(ms). default:Long.MAX_VALUE, eg:1676730526212
 -h,--help                   Print help
 -i,--msgId <arg>            Message Id
 -n,--namesrvAddr <arg>      Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--traceTopic <arg>       The name value of message trace topic
```

## printMsg

```bash
usage: mqadmin printMsg [-b <arg>] [-c <arg>] [-d <arg>] [-e <arg>] [-h] [-l <arg>] [-n <arg>] [-s <arg>] -t
       <arg>
 -b,--beginTimestamp  <arg>   Begin timestamp[currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -c,--charsetName  <arg>      CharsetName(eg: UTF-8,GBK)
 -d,--printBody  <arg>        print body
 -e,--endTimestamp  <arg>     End timestamp[currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -h,--help                    Print help
 -l,--lmqParentTopic <arg>    Lmq parent topic, lmq is used to find the route.
 -n,--namesrvAddr <arg>       Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--subExpression  <arg>    Subscribe Expression(eg: TagA || TagB)
 -t,--topic <arg>             topic name
```

## printMsgByQueue

```bash
usage: mqadmin printMsgByQueue -a <arg> [-b <arg>] [-c <arg>] [-d <arg>] [-e <arg>] [-f <arg>] [-h] -i <arg>
       [-n <arg>] [-p <arg>] [-s <arg>] -t <arg>
 -a,--brokerName  <arg>       broker name
 -b,--beginTimestamp  <arg>   Begin timestamp[currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -c,--charsetName  <arg>      CharsetName(eg: UTF-8,GBK)
 -d,--printBody  <arg>        print body. eg: true | false(default)
 -e,--endTimestamp  <arg>     End timestamp[currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -f,--calculate <arg>         calculate by tag. eg: true | false(default)
 -h,--help                    Print help
 -i,--queueId  <arg>          queue id
 -n,--namesrvAddr <arg>       Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -p,--print msg <arg>         print msg. eg: true | false(default)
 -s,--subExpression  <arg>    Subscribe Expression(eg: TagA || TagB)
 -t,--topic <arg>             topic name
```

## sendMsgStatus

```bash
usage: mqadmin sendMsgStatus -b <arg> [-c <arg>] [-h] [-n <arg>] [-s <arg>]
 -b,--brokerName <arg>    Broker Name e.g. clusterName_brokerName as DefaultCluster_broker-a
 -c,--count <arg>         send message count, Default: 50
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--messageSize <arg>   Message Size, Default: 128
```

## brokerConsumeStats

```bash
usage: mqadmin brokerConsumeStats -b <arg> [-h] [-l <arg>] [-n <arg>] [-o <arg>] [-t <arg>]
 -b,--brokerAddr <arg>      Broker address
 -h,--help                  Print help
 -l,--level <arg>           threshold of print diff
 -n,--namesrvAddr <arg>     Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -o,--order <arg>           order topic
 -t,--timeoutMillis <arg>   request timeout Millis
```

## producerConnection

```bash
usage: mqadmin producerConnection -g <arg> [-h] [-n <arg>] -t <arg>
 -g,--producerGroup <arg>   producer group name
 -h,--help                  Print help
 -n,--namesrvAddr <arg>     Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>           topic name
```

## consumerConnection

```bash
usage: mqadmin consumerConnection [-b <arg>] -g <arg> [-h] [-n <arg>]
 -b,--brokerAddr <arg>      broker address
 -g,--consumerGroup <arg>   consumer group name
 -h,--help                  Print help
 -n,--namesrvAddr <arg>     Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## consumerProgress

```bash
usage: mqadmin consumerProgress [-c <arg>] [-g <arg>] [-h] [-n <arg>] [-s <arg>] [-t <arg>]
 -c,--cluster <arg>        Cluster name or lmq parent topic, lmq is used to find the route.
 -g,--groupName <arg>      consumer group name
 -h,--help                 Print help
 -n,--namesrvAddr <arg>    Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--showClientIP <arg>   Show Client IP per Queue
 -t,--topicName <arg>      topic name
```

## consumerStatus

```bash
usage: mqadmin consumerStatus [-b <arg>] -g <arg> [-h] [-i <arg>] [-n <arg>] [-s]
 -b,--brokerAddr <arg>      broker address
 -g,--consumerGroup <arg>   consumer group name
 -h,--help                  Print help
 -i,--clientId <arg>        The consumer's client id
 -n,--namesrvAddr <arg>     Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--jstack                Run jstack command in the consumer progress
```

## cloneGroupOffset

```bash
usage: mqadmin cloneGroupOffset -d <arg> [-h] [-n <arg>] [-o <arg>] -s <arg> -t <arg>
 -d,--destGroup <arg>     set destination consumer group
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -o,--offline <arg>       the group or the topic is offline
 -s,--srcGroup <arg>      set source consumer group
 -t,--topic <arg>         set the topic
```

## producer

```bash
usage: mqadmin producer -b <arg> [-h] [-n <arg>]
 -b,--broker <arg>        broker address
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## clusterList

```bash
usage: mqadmin clusterList [-c <arg>] [-h] [-i <arg>] [-m] [-n <arg>]
 -c,--clusterName <arg>   which cluster
 -h,--help                Print help
 -i,--interval <arg>      specify intervals numbers, it is in seconds
 -m,--moreStats           Print more stats
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## topicList

```bash
usage: mqadmin topicList [-c] [-h] [-n <arg>]
 -c,--clusterModel        clusterModel
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## updateKvConfig

```bash
usage: mqadmin updateKvConfig [-h] -k <arg> [-n <arg>] -s <arg> -v <arg>
 -h,--help                Print help
 -k,--key <arg>           set the key name
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--namespace <arg>     set the namespace
 -v,--value <arg>         set the key value
```

## deleteKvConfig

```bash
usage: mqadmin deleteKvConfig [-h] -k <arg> [-n <arg>] -s <arg>
 -h,--help                Print help
 -k,--key <arg>           set the key name
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--namespace <arg>     set the namespace
```

## wipeWritePerm

```bash
usage: mqadmin wipeWritePerm -b <arg> [-h] [-n <arg>]
 -b,--brokerName <arg>    broker name
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## addWritePerm

```bash
usage: mqadmin addWritePerm -b <arg> [-h] [-n <arg>]
 -b,--brokerName <arg>    broker name
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## resetOffsetByTime

```bash
usage: mqadmin resetOffsetByTime [-b <arg>] [-c <arg>] [-f <arg>] -g <arg> [-h] [-n <arg>] [-o <arg>] [-q
       <arg>] -s <arg> -t <arg>
 -b,--broker <arg>        broker addr
 -c,--cluster <arg>       Cluster name or lmq parent topic, lmq is used to find the route.
 -f,--force <arg>         set the force rollback by timestamp switch[true|false]. Deprecated.
 -g,--group <arg>         set the consumer group
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -o,--offset <arg>        Expect queue offset, not support old version broker
 -q,--queue <arg>         queue id
 -s,--timestamp <arg>     set the timestamp[now|currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -t,--topic <arg>         set the topic
```

## skipAccumulatedMessage

```bash
usage: mqadmin skipAccumulatedMessage [-c <arg>] [-f <arg>] -g <arg> [-h] [-n <arg>] -t <arg>
 -c,--cluster <arg>       Cluster name or lmq parent topic, lmq is used to find the route.
 -f,--force <arg>         set the force rollback by timestamp switch[true|false]
 -g,--group <arg>         set the consumer group
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>         set the topic
```

## updateOrderConf

```bash
usage: mqadmin updateOrderConf [-h] -m <arg> [-n <arg>] -t <arg> [-v <arg>]
 -h,--help                Print help
 -m,--method <arg>        option type [eg. put|get|delete
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>         topic name
 -v,--orderConf <arg>     set order conf [eg. brokerName1:num;brokerName2:num]
```

## cleanExpiredCQ

```bash
usage: mqadmin cleanExpiredCQ [-b <arg>] [-c <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    Broker address
 -c,--cluster <arg>       clustername
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## deleteExpiredCommitLog

```bash
usage: mqadmin deleteExpiredCommitLog [-b <arg>] [-c <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    Broker address
 -c,--cluster <arg>       clustername
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address
```

## cleanUnusedTopic

```bash
usage: mqadmin cleanUnusedTopic [-b <arg>] [-c <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    Broker address
 -c,--cluster <arg>       cluster name
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## startMonitoring

```bash
usage: mqadmin startMonitoring [-h] [-n <arg>]
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## statsAll

```bash
usage: mqadmin statsAll [-a] [-h] [-n <arg>] [-t <arg>]
 -a,--activeTopic         print active topic only
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>         print select topic only
```

## allocateMQ

```bash
usage: mqadmin allocateMQ [-h] -i <arg> [-n <arg>] -t <arg>
 -h,--help                Print help
 -i,--ipList <arg>        ipList
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>         topic name
```

## checkMsgSendRT

```bash
usage: mqadmin checkMsgSendRT [-a <arg>] [-h] [-n <arg>] [-s <arg>] -t <arg>
 -a,--amount <arg>        message amount | default 100
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--size <arg>          message size | default 128 Byte
 -t,--topic <arg>         topic name
```

## clusterRT

```bash
usage: mqadmin clusterRT [-a <arg>] [-c <arg>] [-h] [-i <arg>] [-m <arg>] [-n <arg>] [-p <arg>] [-s <arg>]
 -a,--amount <arg>         message amount | default 100
 -c,--cluster <arg>        cluster name | default display all cluster
 -h,--help                 Print help
 -i,--interval <arg>       print interval | default 10 seconds
 -m,--machine room <arg>   machine room name | default noname
 -n,--namesrvAddr <arg>    Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -p,--print log <arg>      print as tlog | default false
 -s,--size <arg>           message size | default 128 Byte
```

## getNamesrvConfig

```bash
usage: mqadmin getNamesrvConfig [-h] [-n <arg>]
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## updateNamesrvConfig

```bash
usage: mqadmin updateNamesrvConfig [-h] -k <arg> [-n <arg>] -v <arg>
 -h,--help                Print help
 -k,--key <arg>           config key
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -v,--value <arg>         config value
```

## getBrokerConfig

```bash
usage: mqadmin getBrokerConfig [-b <arg>] [-c <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    get which broker
 -c,--clusterName <arg>   get which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## getConsumerConfig

```bash
usage: mqadmin getConsumerConfig -g <arg> [-h] [-n <arg>]
 -g,--groupName <arg>     subscription group name
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## queryCq

```bash
usage: mqadmin queryCq [-b <arg>] [-c <arg>] [-g <arg>] [-h] -i <arg> [-n <arg>] -q <arg> -t <arg>
 -b,--broker <arg>        broker addr.
 -c,--count <arg>         how many.
 -g,--consumer <arg>      consumer group.
 -h,--help                Print help
 -i,--index <arg>         start queue index.
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -q,--queue <arg>         queue num, ie. 1
 -t,--topic <arg>         topic name
```

## sendMessage

```bash
usage: mqadmin sendMessage [-b <arg>] [-c <arg>] [-h] [-i <arg>] [-k <arg>] [-m <arg>] [-n <arg>] -p <arg> -t
       <arg>
 -b,--broker <arg>           Send message to target broker
 -c,--tags <arg>             Message tags
 -h,--help                   Print help
 -i,--qid <arg>              Send message to target queue
 -k,--key <arg>              Message keys
 -m,--msgTraceEnable <arg>   Message Trace Enable, Default: false
 -n,--namesrvAddr <arg>      Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -p,--body <arg>             UTF-8 string format of the message body
 -t,--topic <arg>            Topic name
```

## consumeMessage

```bash
usage: mqadmin consumeMessage [-b <arg>] [-c <arg>] [-e <arg>] [-g <arg>] [-h] [-i <arg>] [-n <arg>] [-o
       <arg>] [-s <arg>] -t <arg>
 -b,--brokerName <arg>        Broker name
 -c,--MessageNumber <arg>     Number of message to be consumed
 -e,--endTimestamp  <arg>     End timestamp[currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -g,--consumerGroup <arg>     Consumer group name
 -h,--help                    Print help
 -i,--queueId <arg>           Queue Id
 -n,--namesrvAddr <arg>       Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -o,--offset <arg>            Queue offset
 -s,--beginTimestamp  <arg>   Begin timestamp[currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -t,--topic <arg>             Topic name
```

## updateStaticTopic

```bash
usage: mqadmin updateStaticTopic -b <arg> | -c <arg>  [-fr <arg>] [-h] [-mf <arg>] [-n <arg>] -qn <arg> -t
       <arg>
 -b,--brokers <arg>          remapping static topic to brokers, comma separated
 -c,--clusters <arg>         remapping static topic to clusters, comma separated
 -fr,--forceReplace <arg>    Force replace the old mapping
 -h,--help                   Print help
 -mf,--mapFile <arg>         The mapping data file name
 -n,--namesrvAddr <arg>      Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -qn,--totalQueueNum <arg>   total queue num
 -t,--topic <arg>            topic name
```

## remappingStaticTopic

```bash
usage: mqadmin remappingStaticTopic -b <arg> | -c <arg>  [-fr <arg>] [-h] [-mf <arg>] [-n <arg>] -t <arg>
 -b,--brokers <arg>         remapping static topic to brokers, comma separated
 -c,--clusters <arg>        remapping static topic to clusters, comma separated
 -fr,--forceReplace <arg>   Force replace the old mapping
 -h,--help                  Print help
 -mf,--mapFile <arg>        The mapping data file name
 -n,--namesrvAddr <arg>     Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--topic <arg>           topic name
```

## exportMetadata

```bash
usage: mqadmin exportMetadata [-b <arg>] [-c <arg>] [-f <arg>] [-g] [-h] [-n <arg>] [-s] [-t]
 -b,--brokerAddr <arg>    choose a broker to export
 -c,--clusterName <arg>   choose a cluster to export
 -f,--filePath <arg>      export metadata.json path | default /tmp/rocketmq/export
 -g,--subscriptionGroup   only export subscriptionGroup metadata
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--specialTopic        need retryTopic and dlqTopic
 -t,--topic               only export topic metadata
```

## exportConfigs

```bash
usage: mqadmin exportConfigs -c <arg> [-f <arg>] [-h] [-n <arg>]
 -c,--clusterName <arg>   choose a cluster to export
 -f,--filePath <arg>      export configs.json path | default /tmp/rocketmq/export
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## exportMetrics

```bash
usage: mqadmin exportMetrics -c <arg> [-f <arg>] [-h] [-n <arg>]
 -c,--clusterName <arg>   choose a cluster to export
 -f,--filePath <arg>      export metrics.json path | default /tmp/rocketmq/export
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## exportMetadataInRocksDB

```bash
usage: mqadmin exportMetadataInRocksDB [-h] [-j <arg>] [-n <arg>] -p <arg> -t <arg>
 -h,--help                Print help
 -j,--jsonEnable <arg>    Json format enable, Default: false
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -p,--path <arg>          Absolute path for the metadata directory
 -t,--configType <arg>    Name of kv config, e.g. topics/subscriptionGroups
```

## exportPopRecord

```bash
usage: mqadmin exportPopRecord [-b <arg>] [-c <arg>] [-d <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    choose one broker to export
 -c,--clusterName <arg>   choose one cluster to export
 -d,--dryRun <arg>        no actual changes will be made
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## haStatus

```bash
usage: mqadmin haStatus [-b <arg>] [-c <arg>] [-h] [-i <arg>] [-n <arg>]
 -b,--brokerAddr <arg>    which broker to fetch
 -c,--clusterName <arg>   which cluster
 -h,--help                Print help
 -i,--interval <arg>      the interval(second) of get info
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## getSyncStateSet

```bash
usage: mqadmin getSyncStateSet -a <arg> [-b <arg>] [-c <arg>] [-h] [-i <arg>] [-n <arg>]
 -a,--controllerAddress <arg>   the address of controller
 -b,--brokerName <arg>          which broker to fetch
 -c,--clusterName <arg>         which cluster
 -h,--help                      Print help
 -i,--interval <arg>            the interval(second) of get info
 -n,--namesrvAddr <arg>         Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## getBrokerEpoch

```bash
usage: mqadmin getBrokerEpoch [-b <arg>] [-c <arg>] [-h] [-i <arg>] [-n <arg>]
 -b,--brokerName <arg>    which broker to fetch
 -c,--clusterName <arg>   which cluster
 -h,--help                Print help
 -i,--interval <arg>      the interval(second) of get info
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## getControllerMetaData

```bash
usage: mqadmin getControllerMetaData -a <arg> [-h] [-n <arg>]
 -a,--controllerAddress <arg>   the address of controller
 -h,--help                      Print help
 -n,--namesrvAddr <arg>         Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## getControllerConfig

```bash
usage: mqadmin getControllerConfig -a <arg> [-h] [-n <arg>]
 -a,--controllerAddress <arg>   Controller address list, eg: 192.168.0.1:9878;192.168.0.2:9878
 -h,--help                      Print help
 -n,--namesrvAddr <arg>         Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## updateControllerConfig

```bash
usage: mqadmin updateControllerConfig -a <arg> [-h] -k <arg> [-n <arg>] -v <arg>
 -a,--controllerAddress <arg>   Controller address list, eg: 192.168.0.1:9878;192.168.0.2:9878
 -h,--help                      Print help
 -k,--key <arg>                 config key
 -n,--namesrvAddr <arg>         Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -v,--value <arg>               config value
```

## electMaster

```bash
usage: mqadmin electMaster -a <arg> -b <arg> -bn <arg> -c <arg> [-h] [-n <arg>]
 -a,--controllerAddress <arg>   The address of controller
 -b,--brokerId <arg>            The id of the broker which requires to become master
 -bn,--brokerName <arg>         The broker name of the replicas that require to be manipulated
 -c,--clusterName <arg>         the clusterName of broker
 -h,--help                      Print help
 -n,--namesrvAddr <arg>         Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## cleanBrokerMetadata

```bash
usage: mqadmin cleanBrokerMetadata -a <arg> [-b <arg>] -bn <arg> [-c <arg>] [-h] [-l] [-n <arg>]
 -a,--controllerAddress <arg>            The address of controller
 -b,--brokerControllerIdsToClean <arg>   The brokerController id list which requires to clean metadata. eg:
                                         1;2;3, means that clean broker-1, broker-2 and broker-3
 -bn,--brokerName <arg>                  The broker name of the replicas that require to be manipulated
 -c,--clusterName <arg>                  The clusterName of broker
 -h,--help                               Print help
 -l,--cleanLivingBroker                  Whether clean up living brokers,default value is false
 -n,--namesrvAddr <arg>                  Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## dumpCompactionLog

```bash
usage: mqadmin dumpCompactionLog [-f <arg>] [-h] [-n <arg>]
 -f,--file <arg>          to dump file name
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## getColdDataFlowCtrInfo

```bash
usage: mqadmin getColdDataFlowCtrInfo [-b <arg>] [-c <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    get from which broker
 -c,--clusterName <arg>   get from which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## updateColdDataFlowCtrGroupConfig

```bash
usage: mqadmin updateColdDataFlowCtrGroupConfig [-b <arg>] [-c <arg>] -g <arg> [-h] [-n <arg>] -v <arg>
 -b,--brokerAddr <arg>      update which broker
 -c,--clusterName <arg>     update which cluster
 -g,--consumerGroup <arg>   specific consumerGroup
 -h,--help                  Print help
 -n,--namesrvAddr <arg>     Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -v,--threshold <arg>       cold read threshold value
```

## removeColdDataFlowCtrGroupConfig

```bash
usage: mqadmin removeColdDataFlowCtrGroupConfig [-b <arg>] [-c <arg>] -g <arg> [-h] [-n <arg>]
 -b,--brokerAddr <arg>      update which broker
 -c,--clusterName <arg>     update which cluster
 -g,--consumerGroup <arg>   the consumer group will remove from the config
 -h,--help                  Print help
 -n,--namesrvAddr <arg>     Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## setCommitLogReadAheadMode

```bash
usage: mqadmin setCommitLogReadAheadMode [-b <arg>] [-c <arg>] [-h] -m <arg> [-n <arg>]
 -b,--brokerAddr <arg>               set which broker
 -c,--clusterName <arg>              set which cluster
 -h,--help                           Print help
 -m,--commitLogReadAheadMode <arg>   set the CommitLog read ahead mode; 0 is default, 1 random read
 -n,--namesrvAddr <arg>              Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## createUser

```bash
usage: mqadmin createUser -b <arg> | -c <arg>  [-h] [-n <arg>] -p <arg> [-t <arg>] -u <arg>
 -b,--brokerAddr <arg>    create user to which broker
 -c,--clusterName <arg>   create user to which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -p,--password <arg>      the password of user to create
 -t,--userType <arg>      the userType of user to create
 -u,--username <arg>      the username of user to create.
```

## updateUser

```bash
usage: mqadmin updateUser -b <arg> | -c <arg>  [-h] [-n <arg>] -p <arg> | -s <arg> | -t <arg>   -u <arg>
 -b,--brokerAddr <arg>    update user to which broker
 -c,--clusterName <arg>   update user to which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -p,--password <arg>      the password of user to update
 -s,--userStatus <arg>    the userStatus of user to update
 -t,--userType <arg>      the userType of user to update
 -u,--username <arg>      the username of user to update.
```

## deleteUser

```bash
usage: mqadmin deleteUser -b <arg> | -c <arg>  [-h] [-n <arg>] -u <arg>
 -b,--brokerAddr <arg>    delete user from which broker
 -c,--clusterName <arg>   delete acl from which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -u,--username <arg>      the username of user to delete.
```

## getUser

```bash
usage: mqadmin getUser -b <arg> | -c <arg>  [-h] [-n <arg>] [-u <arg>]
 -b,--brokerAddr <arg>    get user for which broker
 -c,--clusterName <arg>   get user for specified cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -u,--username <arg>      the username of user to get
```

## listUser

```bash
usage: mqadmin listUser -b <arg> | -c <arg>  [-f <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    list user for which broker
 -c,--clusterName <arg>   list user for specified cluster
 -f,--filter <arg>        the filter to list users
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
```

## copyUser

```bash
usage: mqadmin copyUser -f <arg> [-h] [-n <arg>] -t <arg> [-u <arg>]
 -f,--fromBroker <arg>    the source broker that the users copy from
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -t,--toBroker <arg>      the target broker that the users copy to
 -u,--usernames <arg>     the username list of user to copy.
```

## createAcl

```bash
usage: mqadmin createAcl -a <arg> -b <arg> | -c <arg>  -d <arg> [-h] [-i <arg>] [-n <arg>] -r <arg> -s <arg>
 -a,--actions <arg>       the actions of acl to create
 -b,--brokerAddr <arg>    create acl to which broker
 -c,--clusterName <arg>   create acl to which cluster
 -d,--decision <arg>      the decision of acl to create
 -h,--help                Print help
 -i,--sourceIp <arg>      the sourceIps of acl to create
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -r,--resources <arg>     the resources of acl to create
 -s,--subject <arg>       the subject of acl to create.
```

## updateAcl

```bash
usage: mqadmin updateAcl -a <arg> -b <arg> | -c <arg>  -d <arg> [-h] [-i <arg>] [-n <arg>] -r <arg> -s <arg>
 -a,--actions <arg>       the actions of acl to update
 -b,--brokerAddr <arg>    update acl to which broker
 -c,--clusterName <arg>   update acl to which cluster
 -d,--decision <arg>      the decision of acl to update
 -h,--help                Print help
 -i,--sourceIp <arg>      the sourceIps of acl to update
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -r,--resources <arg>     the resources of acl to update
 -s,--subject <arg>       the subject of acl to update.
```

## deleteAcl

```bash
usage: mqadmin deleteAcl -b <arg> | -c <arg>  [-h] [-n <arg>] [-r <arg>] -s <arg>
 -b,--brokerAddr <arg>    delete acl from which broker
 -c,--clusterName <arg>   delete acl from which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -r,--resources <arg>     the resources of acl to delete
 -s,--subject <arg>       the subject of acl to delete.
```

## getAcl

```bash
usage: mqadmin getAcl -b <arg> | -c <arg>  [-h] [-n <arg>] [-s <arg>]
 -b,--brokerAddr <arg>    get acl for which broker
 -c,--clusterName <arg>   get acl for specified cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--subject <arg>       the subject of acl to get
```

## listAcl

```bash
usage: mqadmin listAcl -b <arg> | -c <arg>  [-h] [-n <arg>] [-r <arg>] [-s <arg>]
 -b,--brokerAddr <arg>    list acl for which broker.
 -c,--clusterName <arg>   list acl for specified cluster.
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -r,--resource <arg>      the resource of acl to filter.
 -s,--subject <arg>       the subject of acl to filter.
```

## copyAcl

```bash
usage: mqadmin copyAcl -f <arg> [-h] [-n <arg>] [-s <arg>] -t <arg>
 -f,--fromBroker <arg>    the source broker that the acls copy from
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: '192.168.0.1:9876;192.168.0.2:9876'
 -s,--subjects <arg>      the subject list of acl to copy.
 -t,--toBroker <arg>      the target broker that the acls copy to
```

## rocksDBConfigToJson

```bash
usage: mqadmin rocksDBConfigToJson [-b <arg>] [-c <arg>] [-e <arg>] [-h] [-j <arg>] [-n <arg>] [-p <arg>] [-t
       <arg>]
 -b,--brokerAddr <arg>       [rpc mode] Broker address. If brokerAddr is provided, will ignore [-p, -e, -j]
                             args
 -c,--cluster <arg>          [rpc mode] Cluster name. If nameserverAddr and clusterName are provided, will
                             ignore [-p, -e, -j, -b] args
 -e,--exportFile <arg>       [local mode] Absolute file path for exporting, auto backup existing file, not
                             directory. If exportFile is provided, will export Json file and ignore [-j].
 -h,--help                   Print help
 -j,--jsonEnable <arg>       [local mode] Json format enable, Default: true. If exportFile is provided, will
                             export Json file and ignore [-j].
 -n,--nameserverAddr <arg>   [rpc mode] nameserverAddr. If nameserverAddr and clusterName are provided, will
                             ignore [-p, -e, -j, -b] args
 -p,--configPath <arg>       [local mode] Absolute path to the metadata config directory
 -t,--configType <arg>       Name of kv config, e.g. topics/subscriptionGroups/consumerOffsets. Required in
                             local mode and default all in rpc mode.
```

## checkRocksdbCqWriteProgress

```bash
usage: mqadmin checkRocksdbCqWriteProgress -c <arg> [-cf <arg>] [-h] -n <arg> [-t <arg>]
 -c,--cluster <arg>          cluster name
 -cf,--checkFrom <arg>       check from time
 -h,--help                   Print help
 -n,--nameserverAddr <arg>   nameserverAddr
 -t,--topic <arg>            topic name
```

