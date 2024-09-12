
#include <iostream>
#include <vector>
#include <fstream>
#include <string>
#include <algorithm>
using namespace std;

struct banan{
    int suly;
    string minoseg;
    bool bio;
};
 
 
 int main(){
 
 
    /*Hozzon létre egy osztályt vagy struktúrát Banan néven, amelynek van súlya,
    minősége(„A vagy B”), egy bool adattagja, amely jelzi, hogy bio-e. (10, „A”,1) Töltsön
    fel egy 5 méretű tömböt banánokkal. Rendezze a tömböt súly szerint.*/
    cout << "5. feladat" << endl;
    vector<banan> bananok;
    banan temp;

    for(int i = 0;i<5;i++){
            cout << "suly minoseg bio" << endl;
            cin >> temp.suly >> temp.minoseg >> temp.bio;
            bananok.push_back(temp);
    }
    
    for(banan b : bananok){
        cout << b.suly << " " << b.minoseg << " " << b.bio << endl;
    }

    // Banánok rendezése súly szerint
    sort(bananok.begin(), bananok.end(), [](const banan& a, const banan& b) {
        return a.suly < b.suly;
    });

    // Rendezett banánok kiírása
    for (const banan& b : bananok) {
        cout << b.suly << " " << b.minoseg << " " << b.bio << endl;
    }
        
return 0;
 }