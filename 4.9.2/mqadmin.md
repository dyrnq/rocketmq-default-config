# mqadmin

<!-- TOC -->
- [updateTopic](#updateTopic) 
- [deleteTopic](#deleteTopic) 
- [updateSubGroup](#updateSubGroup) 
- [deleteSubGroup](#deleteSubGroup) 
- [updateBrokerConfig](#updateBrokerConfig) 
- [updateTopicPerm](#updateTopicPerm) 
- [topicRoute](#topicRoute) 
- [topicStatus](#topicStatus) 
- [topicClusterList](#topicClusterList) 
- [brokerStatus](#brokerStatus) 
- [queryMsgById](#queryMsgById) 
- [queryMsgByKey](#queryMsgByKey) 
- [queryMsgByUniqueKey](#queryMsgByUniqueKey) 
- [queryMsgByOffset](#queryMsgByOffset) 
- [QueryMsgTraceById](#QueryMsgTraceById) 
- [printMsg](#printMsg) 
- [printMsgByQueue](#printMsgByQueue) 
- [sendMsgStatus](#sendMsgStatus) 
- [brokerConsumeStats](#brokerConsumeStats) 
- [producerConnection](#producerConnection) 
- [consumerConnection](#consumerConnection) 
- [consumerProgress](#consumerProgress) 
- [consumerStatus](#consumerStatus) 
- [cloneGroupOffset](#cloneGroupOffset) 
- [clusterList](#clusterList) 
- [topicList](#topicList) 
- [updateKvConfig](#updateKvConfig) 
- [deleteKvConfig](#deleteKvConfig) 
- [wipeWritePerm](#wipeWritePerm) 
- [addWritePerm](#addWritePerm) 
- [resetOffsetByTime](#resetOffsetByTime) 
- [updateOrderConf](#updateOrderConf) 
- [cleanExpiredCQ](#cleanExpiredCQ) 
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
- [updateAclConfig](#updateAclConfig) 
- [deleteAccessConfig](#deleteAccessConfig) 
- [clusterAclConfigVersion](#clusterAclConfigVersion) 
- [updateGlobalWhiteAddr](#updateGlobalWhiteAddr) 
- [getAccessConfigSubCommand](#getAccessConfigSubCommand) 
- [exportMetadata](#exportMetadata) 
- [exportConfigs](#exportConfigs) 
- [exportMetrics](#exportMetrics) 

<!-- /TOC -->


## updateTopic

```bash
usage: mqadmin updateTopic -b <arg> | -c <arg>  [-h] [-n <arg>] [-o <arg>] [-p <arg>] [-r <arg>] [-s <arg>] -t
       <arg> [-u <arg>] [-w <arg>]
 -b,--brokerAddr <arg>       create topic to which broker
 -c,--clusterName <arg>      create topic to which cluster
 -h,--help                   Print help
 -n,--namesrvAddr <arg>      Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -o,--order <arg>            set topic's order(true|false)
 -p,--perm <arg>             set topic's permission(2|4|6), intro[2:W 4:R; 6:RW]
 -r,--readQueueNums <arg>    set read queue nums
 -s,--hasUnitSub <arg>       has unit sub (true|false)
 -t,--topic <arg>            topic name
 -u,--unit <arg>             is unit topic (true|false)
 -w,--writeQueueNums <arg>   set write queue nums
```

## deleteTopic

```bash
usage: mqadmin deleteTopic -c <arg> [-h] [-n <arg>] -t <arg>
 -c,--clusterName <arg>   delete topic from which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>         topic name
```

## updateSubGroup

```bash
usage: mqadmin updateSubGroup [-a <arg>] [-b <arg>] [-c <arg>] [-d <arg>] -g <arg> [-h] [-i <arg>] [-m <arg>]
       [-n <arg>] [-q <arg>] [-r <arg>] [-s <arg>] [-w <arg>]
 -a,--notifyConsumerIdsChanged <arg>       notify consumerId changed
 -b,--brokerAddr <arg>                     create subscription group to which broker
 -c,--clusterName <arg>                    create subscription group to which cluster
 -d,--consumeBroadcastEnable <arg>         broadcast
 -g,--groupName <arg>                      consumer group name
 -h,--help                                 Print help
 -i,--brokerId <arg>                       consumer from which broker id
 -m,--consumeFromMinEnable <arg>           from min offset
 -n,--namesrvAddr <arg>                    Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -q,--retryQueueNums <arg>                 retry queue nums
 -r,--retryMaxTimes <arg>                  retry max times
 -s,--consumeEnable <arg>                  consume enable
 -w,--whichBrokerWhenConsumeSlowly <arg>   which broker id when consume slowly
```

## deleteSubGroup

```bash
usage: mqadmin deleteSubGroup [-b <arg>] [-c <arg>] -g <arg> [-h] [-n <arg>] [-r <arg>]
 -b,--brokerAddr <arg>     delete subscription group from which broker
 -c,--clusterName <arg>    delete subscription group from which cluster
 -g,--groupName <arg>      subscription group name
 -h,--help                 Print help
 -n,--namesrvAddr <arg>    Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -r,--removeOffset <arg>   remove offset
```

## updateBrokerConfig

```bash
usage: mqadmin updateBrokerConfig [-b <arg>] [-c <arg>] [-h] -k <arg> [-n <arg>] -v <arg>
 -b,--brokerAddr <arg>    update which broker
 -c,--clusterName <arg>   update which cluster
 -h,--help                Print help
 -k,--key <arg>           config key
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -v,--value <arg>         config value
```

## updateTopicPerm

```bash
usage: mqadmin updateTopicPerm [-b <arg>] [-c <arg>] [-h] [-n <arg>] -p <arg> -t <arg>
 -b,--brokerAddr <arg>    create topic to which broker
 -c,--clusterName <arg>   create topic to which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -p,--perm <arg>          set topic's permission(2|4|6), intro[2:W; 4:R; 6:RW]
 -t,--topic <arg>         topic name
```

## topicRoute

```bash
usage: mqadmin topicRoute [-h] [-l] [-n <arg>] -t <arg>
 -h,--help                Print help
 -l,--list                Use list format to print data
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>         topic name
```

## topicStatus

```bash
usage: mqadmin topicStatus [-h] [-n <arg>] -t <arg>
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>         topic name
```

## topicClusterList

```bash
usage: mqadmin topicClusterList [-h] [-n <arg>] -t <arg>
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>         topic name
```

## brokerStatus

```bash
usage: mqadmin brokerStatus [-b <arg>] [-c <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    Broker address
 -c,--clusterName <arg>   which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## queryMsgById

```bash
usage: mqadmin queryMsgById [-d <arg>] [-g <arg>] [-h] -i <arg> [-n <arg>] [-s <arg>] [-u <arg>]
 -d,--clientId <arg>        The consumer's client id
 -g,--consumerGroup <arg>   consumer group name
 -h,--help                  Print help
 -i,--msgId <arg>           Message Id
 -n,--namesrvAddr <arg>     Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--sendMessage <arg>     resend message
 -u,--unitName <arg>        unit name
```

## queryMsgByKey

```bash
usage: mqadmin queryMsgByKey [-h] -k <arg> [-n <arg>] -t <arg>
 -h,--help                Print help
 -k,--msgKey <arg>        Message Key
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>         topic name
```

## queryMsgByUniqueKey

```bash
usage: mqadmin queryMsgByUniqueKey [-a] [-d <arg>] [-g <arg>] [-h] -i <arg> [-n <arg>] -t <arg>
 -a,--showAll               Print all message, the limit is 32
 -d,--clientId <arg>        The consumer's client id
 -g,--consumerGroup <arg>   consumer group name
 -h,--help                  Print help
 -i,--msgId <arg>           Message Id
 -n,--namesrvAddr <arg>     Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>           The topic of msg
```

## queryMsgByOffset

```bash
usage: mqadmin queryMsgByOffset -b <arg> [-h] -i <arg> [-n <arg>] -o <arg> -t <arg>
 -b,--brokerName <arg>    Broker Name
 -h,--help                Print help
 -i,--queueId <arg>       Queue Id
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -o,--offset <arg>        Queue Offset
 -t,--topic <arg>         topic name
```

## QueryMsgTraceById

```bash
usage: mqadmin QueryMsgTraceById [-h] -i <arg> [-n <arg>] [-t <arg>]
 -h,--help                Print help
 -i,--msgId <arg>         Message Id
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--traceTopic <arg>    The name value of message trace topic
```

## printMsg

```bash
usage: mqadmin printMsg [-b <arg>] [-c <arg>] [-d <arg>] [-e <arg>] [-h] [-n <arg>] [-s <arg>] -t <arg>
 -b,--beginTimestamp  <arg>   Begin timestamp[currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -c,--charsetName  <arg>      CharsetName(eg: UTF-8,GBK)
 -d,--printBody  <arg>        print body
 -e,--endTimestamp  <arg>     End timestamp[currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -h,--help                    Print help
 -n,--namesrvAddr <arg>       Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
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
 -n,--namesrvAddr <arg>       Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -p,--print msg <arg>         print msg. eg: true | false(default)
 -s,--subExpression  <arg>    Subscribe Expression(eg: TagA || TagB)
 -t,--topic <arg>             topic name
```

## sendMsgStatus

```bash
usage: mqadmin sendMsgStatus -b <arg> [-c <arg>] [-h] [-n <arg>] [-s <arg>]
 -b,--brokerName <arg>    Broker Name
 -c,--count <arg>         send message count, Default: 50
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--messageSize <arg>   Message Size, Default: 128
```

## brokerConsumeStats

```bash
usage: mqadmin brokerConsumeStats -b <arg> [-h] [-l <arg>] [-n <arg>] [-o <arg>] [-t <arg>]
 -b,--brokerAddr <arg>      Broker address
 -h,--help                  Print help
 -l,--level <arg>           threshold of print diff
 -n,--namesrvAddr <arg>     Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -o,--order <arg>           order topic
 -t,--timeoutMillis <arg>   request timeout Millis
```

## producerConnection

```bash
usage: mqadmin producerConnection -g <arg> [-h] [-n <arg>] -t <arg>
 -g,--producerGroup <arg>   producer group name
 -h,--help                  Print help
 -n,--namesrvAddr <arg>     Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>           topic name
```

## consumerConnection

```bash
usage: mqadmin consumerConnection -g <arg> [-h] [-n <arg>]
 -g,--consumerGroup <arg>   consumer group name
 -h,--help                  Print help
 -n,--namesrvAddr <arg>     Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## consumerProgress

```bash
usage: mqadmin consumerProgress [-g <arg>] [-h] [-n <arg>] [-s <arg>]
 -g,--groupName <arg>      consumer group name
 -h,--help                 Print help
 -n,--namesrvAddr <arg>    Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--showClientIP <arg>   Show Client IP per Queue
```

## consumerStatus

```bash
usage: mqadmin consumerStatus -g <arg> [-h] [-i <arg>] [-n <arg>] [-s]
 -g,--consumerGroup <arg>   consumer group name
 -h,--help                  Print help
 -i,--clientId <arg>        The consumer's client id
 -n,--namesrvAddr <arg>     Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--jstack                Run jstack command in the consumer progress
```

## cloneGroupOffset

```bash
usage: mqadmin cloneGroupOffset -d <arg> [-h] [-n <arg>] [-o <arg>] -s <arg> -t <arg>
 -d,--destGroup <arg>     set destination consumer group
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -o,--offline <arg>       the group or the topic is offline
 -s,--srcGroup <arg>      set source consumer group
 -t,--topic <arg>         set the topic
```

## clusterList

```bash
usage: mqadmin clusterList [-h] [-i <arg>] [-m] [-n <arg>]
 -h,--help                Print help
 -i,--interval <arg>      specify intervals numbers, it is in seconds
 -m,--moreStats           Print more stats
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## topicList

```bash
usage: mqadmin topicList [-c] [-h] [-n <arg>]
 -c,--clusterModel        clusterModel
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## updateKvConfig

```bash
usage: mqadmin updateKvConfig [-h] -k <arg> [-n <arg>] -s <arg> -v <arg>
 -h,--help                Print help
 -k,--key <arg>           set the key name
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--namespace <arg>     set the namespace
 -v,--value <arg>         set the key value
```

## deleteKvConfig

```bash
usage: mqadmin deleteKvConfig [-h] -k <arg> [-n <arg>] -s <arg>
 -h,--help                Print help
 -k,--key <arg>           set the key name
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--namespace <arg>     set the namespace
```

## wipeWritePerm

```bash
usage: mqadmin wipeWritePerm -b <arg> [-h] [-n <arg>]
 -b,--brokerName <arg>    broker name
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## addWritePerm

```bash
usage: mqadmin addWritePerm -b <arg> [-h] [-n <arg>]
 -b,--brokerName <arg>    broker name
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## resetOffsetByTime

```bash
usage: mqadmin resetOffsetByTime [-c] [-f <arg>] -g <arg> [-h] [-n <arg>] -s <arg> -t <arg>
 -c,--cplus               reset c++ client offset
 -f,--force <arg>         set the force rollback by timestamp switch[true|false]
 -g,--group <arg>         set the consumer group
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--timestamp <arg>     set the timestamp[now|currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -t,--topic <arg>         set the topic
```

## updateOrderConf

```bash
usage: mqadmin updateOrderConf [-h] -m <arg> [-n <arg>] -t <arg> [-v <arg>]
 -h,--help                Print help
 -m,--method <arg>        option type [eg. put|get|delete
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>         topic name
 -v,--orderConf <arg>     set order conf [eg. brokerName1:num;brokerName2:num]
```

## cleanExpiredCQ

```bash
usage: mqadmin cleanExpiredCQ [-b <arg>] [-c <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    Broker address
 -c,--cluster <arg>       clustername
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## cleanUnusedTopic

```bash
usage: mqadmin cleanUnusedTopic [-b <arg>] [-c <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    Broker address
 -c,--cluster <arg>       cluster name
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## startMonitoring

```bash
usage: mqadmin startMonitoring [-h] [-n <arg>]
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## statsAll

```bash
usage: mqadmin statsAll [-a] [-h] [-n <arg>] [-t <arg>]
 -a,--activeTopic         print active topic only
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>         print select topic only
```

## allocateMQ

```bash
usage: mqadmin allocateMQ [-h] -i <arg> [-n <arg>] -t <arg>
 -h,--help                Print help
 -i,--ipList <arg>        ipList
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -t,--topic <arg>         topic name
```

## checkMsgSendRT

```bash
usage: mqadmin checkMsgSendRT [-a <arg>] [-h] [-n <arg>] -s <arg> -t <arg>
 -a,--amount <arg>        message amount | default 100
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--size <arg>          message size | default 128 Byte
 -t,--topic <arg>         topic name
```

## clusterRT

```bash
usage: mqadmin clusterRT [-a <arg>] [-c <arg>] [-h] [-i <arg>] [-m <arg>] [-n <arg>] [-p <arg>] -s <arg>
 -a,--amount <arg>         message amount | default 100
 -c,--cluster <arg>        cluster name | default display all cluster
 -h,--help                 Print help
 -i,--interval <arg>       print interval | default 10 seconds
 -m,--machine room <arg>   machine room name | default noname
 -n,--namesrvAddr <arg>    Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -p,--print log <arg>      print as tlog | default false
 -s,--size <arg>           message size | default 128 Byte
```

## getNamesrvConfig

```bash
usage: mqadmin getNamesrvConfig [-h] [-n <arg>]
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## updateNamesrvConfig

```bash
usage: mqadmin updateNamesrvConfig [-h] -k <arg> [-n <arg>] -v <arg>
 -h,--help                Print help
 -k,--key <arg>           config key
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -v,--value <arg>         config value
```

## getBrokerConfig

```bash
usage: mqadmin getBrokerConfig [-b <arg>] [-c <arg>] [-h] [-n <arg>]
 -b,--brokerAddr <arg>    get which broker
 -c,--clusterName <arg>   get which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## getConsumerConfig

```bash
usage: mqadmin getConsumerConfig -g <arg> [-h] [-n <arg>]
 -g,--groupName <arg>     subscription group name
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## queryCq

```bash
usage: mqadmin queryCq [-b <arg>] [-c <arg>] [-g <arg>] [-h] -i <arg> [-n <arg>] -q <arg> -t <arg>
 -b,--broker <arg>        broker addr.
 -c,--count <arg>         how many.
 -g,--consumer <arg>      consumer group.
 -h,--help                Print help
 -i,--index <arg>         start queue index.
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
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
 -n,--namesrvAddr <arg>      Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
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
 -n,--namesrvAddr <arg>       Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -o,--offset <arg>            Queue offset
 -s,--beginTimestamp  <arg>   Begin timestamp[currentTimeMillis|yyyy-MM-dd#HH:mm:ss:SSS]
 -t,--topic <arg>             Topic name
```

## updateAclConfig

```bash
usage: mqadmin updateAclConfig -a <arg> -b <arg> | -c <arg>  [-g <arg>] [-h] [-i <arg>] [-m <arg>] [-n <arg>]
       [-s <arg>] [-t <arg>] [-u <arg>] [-w <arg>]
 -a,--accessKey <arg>            set accessKey in acl config file
 -b,--brokerAddr <arg>           update acl config file to which broker
 -c,--clusterName <arg>          update acl config file to which cluster
 -g,--groupPerms <arg>           set groupPerms list,eg: groupD=DENY,groupD=SUB
 -h,--help                       Print help
 -i,--defaultTopicPerm <arg>     set default topicPerm in acl config file
 -m,--admin <arg>                set admin flag in acl config file
 -n,--namesrvAddr <arg>          Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--secretKey <arg>            set secretKey in acl config file
 -t,--topicPerms <arg>           set topicPerms list,eg: topicA=DENY,topicD=SUB
 -u,--defaultGroupPerm <arg>     set default GroupPerm in acl config file
 -w,--whiteRemoteAddress <arg>   set white ip Address for account in acl config file
```

## deleteAccessConfig

```bash
usage: mqadmin deleteAccessConfig -a <arg> -b <arg> | -c <arg>  [-h] [-n <arg>]
 -a,--accessKey <arg>     set accessKey in acl config file for deleting which account
 -b,--brokerAddr <arg>    delete acl config account from which broker
 -c,--clusterName <arg>   delete acl config account from which cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## clusterAclConfigVersion

```bash
usage: mqadmin clusterAclConfigVersion -b <arg> | -c <arg>  [-h] [-n <arg>]
 -b,--brokerAddr <arg>    query acl config version for which broker
 -c,--clusterName <arg>   query acl config version for specified cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## updateGlobalWhiteAddr

```bash
usage: mqadmin updateGlobalWhiteAddr -b <arg> | -c <arg>  -g <arg> [-h] [-n <arg>]
 -b,--brokerAddr <arg>                   update global white address to which broker
 -c,--clusterName <arg>                  update global white address to which cluster
 -g,--globalWhiteRemoteAddresses <arg>   set globalWhiteRemoteAddress list,eg: 10.10.103.*,192.168.0.*
 -h,--help                               Print help
 -n,--namesrvAddr <arg>                  Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## getAccessConfigSubCommand

```bash
usage: mqadmin getAccessConfigSubCommand -b <arg> | -c <arg>  [-h] [-n <arg>]
 -b,--brokerAddr <arg>    query acl config version for which broker
 -c,--clusterName <arg>   query acl config version for specified cluster
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## exportMetadata

```bash
usage: mqadmin exportMetadata [-b <arg>] [-c <arg>] [-f <arg>] [-g] [-h] [-n <arg>] [-s] [-t]
 -b,--brokerAddr <arg>    choose a broker to export
 -c,--clusterName <arg>   choose a cluster to export
 -f,--filePath <arg>      export metadata.json path | default /tmp/rocketmq/export
 -g,--subscriptionGroup   only export subscriptionGroup metadata
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -s,--specialTopic        need retryTopic and dlqTopic
 -t,--topic               only export topic metadata
```

## exportConfigs

```bash
usage: mqadmin exportConfigs -c <arg> [-f <arg>] [-h] [-n <arg>]
 -c,--clusterName <arg>   choose a cluster to export
 -f,--filePath <arg>      export configs.json path | default /tmp/rocketmq/export
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

## exportMetrics

```bash
usage: mqadmin exportMetrics -c <arg> [-f <arg>] [-h] [-n <arg>]
 -c,--clusterName <arg>   choose a cluster to export
 -f,--filePath <arg>      export metrics.json path | default /tmp/rocketmq/export
 -h,--help                Print help
 -n,--namesrvAddr <arg>   Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
```

