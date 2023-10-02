#include <iostream>
using namespace std;

int main() {
    int N = 1;
    while (N < 200) {
        if (N >= 50) break;
        else ++N;
        if (N % 5) continue;
        cout << " " << N;
    };

    cout << "\n-----\n";
    //system("pause");
}