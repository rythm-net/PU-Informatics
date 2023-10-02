#include <iostream>
#include <cfloat>
using namespace std;

int main() {
    cout.precision(__FLT_DECIMAL_DIG__);
    cout<<"float:"
        <<"\n  брой байтове: "<<sizeof(float)
        <<"\n  минимално положително: "<<FLT_MIN
        <<"\n  максимално положително: "<<FLT_MAX
        <<"\n  брой десетични цифри: "<<__FLT_DECIMAL_DIG__<<endl;

    cout.precision(__DBL_DECIMAL_DIG__);
    cout<<"double:"
        <<"\n  брой байтове: "<<sizeof(double)
        <<"\n  минимално положително: "<<DBL_MIN
        <<"\n  максимално положително: "<<DBL_MAX
        <<"\n  брой десетични цифри: "<<__DBL_DECIMAL_DIG__<<endl;

    cout.precision(__DECIMAL_DIG__);
    cout<<"long double:"
        <<"\n  брой байтове: "<<sizeof(long double)
        <<"\n  минимално положително: "<<LDBL_MIN
        <<"\n  максимално положително: "<<LDBL_MAX
        <<"\n  брой десетични цифри: "<<__DECIMAL_DIG__<<endl;
    //system("pause");
}