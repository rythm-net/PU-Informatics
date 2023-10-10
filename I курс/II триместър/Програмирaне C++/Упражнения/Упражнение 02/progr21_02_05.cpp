// ����: progr21_02_05.cpp
// �� ���-� 2 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
#include <ctime>
#include <iomanip>
int main() {
  srand(time(NULL));
  const int Len = 15, w = 5;
  // ���������
  long ar[Len];
  for(int i=0; i<Len; ++i) ar[i] = rand()%4 + 8;
  // ���������
  for(long elm : ar) cout<<setw(w)<<elm;
  cout<<endl;
  for(int i=0; i<Len; ++i) cout<<setw(w)<<i;
  cout<<endl;
  // ��������� �� �����������
  long min = ar[0];
  int minCount = 0;
  for(long elm : ar)
    if(min==elm) ++minCount;
    else if(min>elm) { min=elm; minCount=1; }
  int * indx = new int[minCount];
    for(int i=0, pos=0; i<Len; ++i)
      if(min==ar[i]) indx[pos++]=i;
    cout<<"������� �� ����������� ��������: ";
    for(int pos=0; pos<minCount; ++pos) cout<<indx[pos]<<" ";
    cout<<endl;
    for(int pos=0; pos<minCount; ++pos)
      ar[ indx[pos] ] += 100;
  delete[] indx;
  indx = NULL;
  // ���������
  for(long elm : ar) cout<<setw(w)<<elm;
  cout<<endl;
  for(int i=0; i<Len; ++i) cout<<setw(w)<<i;
  cout<<endl;
}
