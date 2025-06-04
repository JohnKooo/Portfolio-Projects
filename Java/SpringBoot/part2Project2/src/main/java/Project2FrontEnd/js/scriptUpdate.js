const numbers = [0]

window.onload = () => {
    fetch("http://localhost:8080/all")
    .then((response) => response.json())
    .then((data) => showGames(data))
}

// Shows each game with an id specifically to the one you want to delete or update.
const showGames = (games) =>{
    console.log(games)
    const tbody = document.querySelector('#gameTable tbody')
    tbody.innerHTML = "";

    games.forEach((game) => {
        const tr = document.createElement('tr');
        ["id", "gameCost", "gameName","gameType", "platform","rating","releaseYear"].forEach(
            (key) => {
                // console.log(key)
                const td = document.createElement("td");
                const input = document.createElement('input');
                input.disabled = true
                if (key == "gameCost") {
                    td.classList.add("updateCostField")
                    input.value = game[key]
                    input.type = "number"
                    input.id = `gameCost${game["id"]}`
                    td.appendChild(input)
                    tr.appendChild(td)
                }else if (key == "rating") {
                    td.classList.add("updateRatingField")
                    input.value = game[key]
                    input.type = "text"
                    input.id = `rating${game["id"]}`
                    td.appendChild(input)
                    tr.appendChild(td)
                } else {
                    td.textContent = game[key];
                    tr.appendChild(td)   
                }
            }
        )
        
        const actionTd = document.createElement("td");
        actionTd.id = `AA${game["id"]}`;

        const deleteButton = document.createElement("button")
        deleteButton.textContent = "Delete";
        deleteButton.addEventListener("click", () => deleteGame(game.id))
        actionTd.append(deleteButton);

        const updateButton = document.createElement("button")        
        
        updateButton.id = `A${game["id"]}`;
        
        updateButton.textContent = "Update";
        updateButton.addEventListener("click", () => updateGame(game.id, updateButton.id))
        actionTd.append(updateButton);

        tr.append(actionTd);

        tbody.appendChild(tr)
    });
}

// Simply deletes the game
const deleteGame = (id) => {
    fetch(`http://localhost:8080/delete/${id}`, {
        method: "DELETE"
    })
    .then((response) => response.text())
    .then(() => window.location.reload())
}

// Updates the name by grabbing the id of the student
const updateGame = (id, idName) => {
    console.log(idName)
    const buttonBox = document.querySelector(`#AA${id}`);
    const gameCost = document.querySelector(`#gameCost${id}`)
    const rating = document.querySelector(`#rating${id}`)
    gameCost.disabled = false;
    rating.disabled = false;
    console.log(gameCost)
    console.log(rating)
    
    buttonBox.innerHTML = ""
    const updateDataButton = document.createElement("button")
    updateDataButton.textContent = "Save"
    buttonBox.appendChild(updateDataButton)

    updateDataButton.addEventListener("click", () => saveUpdatedGame(id))
}

// saves game into database
const saveUpdatedGame = (id) => {
    const game = {
        gameCost: document.querySelector(`#gameCost${id}`).value,
        rating: document.querySelector(`#rating${id}`).value,
    };

    fetch(`http://localhost:8080/update/${id}`,{
        method: "PUT",
        headers:{
            "Content-Type": "application/json"
        },
        body: JSON.stringify(game)
    })
    .then((response) => response.text())
    .then(() => window.location.reload())
}