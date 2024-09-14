# Quiz System

A comprehensive command-line and web-based quiz system that supports multiple programming languages, including Python, Java, and web development technologies. This system allows users to answer multiple-choice questions from different categories and calculates their final score and percentage.

## Features
- **Multi-Language Support**: Implemented in Python and Java, with a web version using HTML, CSS, and JavaScript.
- **Category Selection**: Choose from different categories of questions (e.g., Sports, General Knowledge, etc.).
- **Multiple-Choice Questions**: Answer questions with options labeled [A], [B], [C], etc.
- **Immediate Feedback**: Get instant feedback on your answers.
- **Score Calculation**: Displays total score and percentage at the end of the quiz.

## Project Structure

```bash
.
├── python/               # Python implementation of the quiz system
│   ├── quiz.py           # Main quiz system logic in Python
│   ├── reader/
│   │   └── data_reader.py # Module for fetching quiz questions
│   └── README.md         # Documentation for the Python version
│
├── java/                 # Java implementation of the quiz system
│   ├── QuizSystem.java   # Main quiz system logic in Java
│   ├── Question.java      # Class for question structure
│   └── README.md         # Documentation for the Java version
│
├── web/                  # Web implementation of the quiz system
│   ├── index.html        # Main HTML file
│   ├── style.css         # CSS file for styling
│   ├── script.js         # JavaScript file for quiz logic
│   └── README.md         # Documentation for the web version
│
└── README.md             # Main project documentation
```

## Installation

### Python Version

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/quiz-system.git
   cd quiz-system/python
   ```

2. **Dependencies**:
   This system doesn't require any external libraries. Just ensure that you have Python 3.x installed.

3. **Data Source**:
   The questions are read from a data source via `data_reader.get_questions(category)`. You need to provide a valid implementation of the `data_reader` module that supplies the quiz questions.

4. **Run the program**:
   ```bash
   python quiz.py
   ```

### Java Version

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/quiz-system.git
   cd quiz-system/java
   ```

2. **Compile and Run**:
   ```bash
   javac QuizSystem.java
   java QuizSystem
   ```

### Web Version

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/quiz-system.git
   cd quiz-system/web
   ```

2. **Open in a browser**:
   Open `index.html` in your preferred web browser to start the quiz.

## Usage

1. **Category Selection**:
    - The quiz prompts you to select a category of questions.

2. **Answering Questions**:
    - For each question, the system displays a list of options labeled with [A], [B], [C], etc.
    - You input your choice by typing the corresponding letter (e.g., `B`).
    - The system compares your answer to the correct one and provides immediate feedback.

3. **Scoring**:
    - The system keeps track of your score throughout the quiz.
    - After answering all questions, your total score and percentage will be displayed.

## Customizing the Quiz

You can customize the quiz by adding more categories and questions in the `data_reader` module for Python or by modifying the corresponding classes for Java.

### Question Format
Ensure that the questions are structured as dictionaries in Python or as `Question` objects in Java, with the following keys:
- **Python**:
  ```python
  {
      "question": "What is the capital of France?",
      "options": ["Berlin", "London", "Paris", "Rome"],
      "answer": "Paris"
  }
  ```

- **Java**:
  ```java
  public class Question {
      private String question;
      private List<String> options;
      private String answer;

      // Constructor, Getters, and Setters
  }
  ```

