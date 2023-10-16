using System;
using System.Collections.Generic;
using System.Text;

namespace SnakeGame.Tools
{
    public class Point
    {
        public int X { get; set; }
        public int Y { get; set; }

        public Point(int a, int b)
        {
            this.X = a;
            this.Y = b;
        }
    }
}
