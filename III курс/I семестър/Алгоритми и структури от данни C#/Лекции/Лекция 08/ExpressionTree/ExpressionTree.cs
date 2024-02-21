using System;
using System.Collections.Generic;

namespace ExpressionTree
{
    public class ExpressionTreeNode
    {
        private ExpressionTreeNode left;
        public ExpressionTreeNode right;

        private char oper = ' ';
        private string value;

        // constructor to create leaf nodes with value
        public ExpressionTreeNode(string value)
        {
            left = null;
            right = null;
            this.value = value;
        }

        // constructor to create operation nodes with left and right node
        public ExpressionTreeNode(char oper, ExpressionTreeNode left, ExpressionTreeNode right)
        {
            this.left = left;
            this.right = right;
            this.oper = oper;
        }

        public double Calc(Dictionary<string, double> parameters)
        {
            // leaf node - bottom of the recursion
            if (oper == ' ')
            {
                if (Double.TryParse(value, out double val))
                {
                    return val;
                }
                return parameters[value];
            }

            double leftValue = left.Calc(parameters);
            double rightValue = right.Calc(parameters);
            switch (oper)
            {
                case '+':
                    return leftValue + rightValue;
                case '-':
                    return leftValue - rightValue;
                case '*':
                    return leftValue * rightValue;
                case '/':
                    return leftValue / rightValue;
            }
            throw new InvalidOperationException("Bad operator " + oper + "!");
        }

        public string TreeToString()
        {
            // bottom of the recursion - leaf node
            if (oper == ' ')
                return value;
            string leftVal = left.TreeToString();
            string rightVal = right.TreeToString();
            return $"({leftVal} {oper} {rightVal})";
        }

        public override string ToString()
        {
            return TreeToString();
        }
    }

    public class ExpressionTree
    {
        public ExpressionTreeNode TreeRoot { get; set; }
        public double Value { get; set; }

        private static bool isOperator(char ch)
        {
            return ch == '+' || ch == '-' || ch == '*' || ch == '/';
        }

        public static ExpressionTree BuildFromPostfix(string postfix)
        {
            // very similar to PostfixNotation calculation
            Stack<ExpressionTreeNode> stack = new Stack<ExpressionTreeNode>();

            foreach (char ch in postfix)
            {
                if (!isOperator(ch))
                {
                    ExpressionTreeNode node = new ExpressionTreeNode(ch.ToString());
                    stack.Push(node);
                }
                else
                {
                    if (stack.Count < 2)
                        throw new InvalidOperationException("Wrong postfix expression.");
                    ExpressionTreeNode right = stack.Pop();
                    ExpressionTreeNode left = stack.Pop();

                    ExpressionTreeNode node = new ExpressionTreeNode(ch, left, right);
                    stack.Push(node);
                }
            }

            if (stack.Count != 1)
                throw new InvalidOperationException("Wrong postfix expression");

            ExpressionTreeNode root = stack.Pop();
            ExpressionTree tree = new ExpressionTree() { TreeRoot = root };
            return tree;
        }

        public double CalcTree(Dictionary<string, double> parameters)
        {
            if (TreeRoot == null)
                throw new InvalidOperationException("Tree empty");
            Value = TreeRoot.Calc(parameters);
            return Value;
        }

        public override string ToString()
        {
            return TreeRoot.ToString();
        }
    }
}