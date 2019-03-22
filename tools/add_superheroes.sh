#!/usr/bin/env bash
CSV="data/heroes_information.csv"
DBNAME="$(grep spring.datasource.url server/src/main/resources/application.properties | sed -e 's:.*/::')"

# Alignments
echo "Adding alignments..."
while IFS=, read -r id name gender eye_color race hair_color height publisher skin_color alignment weight
do
  sudo -i -u postgres psql $DBNAME -c\
    "INSERT INTO alignment (name)\
      SELECT '$alignment'\
      WHERE NOT EXISTS (\
        SELECT id FROM alignment WHERE name = '$alignment'\
      )" > /dev/null
done < $CSV

# Publishers
echo "Adding publishers..."
while IFS=, read -r id name gender eye_color race hair_color height publisher skin_color alignment weight
do
  sudo -i -u postgres psql $DBNAME -c\
    "INSERT INTO publisher (name)\
      SELECT '$publisher'\
      WHERE NOT EXISTS (\
        SELECT id FROM publisher WHERE name = '$publisher'\
      )" > /dev/null
done < $CSV

# Races
echo "Adding races..."
while IFS=, read -r id name gender eye_color race hair_color height publisher skin_color alignment weight
do
  sudo -i -u postgres psql $DBNAME -c\
    "INSERT INTO race (name)\
      SELECT '$race'\
      WHERE NOT EXISTS (\
        SELECT id FROM race WHERE name = '$race'\
      )" > /dev/null
done < $CSV

# Heroes
i=0
while IFS=, read -r id name gender eye_color race hair_color height publisher skin_color alignment weight
do
  if [ $i -gt 0 ]
  then
    echo "Adding superhero: $name"
    sudo -i -u postgres psql $DBNAME -c\
      "INSERT INTO superhero (name, gender, skin_color, eye_color, hair_color, height, weight, alignment_id, publisher_id, race_id)\
      VALUES (\
        '$name',\
        '$gender',\
        '$skin_color',\
        '$eye_color',\
        '$hair_color',\
        $height,\
        $weight,\
        (SELECT id FROM alignment WHERE name = '$alignment'),\
        (SELECT id FROM publisher WHERE name = '$publisher'),\
        (SELECT id FROM race WHERE name = '$race')\
      )" > /dev/null
  fi
  i=$((i+1))
done < $CSV
