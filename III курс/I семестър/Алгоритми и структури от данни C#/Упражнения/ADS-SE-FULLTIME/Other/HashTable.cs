using System;
using System.Collections.Generic;

namespace Other
{
    public struct HashEntry<K, V>
    {
        public K Key { get; set; }
        public V Value { get; set; }
    }

    public class HashTable<K, V>
    {
        private readonly int size;
        private readonly LinkedList<HashEntry<K, V>>[] items;

        public HashTable(int size = 64)
        {
            this.size = size;
            items = new LinkedList<HashEntry<K, V>>[size];
        }

        protected int Hash(K key)
        {
            int position = key.GetHashCode() % size;
            return Math.Abs(position);
        }

        public V Find(K key)
        {
            int position = Hash(key);
            LinkedList<HashEntry<K, V>> linkedList = GetLinkedList(position);
            foreach (HashEntry<K, V> item in linkedList)
            {
                if (item.Key.Equals(key))
                {
                    return item.Value;
                }
            }

            return default(V);
        }

        public void Add(K key, V value)
        {
            int position = Hash(key);
            LinkedList<HashEntry<K, V>> linkedList = GetLinkedList(position);
            HashEntry<K, V> item = new HashEntry<K, V>() { Key = key, Value = value };
            linkedList.AddLast(item);
        }

        public void Remove(K key)
        {
            int position = Hash(key);
            LinkedList<HashEntry<K, V>> linkedList = GetLinkedList(position);
            bool itemFound = false;
            HashEntry<K, V> foundItem = default(HashEntry<K, V>);
            foreach (HashEntry<K, V> item in linkedList)
            {
                if (item.Key.Equals(key))
                {
                    itemFound = true;
                    foundItem = item;
                }
            }

            if (itemFound)
            {
                linkedList.Remove(foundItem);
            }
        }

        protected LinkedList<HashEntry<K, V>> GetLinkedList(int position)
        {
            LinkedList<HashEntry<K, V>> linkedList = items[position];
            if (linkedList == null)
            {
                linkedList = new LinkedList<HashEntry<K, V>>();
                items[position] = linkedList;
            }

            return linkedList;
        }
    }
}
