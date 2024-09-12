#include <iostream>
#include <vector>
#include <fstream>
#include <map>

//1. feladat MAR GYAKOROLVA 1-SZER
//Írjon függvényt, amely paramétere egy integer, és megszámolja, hogy az adott számot hány nála kisebb számmal tudjuk osztani úgy, hogy 0 maradék képződjön
//(megszámlálás)
int oszthato(int n){
	int szaml = 0;
	for(int i = 1; i<n ; i++){
		if((n % i) == 0){
			szaml++;
		}
	}
	return szaml;
}

//2.feladat MAR GYAKOROLVA 1-SZER
//Írjon függvényt, amelynek egy 10 méretű integer tömb a paramétere, és visszaadja a maximum indexét.
int maxindex(int tomb[10]){
	int max = tomb[0];
	int ind = 0;
	for(int i = 0; i<10; i++){
		if(tomb[i] > max){
			max = tomb[i];
			ind = i;
		}
	}
	return ind;
}

//2. feladat MAR GYAKOROLVA 1-SZER
//Írjon függvényt, amelynek egy 10 méretű integer tömb a paramétere, és visszaadja a leggyakoribb elemet.
int gyakori(int tomb[10]){
	int maxcount = 0;
	int lgyakoribb;
	for(int i = 0; i<10; i++){
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


using namespace std;

struct labda{
	string szin;
	int meret;
};

int main(){
	cout << oszthato(20) << endl;
	//2.feladat
	int tomb[10] = {0,1,2,3,4,5,6,7,8,9};
	cout << maxindex(tomb) << endl;
	
	//2.feladat
	int tomb2[10] = {1,1,1,2,2,2,3,4,2,2};
	cout << gyakori(tomb2) << endl;
	
	//4. feladat
	//Hozzon létre egy osztályt vagy struktúrát labda néven, amelynek mérete és színe van. Kérjen be a felhasználótól 5 labdát, majd tárolja tetszőleges adatszerkezetben. //1 pont
	//Hozzon létre 2 tömböt (más adatszerk. is megfelel), egyikbe a piros 	labdák, másikba a nem piros labdák kerüljenek. //1pont
	
	vector<labda> labdak;
	labda temp;
	
	for(int i = 0; i<5; i++){
		cout << "Adja meg a labda színét és méretét!" << endl;
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
	
	cout << "Piros labdák: "<<endl;
	for(labda l : pirosak){
		cout << l.szin << " " << l.meret << endl;
	}
	cout<< endl << "Nem piros labdák: " << endl;
	for(labda l : nempirosak){
		cout << l.szin << " " << l.meret << endl;
	}
	
	//6. feladat
	//Lottó doksi beolvasás 1 pont, kiszámolás, kiiírás 1 pont
	//A számok gyakoriságát írjuk ki a gyakorisag.txt-be
	
	ifstream input;
	input.open("doksi");
	
	vector<int> szamok;
	int t;
	
	while( input >> t ){
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
	//for(std::pair<int, int> a : elofordulasok)
	for(auto a : elofordulasok){
		//cout << a.first << " " << a.second << endl;
		out << a.first << " " << a.second << endl;
	}
	out.close();
	
	//feladat: lottó doksi
	// írjuk ki az oszlopmaximumokat.
	
	ifstream input2d;
	input2d.open("doksi");
	int tomb2d[4][5];
	for(int i = 0; i<4; i++){
		for(int j = 0; j <5 ; j++){
			input2d >> tomb2d[i][j];
		}
	}
	int oszlopmax[5] = {0};
	
	for(int i = 0; i<5; i++){
		for(int j = 0; j<4 ; j++){
			if(tomb2d[j][i] > oszlopmax[i]){
				oszlopmax[i] = tomb2d[j][i];
			}
		}
	}
	
	for(int i : oszlopmax){
		cout << i << " " ;
	}
	cout << endl;
	
	
	
	
	input.close();

	

	return 0;
}







