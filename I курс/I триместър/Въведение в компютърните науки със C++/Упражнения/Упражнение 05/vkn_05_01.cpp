//Да се напише програма, която намира сумата на 10 положителни цели числа и я извежда на екрана.
//Тези цели числа трябва да са въведени от потребителя.
//Да се намери минималното число от тези и да се изведе на екрана.

#include <iostream>
#include <math.h>
using namespace std;

int main() {
    int A[10] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int Sum = 0;
    for (int i = 0; i < 10; i++) {
        cout << "Vyvedi A[" << i << "] = " << endl;
        cin >> A[i];
        if (cin.fail() || A[i]<0 ) {
            cout << "Wrong format" << endl;
            return 1;
        }
        Sum += A[i];
    }

    int min = A[0];
    for (int i = 1; i < 10; i++) {
        if (A[i] < min) {
            min = A[i];
        }
    }

    cout << "Sum = " << Sum << endl;
    cout << "Min = " << min << endl;
    return 0;
}