using System;

namespace Hashtable
{
    class Program
    {
        static void Main(string[] args)
        {
            HashTable<string, double> studentGrades = new HashTable<string, double>();

            studentGrades.Put("Ivan Ivanov", 5.75);
            studentGrades.Put("Maria Petrova", 6.00);
            studentGrades.Put("Petar Yordanov", 5.50);
            studentGrades.Put("Yoana Stoeva", 5.75);

            Console.WriteLine(studentGrades.Get("Ivan Ivanov"));
            Console.WriteLine(studentGrades.Get("Maria Petrova"));
        }
    }
}
