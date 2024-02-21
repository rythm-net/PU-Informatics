using System;

namespace BSort
{
    public static class MyArrayExtensions
    {
        public static void SwapElements<T>(this T[] arr, int index1, int index2)
        {
            T temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }

        public static void PrintArray<T>(this T[] arr)
        {
            for (int i = 0; i < arr.Length; i++)
            {
                Console.Write(arr[i]);
                if (i < arr.Length - 1)
                    Console.Write(", ");
            }
            Console.WriteLine();
        }
    }

    class Sorting
    {
        static void SelectionSort(int[] arr)
        {
            // algorithm complexity = O(n^2)
            for (int i = 0; i < arr.Length - 1; i++)
            {
                // find minimum value
                int minValue = arr[i];
                int minPos = i;
                for (int j = i + 1; j < arr.Length; j++)
                    if (arr[j] <= minValue)
                    {
                        minValue = arr[j];
                        minPos = j;
                    }
                // swap the minimum with the current position(i)
                arr.SwapElements(i, minPos);
            }
        }

        static void InsertionSort(int[] arr)
        {
            // algorithm complexity = O(n^2)
            for (int i = 1; i < arr.Length; i++)
            {
                int value = arr[i];
                int j;
                for (j = i - 1; j >= 0 && arr[j] > value; j--)
                    arr[j + 1] = arr[j];
                arr[j + 1] = value;
            }
        }

        private static void quickSort(int[] arr, int leftb, int rightb)
        {
            //int pivot = arr[leftb + (rightb - leftb) / 2];
            int pivot = arr[(leftb + rightb) / 2];
            //int pivot = arr[rightb];

            int li = leftb;
            int ri = rightb;

            // loop until left and right index meet
            while (li <= ri)
            {
                // move left index to the right until we find bigger than pivot
                while (li <= rightb && arr[li] < pivot) li++;
                // move right index to the left until we find smaller than pivot
                while (ri >= leftb && arr[ri] > pivot) ri--;

                // swap the elements
                if (li <= ri)
                {
                    arr.SwapElements(li, ri);
                    li++; ri--;
                }
            }
            if (li < rightb) quickSort(arr, li, rightb);
            if (ri > leftb) quickSort(arr, leftb, ri);
        }

        static void BubbleSort(int[] arr)
        {
            for (int i = arr.Length - 1; i > 0; i--)
            {
                bool sorted = true;
                for (int j = 0; j < i; j++)
                {
                    if (arr[j + 1] < arr[j])
                    {
                        arr.SwapElements(j, j + 1);
                        sorted = false;
                    }
                }
                if (sorted)
                    break;
            }
        }

        static void QuickSort(int[] arr)
        {
            quickSort(arr, 0, arr.Length - 1);
        }

        static int[] tempArray = new int[0];

        private static void mergeArr(int[] arr, int left, int middle, int right)
        {
            //merge both sides of the subarray [left-middle] and [middle+1-right]
            //copy [left-middle] to the temp array
            for (int li = left, tmp = 0; li <= middle; li++, tmp++)
                tempArray[tmp] = arr[li];
            //merge the arrays
            int tmpi = 0;
            int righti = middle + 1;
            int i = left;
            while (i < righti && righti <= right)
            {
                if (tempArray[tmpi] <= arr[righti])
                    arr[i++] = tempArray[tmpi++];
                else
                    arr[i++] = arr[righti++];
            }

            while (i < righti)
                arr[i++] = tempArray[tmpi++];
        }

        private static void mergeSort(int[] arr, int left, int right)
        {
            if (left < right)
            {
                int middle = (left + right) / 2;
                mergeSort(arr, left, middle);
                mergeSort(arr, middle + 1, right);
                mergeArr(arr, left, middle, right);
            }
        }

        static void MergeSort(int[] arr)
        {
            tempArray = new int[arr.Length];
            mergeSort(arr, 0, arr.Length - 1);
        }

        static void CountingSort(byte[] arr)
        {
            int[] counts = new int[byte.MaxValue];
            // count every number in the array
            foreach (byte element in arr)
                counts[element]++;
            // sort the array
            byte num = 0;
            int i = 0;
            while (num < byte.MaxValue)
            {
                for (int j = 0; j < counts[num]; j++)
                    arr[i++] = num;
                num++;
            }
        }

        static void Main(string[] args)
        {
            //int[] arr = { 5, 6, 100, 3, 6 };
            //arr.SwapElements(0, 3);
            //arr.PrintArray();

            //long[] larr = { 1, 2, 3 };
            //larr.SwapElements(1, 2);
            //larr.PrintArray();

            //C# has sorting build in under Array class
            int[] arr = { 17, 1, 5, 20, 10, 15, 1 };
            Array.Sort(arr);

            arr = new int[] { 17, 1, 5, 20, 10, 15, 1 };
            SelectionSort(arr);
            arr.PrintArray();

            arr = new int[] { 17, 1, 5, 20, 10, 15, 1 };
            InsertionSort(arr);
            arr.PrintArray();

            arr = new int[] { 17, 1, 5, 20, 10, 15, 1 };
            BubbleSort(arr);
            arr.PrintArray();

            arr = new int[] { 17, 1, 5, 20, 10, 15, 1 };
            QuickSort(arr);
            arr.PrintArray();

            arr = new int[] { 17, 1, 5, 20, 10, 15, 1 };
            MergeSort(arr);
            arr.PrintArray();

            byte[] byteArr = new byte[] { 1, 5, 1, 3, 3, 7 };
            CountingSort(byteArr);
            byteArr.PrintArray();
        }
    }
}
