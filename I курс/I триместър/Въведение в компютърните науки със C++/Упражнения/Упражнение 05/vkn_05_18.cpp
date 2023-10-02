#include <iostream>
using namespace std;

int main() {
    int N = -10;
    do {
        if (N < -4 || N % 2) continue;
        if (N >= 10) break;
        cout << "N=" << N << endl;
    } while (++N < 200);
    //system("pause");
}