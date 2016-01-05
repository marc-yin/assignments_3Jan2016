#!/bin/bash
PS3="Select the testing CRUD operation(please respect the testing sequence from 1 to 4, enter 5 to exit):"

#pre-fill the data collection
curl -i -X POST -H "Content-Type:application/json" -d '{  "name" : "banana3",  "value" : 7.7 }' http://localhost:8080/restAPI/items &> /dev/null
curl -i -X POST -H "Content-Type:application/json" -d '{  "name" : "pear",  "value" : 4.2 }' http://localhost:8080/restAPI/items &> /dev/null

#test the CRUD operations
select operation in Create Read Update Delete exit
do
  case $operation in

    Create)
      echo "************************************************"
      echo "Creating a new Entry by POST:"
        curl -i -X POST -H "Content-Type:application/json" -d '{  "name" : "watermelon",  "value" : 7.7 }' http://localhost:8080/restAPI/items

      echo "************************************************"
      echo "Creating a new Entry by Put:"
        curl -i -X POST -H "Content-Type:application/json" -d '{  "name" : "apple",  "value" : 5.8 }' http://localhost:8080/restAPI/items

      echo "************************************************"
      echo "Mongodb items collection:"
        curl http://localhost:8080/restAPI/items
      ;;


    Read)
      echo "************************************************"
      echo "Retrieving exiting Entry whose name is pear:"
        curl http://localhost:8080/restAPI/items/search/findByName?name=pear
      ;;


    Update)
      echo "************************************************"
      echo "Updating exiting Entry:"
      echo "usage: curl -X PATCH -H "Content-Type:application/json" -d '{ "name": "banana3" }' http://localhost:8080/restAPI/items/568bc3cc44ae887a48e8003d"
      ;;


    Delete)
      echo "************************************************"
      echo "Deleting an exiting Entry:"
      echo "usage: curl -X DELETE http://localhost:8080/restAPI/items/568bc3cc44ae887a48e8003d"
      ;;


    exit|*)
      echo "Bye"
      break
      ;;
   esac

done
