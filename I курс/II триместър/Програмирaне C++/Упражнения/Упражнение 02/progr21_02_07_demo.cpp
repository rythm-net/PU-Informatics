// ����: progr21_02_07_demo.cpp
// �� ���-� 2 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
int main() {
  int i=1, j=5, &r=i;
  cout<<"i= "<<i<<"; r= "<<r<<"; j= "<<j<<endl;
  r=j;
  j=8;
  cout<<"i= "<<i<<"; r= "<<r<<"; j= "<<j<<endl;
}
