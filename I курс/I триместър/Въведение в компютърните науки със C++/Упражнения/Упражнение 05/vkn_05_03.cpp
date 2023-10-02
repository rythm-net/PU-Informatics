#include <iostream>
#include <climits>
#include <iomanip>
using namespace std;

int main() {
    const int width = 20;
    cout << "Максимални стойности:\n";

    cout << "  В осмична бройна система:\n" << oct
         << "за типа unsigned long long: "
         << setw(width) << ULLONG_MAX << endl
         << "         за типа long long: "
         << setw(width) << LLONG_MAX << endl;

    cout << "  В десетична бройна система:\n" << dec
         << "за типа unsigned long long: "
         << setw(width) << ULLONG_MAX << endl
         << "         за типа long long: "
         << setw(width) << LLONG_MAX << endl;

    cout << "  В шестнайсетична бройна система:\n" << hex
         << "за типа unsigned long long: "
         << setw(width) << ULLONG_MAX << endl
         << "         за типа long long: "
         << setw(width) << LLONG_MAX << endl;

    cout << dec;
    // активира 10-ичен запис за следващите цели числа
    cout << "Степени на двойката от тип unsigned long long:\n";
    for (int k = 0; k <= 63; k==5 ? k=59 : ++k)
        cout << "2 на степен " << setw(2) << k << " = "
             << setw(width)
             << (1uLL << k) // 1uLL е от тип unsigned long long
             << endl;
    //system("pause");
}