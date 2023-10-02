#include <iostream>
using namespace std;

int main() {
    int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int sum = 0;
    cout << "Масив: ";

    for (int elm : ar) {
        cout << ' ' << elm;
        sum += elm;
    }
    cout << "\nСума: " << sum << endl;
    //system("pause");
}