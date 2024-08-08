def translate_to_english(prolog_results, query_type):
    """
    Translates the results from a PROLOG query back into natural English sentences.

    :param prolog_results: A list of dictionaries, each representing a result from the PROLOG query.
    :param query_type: The type of the query which determines the format of the English response.
    :return: A string containing the English translation of the PROLOG results.
    """
    if not prolog_results:
        return "No results found."

    response_templates = {
        "who_teaches": "subject is taught by {Teacher}.",
        "who_is_a_student_of": "The student is {Student}.",
        "who_is_a_teacher_of": "The teacher is {Teacher}.",
    }

    print("Prolog Results", prolog_results)

    responses = []
    template = response_templates.get(query_type)

    if not template:
        return "Unsupported query type."

    for result in prolog_results:
        # Filling in the details into the response template
        response = template.format(**result)
        responses.append(response)

    return " ".join(responses)
