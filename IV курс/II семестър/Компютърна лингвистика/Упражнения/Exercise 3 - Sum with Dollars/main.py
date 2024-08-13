# coding=utf8
# the above tag defines encoding for this document and is for Python 2.x compatibility

import re

regex = r"(\$|USD)? *(\-|\+)?(\d+)([\.,](\d+))?"

test_str = (
    "sdfsdf dsfsdfsf dfssdfds sdfsd 999.21 fdsfsdsdfsd 34 dsfdsfdsfsd -34,56 dsffdsfsdf $43.25 dssfsfdsdfd 43 fdssdfdsfsd\n\n"
    "$ 23 ffdsfsdfdf 4333443 dssdfsdf -12   -25\n\n"
    "-23    -12  fdfdffd  USD +34")

matches = re.finditer(regex, test_str, re.MULTILINE)

Sum = 0.0
Sum_dollars = 0.0
for matchNum, match in enumerate(matches, start=1):

    print("Match {matchNum} was found at {start}-{end}: {match}".format(matchNum=matchNum, start=match.start(),
                                                                        end=match.end(), match=match.group()))
    format = ""
    sing = "+"
    if match.group(5) is None:
        format = f"{match.group(3)}"
    if match.group(2) is not None:
        if match.group(2) == "-":
            sing = "-"
    if match.group(5) is not None:
        format = f"{match.group(3)}.{match.group(5)}"
    number = 0.0
    if sing == "-":
        Sum -= float(format)
        number = - float(format)
    else:
        Sum += float(format)
        number = float(format)
    if match.group(1) is not None:
        Sum_dollars += number
print(f"Sum = {Sum}")
print(f"Sum dollars = {Sum_dollars}")








