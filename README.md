# Routine Transactions

Application responsable to receive and register accounts transactions

## Setup

- [JDK 1.8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [PostgreSQL 11.7](https://www.postgresql.org/)
- [Docker](https://www.docker.com/) - Optional
- [Docker Compose](https://www.docker.com/) - Optional

### How to prepare your environment

Follow the steps to prepare you machine to develop or just run the API.

### Without Docker

Export the environmet variables required the application connect with database

```bash
root@81e49a8b8ad9:/# export DATABASE_HOST=db
root@81e49a8b8ad9:/# export DATABASE_USER=postgres
root@81e49a8b8ad9:/# export DATABASE_PASSWORD=""
root@81e49a8b8ad9:/# export DATABASE_NAME=routine_transactions
```

With your database server up, create your main db

```bash
root@81e49a8b8ad9:/# ./scripts/created_databse.sh
```

Cause any problem appear please run the command directly at database.

```bash
root@81e49a8b8ad9:/# psql -U <username> -h localhost
```

```bash
postgres=# CREATE DATABASE <DATABASE_NAME>;
```

Now you'll be able to run the aplication

```
root@81e49a8b8ad9:/# ./nvmw package && java -jar target/<package-name>
```

### With Docker

You need to build the base image

```bash
root@81e49a8b8ad9:/# docker-compose build
```

Create your main db

```bash
root@81e49a8b8ad9:/# docker-compose run --rm api ./scripts/create_database.sh
```

Generate the package

```bash
root@81e49a8b8ad9:/# docker-compose run --rm api ./mvnw package
```

Now you'll be able to run the aplication

```
root@81e49a8b8ad9:/# docker-compose up
```