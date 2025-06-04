var currentQuestionIndex = 0;
var questions = [];
var userAnswers = [];

function loadQuestion() {
    fetch('/questions/all')
        .then(response => response.json())
        .then(data => {
            questions = data;
            displayQuestion();
        });
}

function displayQuestion() {
    var question = questions[currentQuestionIndex];
    var questionContainer = document.getElementById('questionContainer');

    var questionHTML = `
    <h3>${question.question}</h3>
  `;

    if (currentQuestionIndex === 0) {
        // First question is true or false
        questionHTML += `
      <div>
        <input type="radio" id="true" name="answer" value="true">
        <label for="true">True</label>
      </div>
      <div>
        <input type="radio" id="false" name="answer" value="false">
        <label for="false">False</label>
      </div>
    `;
    } else {
        // Remaining questions are multiple choice
        questionHTML += question.answers.map((answer, index) => `
      <div>
        <input type="radio" id="answer${index}" name="answer" value="${answer}">
        <label for="answer${index}">${answer}</label>
      </div>
    `).join('');
    }

    questionHTML += '<button onclick="submitAnswer()">Submit Answer</button>';

    questionContainer.innerHTML = questionHTML;
}

function submitAnswer(e) {
    e.preventDefault();

    const pickedChoice = {
        userChoice: document.querySelector('input[name="answer"]:checked').value,
    };
    console.log(pickedChoice);
    fetch(`http://localhost:8080/update/${id}`, {
        method: "PUT",
        headers:{
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pickedChoice),

            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                displayQuestion();
            } else {
                displayResults();
            }
        });
}

function displayResults() {
    var resultsHTML = userAnswers.map((answer, index) => `
    <div>
      <h3>Question ${index + 1}: ${answer.question}</h3>
      <p>Your answer: ${answer.userAnswer}</p>
      <p>${answer.correct ? 'Correct!' : 'Incorrect.'}</p>
      <p>Correct answer: ${answer.correctAnswer}</p>
    </div>
  `).join('');

    document.getElementById('questionContainer').innerHTML = resultsHTML;
}

loadQuestion();
