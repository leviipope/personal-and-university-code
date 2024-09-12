#include <iostream> 
#include <vector>
#include <map>
#include <fstream>
using namespace std;

//4.f
struct labda{
    string szin;
    int meret;

};

int oszthato(int n){
    int szaml = 0;
    for(int i =1; i<n;i++){
        if((n%i)==0){
            szaml++;
        }
    }
    return szaml;
}

//2. feladat
//irjon fuggvenyt amelynek egy 10 meretu integer tomb a parametere es visszadja a maximum indexet
int maxindex(int tomb[10]){
    int max = tomb[0];
    int ind = 0;
    for(int i = 0; i<10;i++){
        if(tomb[i]>max){
            max = tomb[i];
            ind = i;
        }
    }
    return ind;
}

//irjon fugv-t amelynek egy 10meretu integer tomb a parametere es visszaadja a leggyakroibb elemet
int gyakori(int tomb[10]){
    int maxcount = 0;
    int lgyakoribb;
    for(int i = 0; i<10;i++){
        int count = 0;
        for(int j = 0; j < 10; j++){
            if(tomb[i] == tomb[j]){
                count++;
            }
        }
        if(count > maxcount){
            maxcount = count;
            lgyakoribb = tomb[i];
        }
    }
    return lgyakoribb;
}
    



int main(){

    cout<<oszthato(10)<<endl;    

    //2.f
    int tomb[10] = {0,1,2,3,4,5,6,7,8,9};
    cout << maxindex(tomb) << endl;

    //leggy



    vector<labda> labdak;
    labda temp;

    for(int i = 0; i < 5; i++){
        cout << "adja meg a labda szinet es meretet" << endl;
        cin >> temp.szin >> temp.meret;
        labdak.push_back(temp);
    }

    vector<labda> pirosak;
    vector<labda> nempirosak;

    for(labda l : labdak){
        if(l.szin == "piros"){
            pirosak.push_back(l);
        } else {
            nempirosak.push_back(l);
        }
    }

    cout << "Piros labdak: " << endl;
    for(labda l : pirosak){
        cout << l.szin << " " << l.meret << endl;
    }
    cout << endl << "nem piros labdak: " << endl;
    for(labda l : nempirosak){
        cout << l.szin << " " << l.meret << endl;
    } 

    //6. f
    //lotto doksi beolvasas, kiszamolas, kiiras,
    //a szamok gyakorisagat irjuk ki a gyakoirsag txtbe

    ifstream input;
    input.open("doksi");

    vector<int> szamok;
    int t;

    while(input>>t){
        szamok.push_back(t);
    }
    map<int, int> elofordulasok;

    for(int i : szamok){
        elofordulasok[i] = 0;
    }

    for(int i : szamok){
        elofordulasok[i]++;
    }

    ofstream out;
    out.open("gyakorisagok.txt");


    //for(std::pair<int,int> a : elofordulasok)
    for(auto a : elofordulasok){
        //cout << a.first << " " << a.second << endl;
        out << a.first << " " << a.second << endl;
    }

    out.close();

    //feladat
    //irjuk ki az oszlopmaximumokat

    input.close();
    

    return 0;
}