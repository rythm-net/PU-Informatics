#include <iostream>
using namespace std;

int main() {
    char L1, L2;
    do {
        cout << "1-а малака латинска буква: ";
        cin >> L1;
    } while (L1 < 'a' || 'z' < L1);

    do {
        cout << "2-а малака латинска буква: ";
        cin >> L2;
    } while (L2 < 'a' || 'z' < L2);
    if (L2 < L1) { char temp = L1; L1 = L2; L2 = temp; }
    cout << "Букви строго между " << L1 << " и " << L2 << ":\n";
    for (char c = L1 + 1; c < L2; ++c) cout << c << " ";
    cout << "\n(край)\n";
    //system("pause");
}