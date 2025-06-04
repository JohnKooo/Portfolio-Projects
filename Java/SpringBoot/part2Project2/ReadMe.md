**John Krasko**

**Part 2 Project 1**

This project simply is for adding games to a database. Down below you will
see CRUD documentation on how to add, update(put),get(select all), and delete
from the database. 

Make sure you check that the correct id is selected. 

***
**How to run the project**
1. First start off by running the Part2Project2Application.
2. Then open the entire Project2FrontEnd folder in Visual Studio Code.
3. Then run the home.html on a live server.
4. Now have fun and explore the pages!

***
If you don't want to use the website still then down below is another option.

# ADD - CRUD
curl --location 'http://localhost:8080/add' \
--header 'Content-Type: application/json' \
--data '  {
"gameName": "Binding of Isaac",
"releaseYear": 2011,
"gameCost": 30.00,
"gameType": "Rougelike",
"platform": "NS,Xbox,Playstation,Pc",
"rating": "M"
}'

# PUT - CRUD
curl --location --request PUT 'http://localhost:8080/update/3' \
--header 'Content-Type: application/json' \
--data '{
"gameCost": 40.0,
"rating": "R"
}'

# GET/SELECT ALL - CRUD
curl --location 'http://localhost:8080/all' \
--data ''

# DELETE - CRUD
curl --location --request DELETE 'http://localhost:8080/delete/1' \
--data ''