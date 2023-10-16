using MvcExplained.Attributes;
using MvcExplained.Controllers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace MvcExplained
{
    class Program
    {
        static void Main(string[] args)
        {
            // /Home/Index
            string httpRequest = Console.ReadLine();

            string controller = httpRequest.Substring(1, httpRequest.IndexOf("/", 1) - 1);
            string action = httpRequest.Substring(httpRequest.IndexOf("/", 1) + 1);

            Console.Clear();

            Console.WriteLine("Controller: " + controller);
            Console.WriteLine("Action: " + action);

            // Home
            // HomeController
            Type controllerT = null;
            foreach (Type t in Assembly.GetExecutingAssembly().GetTypes())
            {
                if (t.Name == (controller + "Controller"))
                {
                    controllerT = t;
                    break;
                }
            }

            if (controllerT == null)
            {
                Console.WriteLine("No class with that name found!");
                Console.ReadKey(true);
                return;
            }

            object c = Activator.CreateInstance(controllerT);
            
            // /Home/Index
            MethodInfo mi = null;
            foreach (MethodInfo m in controllerT.GetMethods())
            {
                if (m.Name == action)
                {
                    mi = m;
                    break;
                }
            }

            if (mi == null)
            {
                Console.WriteLine("No method with that name found!");
                Console.ReadKey(true);
                return;
            }

            IgnoreAttribute a = null;
            foreach (Attribute attrib in mi.GetCustomAttributes())
            {
                if (attrib is IgnoreAttribute)
                {
                    a = (IgnoreAttribute)attrib;
                    break;
                }
            }

            if (a != null)
            {
                Console.WriteLine("This Method is marked with ignore!");
                Console.Write("Error Message: " + a.ErrorMessage);
                Console.ReadKey(true);
                return;
            }

            object result = mi.Invoke(c, null);

            Console.WriteLine("Result: " + result.ToString());
            Console.ReadKey(true);
        }
    }
}
