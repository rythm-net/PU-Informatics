#include <iostream>
using namespace std;

int main() {
    long long n;
    cout << "Цяло число: ";
    cin >> n;
    if(n<0) n = -n;

    do {
        cout << n % 10 << endl;
        n /= 10;
    } while (n);
    //system("pause");
}