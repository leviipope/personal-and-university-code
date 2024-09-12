#include <iostream>

using namespace std;

bool palindrome(string s){
	if(s.length() == 0){
		return true;
	}
	
	for(int i = 0; i< (s.length() / 2)+1 ; ++i){
		if(s.at(i) != s.at(s.length() - i -1)){
			return false;
		}
	}
	return true;
}

void printascii(){
	for(int i = 32; i<= 127; i++){
		cout << i << ": " << (char)i << endl;
	}
}

void printpiramis(int magassag){
	for(int i = 1; i<= magassag; i++){
		for(int j = 1; j<= magassag -i; j++){
			cout << " " ;
		}
		for(int j = 1; j<= i ; j++){
			cout << "#";
		}
		cout << "  ";
		for(int j = 1; j<= i ; j++){
			cout << "#";
		}
		for(int j = 1; j<= magassag -i; j++){
			cout << " " ;
		}
		cout << endl;
	}
}

void pozitiv(int* t, int size){
	for(int i = 0; i < size; i++){
		if(t[i] < 0){
			t[i] = abs(t[i]);
		}	
	}
}

int* sekelymasolat(int* t, int size){
	int* t2 = t; //t2 = &t[0]
	return t2;
}

int* melymasolat(int* t, int size){
	int* t2 = new int[size];
	for(int i = 0; i< size; i++){
		t2[i] = *(t + i);
	}
	return t2;
}

int main(){

	cout << palindrome("abba") << endl;
	cout << palindrome("aladar") << endl;
	cout << palindrome("") << endl;
	
//	printascii();
	//printpiramis(25);
	
	int tomb[5] = {1, -2, 3, -4, -5};
	pozitiv(tomb,5);
	
	for(int i = 0; i< 5; i++){
		cout << tomb[i] << " " ;
	}
	cout << endl;
	
	//sekély
	
	int* tomb2 = sekelymasolat(tomb, 5);
	
	tomb[0] = 100;
	
	cout << tomb[0] << " " <<tomb2[0] << endl;
	
	//mélymásolás
	
	int* tomb3 = melymasolat(tomb, 5);
	
	tomb[0] = 1;
	
	cout << tomb[0] << " " << tomb3[0] << endl;
	
	

	return 0;
}
