#include <iostream>
using namespace std;

int main() {
    int *A;
    A = new int[30];
    int sum;
    int sumOfEvenNumbers;

    for (int i = 0; i < A[30]; i++) {
        cin >> A[i];
        sum += A[i];
    }

    int avarage = sum / A[30];
    for (int j = 0; j < A[30]; j++) {
        if ((A[j] % 2 == 0) && (A[j] < avarage)) {
            sumOfEvenNumbers += A[j];
        }
    }
}