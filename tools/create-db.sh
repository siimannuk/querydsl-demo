#!/usr/bin/env bash
DBNAME="$(grep spring.datasource.url server/src/main/resources/application.properties | sed -e 's:.*/::')"
DBUSER="$(grep "^ *spring.datasource.username" server/src/main/resources/application.properties | sed -e 's/^[^=]*= *//')"
DBPASS="$(grep "^ *spring.datasource.password" server/src/main/resources/application.properties | sed -e 's/^[^=]*= *//')"

# Creates database
sudo -i -u postgres createdb "$DBNAME"

# Creates user
sudo -i -u postgres psql -c "create user $DBUSER with password '$DBPASS';"

# Grants rights to user
sudo -i -u postgres psql $DBNAME -c "grant all on database $DBNAME to $DBUSER;"
