using System;
using System.Collections.Generic;

namespace PostfixNotation
{
    class Program
    {
        public static int CalcPrefixNotation(string str)
        {
            Stack<int> stack = new Stack<int>();
            foreach(char ch in str)
            {
                if (Char.IsDigit(ch))
                {
                    stack.Push(ch - '0');
                } else
                {
                    int n2 = stack.Pop();
                    int n1 = stack.Pop();
                    int v;
                    switch(ch) {
                        case '+':
                            v = n1 + n2;
                            break;
                        case '-':
                            v = n1 - n2;
                            break;
                        case '*':
                            v = n1 * n2;
                            break;
                        case '/':
                            v = n1 / n2;
                            break;
                        default:
                            throw new InvalidOperationException("Invalid operator " + ch);
                    }
                    stack.Push(v);
                }           
            }
            return stack.Pop();
        }
        static void Main(string[] args)
        {
            Console.WriteLine(CalcPrefixNotation("55*3+182/+*"));
        }
    }
}
