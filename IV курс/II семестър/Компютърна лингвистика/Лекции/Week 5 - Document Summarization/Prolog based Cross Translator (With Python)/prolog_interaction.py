from pyswip import Prolog


def query_prolog(prolog_query):
    """
    Sends a query to the PROLOG system using pyswip and retrieves the results.

    :param prolog_query: The PROLOG query string.
    :return: A list of dictionaries, each representing a result from the query.
    """
    print("debug: 0")
    prolog = Prolog()
    # Assuming your PROLOG knowledge base is defined in 'knowledge_base.pl'
    print("debug: 1")
    prolog.consult('knowledge_base.pl')
    print("debug: 2")
    results = list(prolog.query(prolog_query))
    print("debug: 3")
    # pyswip returns results as a list of dictionaries, exactly what we need.
    return results
