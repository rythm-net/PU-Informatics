// ����: progr21_02_03_demo.cpp
// �� ���-� 2 �� ������������ (C++) ��� ����. ���., ���., 1 ����
#include <iostream>
using namespace std;
int main() {
  double * u = new double; // ��������� �� �������� �����
  cout<<"�����: ";
  cin>> *u;
  cout<<"���������: "<< *u <<endl;
  delete u; // ����������� �� �������� �����
  u = NULL; // ���������� �������, �� u �� ���� �����
  if(u) cout<<"���������: "<< *u <<endl;
  const double * uc = new double const (-234.56778989);
    // ��������� �� ��������� � ����������� �����
  cout<<"*uc = "<< *uc <<endl;
  delete uc;
  uc = NULL;
  if(uc) cout<<"���������: "<< *uc <<endl;
  int Len = 4;
  u = new double [Len]; // ��������� �� �������� �����
    for(int i=0; i<Len; ++i) u[i] = i*10.23 + 1;
    for(int i=0; i<Len; ++i) cout<<u[i]<<"  ";
    cout<<endl;
  delete[] u; // ����������� �� ��������� �����
  u = NULL;
  if(u) {
    for(int i=0; i<Len; ++i) cout<<u[i]<<"  ";
    cout<<endl;
  }
  Len = 6;
  uc = new double const [Len] {1.1, 2.2, 3.3, 4.444};
    // ��������� �� ����� �� ���������
    for(int i=0; i<Len; ++i) cout<<uc[i]<<"  ";
    cout<<endl;
  delete[] uc;
  uc = NULL;
}
