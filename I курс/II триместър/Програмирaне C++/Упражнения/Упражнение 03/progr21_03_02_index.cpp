// ����: progr21_03_02_index.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
int const number = 6;
int main() {
  long long ar[number];
  for(int i=0; i<number; ++i) {
    cout<<"  "<<i+1<<"-� ����� (�� ���� "<<number<<"): ";
    cin>>ar[i];
  }
  for(long long r = -2LL; r<=2LL; ++r) {
    cout<<"������� "<<r<<" �� �������� ��: ";
    for(long long elm : ar)
      if( elm % 3 == r )
        cout<<elm<<' ';
    cout<<endl;
  }
}
