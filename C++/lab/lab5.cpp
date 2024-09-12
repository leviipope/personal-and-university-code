#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int osszead(int a, int b){
    return a+b;
}

void csere(int a, int b){
    int tmp = a;
    a = b;
    b = tmp;
}

void csereref(int& a, int& b){
    int tmp = a;
    a = b;
    b = tmp;
}

void csereptr(int* a, int* b){
    int tmp = *a;
    *a = *b;
    *b=tmp;
}

void szoroz(int& a, int szam){
    a = a * szam;
    szam ++;
}

void tombkiir(int tomb[5]){ //int*
    for(int i = 0; i<5; i++){
        cout << ++tomb[i] <<" " ;
    }
    cout << endl;

}

int fakt(int n){
    int sz = 1;
    for(int i = 2; i<=n;i++){
        sz = sz *i;
    }
    return sz;
}

int faktrek(int n){
    if (n>1) {
        return n * faktrek(n-1);
    } else {
            return 1;
    }
}

int factloop(int n){
    cout << n << endl;
    return n * factloop(n-1);
}

int main(){
    cout<<"Hello world"<<endl;

    vector<int>v; //típusa vektor, amelynek minden eleme integer

    for(int i = 0;i<=10;i++){
        v.push_back(i*10);
        cout << v[i] << " " << v.at(i) << endl;
    }

    cout << v[-2] << endl; //a vektor 0. elemétől 2 integer-nyit lépjen vissza, memória szemét
    //cout v.at(-2) << endl; //a vektor eleme a -2. pozíción

    cout << v.size() << " " << v.capacity() << endl;

    int* pos = v.data(); //tömb 0. elemére mutat
    
    cout << pos << endl;

    v.push_back(101);
    v.push_back(101);
    v.push_back(101);
    v.push_back(101);
    v.push_back(101);
    v.push_back(101);
    v.push_back(101);

    pos = v.data();

    cout << pos << endl;
    cout << v.size() << " " << v.capacity() << endl;

    cout << v.front() << " " << v.back() << endl;

    v.pop_back();
    v.pop_back();
    v.pop_back();
    v.pop_back();
    v.pop_back();
    v.pop_back();
    v.pop_back();
    v.pop_back();
    v.pop_back();

    cout << v.back() << endl;

    v.clear();
    cout << v.size() << " " << v.capacity() << endl;

    v.shrink_to_fit();
    cout << v.size() << " " << v.capacity() << endl;

    v = {3, 54, 3, 5 , 6, 7, 4, 123, 2, 4, 5, 3, 765, 3, 44, 54, 88};
    //cppreference, cpp/algrorithm
     
    std::sort(v.begin(), v.end());

    for(int i: v){
        cout << i << " ";
    }
    cout << endl;

    int x = 1;
    int y = 2;

    int o = osszead(x,y);// int o = (int) 3
    cout << osszead(x,y) << endl;// << 1+2 << endl

    int tmp = x;
    x = y;
    y = tmp;

    cout << x << " " << y << endl;

    csere (x,y);

    cout << x << " " << y << endl;

    csereref(x,y);

    cout << x << " " << y << endl;

    csereptr(&x,&y);

    cout << x << " " << y << endl;

    szoroz (x,10);

    cout << x << endl;

    szoroz (x,x);

    cout << x << endl;

    int tomb[5] = {1,2,3,4,5};

    tombkiir(tomb); //tombkiir(&tomb[0])
    tombkiir(tomb);

    cout << fakt(5) << endl;

    cout << faktrek(5) << endl;

    //cout << factloop(5) << endl;


    

    return 0;
}