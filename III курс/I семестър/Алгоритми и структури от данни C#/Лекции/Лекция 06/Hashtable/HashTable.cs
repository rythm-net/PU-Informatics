using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

namespace Hashtable
{
    class HashTable<TKey, TValue> where TKey : notnull
    {
        private LinkedList<HashEntry>[] buckets = new LinkedList<HashEntry>[3];

        // hash function
        private int getIndex(TKey key)
        {
            return Math.Abs(key.GetHashCode() % buckets.Length);
        }

        public void Put(TKey key, TValue value)
        {
            int idx = getIndex(key);

            if (buckets[idx] == null)
                buckets[idx] = new LinkedList<HashEntry>();

            HashEntry hashEntry = buckets[idx].Where(entry => entry.Key.Equals(key)).FirstOrDefault();
            if (hashEntry != null)
                hashEntry.Value = value;
            else
                buckets[idx].AddFirst(new HashEntry(key, value));
        }

        public TValue Get(TKey key)
        {
            int idx = getIndex(key);

            if (buckets[idx] == null)
                throw new InvalidOperationException("Key does not exist");
            
            HashEntry hashEntry = buckets[idx].Where(entry => entry.Key.Equals(key)).FirstOrDefault();
            if (hashEntry != null)
                return hashEntry.Value;
            else
                throw new InvalidOperationException("Key does not exist");
        }

        class HashEntry
        {
            public TKey Key { get; private set; }
            public TValue Value { get; set; }

            public HashEntry(TKey key, TValue value)
            {
                Key = key;
                Value = value;
            }
        }
    }
}
