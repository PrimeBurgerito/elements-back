## Docker

### Mongo

In folder docker/database/mongodb:
 1. `docker-compose up`
 2. `docker-compose -f docker-compose.setup.yml up`
 3. For db dashboard @localhost:8079: `docker-compose -f docker-compose.post.yml up`

In folder docker/database/redis:
 1. `docker-compose up`

In folder docker/nginx:
 1. `docker-compose up`

## DigitalOcean

### Run Application

`$ /usr/lib/jvm/java-13-openjdk-amd64/bin/java -jar /var/tmp/app/elements-api.jar`
`$ /usr/lib/jvm/java-13-openjdk-amd64/bin/java -jar /var/tmp/app/elements-session.jar`

### Swagger

* http://128.199.54.24/elements/api/swagger-ui/index.html?configUrl=/elements/api/v3/api-docs/swagger-config#/

#### Local
* http://localhost:7777/api/swagger-ui/index.html?configUrl=/api/v3/api-docs/swagger-config
