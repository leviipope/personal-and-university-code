#include <iostream>
using namespace std;

int main(){
    struct{
        int szulEv;
        string nev;
    } szemely1, szemely2;
    //int x, y;


    szemely1.szulEv = 2000;
    szemely1.nev = "Kiss Janos";

    cout << szemely1.nev << " " << szemely1.szulEv << endl;

    szemely2 = szemely1; //1 személlyé válik vagy csak adatot másol?

    szemely2.szulEv = 2010;

    cout << szemely1.szulEv << " " << szemely2.szulEv << endl; //két külön személy lesz, de az adatok átmásolódnak

    struct jarmu{
        string marka;
        string tipus;
        short int evjarat;
    };

    jarmu swift;
    swift.marka = "Suzuki";
    swift.tipus = "Swift";
    swift.evjarat = 2002;

    jarmu corsa;
    corsa.marka = "Opel";
    corsa.tipus = "Corsa";
    corsa.evjarat = 2004;

    if(swift.evjarat > corsa.evjarat){
        cout << "A " << swift.tipus << " fiatalabb" << endl;
    } else {
        cout << "A " << corsa.tipus << " fiatalabb" << endl;
    }
    

    //tipus& -> referencia
    string st = "narancs";
    string& gyumolcs = st;

    cout << st << " " << gyumolcs << endl;
    cout << &st << " " << &gyumolcs << endl; //&nev -> nevnek a memoriacime
    //ugyanazt a memoriat hasznaljak, 2 valtozo egy memorian

    gyumolcs = "kiwi";
    cout << st << " " << gyumolcs << endl;
    //megváltozott a st is


    int a = 10;
    int *b = &a; //pointer értéke memóriacím (tipus* -> pointer) (barhova lehet tenni)
    //int *c = a; nem tudja atkonvertalni az intet egy memoriacimme

    cout << a << " " << &a << " " << b << " " << &b << endl;

    cout << *b << endl;

    *b = 15;

    cout << a << " " << *b << endl;

    cout << sizeof(b) << endl;

    int *ptr = NULL;

    if(ptr){
        cout << "Nem null" << endl;
    } else {
        cout << "Null" << endl;
    }


    return 0;
}