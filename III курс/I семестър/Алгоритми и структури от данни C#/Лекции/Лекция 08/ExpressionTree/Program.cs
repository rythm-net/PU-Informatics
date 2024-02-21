using System;
using System.Collections.Generic;
using System.Linq.Expressions;

namespace ExpressionTree
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            Dictionary<string, double> parameters = new Dictionary<string, double>() {
                { "a", 5 },
                { "b", 3 },
                { "c", 1 },
                { "d", 8 },
                { "e", 2 }
            };
            ExpressionTree tree = ExpressionTree.BuildFromPostfix("2a*b+cde/+*");
            Console.WriteLine(tree);
            double val = tree.CalcTree(parameters);
            Console.WriteLine(val);
            parameters["a"] = 7;
            val = tree.CalcTree(parameters);
            Console.WriteLine(val);


            Expression<Func<int, int, int, int, int, int>> lambda = 
                (a, b, c, d, e) => (2 * a + b) * (c + d / e);
            Func<int, int, int, int, int, int> code = lambda.Compile();
            Console.WriteLine(code.Invoke(5, 3, 1, 8, 2));
            Console.WriteLine(code.Invoke(7, 3, 1, 8, 2));
        }
    }
}