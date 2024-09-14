import json
import pathlib

def get_data(opt):
    match opt:
        case "sections":
            return(get_section())
        case "question":
            return(get_questions(opt))


def get_options():
    sections = get_data("sections")
    
    if not sections:
        print("No sections available.")
        return None

    print("Select An Option:")
    for count, item in enumerate(sections, start=1):
        print(f"[{count}]. {item}")

    while True:
        try:
            selected_opt = int(input("\nEnter an option (number): "))
            
            if 1 <= selected_opt <= len(sections):
                print(f"You selected: {sections[selected_opt - 1]}")
                return sections[selected_opt - 1]  
            else:
                print(f"Please select a number between 1 and {len(sections)}.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")
     
def get_questions(opt):
    questions = []
    
    with open("Data\quiz_data.json", "r") as file :
        data = json.load(file)
        questions = list(data["sections"][f"{opt}"])
    return questions

def get_section():
    section = []
    
    with open("Data\quiz_data.json", "r") as file:
        data = json.load(file)
        section = list(data['sections'].keys())
    
    return section
    
def get_the_questions():
    pass

    