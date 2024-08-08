import requests
import json
import nltk

nltk.download('omw-1.4')
import sys
from nltk.corpus import genesis
from nltk.corpus import wordnet as wn
from simplejson import JSONDecodeError

# from google_trans_new import google_translator
import numpy as np
import pandas as pd
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
import re
from googletrans import Translator, LANGUAGES


words_tags = {  # list of tableNames
    "student": {"tn": "student", "dc": "faculty_number"}, "students": {"tn": "student"},
    "specializing": {"tn": "specialty"}, "specialty": {"tn": "specialty", "dc": "specname"},
    "faculty": {"tn": "faculty"}, "discipline": {"tn": "discipline"}, "department": {"tn": "department"},
    "teacher": {"tn": "teacher"}, "form": {"tn": "form"}, "degree": {"tn": "degree"},
    "university": {"tn": "university"},
    "examprotocol": {"tn": "examprotocol"}, "examprotocolcontent": {"tn": "examprotocolcontent"},
    "paymentfee": {"tn": "paymentfee"}, "sciendegree": {"tn": "sciendegree"}, "users": {"tn": "users"},
    # tableName Student
    "course": {"cn": "course", "tn": "student"}, "year": {"cn": "course", "tn": "student"},
    "faculty_number": {"cn": "faculty_number", "tn": "student"},
    "faculty_numbers": {"cn": "faculty_number", "tn": "student"},
    "faculting_number": {"cn": "faculty_number", "tn": "student"},
    "student_name": {"cn": "username", "tn": "users"},
    # tableName Users
    "user_name": {"cn": "username", "tn": "users"},
    "student_named": {"cn": "name", "tn": "users"},
    "named": {"cn": "name", "tn": "users"},
    "called": {"cn": "name", "tn": "users"}, "name": {"cn": "name", "tn": "users"},
    "address": {"cn": "address", "tn": "users"}, "sex": {"cn": "sex", "tn": "users"},
    "user": {"tn": "users", "dc": "username"}, "email_address": {"cn": "email_address", "tn": "users"},
    "male": {"val": "male", "cn": "sex", "tn": "users"}, "age": {"cn": "age", "tn": "users"},
    "female": {"val": "female", "cn": "sex", "tn": "users"}, "say": {"cn": "name", "tn": "users"},
    "telephone": {"cn": "telephone", "tn": "users"}, "isforeign": {"cn": "isforeign", "tn": "users"},
    "foreign": {"val": "foreign", "cn": "isforeign", "tn": "users"},
    "foreigner": {"val": "foreign", "cn": "isforeign", "tn": "users"},
    "egn": {"cn": "egn", "tn": "users"},
    "username": {"cn": "username", "tn": "users"}, "user_named": {"cn": "username", "tn": "user"},
    "users": {"tn": "users", "dc": "username"},
    # tableName Specialty
    "specname": {"cn": "specname", "tn": "specialty"},
    "eduform": {"cn": "eduform", "tn": "specialty"},
    # "education degree": {"cn": "edudegname", "tn": "edudegree"},
    "code": {"cn": "speccode", "tn": "specialty"},
    # values
    "informatics": {"val": "informatics", "cn": "specname", "tn": "specialty"},
    "technical": {"val": "technical", "cn": "facname", "tn": "faculty"},
    "computer_network": {"val": "computer_network", "cn": "discname", "tn": "discipline"},
    "bussines technology": {"val": "bussines technology", "cn": "discname", "tn": "discipline"},
    "doctor": {"val": "doctor", "cn": "degrname", "tn": "degree"},
    "third_year": {"val": "third_year", "cn":"course", "tn": "student"},
    # tableName Faculty
    "facname": {"cn": "facname", "tn": "faculty"},
    "faculty address": {"cn": "address", "tn": "faculty"},
    "faculty city": {"cn": "city", "tn": "faculty"}, "faculty_code": {"cn": "code", "tn": "faculty"},
    # "dean_name": {"cn": "deanname", "tn": "users"},
    # tableName Discipline
    "discname": {"cn": "discname", "tn": "discipline"},
    "code": {"cn": "disccode", "tn": "discipline"},
    # tableName Teacher
    "teacher_name": {"cn": "teachname", "tn": "teacher"}, "teachname": {"cn": "teachname", "tn": "teacher"},
    # tableName ScienDegree
    # "degreename": {"cn": "degrname", "tn": "degree"},
    # tableName EduForm
    # "formname": {"cn": "formname", "tn": "form"},
    # functions & aggregate function
    "number": {"aggr_fun": "count"}, "average": {"aggr_fun": "avg"}, "minimal": {"aggr_fun": "min"},
    "ratio": {"fun": "ratio"}, "relative_value": {"fun": "ratio"}, "total": {"aggr_fun": "sum"},
    "sum": {"aggr_fun": "sum"}, "amount": {"aggr_fun": "sum"}, "quantity": {"aggr_fun": "sum"},
    "aggregate": {"aggr_fun": "sum"}, "size": {"aggr_fun": "count"}, "numerate": {"aggr_fun": "count"},
    "calculate": {"aggr_fun": "sum"}, "result": {"aggr_fun": "sum"}, "how_many": {"aggr_fun": "count"},
    "count": {"aggr_fun": "count"}, "percentage": {"fun": "ratio"}, "range": {"fun": "range"},
    "over": {"fun": "over"}, "between": {"fun": "between"}, "partition_by": {"aggr_fun": "partition_by"},
    "minimal_average": {"fun": "min_avg"}, "maximal_average": {"fun": "max_avg"},
    "minimum": {"aggr_fun": "min"}, "maximum": {"aggr_fun": "max"}, "max": {"aggr_fun": "max"},
    "medium": {"aggr_fun": "avg"},
    "not": {"negation": "not"}, "or": {"lop": "or"}, "no": {"negation": "not"}, "arranged": {"fun": "order_by"},
    "order_by": {"order": "order_by"}, "ordered_by": {"order": "order_by"}, "ordered": {"order": "order_by"},
    # tableName grades
    "grade": {"cn": "grade", "tn": "grades"}, "success": {"cn": "grade", "tn": "grades"},
    "grades": {"cn": "grade", "tn": "grades", "dc": "grade"}, "estimate": {"cn": "grade", "tn": "grades"},
}

