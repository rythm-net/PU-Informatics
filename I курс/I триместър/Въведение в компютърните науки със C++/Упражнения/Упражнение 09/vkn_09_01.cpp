//Да се напише програма, която организира вход от клавиатура на дневните обороти на магазин за месец с 20 работни дни.
//След като са въведени всички дневни обороти, да се изчисли:
//1. Кои са номерата на дните с най-малък оборот.
//2. Средноаритметичен оборот.

#include "stdafx.h"
#include <iostream>
using namespace std;

template<class T>
int Vhod(T *oboroti, int num_params) {
    for (int i = 0; i < num_params; i++) {
        cout << "Vyvedete oborot za den " << i << endl;
        cin >> oboroti[i];
        if (cin.fail() || oboroti[i] < 0.0) {
            cout << "Wrong input " << endl;
            return 1;
        }
    }
    return 0;
}


int main() {
    float oboroti[20];
    if (Vhod(oboroti, 20) != 0) {
        return 1;
    }

    float min_oborot = oboroti[0];
    for (int i = 0; i < 20; i++) {
        if (oboroti[i] < min_oborot) {
            min_oborot = oboroti[i];
        }
    }

    float average = 0;
    for (int i = 0; i < 20; i++) {
        if (oboroti[i] == min_oborot) {
            cout << "Den s min. oborot " << i << endl;
        }
        average += oboroti[i];
    }

    average /= 20;
    cout << "Sreden oborot za den " << average << endl;
    return 0;
}