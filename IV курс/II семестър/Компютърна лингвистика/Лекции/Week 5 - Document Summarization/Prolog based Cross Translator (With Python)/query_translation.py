def translate_to_prolog(structured_query):
    """
    Translates a structured query dictionary into a PROLOG query string.

    :param structured_query: Dictionary with query type and relevant details.
    :return: String representing the corresponding PROLOG query.
    """

    # Dictionary mapping structured query types to PROLOG query templates
    query_templates = {
        "who_teaches": "teaches(Teacher, '{subject}').",
        "who_is_a_student_of": "student_of(Student, '{teacher}').",
        "who_is_a_teacher_of": "student_of({student}, Teacher)."
    }

    query_type = structured_query.get("type")
    if query_type not in query_templates:
        raise ValueError("Unsupported query type.")

    # Using the query template and filling in the details from the structured query
    prolog_query = query_templates[query_type].format(**structured_query)
    print(prolog_query)

    return prolog_query
