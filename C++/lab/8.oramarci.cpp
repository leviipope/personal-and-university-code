#include <iostream>
#include <vector>
#include <fstream>

struct Allat{
	std::string nev;
	int kor;
};

std::istream& operator>>(std::istream& i, Allat& a){
	i >> a.nev >> a.kor;
	return i;
}

void operator<<(std::ofstream& o, Allat& a){
	o << a.nev << "\t" << a.kor << std::endl;
}


int main(){
	int x, y;

	std::cout << "Adjon meg egy számot: ";
	std::cin >> x;
	std::cout << "Adjon meg egy másik számot: ";
	std::cin >> y;
	std::cout << x << "+" << y << "= " << x+y << std::endl;

	Allat a;
	std::cout << "Adj meg egy állatot: ";
	std::cin >> a;
	//std::cin >> a.nev >> a.kor;
	std::cout << a.kor << " " << a.nev << std::endl;
	
	//vektor ami állat rekordokat tartalmaz 2. kérj be egy számot 3. kérj be n darab állatot és tegyük a vektorba
	std::vector<Allat> vector;
	int n = 0;
	std::cout << "Adj meg egy számot";
	std::cin >> n;
	for(int i = 0; i<n; i++){
		//Allat a; nem kell mert folyamat lefoglalja a memóriát.
		std::cout << "Adj meg egy állatot: ";
		std::cin >> a;
		vector.push_back(a);
	}

	/*
		Állománykezelés
		ofstream - outpus file stream - kienet- írni is tud
		ifstream - input file stream - bemenet csak olvas
		fstream - file stream - írás olvasás létrehoz
	*/

	std::ofstream ofile;  //Létrehozás, virt állomány létrehozása
	ofile.open("kienet.txt");  //Összerendelés(fizikai és logikai állomány összefűzése), megnyitás
	ofile << "Megnyitottuk a filet írásra";  //feldolgozás
	ofile.close(); // Bezárás

	std::ifstream ifile("kimenet.txt");
	std::string sor;
	
	while(getline(ifile, sor)){
		std::cout << sor << std::endl;
	}
	ifile.close();

	//felh neve bekérni 2. írjuk ki egy fileba 3. olvassuk ki onnan 4. írjuk ki a beolvasottat.
	std::string felhNev;
	std::cout << "Add meg a neved: "; 
	std::cin >> felhNev;
	
	std::ofstream ofile2;
	ofile2.open("nev.txt");
	ofile2 << felhNev;
	ofile2.close();
	std::ifstream infile("nev.txt");

	std::string beolvasott;
	infile >> beolvasott;

	infile.close();
	std::cout << beolvasott << std::endl;

	/*
		Állomány megnyitási módok
		ios::app append
		ios::ate Megnyitja írásra, az írás/olavasás vezérlés a végére kerül
		ios::in  Bemenet csak olvasás
		ios::out Kimenet csak írs
		ios::trunk Ha az állomány létezik, akkor törli ami eddig benne volt
	*/
	std::ofstream outfile;
	outfile.open("nev.txt", std::ios::out | std::ios::trunc);
	outfile.close();
	
	std::fstream ffile;
	ffile.open("nev.txt", std::ios::out | std::ios::in);
	ffile.close();

	std::ofstream allatfile("allatok.txt");
	for(int i = 0; i<vector.size();i++){
		//allatfile << vector[i]; //Melyikbe hány darab van HASZNÁLD A MAPET, NÉZZ UTÁNNA
	}
	allatfile.close();
	
	//feladat olvasd be az állományt 
	std::vector<Allat> allatV;

	std::ifstream inallat("allatok.txt");
	Allat allatolvas;
	while(inallat >> allatolvas){//operátortúlterhelésnek nincsen visszatárisi értéke ezért nem működik
		allatV.push_back(allatolvas);
	}

	int max = 0;
	int maxInd = 0;

	for(int i = 0; i<allatV.size();i++){
		if(allatV[i].kor > max){
			max = allatV[i].kor;
			maxInd = i;
		}
	}

	std::cout << "A legidősebb állat" << allatV[maxInd].nev << " " << allatV[maxInd].kor << std::endl;




























	
	return 0;
}
