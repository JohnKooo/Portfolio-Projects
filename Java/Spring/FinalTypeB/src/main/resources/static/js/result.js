const totalButton = document.querySelector("#submitBtn");
totalButton.addEventListener("click", (e) => GetUser(e));

window.onload = () => {
    fetch("/questions/all")
        .then((response) => response.json())
        .then((data) => displayResults(data));
};

var points = 0;
const displayResults = (answers) => {

    console.log(answers);
    const tbody = document.querySelector("#quizTable tbody");
    const div = document.querySelector("#div");
    tbody.innerHTML = "";

    answers.forEach((answer) => {
        //points increment if user choice matches correct answer
        if(answer.correct_answer === answer.user_choice){
        points++;
        }
        const tr = document.createElement("tr");
        const columnNames = [
            "question",
            "correct_answer",
            "user_id",
            "user_choice",
        ];
        columnNames.forEach((key) => {
            const td = document.createElement("td");
            td.textContent = answer[key];
            tr.appendChild(td);
        });
        tbody.appendChild(tr);

    });

    //display total
    const total = document.createElement("h4");
    total.textContent = `The total is ${points}`;
    div.appendChild(total);

};

//get user
const GetUser = (e) => {
    e.preventDefault();
    fetch("user/all")
        .then((response) => response.json())
        .then((data) => TotalScore(data));

}


//add total to best score and update if necessary
const TotalScore = (user) => {
    user.preventDefault();

    //check to see if the best score is empty or less than curent score
    if (!user.best_score || user.best_score.trim() === '' || user.best_score < points) {
        //update best score
        fetch(`user/update/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(points)
        })
            .then((response) => response.text())
            .then(() => {
                console.log("Best score updated: ", points)
            })
    }else{
        console.log("Score stays the same.")
    }
}