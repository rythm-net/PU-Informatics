// ����: progr21_02_09.cpp
// �� ���-� 2 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand(time(NULL));
  const int Len = 10;
  long ar[Len];
  for(long &ref : ar) ref = rand()%21 - 15;
  for(long elm : ar) cout<<elm<<"  ";
  cout<<endl;
  int Last = Len-1;
  while( 0<=Last && ! (ar[Last]%2) ) --Last;
  if(0>Last) cout<<"���� ������� �������.\n";
  else {
    long &refOdd = ar[Last];
    refOdd *= 2;
  }
  cout<<"��������:\n";
  for(long elm : ar) cout<<elm<<"  ";
  cout<<endl;
}