table_joins = {
    "degree specialty": "degree.id = specialty.degree_id",
    "degree teacher": "teacher.sciendegree_id = degree.id",
    "department teacher": "teacher.department_id = deparment.id",
    "discipline teacher": "teacher.discipline_id = discipline.id",
    "discipline student users": "discipline.students_id = student.id AND users.id = student.user_id",
    "discipline specialty student": "student.spec_id = specialty.id AND discipline.students_id = student.id AND specialty.id = discipline.specialty_id",
    "discipline specialty": "specialty.id = discipline.specialty_id",
    "examprotocolcontent discipline": "discipline.id = examprotocolcontent.discipline_id",
    "examprotocolcontent teacher": "teacher.id = examprotocolcontent.teacher_id",
    "examprotocolcontent student": "student.id = examprotocolcontent.student_id",
    "faculty users": "users.id = faculty.dean_id",
    "faculty specialty": "faculty.id = specialty.faculty_id",
    "form specialty": "form.id = specialty.form_id",
    "form university": "form.id = specialty.form_id AND faculty.university_id = university.id AND faculty.id = specialty.faculty_id",
    "grade specialty student": "grade.student_id = student.id AND student.spec_id = specialty.id",
    "grades student": "grades.student_id = student.id",
    "paymentfee student": "student.id = peymentfee.student_id",
    "specialty student": "student.spec_id = specialty.id",
    "specialty student users": "users.id = student.user_id AND student.spec_id = specialty.id",
    "student users": "users.id = student.user_id"
}

nltk.download('genesis')
nltk.download('wordnet')
nltk.download('punkt')
nltk.download('averaged_perceptron_tagger')
genesis_ic = wn.ic(genesis, False, 0.0)


