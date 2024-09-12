#include <iostream>

using namespace std;

int main(){
	//Stack
	
	int a;
	int b[10];
	
	//Heap
	//C malloc és free
	//C++ new és delete
	//pointer-változó = new adattípus;
	
	int* p = new int;
	int* tp = new int[10];
	
	int* p2 = new(nothrow) int;
	
	if(!p2){ //p2 == NULL
		cout << "Memória allokáció nem sikerült" << endl;
	} else {
		*p2 = 29;
		cout << "A p2 értéke: "<<*p2 << endl; 
	}
	
	float* r= new float(72.24);
	
	cout << r << " " << *r << " " << &r << endl;
	
	int n2 = 5;
	int* q = new int[n2];
	
	for(int i=0; i<n2 ; i++){
		q[i] = i+1;
		cout << q[i] << endl;
	}
	
	delete p2;
	delete r;
	
	//delete q;//delete &q[0]
	delete[] q;
	
	
	
	
	
	
	
	
	
	
	

	return 0;
}
