# coding=utf8
# the above tag defines encoding for this document and is for Python 2.x compatibility

import re

regex = r"(\-|\+)?(\d+)([\.,]\d+)?"

test_str = (
    "sdfsdf dsfsdfsf dfssdfds sdfsd 999.21 fdsfsdsdfsd 34 dsfdsfdsfsd -34,56 dsffdsfsdf 43.25 dssfsfdsdfd 43 fdssdfdsfsd\n\n"
    "23 ffdsfsdfdf 4333443 dssdfsdf -12   -25\n\n"
    "-23    -12  fdfdffd  +34")

matches = re.finditer(regex, test_str, re.MULTILINE)

for matchNum, match in enumerate(matches, start=1):

    print("Match {matchNum} was found at {start}-{end}: {match}".format(matchNum=matchNum, start=match.start(),
                                                                        end=match.end(), match=match.group()))

    for groupNum in range(0, len(match.groups())):
        groupNum = groupNum + 1

        print("Group {groupNum} found at {start}-{end}: {group}".format(groupNum=groupNum, start=match.start(groupNum),
                                                                        end=match.end(groupNum),
                                                                        group=match.group(groupNum)))

# Note: for Python 2.7 compatibility, use ur"" to prefix the regex and u"" to prefix the test string and substitution.
