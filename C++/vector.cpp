#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){

    // Create a vector that can contain integers (vector library)
    vector<int> v;

    // Add integers to vector
    v.push_back(2);

    // Add ints using for loop
    for(int i = 0; i<=10; i++){
		v.push_back(i*5);
        //Print out the vector in two ways
		cout << v[i] << " " << v.at(i) << endl;
	}

    // You can also print the vector with a for loop
    for(int i : v){
        cout << i << " ";
    }   cout << endl;

    // Element access with .at (access specified element with bounds checking)
    cout << v.at(0) << " " << v.at(1) << endl;

    // First and last element of the vector
    cout << v.front() << " " << v.back() << endl;

    // Capacity
    cout << v.size() << endl; // returns the number of elements
    cout << v.capacity() << endl; // returns number of elements that can be held in currently allocated storage

    // Pointer to the memory address (of the first element)
    int* pos = v.data();
	cout << pos << endl;

    // Remove the last element
    v.pop_back();

    // Clear the contents (already allocated space remains)
    v.clear();
    cout << v.size() << endl; // 0
    cout << v.capacity() << endl; // 16

    // Reduce memory usage by freeing unused memory
    v.shrink_to_fit();
    cout << v.size() << endl; // 0 
    cout << v.capacity() << endl; // 0 

    // Can be sorted (algorythm library)
    vector<int> q = {9, -4, 102, -5, 6, 1};
    sort(q.begin(), q.end());
    for(int i : q){
        cout << i << " ";
    } cout << endl;

    return 0;
}