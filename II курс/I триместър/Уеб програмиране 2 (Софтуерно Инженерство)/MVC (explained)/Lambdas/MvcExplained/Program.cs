using System;
using System.Linq.Expressions;
using System.Threading;

namespace MvcExplained
{
    // 1. Annonymous methods
    // 2. Lambda expressions
    // 3. Expression Trees
    // 4. Lambda VS expression trees
    class Program
    {
        static void Main(string[] args)
        {
            //Action dlg = Test;
            //dlg();

            //Action dlg = delegate ()
            //{
            //    Console.WriteLine("This is an annonymous function!!!");
            //};
            //dlg();

            //Action dlg = () => Console.WriteLine("This is an annonymous method using lambda!!!");
            //dlg();

            //Func<User, bool> dlg = delegate (User u)
            //{
            //    if (u.Passwor.Length < 8)
            //        return false;
            //    else
            //        return true;
            //};
            //User item = new User();
            //item.Username = "nvalchanov";
            //item.Passwor = "123456789";
            //Console.WriteLine(dlg(item));

            //Func<User, bool> dlg = (u) => u.Passwor.Length >= 8;
            //User item = new User();
            //item.Username = "nvalchanov";
            //item.Passwor = "1234567";
            ////Console.WriteLine(dlg(item));
            //Console.WriteLine($"Method name: {dlg.Method.Name}");
            //Console.WriteLine($"Is Static: {dlg.Method.IsStatic}");
            //Console.WriteLine($"Parameters count: {dlg.Method.GetParameters().Length}");
            //Console.WriteLine($"Param 1 Name: {dlg.Method.GetParameters()[0].Name}");
            //Console.WriteLine($"Param 1 Type: {dlg.Method.GetParameters()[0].ParameterType.Name}");
            
            // (a, b) => a > b
            var a = Expression.Parameter(typeof(int), "a");
            var b = Expression.Parameter(typeof(int), "b");
            Expression<Func<int, int, bool>> dlg = Expression.Lambda<Func<int, int, bool>>(
                Expression.GreaterThan(a, b),
                a, b
            );

            Console.WriteLine(dlg.Compile().Invoke(5, 10));
            
            Func<int, int, bool> dlg1 = dlg.Compile();
            Console.WriteLine(dlg1(6, 10));

            //Expression<Func<int, int, bool>> dlg = (a, b) => a > b;
            //Func<int, int, bool> res = dlg.Compile();
            //Console.WriteLine(res(10, 5));

            //Func<User, string> dlg = u => u.Username;
            //Expression<Func<User, string>> lambda = u => u.Username;
            // <input type="text" name="Username"

            //Console.WriteLine(dlg.ToString());

            //Console.WriteLine(lambda.ToString());
            //Console.WriteLine(lambda.Body.ToString());
            //Console.WriteLine(lambda.Body.GetType().BaseType.Name);
            //Console.WriteLine(((MemberExpression)lambda.Body).Member.Name);

            //Console.WriteLine(
            //    TextBoxFor<User>(m => m.Usernm)
            //    );

            Console.ReadKey(true);
        }
        //m => m.Username
        public static string TextBoxFor<T>(Expression<Func<T, object>> lamba)
        {
            return $"<input type=\"text\" name=\"{((MemberExpression)lamba.Body).Member.Name}\" />";
        }

        static bool IsBigger(int a, int b)
        {
            return a > b;
        }

        static void Test()
        {
            Console.WriteLine("This is a test");
        }
    }
}
