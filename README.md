# HandsOn - Kafka


## Download Kafka Installer

```
wget https://dlcdn.apache.org/kafka/3.0.0/kafka_2.12-3.0.0.tgz
```


## Extract Package

```
tar zxf kafka_2.12-3.0.0.tgz
```

## Check Folder

```
cd kafka_2.12-3.0.0
ls -ltrh
```

## Running Requeriments

### Start ZooKeeper

```
bin/zookeeper-server-start.sh config/zookeeper.properties
```

### Start Kafka

```
bin/kafka-server-start.sh config/server.properties
```

### Create Topic

```
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic MY_TOPIC_NAME
```

### List Topics

```
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

### Check Topics

```
bin/kafka-console-producer.sh --broker-list --bootstrap-server localhost:9092 --topic MY_TOPIC_NAME

```

### Check Write Input

```
1, Test
2, Test
3, Test
```

### Check Read Streams

```
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic MY_TOPIC_NAME --from-beginning
```

### Check Describe Topics

```
bin/kafka-console-producer.sh --describe --bootstrap-server localhost:9092 
```

### Delete Topic

Before Edit file

```
vim config/server.properties
```

And add parameter

```
delete.topic.enable=true
```

```
bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic MY_TOPIC_NAME
```

