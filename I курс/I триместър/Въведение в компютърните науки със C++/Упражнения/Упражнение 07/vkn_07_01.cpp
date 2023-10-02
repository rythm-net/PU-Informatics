//Да се напише програма на C++, която работи с 3 масива A, B, C с еднакъв размер.
//Въвежда данни от клавиатурата в A и B и изчислява данни за масива C, като за всяко i C[i] = A[i]+ 2*B[i];
//Въвеждането на данните в масив да се реализира като отделна функция, както и изчислението на данните също да бъде отделна функция.

#include <iostream>
#include <math.h>
#include <vector>
constexpr auto ARRAY_LENGTH = 5;
using namespace std;

void Input(double* A) {
    for (int i = 0; i < ARRAY_LENGTH; i++) {
        cout << "Vyvedete danni za index " << i << endl;
        cin >> A[i];
    }
}

void Calculate(double* A, double* B, double* C) {
    for (int i = 0; i < ARRAY_LENGTH; i++) {
        C[i] = A[i] + 2 * B[i];
    }
}

int main() {
    double A[ARRAY_LENGTH], B[ARRAY_LENGTH], C[ARRAY_LENGTH];
    cout << "Array A" << endl;
    Input(A);
    cout << "Array B" << endl;
    Input(B);
    Calculate(A, B, C);
    cout << "Array C" << endl;
    for (int i = 0; i < ARRAY_LENGTH; i++) {
        cout << "C(" << i << ") = " << C[i] << endl;
    }
    return 0;
}