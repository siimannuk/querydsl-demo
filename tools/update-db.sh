#!/usr/bin/env bash
if [ -z "$LIQUIBASE_HOME" ]; then
  echo "LIQUIBASE_HOME environment variable must be set!"
  exit 1
fi

DBNAME="$(grep spring.datasource.url server/src/main/resources/application.properties | sed -e 's:.*/::')"
DBUSER="$(grep "^ *spring.datasource.username" server/src/main/resources/application.properties | sed -e 's/^[^=]*= *//')"
DBPASS="$(grep "^ *spring.datasource.password" server/src/main/resources/application.properties | sed -e 's/^[^=]*= *//')"

POSTGRES_JAR=$LIQUIBASE_HOME/lib/postgresql-9.4.1209.jar

$LIQUIBASE_HOME/liquibase --driver=org.postgresql.Driver \
    --classpath=$POSTGRES_JAR \
    --logFile=server/build/liquibase_update.log --logLevel=debug \
    --changeLogFile=server/db/liquibase-changelog.xml \
    --url="jdbc:postgresql://localhost:5432/$DBNAME" --username=$DBUSER --password=$DBPASS \
    update
