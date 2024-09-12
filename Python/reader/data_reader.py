import json

def get_data(opt):
    match opt:
        case "header":
            return(get_headers())
        case "question":
            pass


def get_options():
    # Assuming get_data("headers") retrieves the list of section titles
    sections = get_data("headers")
    
    if not sections:
        print("No sections available.")
        return None

    print("Select An Option:")
    for count, item in enumerate(sections, start=1):
        print(f"[{count}]. {item}")

    # Loop to ensure valid input
    while True:
        try:
            selected_opt = int(input("\nEnter an option (number): "))
            
            if 1 <= selected_opt <= len(sections):
                print(f"You selected: {sections[selected_opt - 1]}")
                return sections[selected_opt - 1]  # Return the selected section
            else:
                print(f"Please select a number between 1 and {len(sections)}.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")

            
    


def get_headers():
    section = []
    
    with open("Data\quiz_data.json", "r") as file:
        data = json.load(file)
        section = list(data['sections'].keys())
    
    return section
    
def get_the_questions():
    pass

    