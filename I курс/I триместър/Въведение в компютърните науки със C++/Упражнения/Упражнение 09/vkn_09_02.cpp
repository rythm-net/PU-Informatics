//Да се напише програма, която използва vector и въвежда първия елемент на числова редица T,
//и изчислява следващите 35 елемента от тази редица по следната формула:
//T[i] = 2Т[i-1]^i - 23*cos(Т[i-1]*3), където ^ в записа е "на степен".
//Да се изведат всички елементи на числовия ред на екрана.

#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

int main() {
	vector<double> T;
    double t_0=0;
    cout << "Vyvedete T[0] = " << endl;
    cin >> t_0;
    T.push_back(t_0);

    if(cin.fail()) {
        cout << "Wrong format" << endl;
        return 0;
    }

    for(int i=1; i<=35; i++) {
        t_0 = 2 * pow(T[i-1], i) -23 * cos(3*T[i-1]);
        T.push_back(t_0);
    }

    for(int i=0; i<T.size(); i++) {
        cout << "T[" << i << "] = " << T[i] << endl;

    }
    return 0;
}