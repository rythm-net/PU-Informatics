#include <iostream>
using namespace std;

int main() {
    int i=0, fac=1, n=1;
    cout << "Въведете n " << endl;
    cin >> n;
    if(cin.fail() || n<1){
        cout << "Невалидна стойност за n " << endl;
        return 1;
    }
    for (i=1, i<=n, i++) {
        fac *=i;
    }
    cout << "fac (" << n << ") =" << fac << endl;
    return 0;
}