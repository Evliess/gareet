## https://kafka.apache.org/24/documentation.html#producerapi

### 3.1 Broker Configs

```bash
broker.id
log.dirs
zookeeper.connect
compression.type
min.insync.replicas
unclean.leader.election.enable
```

### 3.3 Producer Configs

```bash
acks
enable.idempotence
retries
max.in.flight.requests.per.connection
interceptor.classes
buffer.memory
compression.type
batch.size 
linger.ms
```

### 3.4 Consumer Configs

```bash
# A unique string that identifies the consumer group this consumer belongs to. 
# This property is required if the consumer uses either the group management functionality by using subscribe(topic) or the Kafka-based offset management strategy.
group.id 

#This can be used in combination with a larger session timeout to avoid group rebalances caused by transient unavailability (e.g. process restarts). 
# If not set, the consumer will join the group as a dynamic member, which is the traditional behavior.
group.instance.id 

session.timeout.ms
enable.auto.commit

# The maximum delay between invocations of poll() when using consumer group management. 
# This places an upper bound on the amount of time that the consumer can be idle before fetching more records. 
# If poll() is not called before expiration of this timeout, then the consumer is considered failed and the group will rebalance in order to reassign the partitions to another member. 
# For consumers using a non-null group.instance.id which reach this timeout, partitions will not be immediately reassigned. 
# Instead, the consumer will stop sending heartbeats and partitions will be reassigned after expiration of session.timeout.ms. 
# This mirrors the behavior of a static consumer which has shutdown.
max.poll.interval.ms

fetch.max.wait.ms
fetch.min.bytes
isolation.level
```