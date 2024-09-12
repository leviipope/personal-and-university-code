#include <iostream>

int main(){


	// == <= >= < > != !
	std::cout << (10 == 1) << std::endl;
	
	//logikai oprátorok
	// && || !
	// és vagy tagadás
	std::cout << !false << std::endl;
	std::cout << (true || false) << std::endl;
	
	//bitműveletek
	// & | ^ << >>
	//bitenkénti és, vagy, XOR, balra eltolás, jobbra eltolás
	int A = 60;
	int B = 13;
	
	std::cout << (A & B) << std::endl;
	std::cout << (A << 2) << std::endl;
	
	//értékadó operátorok
	// = += -= *= /= %= <<= >>= &= |= ^=
	
	A += 10;
	std::cout << A << std::endl;
	
	int tomb[5] = {1, 2, 3, 4, 5};
	
	std::cout << tomb[0] << std::endl;
	std::cout << tomb[5] << std::endl;
	
	tomb[0] = 2;
	
	char sztring[] = "Hello, world!";
	sztring[0] = 'h';
	
	std::cout << sztring << std::endl;
	
	std::string cppstring = "Hello, world!";
	cppstring[0] = 'h';
	
	std::cout << cppstring << std::endl;
	
	using namespace std;
	
	cout << "std névtérben vagyunk" << endl;
	
	
	//implicit típuskonverzió
	int num = 92;
	double d;
	
	d = num;
	cout << d << endl;
	
	//--------------------------
	double double_num = 1.11;
	int int_num;
	
	int_num = double_num;
	cout << int_num << endl;
	
	
	//explicit
	int z = 21;
	double dupla;
	
	dupla = double(z);
	
	if( 21 > 10 ){
		cout << "A feltétel igaz" << endl;
	}
	
	if( A ){
		cout << "A feltétel igaz" << endl;
	}
	
	if( A == 0 ){
		cout << "A feltétel igaz" << endl;
	}
	
	if( 21 > 10 ){
		cout << "A feltétel igaz" << endl;
	} else {
		cout << "A feltétel hamis" << endl;
	}
	
	if (21 > 10) {
		cout << "igaz ág" << endl;
	} else if (1<2) {
		cout << "else if ág" << endl;
	} else if (3>2) {
		cout << "else if2 ág" << endl;
	} else {
		cout << "else ág" <<endl;
	}
	
	if( 10 >9 ){
		if(1 < 2){
			cout << "belső if" << endl;
		}
	}
	
	int cif = 10>9 ? 1 : 0;
	cout << cif << endl;
	
	int x1 = 1;
	int y1 = 10;
	string eredmeny;
	
	eredmeny = (x1 == y1) ? "egyenlő" : "nem egyenlő";
	cout << eredmeny << endl;
	
	if (x1 == y1){
		eredmeny = "egyenlő";
	} else if( x1 < y1){
		eredmeny = "kisebb";
	} else {
		eredmeny = "nagyobb";
	}
	
	cout << eredmeny << endl;
	
	eredmeny = ( x1 == y1) ? "egyenlő" : (x1 < y1) ? "kisebb" : "nagyobb";
	cout << eredmeny << endl;
	
	int nap = 7;
	
	switch(nap){
		case 6:
			cout << "szombat" << endl;
			break;
		case 7:
			cout << "vasárnap" << endl;
			break;
		default:
			cout << "mindjárt hétvége" << endl;
			break;
	}
	
	int i= 0;
	while( i < 10){ //előltesztelő ciklus, 0 vagy több alkalommal fut
		cout << i << " ";
		i++;
	}
	cout << endl;
	
	do{ //hátultesztelő ciklus, 1 vagy több alkalommal fut
		cout << i << " ";
		i++;
	} while ( i < 10);
	cout << endl;
	
	//for
	//meghatározott lépésszámú ciklus
	//előírt lépésszámú ciklus
	//for(ciklusváltozó inicializálás; leállási feltétel; ciklusváltozó értékváltozása)
	
	for(int i = 0; i < 10; i++){
		cout << i << " ";
	}
	cout << endl;
	
	/*while(true){
		cout << "végtelen ciklus" << endl;
	}*/
	
	/*for(int i=0; ; i++){
		cout << i << endl;
	}*/
	
	/*for(;;){
		cout << "végtelen ciklus " << endl;
	}*/
	
	cout << "i j"<< endl;
	for(int i=0; i<3; i++){
		for(int j = 0; j<5 ; j++){
			cout << i << " " << j << endl; 
		}
	}
	
	int szamok[5] = {20,30,40,50,60};
	
	cout << szamok << endl;
	
	for(int i = 0; i<5; i++){
		cout << szamok[i] << " " ;
		//szamok[i] = szamok[i-1]*2;
	}
	cout << endl;
	
	for(int szam : szamok){//nincs indexelés
		cout << szam << " ";
	}
	cout << endl;
	
	cout << sizeof(szamok) << endl; //int 4byte, 5 elem => 5 x 4byte = 20 byte
	
	for(int i=0; i< sizeof(szamok)/sizeof(int) ; i++){
		cout << szamok[i] << " " ;
	}
	cout << endl;
	
	i = 0;
	while ( i < 10){
		cout << i << " " ;
		i++;
		if( i == 4){
			break;
		}
	}
	cout << endl;
	
	i = 0;
	while( i < 10 ){
		if( i == 4){
			i++;
			continue;
		}
		cout << i << " ";
		i++;
	}
	cout << endl;
	
	char betuk[2][4] = {
		{'a','b','c','d'},
		{'e','f','g','h'}
	};
	
	cout << betuk[0] << " " << betuk[1] << " " << betuk[0][2] << endl;
	
	for(int i = 0; i<2; i++){
		for(int j = 0; j<4; j++){
			cout << betuk[i][j] << " " ;
		}
		cout << endl;
	}
	
	
	int szam2d[3][4] = {
		{1,2,3,4},
		{5,6,7,8},
		{9,10,11,12}
	};
	
	{
		float osszeg;
	
		for(int i = 0; i<3; i++){
			osszeg = 0;
			for(int j = 0; j<4 ; j++){
				osszeg += szam2d[i][j];
			}
			cout << osszeg/4 << endl;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	return 0;	
}
