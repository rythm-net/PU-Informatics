// ����: progr21_03_03_pointer.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <cmath>
const int Len = 7;
int main() {
  long double ar[Len];
  for(long double *u = ar; u-ar < Len; ++u) {
    cout<<"  "<< u-ar + 1 <<"-� ����� (�� "<<Len<<"): ";
    cin>> *u;
  }
  cout<<"������ ������� � ����������� ����:\n";
  for(long double * u = ar + Len-1; ar < u; --u)
    if( trunc(*(u-1)+*u) == *(u-1)+*u )
      cout << *(u-1) <<" + "<< *u
           << " = ar[" << u-1 - ar << "] + ar[" << u - ar
           << "] = " << *(u-1)+*u << endl;
  cout<<"  (���� �� ��������)\n";
}
