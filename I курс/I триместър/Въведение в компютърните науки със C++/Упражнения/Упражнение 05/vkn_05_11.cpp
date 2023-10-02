#include <iostream>
using namespace std;

int main() {
    long long n;
    do {
        cout << "Естествено число: ";
        cin >> n;
    } while (n < 1);
    int max = 0;

    do {
        int next = n % 10;
        n /= 10;
        if (max < next) max = next;
    } while (n);
    cout << "Максимална цифра: " << max << endl;
    //system("pause");
}