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
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic AMOSTRA_NOVO_ITEM

```

### Check Write Input

```
Item1, Alpha, 100
Item2, Beta, 200
Item3, Charlie, 300
Item4, Delta, 400
Item5, Echo, 500
```

### Check Read Streams

```
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic AMOSTRA_NOVO_ITEM --from-beginning
```
