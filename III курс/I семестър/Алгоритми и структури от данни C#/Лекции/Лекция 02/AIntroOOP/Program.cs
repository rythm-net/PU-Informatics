using System;

namespace AIntroOOP
{
    class Point
    {
        private int x;
        public int X
        {
            get
            {
                return x;
            }

            set
            {
                if (value < 0)
                    throw new ArgumentOutOfRangeException("X", "X cannot be negative");
                x = value;
            }
        }

        public int Y { get; set; }

        // Y with getters and setters
        //private int y;

        //public void setY(int y)
        //{
        //    if (y < 0)
        //        throw new ArgumentOutOfRangeException("Y", "Y cannot be negative");
        //    this.y = y;
        //}

        //public int getY()
        //{
        //    return y;
        //}
    }

    class Line
    {
        public Point StartPoint { get; set; }
        public Point EndPoint { get; set; }

        public double Length
        {
            get
            {
                double dx, dy;
                dx = StartPoint.X - EndPoint.X;
                dy = StartPoint.Y - EndPoint.Y;

                return Math.Sqrt(dx * dx + dy * dy); 
            }
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Point p = new Point();
            p.X = 10;

            Line line = new Line()
            {
                StartPoint = new Point()
                {
                    X = 10,
                    Y = 20
                },
                EndPoint = new Point()
                {
                    X = 100,
                    Y = 20
                }
            };

            // not correct - Length has only a getter and is read only
            // line.Length = 10;
            Console.WriteLine($"The length of the line is {line.Length}");
        }
    }
}
