from reader import data_reader
import os

def displayHeader():
    print("Welcome to a general knowledge quiz")

def displayRules():
    print("""\nGENERAL RULES:
1. SELECT YOUR PREFERRED TOPIC.
2. GET READY TO ANSWER QUESTIONS
3. 10 QUESTIONS IN TOTAL
4. AT THE END A SCORE WILL BE CALCULATED
          """)

def clearing():
    os.system("cls")

def main():
    displayHeader()
    displayRules()
    opt = data_reader.get_options()
    clearing()    
    

if __name__ == "__main__":
    main()