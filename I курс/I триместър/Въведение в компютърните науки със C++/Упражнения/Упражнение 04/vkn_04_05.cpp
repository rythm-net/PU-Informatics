#include <iostream>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    bool x, y, z;
    cout << "Ѕулеви x y z: ";
    cin >> x >> y >> z;
    cout<<"f("<<x<<';'<<y<<';'<<z<<") = "
        << (x&&y&&!z || !x&&y&&!z || !x&&!y&&z)
        << endl;
    cout<<"f("<< (x?"true":"false")
        <<';'<< (y?"true":"false")
        <<';'<< (z?"true":"false") <<") = "
        << (x&&y&&!z || !x&&y&&!z || !x&&!y&&z
            ? "true"
            : "false")
        << endl;
    //system("pause"); // за MS VS
}