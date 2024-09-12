#include <iostream>
using namespace std;

int main(){

    int tomb[5] = {1,2,3,4,5};
    int *tptr;

    tptr = tomb; // tptr = &tomb[0]

    cout << tomb << " " << &tomb[0] << " " << tptr << endl;

    for(int i = 0; i<5; i++){
        cout << tptr << " " << *tptr << endl;
        tptr++;
    }
    cout << endl;

    tptr = &tomb[4];

    for(int i = 5; i>0; i--){
        cout << tptr << " " << *tptr << endl;
        tptr--;
    }
    cout << endl;

    tptr = tomb;
    while(tptr <= &tomb[4]){
        cout << tptr << " " << *tptr << endl;
        tptr++;
    }
    cout << endl;

    *(tomb+4) = 500;//tomb[4] = 500;

    cout<< tomb[4] << endl;

    for(int i = 0; i<5; i++){
        *(tomb + i) = 1; //tomb[i] = 1; //*(tomb[0] + i) = 1;
    }

    int* ptrtomb[5];//5 elemű tömb, az elemek típusa: pointer
    for(int i = 0; i<5; i++){
        ptrtomb[i] = &tomb[i];
        cout << *ptrtomb[i] << " ";
    }
    cout << endl;

    const char* names[3] = {"Karoly", "Tamas", "Istvan"};

    for(int i = 0; i<3; i++){
        cout << (names+i) << " " << *(names+i) << endl;
    }

    int z = 10;
    int *zptr = &z;
    int ** zpptr = &zptr; //zh-n nem, vizsgán lehet

    cout << z << " " << *zptr << " " << **zpptr << endl;

    //*p++ vagy *(p++) pointer inkrementálása, majd a megnövelés előtti címen található pointer dereferencelése
    
    //*++p vagy *(++p) pointer inkrementálása, majd dereference

    //++*p vagy ++(*p) pointer dereference, majd a mutatott érték növelése

    //(*p)++ dereference, majd érték növelése


    //Feladat: tomb+i használatával cseréljük ki tomb={1,2,3,4,5} -ben az 1-t és az 5-t. tomb={5,2,3,4,1}
    //Termeszetesen nem teljesítettem.
    int cseretomb[5] = {1,2,3,4,5};
    
    int temp = *cseretomb; //tomb 0. elemének a címe
    *cseretomb = *(cseretomb+4);
    *(cseretomb+4) = temp;

    for(int i = 0; i<5; i++){
        cout << *(cseretomb+i) << " ";
    }
    cout << endl;

    /*Feladat:
    Aptr = A
    Avptr = &A[4]
    Bptr = B
    A = 1 2 3 4 5
    B = _ _ _ _ _
    nem lehet: tomb[i], tomb+i
    Másoljuk át az A pointer elemeit a B-re. (Hozzá se tudok szagolni)
    */

    int A[5] = {1,2,3,4,5};
    int B[5];

    int* Aptr = A;
    int* Avptr = &A[4];
    int* Bptr = B;
    //innen kezdődik a feladat, bár teljesen mindegy honnan kezdődik, mer egy betűt se írtam.

    while(Aptr <= Avptr){
        *(Bptr++) = *(Aptr++);
    }

    for(int i = 0; i<5;i++){
        cout << A[i] << " " << B[i] << endl;
    }


    










    return 0;
}