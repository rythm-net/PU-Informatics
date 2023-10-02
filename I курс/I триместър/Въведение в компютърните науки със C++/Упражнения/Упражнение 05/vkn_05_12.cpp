#include <iostream>
using namespace std;

int main() {
    int n1, n2;
    do {
        cout << "1-о цяло число: ";
        cin >> n1;
        cout << "2-о цяло число: ";
        cin >> n2;
    } while ( ( (n1%2==0?1:0) + (n1%3==0?1:0) + (n1%5==0?1:0)
                + (n1%7==0?1:0) + (n1%11==0?1:0) )
              !=( (n2%2==0?1:0) + (n2%3==0?1:0) + (n2%5==0?1:0)
                  + (n2%7==0?1:0) + (n2%11==0?1:0) ) );

    int d[] = { 2, 3, 5, 7, 11 };
    for (int i = 1, n = n1; i <= 2; ++i) {
        cout << "\n  Делители на " << n << ": ";
        for (int elm : d)
            if (n % elm == 0)
                cout << "  " << elm;
        n = n2;
    }
    //system("pause");
}