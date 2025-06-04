const signupForm = document.querySelector("#signupForm");
const saveButton = document.querySelector("#submitBtn");

saveButton.addEventListener("click", (e) => addUser(e));

const addUser = (e) => {
    e.preventDefault();
    const user = {
        username: document.querySelector("#username").value,
        password: document.querySelector("#password").value,
    };
    console.log(user)
    fetch("http://localhost:8080/user/add", {
        method: "POST",
        headers:{
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
        .then((response) => response.text())
        .then(() => window.location.href = "login.html");
};
