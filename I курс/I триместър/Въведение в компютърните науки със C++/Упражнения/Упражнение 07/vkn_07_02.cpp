#include <iostream>
using namespace std;

int main() {
    const int n = 10;
    int arr[n];
    int maxNum = 1;
    cout << "Enter all numbers in the array: " << endl;

    for (int i = 0; i < n;  i++) {
        cin >> arr[i];
    }

    cout << "The numbers between 25 and 225 are: ";
    for (int i = 0; i < n; i++) {
        if (arr[i] > 25 && arr[i] < 225) {
            cout << arr[i] << ", ";
        }
    }
    cout << endl;

    for (int i = 0; i < n; i++) {
        if (arr[i] % 2 == 0) {
            if (arr[i + 1] % 2 == 0) {
                cout << "The even numbers after " << arr[i] << " are: ";
                for (int j = i+1; j < n; j++) {
                    if (arr[j] % 2 == 0) {
                        cout << arr[j] << ", ";
                    } else {break;}
                }
                cout << endl;
            }
            else {
                cout << "The number after " << arr[i] << " is not even." << endl;;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        if (arr[i] > maxNum) {
            maxNum = arr[i];
        }
    }
    cout << "The furthest number of 1 is: " << maxNum;
}