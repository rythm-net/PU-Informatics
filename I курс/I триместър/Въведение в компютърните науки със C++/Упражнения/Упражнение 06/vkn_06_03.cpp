#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

struct Point {
    double X;
    double Y;
    Point(){
        X=0; Y=0;
    }

    Point(double _X, double _Y) {
        X=_X; Y=_Y;
    }

    Point(Point& b) {
        X=b.X;
        Y=b.Y;
    }

    bool input() {
        cout << "Въведете X" << endl;
        cin >> X;
        cout << "Въведете Y" << endl;
        cin >> Y;
        if(cin.fail()){
            return false;
        }
        return true;
    }

    double distance(Point& b) {
        return sqrt(pow(X - b.X, 2) + pow(Y-b.Y, 2));
    }
};

int main() {
    vector<Point> A;
    cout << "Колко точки ще въвеждаме " << endl;
    int n;
    cin >> n;

    if(cin.fail() || n<1) {
        cout << "Невалидна стойност за n " << endl;
        return 1;
    }

    for(int i=0; i<n; i++) {
        Point pI;
        pI.input();
        if(!pI.input()){
            cout<<"Невалидни входни данни за точка" << endl;
            return 2;
        }
        A.push_back(pI);
    }

    Point p;
    if(!p.input()) {
        cout<<"Невалидни входни данни за точката" << endl;
        return 3;
    }

    for(Point pI: A){
        cout<<"разстояние: " << (p.distance(pI)) << endl;
    }
    return 0;
}