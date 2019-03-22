#!/usr/bin/env bash
CSV="data/super_hero_powers.csv"
DBNAME="$(grep spring.datasource.url server/src/main/resources/application.properties | sed -e 's:.*/::')"

IFS=','
POWERS=`echo "$(head -n 1 $CSV)"`

# Add superpowers
P=()
i=0
for POWER in $POWERS;
do
  if [ $i -gt 0 ]
  then
    echo "Adding superpower: $POWER"
    sudo -i -u postgres psql $DBNAME -c\
      "INSERT INTO superpower(name) VALUES ('$POWER');" > /dev/null
  fi
  P[$i]=$POWER
  i=$((i+1))
done

echo ${#P[@]}
echo ${P[1]}

# Add hero-superpowers
IFS=$'\n'
for line in `cat $CSV` ;
do
  IFS=',' read -r -a array <<< "$line"
  HERO_NAME=${array[0]}
  echo "Adding superpowers to $HERO_NAME"
  i=0
  for POWER in "${array[@]}"
  do
    if [ "$POWER" = "True" ]; then
      HERO_POWER=${P[i]}
      sudo -i -u postgres psql $DBNAME -c\
        "INSERT INTO superhero_has_superpower(superhero_id, superpower_id)\
          SELECT\
            (SELECT id FROM superhero WHERE name = '$HERO_NAME'),\
            (SELECT id FROM superpower WHERE name = '$HERO_POWER')\
          WHERE EXISTS (\
            SELECT id FROM superhero WHERE name = '$HERO_NAME'\
          );" > /dev/null
    fi
    i=$((i+1))
  done
done
