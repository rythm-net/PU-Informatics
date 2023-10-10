// Файл: progr21_02_11_demo.cpp
// От упр-е 2 по Програмиране (C++) със спец. Инф., ред., 1 курс
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  srand(time(NULL));
  int rows=2;
  const int columns=5;
  long (*u)[columns] = new long[rows][columns];
                 // създаване на изменяем масив БЕЗ инициализация
    for(int r=0; r<rows; ++r)
      for(int c=0; c<columns; ++c)
        u[r][c] = rand()%10;
    for(int r=0; r<rows; ++r) {
      for(long elm : u[r]) cout<<"  "<<elm;
      cout<<endl;
    }
  delete[] u;
  u = NULL;
  cout<<"------------\n";
  rows=4;
  u = new long[rows][columns] {{1},{2,4,8}};
                 // създаване на изменяем масив СЪС инициализация
    for(int r=0; r<rows; ++r) {
      for(long elm : u[r]) cout<<"  "<<elm;
      cout<<endl;
    }
  delete[] u;
  u = NULL;
  cout<<"------------\n";
  rows=3;
  long const (*uCnst)[columns];
  uCnst = new long const[rows][columns] {{1111},{21,22,23,24}};
          // създаване на масив от константи
    for(int r=0; r<rows; ++r) {
      for(long elm : uCnst[r]) cout<<"  "<<elm;
      cout<<endl;
    }
  delete[] uCnst;
  uCnst = NULL;
}
