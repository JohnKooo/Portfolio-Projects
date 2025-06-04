const submitButton = document.querySelector("#submitBtn")
const updateUser = document.querySelector("#updateUser")
submitButton.addEventListener("click", (e) => addTheGame(e))

// gets user data into an object called "game" then sends it to be added to the database
const addTheGame = (e) => {
    e.preventDefault()
    const game = {
        gameCost: document.querySelector("#gameCost").value,
        gameName: document.querySelector("#gameName").value,
        gameType: document.querySelector("#gameType").value,
        platform: document.querySelector("#platform").value,
        rating: document.querySelector("#rating").value,
        releaseYear: document.querySelector("#releaseYear").value,

    };
    console.log(game)
    
    addGame(game)
    
};

// adds game to database
const addGame = (game) => {
    fetch("http://localhost:8080/add",{
        method: "POST",
        headers:{
            "Content-Type": "application/json"
        },
        body: JSON.stringify(game)
    })
    .then((response) => response.text())
    .then(() => window.location.reload())
    updateUser.innerHTML = "<p>Game Added</p>"
}