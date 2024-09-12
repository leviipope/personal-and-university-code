#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>
#include <string>

using namespace std;
https://arato.inf.unideb.hu/szathmary.laszlo/pmwiki/index.php?n=Prog1.20200311f


//2. feladat
//Írjon függvényt, amelynek egy 10 méretű integer tömb a paramétere, és visszaadja a leggyakoribb elemet.
int legg(int tomb[10]){
	int maxcount = 0;
	int leggyakoribb;
	for(int i = 0; i<10;i++){
		int count = 0;
		for(int j = 0; j<10; j++){
			if(tomb[i]==tomb[j]){
				count++;
			}
		}
		if(count>maxcount){
			maxcount = count;
			leggyakoribb = tomb[i];
		}
	}
	return leggyakoribb;
}

int maxindex(int tomb[10]){
	int ind;
	int max = tomb[0];
	for(int i = 0; i<10;i++){
		if(max < tomb[i]){
			max = tomb[i];
			ind = i;
		}
	}
	return ind;
}

int main(){

	int tomb[10] = {1,0,3,3,3,3,3,9,8,8};
	cout << legg(tomb) << endl;
	cout << maxindex(tomb);


	return 0;
}