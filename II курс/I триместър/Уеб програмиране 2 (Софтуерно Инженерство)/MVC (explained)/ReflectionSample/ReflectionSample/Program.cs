using System;
using System.Reflection;

namespace ReflectionSample
{
    class Program
    {
        public static void Main(string[] args)
        {
            Assembly a = Assembly.GetExecutingAssembly();
            
            foreach(Type t in a.GetTypes())
            {
                Console.WriteLine("CLASS NAME: " + t.Name);

                Console.WriteLine("###PUBLIC PROPERTIES###");
                foreach(PropertyInfo pi in t.GetProperties())
                {
                    Console.WriteLine($"\t{pi.PropertyType} {pi.Name}");
                }

                Console.WriteLine("--METHODS--");
                foreach (MethodInfo mi in t.GetMethods())
                {
                    Console.WriteLine($"\t{mi.ReturnType} {mi.Name}");
                }
            }

            Console.ReadKey(true);
        }
    }
}
