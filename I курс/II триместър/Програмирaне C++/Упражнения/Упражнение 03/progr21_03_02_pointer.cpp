// ����: progr21_03_02_pointer.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
int const number = 6;
int main() {
  long long ar[number];
  for( long long * u = ar; u-ar<number; ++u ) {
    cout<<"  "<< u-ar + 1 <<"-� ����� (�� ���� "<<number<<"): ";
    cin>> *u;
  }
  for(long long r = -2LL; r<=2LL; ++r) {
    cout<<"������� "<<r<<" �� �������� ��: ";
    for(long long elm : ar)
      if( elm % 3 == r )
        cout<<elm<<' ';
    cout<<endl;
  }
}
