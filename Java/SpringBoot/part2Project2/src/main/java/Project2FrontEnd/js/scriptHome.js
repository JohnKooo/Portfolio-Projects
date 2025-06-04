window.onload = () => {
    fetch("http://localhost:8080/all")
    .then((response) => response.json())
    .then((data) => showGames(data))
}

// simply shows all the games for viewing pleasure
const showGames = (games) =>{
    console.log(games)
    const tbody = document.querySelector('#gameTable tbody')
    tbody.innerHTML = "";

    games.forEach((game) => {
        const tr = document.createElement('tr');
        ["id", "gameCost", "gameName","gameType", "platform","rating","releaseYear"].forEach(
            (key) => {
                const td = document.createElement("td");
                td.textContent = game[key];
                tr.appendChild(td)
            }
        )
        tbody.appendChild(tr)
    });
}
