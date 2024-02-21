using System;
using System.Diagnostics.CodeAnalysis;

namespace _09.Week
{

    public class BinarySearchTree<T> where T : IComparable<T>
    {

        public class BinaryTreeNode<T> : IComparable<BinaryTreeNode<T>> where T : IComparable<T>
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
                : this(value, null, null)
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


        public BinaryTreeNode<T> Find(T value)
        {
            BinaryTreeNode<T> node = this.root;

            while (node != null)
            {

                int compareTo = value.CompareTo(node.value);

                if (compareTo < 0)
                {
                    node = node.leftChild;
                }
                else if (compareTo > 0)
                {
                    node = node.rightChild;
                }
                else
                {
                    break;
                }
            }

            return node;
        }

        public void Insert(T value)
        {
            if (value == null)
            {
            }

            this.root = Insert(value, null, root);
        }

        private BinaryTreeNode<T> Insert(T value, BinaryTreeNode<T> parentNode, BinaryTreeNode<T> node)
        {
            if (node == null)
            {
                node = new BinaryTreeNode<T>(value);
                node.parent = parentNode;
            }
            else
            {
                int compareTo = value.CompareTo(node.value);

                if (compareTo < 0)
                {
                    node.leftChild = Insert(value, node, node.leftChild);
                }
                else if (compareTo > 0)
                {
                    node.rightChild = Insert(value, node, node.rightChild);
                }
            }

            return node;
        }


        public void Remove(T value)
        {
            BinaryTreeNode<T> nodeToDelete = Find(value);

            if (nodeToDelete == null)
            {
                return;
            }

            Remove(nodeToDelete);
        }

        private void Remove(BinaryTreeNode<T> node)
        {
            if (node.leftChild != null && node.rightChild != null)
            {
                BinaryTreeNode<T> replacement = node.rightChild;

                while(replacement.leftChild != null)
                {
                    replacement = replacement.leftChild;
                }

                node.value = replacement.value;
                replacement.parent.leftChild = null;
            }
            else
            {
                BinaryTreeNode<T> theChild = node.leftChild != null ? node.leftChild : node.rightChild;

                if (theChild != null)
                {
                    theChild.parent = node.parent;

                    if (node.parent == null)
                    {
                        root = theChild;
                    }
                    else
                    {
                        if (node.parent.leftChild.CompareTo(node) == 0)
                        {
                            node.parent.leftChild = theChild;
                        }
                        else
                        {
                            node.parent.rightChild = theChild;
                        }
                    }
                }
                else
                {
                    if (node.parent == null)
                    {
                        root = null;
                    }
                    else
                    {
                        if (node.parent.leftChild.CompareTo(node) == 0)
                        {
                            node.parent.leftChild = null;
                        }
                        else
                        {
                            node.parent.rightChild = null;
                        }
                    }
                }
            }
        } 
    }
}
