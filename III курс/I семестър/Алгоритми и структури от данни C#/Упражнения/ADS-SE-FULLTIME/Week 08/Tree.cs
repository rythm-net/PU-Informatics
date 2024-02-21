using System;
using System.Collections.Generic;

namespace _08.Week
{
    public class TreeNode<T>
    {
        private T value;
        public List<TreeNode<T>> children;
        public bool hasParent;

        public TreeNode(T value)
        {
            if (value == null)
            {
                throw new ArgumentNullException();
            }

            this.value = value;
            this.children = new List<TreeNode<T>>();
            this.hasParent = false;
        }

        public T Value
        {
            get
            {
                return this.value;
            }

            set
            {
                this.value = value;
            }
        }


        public int ChildrenCount
        {
            get
            {
                return this.children.Count;
            }
        }

        public void AddChild(TreeNode<T> child)
        {
            if (child == null)
            {
                throw new ArgumentException();
            }

            this.children.Add(child);
            child.hasParent = true;
        }

        public TreeNode<T> GetChild(int index)
        {
            return this.children[index];
        }
    }


    public class Tree<T>
    {
        private TreeNode<T> root;

        public TreeNode<T> Root
        {
            get
            {
                return this.root;
            }
        }

        public Tree(T value)
        {
            if (value == null)
            { }

            this.root = new TreeNode<T>(value);
        }

        public Tree(T value, params Tree<T>[] subTrees)
            :this(value)
        {
            foreach (var child in subTrees)
            {
                this.root.AddChild(child.root);
            }
        }



        public void DFS()
        {
            Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();

            stack.Push(this.root);


            while(stack.Count > 0)
            {
                TreeNode<T> currentNode = stack.Pop();
                Console.Write("{0} ", currentNode.Value);

                for (int i = 0; i < currentNode.ChildrenCount; i++)
                {
                    TreeNode<T> childNode = currentNode.GetChild(i);

                    stack.Push(childNode);
                }
            }
        }


        public void DFSRecursive(TreeNode<T> root)
        {
            Console.Write(" " + root.Value);

            if (root.ChildrenCount == 0)
            {
                return;
            }

            for (int i = 0; i < root.ChildrenCount; i++)
            {
                DFSRecursive(root.GetChild(i));
            }
        }
    }
}
