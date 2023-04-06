#!/bin/zsh
docker compose down
docker compose up -d
echo "waiting for kafka to come up ..."
sleep 5
docker exec docker-broker-1 kafka-topics --bootstrap-server localhost:9092 --topic topic_1 --create --partitions 1 --replication-factor 1 --if-not-exists
sleep 5
docker exec docker-broker-1 kafka-topics --bootstrap-server localhost:9092 --topic topic_2 --create --partitions 1 --replication-factor 1 --if-not-exists
sleep 5
echo "creating topics... "
echo "created topics :"
docker exec docker-broker-1 kafka-topics --bootstrap-server localhost:9092 --list --exclude-internal