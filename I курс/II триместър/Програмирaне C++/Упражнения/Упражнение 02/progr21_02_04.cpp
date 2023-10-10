// Файл: progr21_02_04.cpp
// От упр-е 2 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
int main() {
  int n;
  do {
    cout<<"Брой от 2 до 10: ";
    cin>>n;
  } while(n<2 ||10<n);
  double *ar = new double[n];
  for(int i=1; i<=n; ++i) {
    cout<<"  "<<i<<"-о число: ";
    cin>>ar[i-1];
  }
  cout<<"Числа в обратен ред:\n";
  for(int i=n-1; 0<=i; --i) cout<<ar[i]<<endl;
  delete[] ar;
  ar = NULL; // само заради добрия стил на програмиране
}
