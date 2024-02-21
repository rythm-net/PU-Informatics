using System;
using System.Diagnostics.CodeAnalysis;

namespace _08.Week
{

    public class BinarySearchTree<T> where T : IComparable<T>
    {

        private class BinaryTreeNode<T> : IComparable<BinaryTreeNode<T>> where T : IComparable<T>
        {

            public T value;
            public bool hasParent;
            public BinaryTreeNode<T> parent;
            public BinaryTreeNode<T> leftChild;
            public BinaryTreeNode<T> rightChild;

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

            public BinaryTreeNode<T> LeftChild
            {
                get
                {
                    return this.leftChild;
                }

                set
                {
                    if (value == null)
                    {
                        return;
                    }

                    value.hasParent = true;
                    leftChild = value;
                }
            }


            public BinaryTreeNode<T> RightChild
            {
                get
                {
                    return this.rightChild;
                }

                set
                {
                    if (value == null)
                    {
                        return;
                    }

                    value.hasParent = true;
                    rightChild = value;
                }
            }


            public BinaryTreeNode(T value)
                :this(value, null, null)
            {
                parent = null;
            }

            public BinaryTreeNode(T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild)
            {
                if (value == null)
                {

                }

                this.value = value;
                this.leftChild = leftChild;
                this.rightChild = rightChild;
            }

            public int CompareTo(BinaryTreeNode<T> other)
            {
                return this.value.CompareTo(other.value);
            }
        }



        // Binary search tree implementation

        private BinaryTreeNode<T> root;


        public BinarySearchTree()
        {
            this.root = null;
        }

        public BinarySearchTree(T value)
            : this(value, null, null)
        { }


        public BinarySearchTree(T value, BinarySearchTree<T> leftChild, BinarySearchTree<T> rightChild)
        {
            if (value == null)
            { }

            BinaryTreeNode<T> leftChildNode = leftChild != null ? leftChild.root : null;
            BinaryTreeNode<T> rightChildNode = rightChild != null ? rightChild.root : null;

            this.root = new BinaryTreeNode<T>(value, leftChildNode, rightChildNode);
        }
    }
}
