from reader import data_reader
import quiz

def displayCategory(cate):
    print(f"Category Selection - {cate}")


def get_answer(ques_dict):
    score = 0
    question = ques_dict["question"]
    options = ques_dict["options"]
    answer = ques_dict["answer"]
    
    print(f"\nQuestion: {question}\n")
    
    for i,opt in enumerate(options):
        print(f"[{chr(65+i)}] {opt}")
        
    try:
        selected_opt = input("\nEnter an answer: ").upper()[0]
            
        if ord("A") <=  ord(selected_opt) <= ord("D"):
            print(f"You selected: {selected_opt}")
            
            if selected_opt == answer:
                score += 1
        else:
            print(f"Please select a number between A and D.")
    
    except ValueError:
        print("Invalid input. Please enter a valid number.")
        
    print()
    return score
        
    
def sheet(category):
    score = 0
    displayCategory(category)
    question_sheets = data_reader.get_questions(category)
    #quiz.clearing()
    for sheet in question_sheets:
        question_dict = dict(sheet)
        answer = get_answer(question_dict)
        score += answer
    
    quiz.clearing()