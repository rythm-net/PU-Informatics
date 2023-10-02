#include <iostream>
#include <ctime>
using namespace std;

int main() {
    struct tm t;
    _getsystime(&t);
    cout<<"Час: "<<t.tm_hour<<':'<<t.tm_min<<':'<<t.tm_sec
        <<"\nДата: "<<t.tm_mday<<'.'<<t.tm_mon<<'.'
        <<1900+t.tm_year<<endl;
    //system("pause");
}