def some_more_lemmatizations(txt):
    regexS = [r"(minimal|maximal) (average)", r"(faculty) (number)", r"(faculting) (number)", r"(email) (address)",
              r"(order) (by)", r"say",
              r"computer skill", r"said", r"(computer network)", r"(science degree)", r"(education) (degree)",
              r"(educational) (degree)", r"(education) (form)", r"(educational) (form)",
              r"(department) (name)", r"(discipline) (name)", r"(faculty) (name)", r"(specialty) (name)",
              r"(student) (name)", r"(name student)",
              r"(teacher|lecturer) (name)", r"lecturer", r"(name lecturer)", r"(name teacher)", r"(name specialty)",
              r"(name user)", r"(user name)", r"(third \\-year)"]
    substS = ["\\1_\\2", "faculty_\\2", "\\1_\\2", "email_\\2", "\\1_\\2", "say",
              "informatics", "name", "computer_network", "degree", "education_degree", "education_degree",
              "education_form", "education_form",
              "department_name", "discipline_name", "faculty_name", "specialty_name", "\\1_\\2", "student_name",
              "\\1_\\name", "teacher", "teacher_name", "teacher_name", "specialty_name", "user_name", "user_name", "third_year"]
    test_strS = txt
    result = test_strS
    for ii in range(0, len(regexS)):
        result = re.sub(regexS[ii], substS[ii], result, 0, re.MULTILINE)
    return result


from googletrans import Translator, LANGUAGES


def translate_func(src_text, lang_src='bg', lang_tgt='en'):
    translator = Translator()
    # Ensure the language codes are supported
    if lang_src not in LANGUAGES or lang_tgt not in LANGUAGES:
        raise ValueError("Unsupported language code")

    chunksTr = [src_text[iTr:iTr + 4000] for iTr in range(0, len(src_text), 4000)]
    result_list = []
    for textTr in chunksTr:
        try:
            # Translate the text chunk
            translated = translator.translate(textTr, src=lang_src, dest=lang_tgt)
            result_list.append(translated.text)
        except Exception as e:
            print(f"Error during translation: {e}")
            return None  # Or handle error as appropriate
    return " ".join(result_list)


