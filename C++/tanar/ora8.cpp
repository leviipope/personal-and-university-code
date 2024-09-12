#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

struct Allat{
	string nev;
	int kor;
};

istream& operator>>(istream& i, Allat& a){
	i  >> a.nev >> a.kor;
	return i;
}

void operator<<(ofstream& o, Allat& a){
	o << a.nev << "\t" << a.kor << endl;
}

int main(){

	int x, y;
	int sum;
	cout << "Adj meg egy egész számot!" << endl;
	cin >> x;
	cout << "Adj meg egy másik számot is!" << endl;
	cin >> y;
	
	sum = x + y;
	cout << "A két szám összege: " << sum << endl;
	
	Allat a;
	cin >> a;
	//cin >> a.nev >> a.kor;
	cout << a.nev << " " << a.kor << endl;
	
	int meret = 0;
	cout << "Add meg, hány állatot szeretnél felvenni" << endl;
	cin >> meret;
	
	vector<Allat> allatok;
	
	for(int i = 0; i<meret; i++){
		Allat a;
		cin >> a;
		allatok.push_back(a);
	}
	
	std::cout << "A vektor elemei: "<< endl;
	
	for(int i = 0; i< allatok.size(); i++){
		cout << allatok[i].nev << " " << allatok[i].kor << endl;
	}
	
	/*
		Fájlkezelés
		ofstream - létrehoz és ír
		ifstream - olvas
		fstream - létrehoz, ír, olvas
	*/
	
	ofstream myfile("file1.txt"); //logikai állomány létrehozása, összerendelés (logikai és fizikai), megnyitás
	
	myfile << "A fájlt megnyitottam írásra" << endl; //feldolgozás
	
	myfile.close(); //lezárás
	
	
	string text;
	
	ifstream readfile("file1.txt");
	
	while(getline(readfile, text ) ){
		cout << text << endl;
	}
	
	readfile.close();
	
	
	string nev;
	
	ofstream outfile;
	outfile.open("nev.dat");
	
	cout << "Add meg a neved!" << endl;
	cin >> nev;
	
	outfile << nev << endl;
	outfile.close();
	
	ifstream infile;
	infile.open("nev.dat");
	
	string beolvasott;
	infile >> beolvasott;
	cout << beolvasott << endl;
	
	infile.close();
	
	/*
		Állomány megnyitási módok:
			
		ios::app Append - Hozzáfűzés, minden output a fájl végére kerül
		ios::ate Kimenetre nyitjuk az állományt, a read/write vezérlés a fájl végére kerül	
		
		ios::in Megnyitás olvasásra
		ios::out Megnyitás írásra
		ios::trunch Ha a fájl létezik, a tartalmát kitörli megnyitás előtt
	
	*/
	
	outfile.open("nev.dat", ios::out | ios::trunc);
	outfile.close();
	
	fstream ffile;
	ffile.open("nev.dat", ios::out | ios::in);
	ffile.close();
	
	
	
	ofstream allatfile("allatok.txt");
	
	for(int i = 0; i< allatok.size(); i++){
		allatfile << allatok[i];
		//allatfile << allatok[i].nev << "\t" << allatok[i].kor << endl;
	}
	
	allatfile.close();
	
	/*
		Olvasd be az allatok.txt adatait tetszőleges adatszerkezetbe, majd írd ki a képernyőre a legidősebb állat adatait.
	
	*/
	
	vector<Allat> allatv;
	ifstream inallat("allatok.txt");
	
	Allat allatolvas;
	//while( inallat >> allatolvas.nev >> allatolvas.kor ){
	while( inallat >> allatolvas ){ //csak akkor alkalmazható, ha az operátor összefűzhető, vagy van visszatérési értéke!
		allatv.push_back(allatolvas);
	} 
	
	int max = 0;
	int maxind = 0;
	
	for(int i = 0; i< allatv.size(); i++){
		if(max < allatv[i].kor){
			max = allatv[i].kor;
			maxind = i;
		}
	}
	
	cout << "A legidősebb állat " << allatv[maxind].nev << " " << allatv[maxind].kor << " éves" << endl;
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	return 0;
}
