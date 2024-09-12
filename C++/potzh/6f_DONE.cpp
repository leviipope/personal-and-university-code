#include<iostream>
#include<fstream>
#include<vector>
#include<algorithm>

using namespace std;



int main(){
    ifstream input;
    input.open("randomok.txt");

    vector<int> elements;
    int n;
    while(input>>n){
        elements.push_back(n);
    }

    input.close();

    sort(elements.begin(), elements.end()); 
    auto it = unique(elements.begin(), elements.end()); 
  
    elements.erase(it, elements.end()); 

    ofstream output;
    output.open("egyedi.txt");
    for (auto& element : elements) { 
        output << element << " "; 
    } 



    return 0;
}


