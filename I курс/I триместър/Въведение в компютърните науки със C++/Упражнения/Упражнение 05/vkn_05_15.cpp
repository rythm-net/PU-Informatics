#include <iostream>
using namespace std;

int main() {
    short n1, n2;
    cout << "Две цели числа: ";
    cin >> n1 >> n2;

    if (n2 < n1) { short temp = n1; n1 = n2; n2 = temp; }
    cout << "Кратни на 5 числа между " << n1 << " и " << n2 << ":";
    for(int d = (n1 + (n1>=0 ? 5 : 1))/5*5; d < n2; d += 5 )
        cout<<' '<<d;
    cout << "  (край)\n";
    //system("pause");
}