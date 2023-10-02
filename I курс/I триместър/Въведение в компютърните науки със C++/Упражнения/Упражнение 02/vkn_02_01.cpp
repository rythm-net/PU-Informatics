//Да се напише програма, която намира сумата на числата от 1 до 200

#include <iostream>
using namespace std;

int main() {
    int Sum = 0;
    for (int i = 1; i <= 200; i++) {
        Sum += i;
    }

    cout << "Sum = " << Sum << endl;
    return 0;
}