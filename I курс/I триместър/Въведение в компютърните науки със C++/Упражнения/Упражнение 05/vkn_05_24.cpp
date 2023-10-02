#include <iostream>
#include <ctime>
using namespace std;

int main() {
    srand(time(NULL));
    // подготвя генерирането на случайни числа
    // чрез базово число, равно на системното време
    cout << "Десет случайни числа от 0 до 50:\n";
    for (int i = 1; i <= 10; ++i)
        cout << ' ' << rand() % 51; // rand() връща неотрицателно цяло
    cout << endl;
    cout << "Десет случайни числа от -20 до -5:\n";
    for (int i = 1; i <= 10; ++i)
        cout << ' ' << rand() % 16 - 20;
    cout << endl;
    //system("pause");
}