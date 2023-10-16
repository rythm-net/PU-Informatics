using SnakeGame.Tools;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace SnakeGame
{
    public class InputPicker
    {
        public Action<DirectionEnum> OnDirectionChanged = null;
        private Thread thread;

        private void PickInput()
        {
            while (true)
            {
                ConsoleKeyInfo keyInfo = Console.ReadKey(true);

                switch(keyInfo.Key)
                {
                    case ConsoleKey.UpArrow:
                    {
                        OnDirectionChanged(DirectionEnum.Up);
                        break;
                    }
                    case ConsoleKey.DownArrow:
                    {
                        OnDirectionChanged(DirectionEnum.Down);
                        break;
                    }
                    case ConsoleKey.LeftArrow:
                    {
                        OnDirectionChanged(DirectionEnum.Left);
                        break;
                    }
                    case ConsoleKey.RightArrow:
                    {
                        OnDirectionChanged(DirectionEnum.Right);
                        break;
                    }
                }
            }
        }

        public void Abort()
        {
            try { this.thread.Abort(); }
            catch { }
        }

        public void Run()
        {
            ThreadStart threadStartDlg = new ThreadStart(PickInput);
            thread = new Thread(threadStartDlg);

            thread.Start();
        }
    }
}
