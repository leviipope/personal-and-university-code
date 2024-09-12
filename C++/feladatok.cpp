#include <iostream>
#include <vector> // 1.2f
#include <algorithm> // 2.5f
#include <map> // 6f
#include <fstream> // 6f
using namespace std;

// 1.1 feladat
int oszthato(int n){
    int count = 0;
    for(int i = n-1; i>0; i--){
        if(n%i==0){
            count+=1;
        }
    }
    return count;
}

// 1.2 feladat
void oszthato100ig(int a, int b){
    vector<int> szamok;
    for(int i = 1; i<=100;i++){
        if(i%a==0 && i%b==0){
            szamok.push_back(i);
        }
    }
    for(int i : szamok){
        cout << i << " ";
    } cout << endl;
}

// 2.1 feladat
int max(int tomb[10]){
    int max = 0;
    for(int i = 0;i<10;i++){
        if(max<tomb[i]){
            max = tomb[i];
        }
    }
    return max;
}

// 2.2 feladat
int maxind(int tomb[10]){
    int max = 0;
    int maxind;
    for(int i = 0;i<10;i++){
        if(max<tomb[i]){
            max = tomb[i];
            maxind = i;
        }
    }
    return maxind;
}

// 2.3 feladat
int min(int tomb[10]){
    int max = 0;
    for(int i = 0;i<10;i++){
        if(max<tomb[i]){
            max = tomb[i];
        }
    }
    int min = max;
    for(int i = 0;i<10;i++){
        if(min>tomb[i]){
            min = tomb[i];
        }
    }
    return min;
}

// 2.4 feladat
int leggy(int tomb[10]){
    int maxelofordulas = 0;
    int szam;
    for(int i = 0; i<10;i++){
            int elofordulas = 0;
            for(int j = 0; j<10; j++){
                if(tomb[i]==tomb[j]){
                    elofordulas += 1;
                }
            }
            if(elofordulas>maxelofordulas){
                maxelofordulas = elofordulas;
                szam = tomb[i];
            }
    }
    return szam;
}

// 2.5 feladat
void rendez(int tomb[10], int p){
    if(p<0 || p>=10){
        cout << "Invalid parameter";
        return;
    }
    sort(tomb + p, tomb + 10);
    cout << "rendezett tomb: ";
    for(int i = 0;i<10;i++){
        cout<<tomb[i]<< " ";
    } cout << endl;

}

// 2.6 feladat
void csokk(int tomb[10]){
    sort(tomb, tomb+10, greater<int>());
    for(int i = 0;i<10;i++){
        cout<<tomb[i]<< " ";
    } cout << endl;

}

// 3 feladat
void dec(int& i){
    i--;
}

// 4.2 feladat
struct labda{
    int meret;
    string szin;
};

// 5 feladat
struct monitor{
    int szelesseg;
    int magassag;
    string marka;
};


