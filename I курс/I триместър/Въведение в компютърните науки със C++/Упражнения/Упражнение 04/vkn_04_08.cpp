#include <iostream>
using namespace std;

int main() {
    //system("chcp 1251"); // за MS VS
    char ch1, ch2;
    cout<<"Два знака: ";
    cin>>ch1>>ch2;
    // релация между знаковете
    cout<< '\''<<ch1<<'\'' << ( ch1<ch2 ? " < " : ch1==ch2 ? " = " : " > " ) << '\''<<ch2<<'\'' <<endl;

    cout<< '\''<<ch1<<'\'';
    if(ch1<ch2) cout << " < ";
    else if(ch1==ch2) cout << " = ";
    else cout << " > ";
    cout<< '\''<<ch2<<'\'' <<endl;

    // релация между кодовете
    cout<< (int)ch1 << ( ch1<ch2 ? " < " : ch1==ch2 ? " = " : " > " ) << (int)ch2 <<endl;
    cout<< (int)ch1;
    if(ch1<ch2) cout << " < ";
    else if(ch1==ch2) cout << " = ";
    else cout << " > ";
    cout<< (int)ch2 <<endl;
    //system("pause"); // за MS VS
}