#include <iostream>
#include <math.h>
using namespace std;

int main() {
    char type;
    float S;
    cout << "Insert type: " << endl;
    cin >> type;
    if (cin.fail()) {
        cout << "Invalid input for type! " << endl;
        return 1;
    }

    switch (type) {
        case 'a': {
            float a, ha;
            cout << "Insert value for a & ha: " << endl;
            cin >> a >> ha;
            if (cin.fail() || a <= 0.0 || ha <= 0.0) {
                cout << "Wrong input for a & ha! " << endl;
                return 2;
            }

            S = (a * ha) / 2;
            cout << "S = " << S << endl;
            break;
        }

        case 'b': {
            float a, b, c, p;
            cout << "Insert value for a, b, c: " << endl;
            cin >> a >> b >> c;
            if (cin.fail() || !(a > 0 && b > 0 && c > 0 && a < b + c && b < a + c && c < a + b)) {
                cout << "Invalid triangle! " << endl;
                return 3;
            }

            p = (a + b + c) / 2;
            S = sqrt(p * (p - a) * (p - b) * (p - c));
            cout << "S = " << S << endl;
            break;
        }

        default: {
            cout << "Invalid value for type!" << endl;
            return 2;
        }
    }
    return 0;
}