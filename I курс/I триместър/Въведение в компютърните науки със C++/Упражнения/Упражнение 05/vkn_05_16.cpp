#include <iostream>
using namespace std;

int main() {
    char Letr;
    do {
        cout << "Въведете малка латинска буква: ";
        cin >> Letr;
    } while (Letr < 'a' || 'z' < Letr);

    cout << "Съответна голяма буква: \'"
         << (char) (Letr + 'Z' - 'z') << "\'\n";
    //system("pause");
}