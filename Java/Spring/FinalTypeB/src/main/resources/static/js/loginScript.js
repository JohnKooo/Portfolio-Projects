
const signupButton = document.querySelector("#signupBtn");
document.addEventListener('click',  () => {
    const loginForm = document.getElementById('loginForm');
    const errorMessage = document.getElementById('errorMessage');

    // async function (event) 

    loginForm.addEventListener('submit', (e) => {
        e.preventDefault();

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        fetch("http://localhost:8080/user/all")
            .then((response) => response.json())
            .then((users) => {
                var user = users.find(user => user.username === username && user.password === password);

                if (user) {
                    alert('Welcome, ' + username + '!');
                    // Redirect to home page
                    // window.location.href = '/frontend_questions/quiz.html';
                } else {
                    alert('Invalid username or password.');
                }
            });
    });
});
signupButton.addEventListener("click", function() {
    window.location.href = "signup.html";
});

