#include <iostream>
#include <vector>
#include <fstream>
#include <string>
#include <algorithm>
using namespace std;


void kulon(int matrix[5][5]){
    vector<int> szamok;
    int sorkicsi = INT_MAX;
    int sormax = INT_MIN;
    int kulonbseg;
    for(int i = 0; i<5;i++){
    sorkicsi = INT_MAX;
    sormax = INT_MIN;
        for(int j = 0; j<5;j++){
            if(matrix[i][j]>sormax){
                sormax = matrix[i][j];
             }
            if(matrix[i][j]<sorkicsi){
                 sorkicsi = matrix[i][j];
             }
        }
        kulonbseg = sormax-sorkicsi;
        szamok.push_back(kulonbseg);
    }
    for(int i : szamok){
        cout << i << " "; 
    } cout << endl;
}

int main(){

    int matrix[5][5] = {
            {1,2,3,4,5},
            {6,7,8,9,70},
            {1,2,80,4,5},
            {1,2,3,4,5},
            {5,4,3,2,1}
    };
    kulon(matrix);

    return 0;
}