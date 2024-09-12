#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void matrixFgv(int matrix[5][5]){
    vector<int> szamok;
    for(int i = 0;i<5;i++){
        szamok.push_back(matrix[2][i]);
        szamok.push_back(matrix[i][2]);
    }

    int elementToRemove = szamok.at(4); 
    auto it = find(szamok.begin(), szamok.end(), elementToRemove); 
    if (it != szamok.end()){ 
        szamok.erase(it); 
    } 

    sort(szamok.begin(),szamok.end());

    vector<int> otMin;
    for(int i = 0;i<5;i++){
        otMin.push_back(szamok[i]);
    }
    for(int i : otMin){
        cout << i << " ";
    } cout << endl;
}

int main(){
    int matrix[5][5] = {
        {1,2,1,4,5},
        {1,2,2,4,5},
        {6,7,3,9,10},
        {1,2,4,4,5},
        {8,7,5,6,2}     
    };

    matrixFgv(matrix);

    return 0;
}