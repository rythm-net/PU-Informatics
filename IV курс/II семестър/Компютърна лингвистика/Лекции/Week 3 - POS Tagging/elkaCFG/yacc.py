import ply.yacc as yacc
import math
# Get the token map from the lexer.  This is required.
from calclex import tokens

var_names = {'pi': math.pi}


def p_expression_plus(p):
    'expression : expression PLUS term'
    p[0] = p[1] + p[3]


def p_expression_varname(p):
    'expression : VARNAME EQ expression'
    p[0] = p[3]
    var_names[p[1]] = p[3]


def p_expression_minus(p):
    'expression : expression MINUS term'
    p[0] = p[1] - p[3]


def p_expression_term(p):
    'expression : term'
    p[0] = p[1]


def p_term_times(p):
    'term : term TIMES factor'
    p[0] = p[1] * p[3]


def p_term_div(p):
    'term : term DIVIDE factor'
    try:
        p[0] = p[1] / p[3]
    except ZeroDivisionError as zd:
        print({"Error": "Zero Division error", "p": p})
        raise EOFError()


def p_term_pow(p):
    'term : term POW factor'
    p[0] = math.pow(p[1], p[3])


def p_term_factor(p):
    'term : factor'
    p[0] = p[1]


def p_factor_num(p):
    'factor : NUMBER'
    p[0] = p[1]


def p_factor_varname(p):
    'factor : VARNAME'
    p[0] = var_names[p[1]]


def p_factor_expr(p):
    'factor : LPAREN expression RPAREN'
    p[0] = p[2]


def p_factor_func(p):
    'factor : FUNNAME LPAREN expression RPAREN'
    p[0] = globals()[p[1]](eval(str(p[3])))


def p_factor_func_no_param(p):
    'factor : FUNNAME LPAREN RPAREN'
    p[0] = globals()[p[1]]()


def p_factor_function_binary(p):
    'factor : FUNNAME LPAREN expression COMMA expression RPAREN'
    p[0] = globals()[p[1]](p[3], p[5])


def p_factor_function_teriary(p):
    'factor : FUNNAME LPAREN expression COMMA expression COMMA expression RPAREN'
    p[0] = globals()[p[1]](p[3], p[5], p[7])


def p_factor_function_quattro(p):
    'factor : FUNNAME LPAREN expression COMMA expression COMMA expression COMMA expression RPAREN'
    p[0] = globals()[p[1]](p[3], p[5], p[7], p[9])


def ONE():
    return 1


def SINUS(p):
    return math.sin(p)


def COSINUS(p):
    return math.cos(p)


def PLUS(a, b):
    return a + b


def PLUST(a, b, c):
    return a + b + c


def SUMF(a, b, c, d):
    return a + b + c + d


# Error rule for syntax errors
def p_error(p):
    print("Syntax error in input!")
    print(p)


# Build the parser
parser = yacc.yacc()
while True:
    try:
        s = input('calc > ')
        if not s:
            continue
        result = parser.parse(s)
        print(result)
    except EOFError:
        break
    except KeyError as e:
        print(f"No such function {e}")
