using BLinkedList;

StringLinkedList stringList = new StringLinkedList();

stringList.Add(new StringListItem("abcd"));
stringList.Add(new StringListItem("test"));
stringList.Add(new StringListItem("some text"));

//Enumerate all elements
Console.WriteLine("Print all items of the linked list:");
StringListItem current = stringList.Root;
while (current != null)
{
    Console.WriteLine(current.Value);
    current = current.Next;
}

Console.WriteLine();
Console.WriteLine("Removing 'test'");
stringList.Remove("test");

Console.WriteLine("Print all items of the linked list:");
current = stringList.Root;
while (current != null)
{
    Console.WriteLine(current.Value);
    current = current.Next;
}




Console.ReadLine();