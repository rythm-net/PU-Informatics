//Да се напише програма, която приема цяло число и смята неговия факториел и го извежда на екрана
//3! = 3*2*1
//1! = 1

#include <iostream>
using namespace std;

int main() {
    int Fac = 1;
    cout << "Въведете число: " << endl;
    cin >> Fac;
    double F = 1;
    for (int i = 2; i <= Fac; i++) {
        F *= i;
    }

    cout << "Fac(" << Fac << ") = " << F << endl;
    return 0;
}