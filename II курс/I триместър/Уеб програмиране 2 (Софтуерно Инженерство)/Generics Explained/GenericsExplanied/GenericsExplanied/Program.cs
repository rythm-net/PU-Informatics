using GenericsExplanied.Entities;
using GenericsExplanied.Generics;
using System;

namespace GenericsExplanied
{
    class Program
    {
        static void Main(string[] args)
        {
            LinkedList<User> list = new LinkedList<User>();
            list.Add(new User()
            {
                Id = 1,
                Username = "nikiv",
                Password = "nikipass"
            });

            list.Add(new User()
            {
                Id = 2,
                Username = "mikiv",
                Password = "mikipass"
            });

            list.Add(new User()
            {
                Id = 3,
                Username = "fikiv",
                Password = "fikipass"
            });

            for (int i = 0; i < list.Count(); i++)
            {
                User item = list.GetAt(i);

                Console.WriteLine($"Id: {item.Id}");
                Console.WriteLine($"Username: {item.Username}");
                Console.WriteLine($"Password: {item.Password}");
                Console.WriteLine("------------------------------------");
            }

            Console.ReadKey(true);
        }
    }
}
