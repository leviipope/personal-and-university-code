#include <iostream>
#include <vector>

using namespace std;

int test() {return 0;}
int test(int a) {return 0;}
float test(float a) {return 0;}
int test(int a, double b) {return 0;}

//int test(int b) {return 0;}
//float test(int b) {return 0;}

int absolute(int a){
    if(a < 0){
        a = -a;
    }
    return a;
}

double absolute(double a){
        if(a < 0.0){
        a = -a;
    }
    return a;
}

void kiir(int a){
    cout << "Integer: " << a << endl;
}

void kiir(double a){
    cout << "Double: " << a << endl;
}

void kiir(int a,double b){
    cout << "Integer: " << a << endl;
    cout << "Double: " << b << endl;
}

void operator<<(vector<double>& v, double d){
    v.push_back(d);
}

vector<int> operator+(vector<int> v1, vector<int> v2){
    vector<int> o;
    for(int i : v1){
        o.push_back(i);
    }
    for( int i : v2){
        o.push_back(i);
    }
    return o;
}

vector<int> operator<<(vector<int>& v, int i){
    v.push_back(i);
    return v;
}

void operator++(vector<int> v){
    for(int i : v){
        cout << i << " ";
    }
    cout << endl;
}

vector<int>& operator--(vector<int>& v){
    for(int i : v){
        cout << --i << " " ;
    }
    cout << endl;
    return v;     
}

struct szemely{
    string nev;
    int kor;
};

int main(){
    //túlterhelés vagy overload
    //függvények azonos névvel, de eltérő paraméterezéssel (típus vagy számosság)


    test();//6. sor
    test(10);//7.sor
    test(2,4);//8.sor
    test(1,2.2);//9.sor

    //float f = test(2);

    int a = 5;
    double b = 5.5;

    cout << absolute(a) << " " << absolute(b) << endl;

    kiir(a);
    kiir(b);
    kiir(a,b);

    //operátor túlterhelés, operator overloading
    //fordítás-idejű polimorfizmus
    //az eredeti operátorok megmaradnak, nem változtathatók
    //az operátorok úk működést, funkciót kapnak
    /* Nem túlterhelő
    sizeof
    typeid
    scope resolution (::)
    class member access (. , .*) (pont, pointer to member)
    ternary (?:)
    
    */

   vector<double> vd = {0, 1, 2.2};
   vd.push_back(3.3);

   vd << 4.4;

   for(double d : vd){
        cout<< d << " ";
   }
   cout << endl;

   vector<int> v1 = {1,2,3,4};
   vector<int> v2 = {5,6,7,8};
   vector<int> o = v1 + v2;

   for(int i : o){
        cout << i << " ";
   }
   cout << endl;

    vector<int> v = {1,2,3};
    //feladat: legyen összefűzhető
    //v << 4 << 5 << 6;

    v << 4 << 5 << 6;

    for(int i : v){
        cout << i << " ";
    }
    cout << endl;
 
    ++v;

    ------v;
 
	szemely sz1;
	sz1.nev = "János";
	sz1.kor = 30;
	
	szemely sz2;
	sz2.nev = "Kitti";
	sz2.kor = 25;
	
	cout << sz1 << " " << sz2 << endl;
	



    return 0;
}