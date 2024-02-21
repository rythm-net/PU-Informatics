using System;
using System.Collections.Generic;
using System.Text;

namespace TreverseTrees
{
    class TreeNode
    {
        public TreeNode Left { get; set; } = null;
        public TreeNode Right { get; set; } = null;
        public int Value { get; set; }

        public TreeNode(int value)
        {
            Value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right)
        {
            Left = left;
            Right = right;
            Value = value;
        }


        public void PrintInOrder()
        {
            if (Left != null)
                Left.PrintInOrder();
            Console.Write(Value + " ");
            if (Right != null)
                Right.PrintInOrder();
        }

        public void PrintPreOrder()
        {
            Console.Write(Value + " ");
            if (Left != null)
                Left.PrintPreOrder();
            if (Right != null)
                Right.PrintPreOrder();
        }

        public void PrintPostOrder()
        {
            if (Left != null)
                Left.PrintPostOrder();
            if (Right != null)
                Right.PrintPostOrder();
            Console.Write(Value + " ");
        }

    }
    class Tree
    {
        public TreeNode RootNode { get; set; }

        public Tree()
        {

        }
        public Tree(TreeNode rootNode)
        {
            RootNode = rootNode;
        }

        public void PrintInOrder()
        {
            RootNode.PrintInOrder();
            Console.WriteLine();
        }

        public void PrintPreOrder()
        {
            RootNode.PrintPreOrder();
            Console.WriteLine();
        }

        public void PrintPostOrder()
        {
            RootNode.PrintPostOrder();
            Console.WriteLine();
        }

    }
}
