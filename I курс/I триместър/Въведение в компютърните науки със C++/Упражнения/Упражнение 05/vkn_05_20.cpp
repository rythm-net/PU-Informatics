#include <iostream>
using namespace std;

int main() {
    for (int x=7, y=x; x>0; y==1 ? y=--x : --y)
        cout << y << (y==1 ? '\n' : ' ');
    //system("pause");
}