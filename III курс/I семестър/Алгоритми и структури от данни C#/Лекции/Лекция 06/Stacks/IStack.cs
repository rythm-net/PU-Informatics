using System;
using System.Collections.Generic;
using System.Text;

namespace Stacks
{
    interface IStack<T>
    {
        void Push(T value);
        T Pop();
        T Peek();
        void Clear();
        int Count { get; }
    }
}
