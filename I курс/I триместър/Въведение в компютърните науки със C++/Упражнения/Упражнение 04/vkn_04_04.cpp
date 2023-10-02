#include <iostream>
using namespace std;

int main() {
    int A[8]={7, -7, 7, -7, 3, -3, 3, -3};
    int B[8]={3, 3, -3, -3, 7, 7, -7, -7};

    for(int i=0; i<8; i++) {
        int цяло=A[i]/B[i];
        int остатък=A[i]%B[i];
        cout << "цяло[" << i << "]=" << цяло << endl;
        cout << "остатък[" << i << "]" << остатък << endl;
    }
}