def ChatBot():
    has_aggregates = False
    has_functions = False
    url = "https://api.meaningcloud.com/parser-2.0"
    payload = {
        'key': 'ba0ec47c838e384fbc3642db021edd6e',
        'lang': 'en',
        'txt': 'YOUR TEXT HERE'
    }
    with open('readme.txt', encoding='utf-8') as f:
        payload['txt'] = translate_func(str(f.readlines()))
    with open("Output.txt", "w", encoding='utf-8') as text_file:
        for i in payload['txt']:
            text_file.write(i)
    response = requests.post(url, data=payload)
    print('Status code:', response.status_code)
    print(response.json())
    nltk.download('stopwords')
    s = stopwords.words('english')
    # add additional stop words
    s.extend(
        ['today', 'tomorrow', 'outside', 'out', 'there', 'get', 'where', 'select', 'remove', 'recorded', 'find', 'show',
         'return', 'provide'])
    s.remove('not')
    s.remove('no')
    ps = nltk.wordnet.WordNetLemmatizer()
    review = ''
    review = re.sub('([^a-zA-Z\\-\\_])', ' ', payload['txt'])
    review = review.lower()
    review = review.split()
    review = [ps.lemmatize(word) for word in review if not word in s]
    review = ' '.join(review)
    payload['txt'] = review
    review = some_more_lemmatizations(review)
    payload['txt'] = review
    print("lemmatized text: {tx}".format(tx=payload['txt']))
    review = review.split()
    review_outp = []
    for w in review:
        if w == 'n':
            continue
        if not words_tags.keys().__contains__(w):
            review_outp.append(w)
            continue
        review_outp.append(
            "{t1}({t2})".format(t1=list(words_tags[w].keys())[0], t2=words_tags[w][list(words_tags[w].keys())[0]]))
        if list(words_tags[w].keys())[0] == "aggr_fun":
            has_aggregates = True
        if list(words_tags[w].keys())[0] == "fun":
            has_functions = True
    review = " ".join(review_outp)
    payload['txt'] = review
    print("tagged text: {tx}".format(tx=payload['txt']))
    # added Pashev 18.01.2021
    review_outp = []
    review = review.split()
    for i in range(0, len(review)):
        if review[i].__contains__("tn("):
            regex = r"tn\(([a-z_]+)\)"
            test_str = review[i]
            subst = "\\1"
            get_tn_1 = re.sub(regex, subst, test_str, 0, re.MULTILINE)
            review_outp.append(review[i])
            if words_tags[get_tn_1].__contains__("dc"):
                review_outp.append("cn({dcn})".format(dcn=words_tags[get_tn_1]["dc"]))
        else:
            review_outp.append(review[i])
    # end added Pashev 18.01.2021
    review = " ".join(review_outp)
    payload['txt'] = review
    print("tagged text: {tx}".format(tx=payload['txt']))
    review = review.split()
    review_output = []
    for i in range(0, len(review)):
        if not review[i].__contains__("("):
            hop_count = 0
            get_cn_1 = ""
            hop_count_left = 0
            get_cn_2 = ""
            cn_last = ""

            for j in range(i + 1, len(review)):
                hop_count = hop_count + 1
                if review[j].__contains__("cn("):
                    regex = r"cn\(([a-z_]+)\)"
                    test_str = review[j]
                    subst = "\\1"
                    get_cn_1 = re.sub(regex, subst, test_str, 0, re.MULTILINE)
                    break
            for j in range(i - 1, -1, -1):
                if j == -1:
                    break
                hop_count_left += 1
                if review[j].__contains__("cn("):
                    regex = r"cn\(([a-z_]+)\)"
                    test_str = review[j]
                    subst = "\\1"
                    get_cn_2 = re.sub(regex, subst, test_str, 0, re.MULTILINE)
                    break
            if get_cn_1 != "":
                cn_last = get_cn_1
            else:
                if get_cn_2 != "":
                    cn_last = get_cn_2
            if hop_count != 0 and hop_count_left != 0:
                if hop_count < hop_count_left:
                    cn_last = get_cn_1
                else:
                    cn_last = get_cn_2
                if hop_count == hop_count_left:
                    cn_last = get_cn_1
            print({"hop_count": hop_count, "hop_count_left": hop_count_left, "i": i})
            review_output.append("val({n1},cn={t2})".format(n1=review[i], t2=cn_last))
        else:
            if review[i].__contains__("aggr_fun("):
                hop_count = 0
                get_cn_1 = ""
                hop_count_left = 0
                get_cn_2 = ""
                cn_last = ""
                for j in range(i + 1, len(review)):
                    hop_count = hop_count + 1
                    if review[j].__contains__("cn("):
                        regex = r"cn\(([a-z_]+)\)"
                        test_str = review[j]
                        subst = "\\1"
                        get_cn_1 = re.sub(regex, subst, test_str, 0, re.MULTILINE)
                        break
                for j in range(i - 1, -1, -1):
                    if j == -1:
                        break
                    hop_count_left = hop_count_left + 1
                    if review[j].__contains__("cn("):
                        regex = r"cn\(([a-z_]+)\)"
                        test_str = review[j]
                        subst = "\\1"
                        get_cn_2 = re.sub(regex, subst, test_str, 0, re.MULTILINE)
                        break
                if get_cn_1 == "":
                    hop_count = 0
                    for j in range(i + 1, len(review)):
                        hop_count = hop_count + 1
                        if review[j].__contains__("val("):
                            regex = r"val\(([a-z_]+)\)"
                            test_str = review[j]
                            subst = "\\1"
                            get_cn_1 = words_tags[re.sub(regex, subst, test_str, 0, re.MULTILINE)]["cn"]
                            break
                if get_cn_2 == "":
                    hop_count_left = 0
                    for j in range(i - 1, 0, -1):
                        hop_count_left += 1
                        if review[j].__contains__("cn("):
                            regex = r"cn\(([a-z_]+)\)"
                            test_str = review[j]
                            subst = "\\1"
                            get_cn_2 = words_tags[re.sub(regex, subst, test_str, 0, re.MULTILINE)]["cn"]
                            break
                if get_cn_1 != "":
                    cn_last = get_cn_1
                else:
                    if get_cn_2 != "":
                        cn_last = get_cn_2
                if hop_count != 0 and hop_count_left != 0:
                    if hop_count < hop_count_left:
                        cn_last = get_cn_1
                    else:
                        cn_last = get_cn_2
                    if hop_count == hop_count_left:
                        cn_last = get_cn_1
                regex = r"aggr_fun\(([a-z_]+)\)"
                test_str = review[i]
                subst = "\\1"
                aggrNm = re.sub(regex, subst, test_str, 0, re.MULTILINE)
                review_output.append("aggr_fun({n1},cn={t2})".format(n1=aggrNm, t2=cn_last))

            else:
                review_output.append(review[i])
    review = " ".join(review_output)
    payload['txt'] = review
    print("tagged text: {tx}".format(tx=payload['txt']))
    print({"has_functions": has_functions, "has_aggregates": has_aggregates})
    # and finally build the query
    table_names = {}
    column_names = {}
    values_dict = {}
    values_pos = {}
    review = review.split()
    negation_pos = float("inf")
    # fill dictionaries of table names and column names
    pos = 0
    for e in review:
        if e.__contains__("negation("):
            negation_pos = pos
        regex = r"tn\(([a-z_]+)\)"
        test_str = e
        matches = re.finditer(regex, test_str, re.MULTILINE)
        for matchNum, match in enumerate(matches, start=1):
            table_names[match.group(1)] = 1
        regex = r"cn\(([a-z_]+)\)"
        test_str = e
        matches = re.finditer(regex, test_str, re.MULTILINE)
        for matchNum, match in enumerate(matches, start=1):
            column_names[words_tags[match.group(1)]["tn"] + "." + words_tags[match.group(1)]["cn"]] = 1
            table_names[words_tags[match.group(1)]["tn"]] = 1
        regex = r"val\(([a-z_]+)\)"
        test_str = e
        matches = re.finditer(regex, test_str, re.MULTILINE)
        for matchNum, match in enumerate(matches, start=1):
            column_names[words_tags[match.group(1)]["tn"] + "." + words_tags[match.group(1)]["cn"]] = 1
            table_names[words_tags[match.group(1)]["tn"]] = 1
            values_dict[words_tags[match.group(1)]["tn"] + "." + words_tags[match.group(1)]["cn"]] = match.group(1)
            values_pos[words_tags[match.group(1)]["tn"] + "." + words_tags[match.group(1)]["cn"]] = pos

        regex = r"val\(([a-z_]+),cn=([a-z_]+)\)"
        test_str = e
        matches = re.finditer(regex, test_str, re.MULTILINE)
        for matchNum, match in enumerate(matches, start=1):
            print({"special_match": match.group(0)})
            column_names[words_tags[match.group(2)]["tn"] + "." + words_tags[match.group(2)]["cn"]] = 1
            table_names[words_tags[match.group(2)]["tn"]] = 1
            values_pos[words_tags[match.group(2)]["tn"] + "." + words_tags[match.group(2)]["cn"]] = pos
            if not values_dict.__contains__(words_tags[match.group(2)]["tn"] + "." + words_tags[match.group(2)]["cn"]):
                values_dict[words_tags[match.group(2)]["tn"] + "." + words_tags[match.group(2)]["cn"]] = match.group(1)

            else:
                values_dict[words_tags[match.group(2)]["tn"] + "." + words_tags[match.group(2)]["cn"]] \
                    = values_dict[
                          words_tags[
                              match.group(
                                  2)][
                              "tn"] + "."
                          + words_tags[
                              match.group(
                                  2)][
                              "cn"]] + " " + match.group(1)
        pos = pos + 1
    # Pashev added 18.01.2022
    column_names11 = {}
    for tn in list(column_names.keys()):
        kk = tn.split(".")
        if words_tags[kk[0]].__contains__("dc"):
            column_names11[kk[0] + "." + words_tags[kk[0]]["dc"]] = 1
            print("added column {cn}".format(cn=kk[0] + "." + words_tags[kk[0]]["dc"]))
    column_names11.update(column_names)
    column_names = column_names11
    # end Pashev added 18.01.2022
    print({"table_names": table_names, "column_names": column_names, "values_dict": values_dict})
    ok = " ".join(list(sorted(table_names.keys())))
    print({"ordered_tables_key": ok})
    if table_joins.__contains__(ok):
        where_clause = " WHERE " + table_joins[ok]
    else:
        where_clause = " WHERE "
    has_negation = False
    for e in review:
        if e.__contains__("negation("):
            has_negation = True
    ii = 0
    positives = []
    negatives = []
    for KeyVal, Val in values_dict.items():
        if values_pos[KeyVal] < negation_pos:
            for vVal in Val.split():
                positives.append(KeyVal + " like('%" + vVal + "%') ")
        else:
            for vVal in Val.split():
                negatives.append(KeyVal + " like('%" + vVal + "%') ")
        ii = ii + 1
    var_AND = "AND"
    if len(table_names) == 1 or len(table_names) == 0:
        var_AND = ""

    if len(positives) > 0:
        where_clause = where_clause + f" {var_AND} " + " AND ".join(positives)
    if len(negatives) > 0:
        where_clause = where_clause + f" {var_AND}" + " NOT ({fn})".format(fn=" AND ".join(negatives))
    from_clause = " FROM {fn}".format(fn=", ".join(list(table_names.keys())))
    print({"from_clause": from_clause, "where_clause": where_clause})
    print({"negation_pos": negation_pos, "positives": positives, "negatives": negatives})
    select_clause = "SELECT "
    if has_functions is False and has_aggregates is False:
        select_clause = select_clause + ", ".join(list(column_names.keys()))
    if has_functions is False and has_aggregates is True:
        lst_aggregates = []
        for ij1 in range(0, len(review)):
            regex = r"aggr_fun\(([a-z_]+),cn=([a-z_]+)\)"
            test_str = review[ij1]
            matches = re.finditer(regex, test_str, re.MULTILINE)
            for matchNum, match in enumerate(matches, start=1):
                lst_aggregates.append("{fn}({col})".format(fn=match.group(1), col=match.group(2)))
        select_clause = select_clause + ", ".join(lst_aggregates)
    order_by_text = ""
    if has_functions is True:
        for ij in range(0, len(review)):
            if review[ij] == "fun(order_by)" and ij < len(review) - 1:
                cn = ""
                if review[ij + 1].__contains__("cn("):
                    regex = r"cn\(([a-z_]+)\)"
                    test_str = review[ij + 1]
                    matches = re.finditer(regex, test_str, re.MULTILINE)
                    for matchNum, match in enumerate(matches, start=1):
                        cn = match.group(1)
                        order_by_text = order_by_text + cn
            if review[ij] == "fun(ratio)" and ij < len(review) - 2:
                append_text = ""
                left = ""
                right = ""
                if review[ij + 1].__contains__("cn("):
                    regex = r"cn\(([a-z_]+)\)"
                    test_str = review[ij + 1]
                    matches = re.finditer(regex, test_str, re.MULTILINE)
                    for matchNum, match in enumerate(matches, start=1):
                        left = match.group(1)
                if review[ij + 2].__contains__("cn("):
                    regex = r"cn\(([a-z_]+)\)"
                    test_str = review[ij + 2]
                    matches = re.finditer(regex, test_str, re.MULTILINE)
                    for matchNum, match in enumerate(matches, start=1):
                        right = match.group(1)
                if review[ij + 1].__contains__("aggr_fun("):
                    regex = r"aggr_fun\(([a-z_]+),cn=([a-z_]+)\)"
                    test_str = review[ij + 1]
                    matches = re.finditer(regex, test_str, re.MULTILINE)
                    for matchNum, match in enumerate(matches, start=1):
                        left = "{fn}({p})".format(fn=match.group(1), p=match.group(2))
                if review[ij + 2].__contains__("aggr_fun("):
                    regex = r"aggr_fun\(([a-z_]+),cn=([a-z_]+)\)"
                    test_str = review[ij + 2]
                    matches = re.finditer(regex, test_str, re.MULTILINE)
                    for matchNum, match in enumerate(matches, start=1):
                        right = "{fn}({p})".format(fn=match.group(1), p=match.group(2))
                append_text = left + "/" + right
                select_clause = select_clause + append_text
    regex = r"order\(order_by\) cn\(([a-z_]+)\)"
    test_str = " ".join(review)
    matches = re.finditer(regex, test_str, re.MULTILINE)
    for matchNum, match in enumerate(matches, start=1):
        order_by_text = order_by_text + " ORDER BY " + match.group(1)
    if where_clause.strip().lower() == "where":
        where_clause = ""
    if select_clause.strip().lower() == "select":
        select_clause = select_clause + " * "
    final_query = select_clause + from_clause + where_clause + order_by_text
    print({'final_query': final_query})


ChatBot()
