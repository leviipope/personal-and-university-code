#include <iostream>
#include <vector>
#include <fstream>
#include <string>
#include <algorithm>
using namespace std;

int main(){

    /*4. Kérjen be a felhasználótól 5 db szóköz nélküli stringet. Írja ki a
    képernyőre azokat, amelyek hossza az kisebb, mint az összes szóban található „a”
    betűk számossága.*/
    
    cout << "4. feladat" << endl;

    vector<string> mondatok;
    string temp;
    int mondatokchar = 0;
    int sorchar[5] = {0};
    for(int i = 0 ; i<5; i++){
        cout << "adjon meg 5 szokoz nelkuli stringet: " << endl;
        cin >> temp;
        mondatok.push_back(temp);
        sorchar[i] = temp.length();
        mondatokchar += temp.length();
    }
   
    int a_betuk_szama = 0;
    for (const string& sor : mondatok) {
        for (char betu : sor) {
            if (betu == 'a') {
                ++a_betuk_szama;
            }
        }
    }
    for (const string& sor : mondatok) {
        if(sor.length()<a_betuk_szama){
            cout << sor << endl;
        }
    }

    return 0;
}