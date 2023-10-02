#include <iostream>
using namespace std;

int main() {
    char h;
    do {
        cout<<"16-ична цифра: ";
        cin>>h;
    } while( (h<'0' || '9'<h)
             && (h<'a' || 'f'<h)
             && (h<'A' || 'F'<h) );

    int hVal = '0'<=h && h<='9'
               ? h-'0'
               : 'a'<=h && h<='f'
                 ? 10 + h-'a'
                 : 10 + h-'A';

    cout<<"Стойност на цифрата: "<<hVal<<endl;
    if(15==hVal) cout<<"Няма следваща цифра.\n";
    else {
        cout<<"Следваща цифра: "<<hex<<hVal+1<<endl;
        if('A'<=h&&h<='F')
            cout<<"Следваща цифра: "<< (char)(h+1) <<endl;
    }
    //system("pause");
}