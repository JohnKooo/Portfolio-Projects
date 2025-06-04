// document.addEventListener("click", () => {
    const quizQuestionsContainer = document.getElementById("quizQuestions");
    let currentQuestionIndex = 0;
    let userAnswers = {};

    // Fetch quiz questions from the backend
    fetch('http://localhost:8080/questions/all')
        //         .then((response) => response.json())
        //         .then((data) => displayQuestion(data));
        .then(response => {
            if (!response.ok) {
                console.log("Failed to fetch quiz questions");
            }
            return response.json();
        })
        .then(questions => {
            // Display the first question
            displayQuestion(questions[currentQuestionIndex]);
        })


    function displayQuestion(question) {
        // Clear previous question
        quizQuestionsContainer.innerHTML = "";

        // Create HTML elements for the current question
        const questionElement = document.createElement("div");
        const theQuestion = document.createElement("p")
        theQuestion.innerHTML = question.question;
        questionElement.appendChild(theQuestion);
        // questionElement.textContent = question.question;
        
        // Append question options
        question.possibleAnswers.forEach(answer => {
            const optionElement = document.createElement("input");
            optionElement.type = "radio";
            optionElement.name = "answer";
            optionElement.value = answer;
            var selectedChoice = document.getElementsByName("answer");
            console.log("elements"+selectedChoice);
            optionElement.addEventListener("change", () => {
                userAnswers[currentQuestionIndex] = this.value;
                console.log(selectedChoice +"what ever value this is lol: " + selectedChoice[0].value);
                console.log("hello")
            });
            const labelElement = document.createElement("label");
            labelElement.textContent = answer;
            questionElement.appendChild(optionElement);
            questionElement.appendChild(labelElement);
        });
        quizQuestionsContainer.appendChild(questionElement);

        // Add button to submit answer
        const nextButton = document.createElement("button");
        nextButton.textContent = "Next";
        nextButton.addEventListener("click", () => {
            
            if (currentQuestionIndex < question.length) {
                displayQuestion(questions[currentQuestionIndex]);
            } else {
                console.log(userAnswers)
                submitAnswers(question.id);
                currentQuestionIndex++;
            }
        });
        quizQuestionsContainer.appendChild(nextButton);
    }

    function submitAnswers(id) {
        // Send a PUT request to save user answers to the backend
        fetch(`http://localhost:8080/question/update/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userAnswers)
        })
            .then(response => {
                if (!response.ok) {
                    console.log("Failed to submit answers");
                }
                return response.json();
            })
            .then(result => {
                // Redirect to result page upon successful submission
                window.location.href = "/quiz/result";
            })

    }
// });









// var currentQuestionIndex = 0;
// var questions = [];
// var userAnswers = [];
//
// window.onload = () => loadQuestion();
//
// function loadQuestion() {
//     fetch('/questions/all')
//         .then((response) => response.json())
//         .then((data) => displayQuestion(data));
// }
//
// function displayQuestion(questions) {
//     console.log(questions);
//
//     // var questionContainer = document.getElementById('questionContainer');
//     //
//     // questions.forEach((question) => {
//     //     questionContainer.innerHTML = "";
//     //     const header = document.createElement("h3");
//     //     header.textContent = question.question;
//     //
//     //
//     // })
// }
//
// //     var questionHTML = `
// //     <h3>${question.question}</h3>
// //   `;
// //
// //     if (currentQuestionIndex === 0) {
// //         // First question is true or false
// //         questionHTML += `
// //       <div>
// //         <input type="radio" id="true" name="answer" value="true">
// //         <label for="true">True</label>
// //       </div>
// //       <div>
// //         <input type="radio" id="false" name="answer" value="false">
// //         <label for="false">False</label>
// //       </div>
// //     `;
// //     } else {
// //         // Remaining questions are multiple choice
// //         questionHTML += question.answers.map((answer, index) => `
// //       <div>
// //         <input type="radio" id="answer${index}" name="answer" value="${answer}">
// //         <label for="answer${index}">${answer}</label>
// //       </div>
// //     `).join('');
// //     }
// //
// //     questionHTML += '<button onclick="submitAnswer()">Submit Answer</button>';
// //
// //     questionContainer.innerHTML = questionHTML;
// // }
// //
// // function submitAnswer(e) {
// //     e.preventDefault();
// //
// //     const pickedChoice = {
// //         userChoice: document.querySelector('input[name="answer"]:checked').value,
// //     };
// //     console.log(pickedChoice)
// //     fetch(`http://localhost:8080/update/${id}`, {
// //         method: "PUT",
// //         headers:{
// //             "Content-Type": "application/json"
// //         },
// //         body: JSON.stringify(pickedChoice)
// //
// //         currentQuestionIndex++;
// //         if (currentQuestionIndex < questions.length) {
// //         displayQuestion();
// //     } else {
// //         displayResults();
// //     }
// // });
// // }
// //
// // function displayResults() {
// //     var resultsHTML = userAnswers.map((answer, index) => `
// //     <div>
// //       <h3>Question ${index + 1}: ${answer.question}</h3>
// //       <p>Your answer: ${answer.userAnswer}</p>
// //       <p>${answer.correct ? 'Correct!' : 'Incorrect.'}</p>
// //       <p>Correct answer: ${answer.correctAnswer}</p>
// //     </div>
// //   `).join('');
// //
// //     document.getElementById('questionContainer').innerHTML = resultsHTML;
// // }
// //
// // loadQuestion();
