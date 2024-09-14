from reader import data_reader
import quiz

def displayCategory(cate):
    print(f"Category Selection - {cate}")

def get_answer(ques_dict):
    score = 0
    question = ques_dict["question"]
    options = ques_dict["options"]
    answer = ques_dict["answer"]  # Full answer text (e.g., "Football")
    
    print(f"\nQuestion: {question}\n")
    
    for i, opt in enumerate(options):
        print(f"[{chr(65+i)}] {opt}")
    
    try:
        selected_opt = input("\nEnter an answer: ").upper()[0]
        
        # Validate selection
        if ord("A") <= ord(selected_opt) < ord("A") + len(options):
            print(f"You selected: {selected_opt}")
            
            selected_answer = options[ord(selected_opt) - ord("A")]  # Map letter to option
            if selected_answer == answer:
                score += 1
                #print("Correct!")
            else:
                score += 0
                #print(f"Wrong. The correct answer is {answer}.")
        else:
            print(f"Please select a valid option from A to {chr(64+len(options))}.")
    
    except (IndexError, ValueError):
        print("Invalid input. Please enter a valid option.")
        
    print()
    return score



def calculate_total(score, ques):
    total = len(ques)
    
    print(f"Total: {score}/{total}")
    
    if total > 0:
        percent = (score / total) * 100
    else:
        percent = 0 

    print(f"Percentage: {percent:.2f}%")


def sheet(category):
    score = 0
    displayCategory(category)
    
    question_sheets = data_reader.get_questions(category)
    
    for sheet in question_sheets:
        question_dict = dict(sheet)
        score += get_answer(question_dict)
    
    quiz.clearing()
    
    calculate_total(score, question_sheets)
