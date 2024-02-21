using System;

namespace TreverseTrees
{
    class Program
    {
        static void Main(string[] args)
        {
            Tree tree = new Tree();
            tree.RootNode = new TreeNode(50);
            tree.RootNode.Left = new TreeNode(30);
            tree.RootNode.Left.Left = new TreeNode(22);
            tree.RootNode.Left.Left.Left = new TreeNode(5);
            tree.RootNode.Left.Left.Right = new TreeNode(27);
            tree.RootNode.Left.Right = new TreeNode(35);
            tree.RootNode.Left.Right.Left = new TreeNode(32);
            tree.RootNode.Left.Right.Right = new TreeNode(40);

            tree.RootNode.Right = new TreeNode(73);
            tree.RootNode.Right.Left = new TreeNode(61);
            tree.RootNode.Right.Left.Left = new TreeNode(55);
            tree.RootNode.Right.Left.Right = new TreeNode(68);
            tree.RootNode.Right.Right = new TreeNode(82);
            tree.RootNode.Right.Right.Left = new TreeNode(77);
            tree.RootNode.Right.Right.Right = new TreeNode(96);

            tree.PrintInOrder();
            tree.PrintPreOrder();
            tree.PrintPostOrder();

            Tree tree2 = new Tree(
                new TreeNode(30, 
                    new TreeNode(20, new TreeNode(5), new TreeNode(21)), 
                    new TreeNode(35)));

            tree2.PrintInOrder();
        }
    }
}
