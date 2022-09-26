#!/bin/bash

docker stop user-service-db && docker rm user-service-db
docker run \
  --name user-service-db \
  -p 5432:5432 \
  -v "pgdata:`pwd`/pgdata" \
  -e POSTGRES_PASSWORD=postgres \
  -d postgres:10.1-alpine