#include <iostream>
using namespace std;

int main() {
    int i = 0, n = 1;
    cout << "Въведете n " << endl;
    cin >> n;
    if (cin.fail() || n < 1) {
        cout << "Невалидна стойност за n " << endl;
        return 1;
    }

    bool is_prime = true;
    for (i = n - 1; i > 1; i--) {
        if (n % i == 0) {
            is_prime = false;
            break;
        }
    }

    cout << "Числото е: ";
    cout << is_prime ? "просто" : "сложно" << endl;
    return 0;
}