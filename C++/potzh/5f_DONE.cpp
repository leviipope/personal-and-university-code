#include <iostream>
#include <vector>
using namespace std;

    struct banan{
        int suly;
        char minoseg;
        bool bio;
    };

int main(){

    vector<banan> bananok;
    banan temp;

    for(int i = 0;i<5;i++){
            cout << "Add meg a banan, sulyat, minoseget(A vagy B), es azt hogy bio e vagy nem (0 vagy 1)" << endl;
            cin >> temp.suly >> temp.minoseg >> temp.bio;
            if(temp.minoseg!='A' && temp.minoseg!= 'B' || temp.suly<0){
                cout << "valami nem jo, kezd ujra (ctrl+C)" << endl;
            }
            bananok.push_back(temp);
    }

    vector<banan> biok;
    vector<banan> nembio;
    int bio = 0;
    int nemBio = 0;
    for(banan b : bananok){
        if(b.bio==1){
            biok.push_back(b);
            bio++;
        } else {
            nembio.push_back(b);
            nemBio++;
        }

    }

    cout << "bio bananok szama: " << bio << endl;
    for(banan b : biok){
        cout << b.suly  << " " << b.minoseg << " " << b.bio << endl;
    }
    cout << "nembio bananok szama: "  << nemBio << endl;
    for(banan b : nembio){
        cout << b.suly  << " " << b.minoseg << " " << b.bio << endl;
    }

    return 0;
}
