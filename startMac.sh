#!/bin/bash

echo "✅ Gotowe! Teraz uruchamiam aplikację Spring Boot..."

cd "$(dirname "$0")"

java -Dspring.profiles.active=local -jar target/app-0.1.0-SNAPSHOT.jar
