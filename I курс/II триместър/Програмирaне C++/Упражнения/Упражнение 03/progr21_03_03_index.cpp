// ����: progr21_03_03_index.cpp
// �� ���-� 3 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <cmath>
int const Len = 7;
int main() {
  long double ar[Len];
  for(int i=0; i<Len; ++i) {
    cout<<"  "<< i + 1 <<"-� ����� (�� ���� "<<Len<<"): ";
    cin>>ar[i];
  }
  cout<<"������ ������� � ����������� ����:\n";
  for(int i=Len-1; 0<i; --i)
    if( trunc(ar[i-1]+ar[i]) == ar[i-1]+ar[i] )
      cout << ar[i - 1] << " + " << ar[i]
           << " = ar[" << i - 1
           << "] + ar[" << i << "] = "
           << ar[i-1] + ar[i] << endl;
  cout<<"(���� �� ��������)\n";
}

