using CStringList;
using BLinkedList;
using System.Diagnostics;

StringArrayList arrList = new StringArrayList();
arrList.Add("abc");
arrList.Add("def");
arrList.Add("text");
arrList.Add("zyz");

for (int i = 0; i < arrList.Length; i++)
{
    Console.WriteLine(arrList[i]);
}

const int testSize = 40_000;

Console.WriteLine();
Console.WriteLine("A simple performance test:");
Console.WriteLine("--------------------------");
Console.Write ("Array List: ");
var arrList2 = new StringArrayList();
Stopwatch watch = new Stopwatch();
watch.Start();
for (int i=0; i < testSize; i++)
{
    arrList2.Add("abc");
}
watch.Stop();
Console.WriteLine($"{watch.ElapsedMilliseconds} ms for {arrList2.Length} items.");

Console.WriteLine();
Console.Write("Linked List: ");
var strLinkedList  = new StringLinkedList();
watch.Restart();
for (int i = 0; i < testSize; i++)
{
    strLinkedList.Add("abc");
}
watch.Stop();
Console.WriteLine($"{watch.ElapsedMilliseconds} ms for {testSize} items.");

Console.WriteLine();
Console.Write("Array List Enhanced: ");
var arrList3 = new StringArrayListEh();
watch.Restart();
for (int i = 0; i < testSize; i++)
{
    arrList3.Add("abc");
}
watch.Stop();
Console.WriteLine($"{watch.ElapsedMilliseconds} ms for {arrList3.Length} items.");


