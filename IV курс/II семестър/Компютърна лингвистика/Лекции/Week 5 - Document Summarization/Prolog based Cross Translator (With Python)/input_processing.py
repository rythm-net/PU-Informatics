import re


def process_input(user_input):
    """
    Process the user's input using regular expressions to identify key structures
    and prepare it for translation into a PROLOG query.

    :param user_input: String containing the user's input in English.
    :return: A dictionary representing the structured query.
    """

    # Example regex patterns for identifying simple queries like "Who teaches X?"
    # You can expand these patterns based on the complexity of your knowledge base.
    user_input = user_input.lower()
    patterns = {
        "who_teaches": re.compile(r"who teaches (?P<subject>[\w \.]+)", re.IGNORECASE),
        "who_is_a_student_of": re.compile(r"who is a student of (?P<teacher>[\w \.]+)", re.IGNORECASE),
        "who_is_a_teacher_of": re.compile(r"who is a teacher of (?P<student>[\w \.]+)", re.IGNORECASE),
    }

    structured_query = {}

    for query_type, pattern in patterns.items():
        match = pattern.match(user_input)
        if match:
            structured_query["type"] = query_type
            structured_query.update(match.groupdict())
            break

    if not structured_query:
        raise ValueError("Could not parse the input. Please try a different query.")

    return structured_query
