#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    cout << "adjon meg egy szamot: "<< endl;
    int n;
    cin >> n;
    vector<int> szamok;
    int t;
    for(int i = 0;i<n;i++){
        cout << "megegyet: "<< endl;
        cin >> t;
        szamok.push_back(t);
    }

    sort(szamok.begin(), szamok.end(), greater<int>());
    auto it = unique(szamok.begin(), szamok.end()); 
    szamok.erase(it, szamok.end()); 
   
    for (auto& szam : szamok) { 
        cout << szam << " "; 
    } 


    return 0;
}