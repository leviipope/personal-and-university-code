#include <iostream>

using namespace std;

int main(){

    // Pointer is a type of a variable that stores a link to another object
    // The link is a memory address
    
    int a = 10;
    int* b = &a; // Pointers value is a memory address
    cout << a << " " << &a << " " << b << " " << &b;

    cout << *b << endl; // *b -> what value does 'b' point to? = 10
	
    // Let 'b' point to 15 on 'a' memory address -> 'a' changes too
	*b = 15;
	cout << a << *b << endl;
	
	// Pointers and arrays
    int tomb[5] = {1,2,3,4,5};
    int* tptr;
    tptr = tomb; //tptr = &tomb[0]

	// Memory address of each element in array using for loop
    tptr = tomb; // Pointer points to the first element of the array
    for(int i = 0; i<5; i++){
        
		cout << tptr << " " << *tptr << endl;
		tptr++; // Increasing pointer means it skips to the next memory address in the memory
	}

    // Using while loop
	tptr = tomb;
	while(tptr <= &tomb[4]){
		cout << tptr << " " << *tptr << endl;
		tptr++;
	}

    // Backwords using for
    tptr = &tomb[4]; //Pointer points to the last element of the array
	for(int i = 5; i>0; i--){
		cout << tptr << " " << *tptr << endl;
		tptr--; // Decreasing pointer -> previous memory address
	}

    // Overwriting elements using pointer
    *(tomb+4) = 500; // tomb[4] = 500;

	for(int i = 0; i<5; i++){
        *(tomb + i) = 1; // tomb[i] = 1; //*(tomb[0] + i) = 1;
    }

    // Pointer array
    int* ptrtomb[5]; // array with 5 pointer type elements
	for(int i = 0; i<5; i++){
		ptrtomb[i] = &tomb[i]; // every pointer gets assigned to the elements in the original array
		cout << *ptrtomb[i] << " "; // print where the elements of the pointer arrays are pointing -> to the elements of the original array
	} cout << endl;

    // Char pointers
    const char* names[3] = {"Károly", "Tamás", "István"}; // array with 3 pointer type elements (that point to char)
	for(int i = 0; i<3; i++){
		cout << (names+i) << " " << *(names+i) << endl; // names[1] << " " << *names[i]
	}

    // Pointer pointing to pointer
    int z = 10;
	int * zptr = &z;
	int ** zpptr = &zptr; 
	cout << z << " " << *zptr << " " << **zpptr << endl;

    // Pointer incrementation possibilities
    // *(p++) or *p++ -> increments pointer, dereferences previous memory address's pointer
    // *(++p) or *++p -> increments pointer, dereferences
    // ++(*p) or ++*p -> dereference, incrementation of shown value
    // (*p)++ -> dereference, value incrementation

    // Exercises
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

    /*
    Aptr = A
    Avptr = &A[4]
    Bptr = B
    A = 1 2 3 4 5
    B = _ _ _ _ _
    Cant use: array[i], array+i
    Copy A pointers elemets to B
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


	return 0;
}