int main(){

    // 1. feladattipus
    /*

    //1.1 Irjon fuggvenyt, amely parametere egy integer es megszamolja, hogy az adott szamot hany nala kisebb szammal tudjuk osztani, ugy hogy a maradek 0 legyen!
    cout << oszthato(24) << endl;
    cout << oszthato(25) << endl;
    cout << oszthato(124) << endl;

    //1.2 Irjon fuggvenyt, amelynek 2 integer parametere van, es kiirja 100-ig azokat a szamokat, amelyek oszthatoak a megadott 2 szammal.
    oszthato100ig(6,9);
    */

    // 2. feladattípus

    //2.1 Írjon függvényt, amelynek egy 10 méretű integer tömb a paramétere, és visszaadja a maximumot.
    /*
    int tomb1[10] = {0,-900,-5,3,180,5,530,7,8,9};
    int tomb2[10] = {100,-700,-5,3,1800,5,553,7,8,9};
    cout << max(tomb1) << endl;
    cout << max(tomb2) << endl;

    //2.2 Írjon függvényt, amelynek egy 10 méretű integer tömb a paramétere, és visszaadja a maximum indexét.
    cout << maxind(tomb1) << endl;
    cout << maxind(tomb2) << endl;

    //2.3 Írjon függvényt, amelynek egy 10 méretű integer tömb a paramétere, és visszaadja a minimumot.
    cout << min(tomb1) << endl;
    cout << min(tomb2) << endl;

    //2.4 Írjon függvényt, amelynek egy 10 méretű integer tömb a paramétere, és visszaadja a leggyakoribb elemet.
    int tomb3[10] = {1,-3,2,2,6,-3,-3,8,-3};
    cout << leggy(tomb3) << endl;

    //2.5 Írjon függvényt, amelynek egy 10 méretű integer tömb és egy egész szám a paramétere, majd rendezi a második paramétertől a tömböt. Pl 5, akkor a tömb 5.elemétől rendezi.
    rendez(tomb3,2);

    //2.6 Írjon függvényt, amelynek egy 10 méretű integer tömb a paramétere, és csökkenő sorrendben rendezi azt.
    csokk(tomb2);
    */

    // 3. feladattípus 

    // Írjon függvényt, amelyben referencia szerinti paraméterátadást használ, és csökkenti a paraméter értékét. void dec(int& i){ i - -  ;}
    /*
    dec(i);
    cout << i<<endl;
    */
   

    // 4. feladattípus - felhasználói input 
    // 4.1 Kérjünk be 5 számot a felhasználótól és írjuk ki az átlag felettieket.d
    //Hozzon létre egy osztályt vagy struktúrát labda néven, amelynek mérete és színe van. Kérjen be a felhasználótól 5 labdát, majd tárolja tetszőleges adatszerkezetben.    
    //Hozzon létre 2 tömböt (más adatszerk. is megfelel), egyikbe a piros labdák, másikba a nem piros labdák kerüljenek.

    // 4.1
    
    int beszam;
    vector<int> szamok;
    for(int i = 0; i<5;i++){
        cout << "irjon be egy szamot: ";
        cin >> beszam;
        szamok.push_back(beszam);
    } 
    int sum = 0;
    for(int i = 0; i<5;i++){
        sum += szamok[i];
    }
    float atlag = (sum/5);
    cout << atlag << endl;
    
    for(int i = 0;i<5;i++){
        if(szamok[i]>atlag){
            cout<<szamok[i] << " ";
        }
    } cout << endl;
    

    //4.2
    /*
    vector<labda> labdak;
    labda temp;
    for(int i = 0; i<5; i++){
        cout << "adja meg a labdak szinet es meretet!" << endl;
        cin >> temp.szin >> temp.meret;
        labdak.push_back(temp);
    }

    cout << "A labdak a következok:" << endl;
    for(labda l : labdak) {
    cout << "Szin: " << l.szin << ", Meret: " << l.meret << endl;
    }
    
    //4.3
    /*
    vector<labda> pirosak;
    vector<labda> nempirosak;
    for(labda l : labdak){
        if(l.szin == "piros"){
            pirosak.push_back(l);
        } else {
            nempirosak.push_back(l);
        }
    }
    
    cout << "Piros labdák: " <<endl;
    for(labda l : pirosak){
        cout << l.szin << " " << l.meret << endl;
    }
    cout << endl << "Nem piros labdák: " << endl;
    for(labda l : nempirosak){
        cout << l.szin << " " << l.meret << endl;
    }
    */

    // 5.2   
    //Írja ki a képernyőre, hogy hány piros és hány kék labdánk van.
    /*
    int kekszam = 0;
    int pirosszam = 0;
    for(labda l : labdak){
        if(l.szin=="kek"){
            kekszam += 1;
        }
        if(l.szin=="piros"){
            pirosszam += 1;
        }
    }
    cout << "piros: " << pirosszam <<endl;
    cout<< "kek: " << kekszam << endl;

    // 5. feladattípus
    // 5.1
    //Hozzon létre egy osztályt vagy struktúrát monitor néven, amelynek szélessége, magassága és márkája van. Töltsön fel egy 5 méretű tömböt monitorokkal.
    //Hozzon létre egy tömböt, amibe kiválogatja a Samsung márkájú monitorokat.

    /*
    vector<monitor> monitorok;
    monitor be;
    for(int i = 0; i<5; i++){
        cout << "adja meg a monitor szelesseget, magassagat es meretet" << endl;
        cin >> be.szelesseg >> be.magassag >> be.marka;
        monitorok.push_back(be);
    } cout << endl;

    for(monitor m : monitorok){
        cout << m.szelesseg << " " << m.magassag << " " << m.marka << endl; 
    } cout << endl;

    vector<monitor> samsungok;
    for(monitor m : monitorok){
        if(m.marka == "samsung"){
            samsungok.push_back(m);
        }
    }

    for(monitor m : samsungok){ 
        cout << m.szelesseg << " " << m.magassag << " " << m.marka << endl; 
    }
    */

    // 6. feladattípus
    //Lottó doksi beolvasás 1 pont, kiszámolás, kiiírás 1 pont
    //A számok gyakoriságát írjuk ki a gyakorisag.txt-be
    /*
    ifstream input;
    input.open("doksi");

    vector<int> szamok;
    int t;
    while(input >> t){
        szamok.push_back(t);
    }

    map<int,int> elofordulasok;

    for(int i :szamok){
        elofordulasok[i] = 0;
    }
    for(int i :szamok){
        elofordulasok[i]++;
    }

    /*for(auto a : elofordulasok){
        cout << a.first << " " << a.second << endl;
    }
    */
    /*
    ofstream out;
    out.open("gyakorisagok.txt");
    for(auto a : elofordulasok){
        out << a.first << " " << a.second << endl;
    }
    out.close();

   	//feladat: lottó doksi
	// írjuk ki az oszlopmaximumokat.

    ifstream input2d;
    input2d.open("doksi");
    int tomb2d[4][5];
    for(int i = 0;i<4;i++){
        for(int j = 0; j<5;j++){
            input2d >> tomb2d[i][j];
        }
    }
    int oszlopmax[5] = {0};

    for(int i = 0;i<5;i++){
        for(int j = 0;j<4;j++){
            if(tomb2d[j][i]> oszlopmax[i]){
                oszlopmax[i] = tomb2d[j][i];
            }
        }
    }

    for(int i : oszlopmax){
        cout << i << " ";
    } cout << endl;

    input.close();
    */

    return 0;
}