import sys
from input_processing import process_input
from query_translation import translate_to_prolog
from prolog_interaction import query_prolog
from answer_translation import translate_to_english


def main():
    print("Welcome to the English to PROLOG translator.")
    while True:
        user_input = input("Enter your query in English (or type 'exit' to quit): ")
        if user_input.lower() == 'exit':
            print("Exiting the translator.")
            sys.exit(0)

        try:
            structured_query = process_input(user_input)
            prolog_query = translate_to_prolog(structured_query)
            prolog_result = query_prolog(prolog_query)
            english_response = translate_to_english(prolog_result, structured_query["type"])
            print(f"Response: {english_response}")
        except Exception as e:
            print(f"An error occurred: {e}")


if __name__ == "__main__":
    main()
