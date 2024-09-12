#include <iostream>

using namespace std;

int main(){
	struct{
		int szulEv;
		string nev;
	} szemely1, szemely2;
	//int x, y;
	
	szemely1.szulEv = 2000;
	szemely1.nev = "Kiss János";
	
	cout << szemely1.nev << " " << szemely1.szulEv << endl;
	
	szemely2 = szemely1;
	
	szemely2.szulEv = 2010;
	
	cout << szemely1.szulEv << " " << szemely2.szulEv << endl;
	
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
	
	if( swift.evjarat > corsa.evjarat){
		cout << "A "<< swift.tipus << " fiatalabb" << endl;
	} else {
		cout << "A "<< corsa.tipus << " fiatalabb" << endl;
	}
	
	string st = "narancs";
	string& gyumolcs = st;
	
	cout << st << " " << gyumolcs << endl;
	cout << &st << " " << &gyumolcs << endl;
	
	gyumolcs = "kiwi";
	
	cout << st << " " << gyumolcs << endl;

	//-----------------------------------------------
	int a = 10;
	int * b = &a;//pointer értéke memóriacím!
	//int *c = a;
	
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
	//////////////////////////////////////////////////////////////////////////////////
	int tomb[5] = {1,2,3,4,5};
	int *tptr;
	
	tptr = tomb; //tptr = &tomb[0]
	
	cout << tomb << " " << &tomb[0] << " " << tptr << endl;
	
	for(int i = 0; i<5; i++){
		cout << tptr << " " << *tptr << endl;
		tptr++;
	}
	
	tptr = &tomb[4];
	
	for(int i = 5; i>0; i--){
		cout << tptr << " " << *tptr << endl;
		tptr--;
	}
	
	tptr = tomb;
	while(tptr <= &tomb[4]){
		cout << tptr << " " << *tptr << endl;
		tptr++;
	}
	
	*(tomb+4) = 500;
	
	cout << tomb[4] << endl;
	
	for(int i = 0; i<5; i++){
		*(tomb + i) = 1; //tomb[i] = 1; // *(&tomb[0] + i) = 1;
	}
	
	int* ptrtomb[5];//5 elemű tömb, az elemek típusa pointer
	for(int i = 0; i<5; i++){
		ptrtomb[i] = &tomb[i];
		cout << *ptrtomb[i] << " ";
	}
	cout << endl;
	
	const char* names[3] = {"Károly", "Tamás", "István"};
	
	for(int i = 0; i<3; i++){
		cout << (names+i) << " " << *(names+i) << endl;
	}
	
	int z = 10;
	int * zptr = &z;
	int ** zpptr = &zptr;
	
	cout << z << " " << *zptr << " " << **zpptr << endl;
	
	//*p++ vagy *(p++) pointer inkrementálása, majd a megnövelés előtti címen található pointer dereferencelése
	
	//*++p vagy *(++p) pointer inkrementálása, majd dereference
	
	//++*p vagy ++(*p) pointer dereference, majd a mutatott érték növelése
	
	//(*p)++ dereference, majd érték növelése
	
	int cseretomb[5] = {1,2,3,4,5};
	
	int temp = *cseretomb;
	*cseretomb = *(cseretomb+4);
	*(cseretomb+4) = temp;
	
	for(int i = 0; i<5; i++){
		cout << *(cseretomb+i) << " " ;
	}
	cout << endl;
	
	
	int A[5] = {1,2,3,4,5};
	int B[5];
	
	int* Aptr = A;
	int* Avptr = &A[4];
	int* Bptr = B;
	
	while(Aptr <= Avptr){
		*(Bptr++) = *(Aptr++);
		//*Bptr = *Aptr;
		//Bptr++;
		//Aptr++;
	}
	
	for(int i = 0; i<5; i++){
		cout << A[i] << " " <<B[i] << endl;
	}
	

	return 0;
}
