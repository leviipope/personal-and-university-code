#include <iostream>
using namespace std;

// Is palindrome
// https://arato.inf.unideb.hu/szathmary.laszlo/pmwiki/index.php?n=Prog1.20200311c
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

// Mario
//https://arato.inf.unideb.hu/szathmary.laszlo/pmwiki/index.php?n=Prog1.20200220g
void mario(int magassag){
    for( int i = 1; i <= magassag;i++){
        for(int j = 1; j <= magassag - i; j++){
            cout <<  " ";
        }
        for(int j = 1 ; j<=i ; j++){
            cout << "#";
        }
        cout << "  ";
        for(int j = 1; j<=i;j++){
            cout<<"#";
        }
        for(int j=1;j<=magassag-i;j++){
            cout << " ";
        }
        cout << endl;
    }
    cout << endl;
}

// Printascii
void printascii(){
    for(int i=32;i<=127;i++){
        cout<<i<<": "<<char(i)<<endl;
    }
}

// Positive
void pozitiv(int* t, int size){
    for(int i=0; i<size;i++){
        if(t[i]<0){
            t[i]=abs(t[i]);
        }
    }
}


// Factorial 
int factorialrec(int n){
    if (n > 1){
        return n * factorialrec(n-1);
    } else {
        return 1;
    }
}


int main(){

    // In the array t[5]={1,2,3,4,5}, switch 1 and 5 using pointers
    int tomb[5] = {1,2,3,4,5};

    int temp = *tomb; // temp = tomb[1]
    *tomb = *(tomb+4); // tomb[1] = tomb[4]
    *(tomb+4) = temp; // tomb[4] = temp

    for(int i : tomb){
        cout << i << " ";
    } cout << endl;

    for(int i = 0; i<5; i++){
		cout << *(tomb+i) << " " ;
	} cout << endl;


    /* Copy A pointers elemets to B
    Aptr = A
    Avptr = &A[4]
    Bptr = B
    A = 1 2 3 4 5
    B = _ _ _ _ _
    Cant use: array[i], array+i
    */

    int A[5] = {1,2,3,4,5};
    int B[5];

    int* Aptr = A; // Aptr = &A[1]
    int* Avptr = &A[4];
    int* Bptr = B; // Bptr = &B[1]
    //START

    while(Aptr <= Avptr){
        *(Bptr++) = *(Aptr++);
    }

    for(int i = 0; i<5;i++){
        cout << A[i] << " " << B[i] << endl;
    }


    // Rows average
    int szam2d[3][4] = {
		{1,2,3,4},
		{5,6,7,8},
		{9,10,11,12}
	};
	// START
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