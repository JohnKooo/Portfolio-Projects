**FinalTypeB Project Notes**



**Add A Test**

POST http://localhost:8080/dev/test/add
Content-Type: application/json
```json
{
"name": "Spring Test",
"description": "This Test is to test your understanding."
}
```
**Add Questions to database**

**The post below each object has to be manually added**


POST http://localhost:8080/dev/questions/add
Content-Type: application/json

```json
{
    "question": "is JSON a lightweight data-interchange format?",
    "type": "radio",
    "possibleAnswers": ["True","False"],
    "correctAnswer": "True"
}
```

```json
{
    "question": "How do you parse JSON in Java?",
    "type": "radio",
    "possibleAnswers": ["Using libraries like Jackson or Gson", "By baking cookies", "Manually typing each character"],
    "correctAnswer": "Using libraries like Jackson or Gson"
}
```

```json
{
    "question": "What is the difference between JSONObject and JSONArray in Java?",
    "type": "radio",
    "possibleAnswers": ["JSONObject represents key-value pairs, JSONArray represents an ordered sequence", "They are the same thing", "JSONObject is used for numbers, JSONArray is used for strings"],
    "correctAnswer": "JSONObject represents key-value pairs, JSONArray represents an ordered sequence"
}
```

```json
{
    "question": "How can you serialize Java objects to JSON?",
    "type": "radio",
    "possibleAnswers": ["Using libraries like Jackson or Gson", "Writing them on paper", "Shouting them out loud"],
    "correctAnswer": "Using libraries like Jackson or Gson"
}
```

```json
{
    "question": "What is Jackson library in Java used for?",
    "type": "radio",
    "possibleAnswers": ["JSON processing", "Making music", "Building skyscrapers"],
    "correctAnswer": "JSON processing"
}
```

```json
{
    "question": "How do you handle nested JSON objects in Java?",
    "type": "radio",
    "possibleAnswers": ["Traversing the JSON structure recursively", "Ignoring them", "Burning them with fire"],
    "correctAnswer": "Traversing the JSON structure recursively"
}
```

```json
{
    "question": "What is JSON schema validation in Java?",
    "type": "radio",
    "possibleAnswers": ["Validating JSON data against a predefined schema", "Creating random JSON", "Building sandcastles"],
    "correctAnswer": "Validating JSON data against a predefined schema"
}
```

```json
{
    "question": "How do you handle exceptions while parsing JSON in Java?",
    "type": "radio",
    "possibleAnswers": ["Using try-catch blocks", "Ignoring them", "Dancing around"],
    "correctAnswer": "Using try-catch blocks"
}
```

```json
{
    "question": "What are the advantages of using JSON over XML in Java applications?",
    "type": "radio",
    "possibleAnswers": ["Simpler syntax, lightweight data representation, better compatibility", "More complex syntax, heavier data representation, worse compatibility", "No advantages"],
    "correctAnswer": "Simpler syntax, lightweight data representation, better compatibility"
}
```

```json
{
    "question": "How can you pretty-print JSON output in Java?",
    "type": "radio",
    "possibleAnswers": ["Using libraries like Jackson or Gson", "Yelling at the computer", "Crying softly"],
    "correctAnswer": "Using libraries like Jackson or Gson"
}
```
