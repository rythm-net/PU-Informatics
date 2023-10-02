#include<iostream>
#include<string>
#include<vector>
using namespace std;

struct Weapon {
    int code;
    float price;
    string name;
    int cat;
    Weapon() {
        code=0; price=0; name=""; cat=0;
    }

    Weapon(int _code, float _price, string _name, int _cat){
        code=_code; price=_price; name=_name; cat=_cat;
    }
};

struct Sell {
    int code;
    int num_sold;
    int day;
    Sell() {
        code=0; num_sold=0; day=0;
    }

    Sell(int _code, int _num_sold, int _day){
        code=_code; num_sold=_num_sold; day=_day;
    }
};

struct Sell sells[100];
struct Weapon weapons[100];
int numSells=0;
int numWeapons=0;
float dnevniOboroti[31];
float oborotiZaArtikul[100];

void inputWeapon() {
    Weapon& w=weapons[numWeapons];
    cout << "Въведете код: " << endl;
    cin >> w.code;
    cout << "Въведете име: " << endl;
    cin >> w.name;
    cout << "Въведете цена: " << endl;
    cin >> w.price;
    cout << "Въведете категория: " << endl;
    cin >> w.cat;
    numWeapons++;
}

void inputSell() {
    Sell& s=sells[numSells];
    cout << "Въведете код: " << endl;
    cin >> s.code;
    cout << "Въведете брой продадени" << endl;
    cin >> s.num_sold;
    cout << "Въведете ден на продажбата" << endl;
    cin >> s.day;

    float ed_cena=0.0;
    for( int i=0; i<numWeapons; i++){
        Weapon& w =weapons[i];
        if(w.code==s.code){
            ed_cena=w.price;
            break;
        }
    }

    dnevniOboroti[s.day]+=s.num_sold*ed_cena;
    oborotiZaArtikul[s.code]+=s.num_sold*ed_cena;
    numSells++;
}

void getMinDailySells() {
    float min_oborot=3000000; int min_day=0;
    for(int i=0; i<31; i++) {
        if(dnevniOboroti[i]!=-1 && dnevniOboroti[i]<min_oborot){
            min_day=i;
            min_oborot=dnevniOboroti[i];
        }
    }
    min_oborot++;
    cout << "Минимален оборот за ден " << (min_day+1) << " е: " << min_oborot << endl;
}

void getMaxDailySells() {
    float max_oborot=0; int max_day=0;
    for(int i=0; i<31; i++){
        if(dnevniOboroti[i]!=-1 && dnevniOboroti[i]>max_oborot){
            max_day=i;
            max_oborot=dnevniOboroti[i];
        }
    }
    max_oborot++;
    cout << "Максимален оборот за ден " << (max_day+1) << " е: " << max_oborot << endl;
}

void getMaxSoldWeapon() {
    float max_oborot=0; int maxArt_code=-1;
    for(int i=0; i<100; i++){
        if(oborotiZaArtikul[i]>max_oborot){
            max_oborot=oborotiZaArtikul[i];
            maxArt_code=i;
        }
    }
    cout << "Най-продавания артикул като сума е: " << maxArt_code << " с оборот: " << max_oborot << endl;
}

int main() {
    int choice=0;
    for(int i=0; i<31; i++) {
        dnevniOboroti[i]=-1;
    }

    for(int i=0; i<100; i++){
        oborotiZaArtikul[i]=0;
    }

    while(choice<6) {
        cout << " 1. Въвеждане на артикул с  код на артикул, единична цена, име, категория; "
            << endl;
        cout << " 2. Въвеждане на продажба с код на артикул, брой продадени единици; пореден ден от месеца на продажбата; "
            << endl;
        cout << " 3. Извежда справка за деня от месеца с най-малък оборот; "
            << endl;
        cout << " 4. Извежда справка за деня от месеца с най-голям оборот; "
            << endl;
        cout << " 5. Извежда справка за най-продавания артикул за месеца със стойност на продадените единици; "
            << endl;
        cout << " 6. Изход от програмата "
            << endl;
        cin >> choice;

        switch(choice){
            case 1: inputWeapon();
                break;
            case 2: inputSell();
                break;
            case 3: getMinDailySells();
                break;
            case 4: getMaxDailySells();
                break;
            case 5: getMaxSoldWeapon();
                break;
            case 6: cout << "Изход" << endl;
                break;
            default: cout << "Грешен избор" <<endl;
        }
    }
}