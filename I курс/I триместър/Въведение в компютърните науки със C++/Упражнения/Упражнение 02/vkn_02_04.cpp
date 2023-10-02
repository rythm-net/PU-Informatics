#include <iostream>
using namespace std;

int main(){
    int n;
    cout << "Цяло число: ";
    cin >> n;
    cout << "Цифра на стотиците: " << n/100%10 << endl;
    cout << "Цифра на хилядите: " << n/1000%10 << endl;
}