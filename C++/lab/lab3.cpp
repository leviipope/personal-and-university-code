#include <iostream>
using namespace std;

int main(){

    //példák végtelen ciklusra
    /*
    while(true){
        cout << "vegtelen ciklus" << endl;
    }
    */

    /*
    for( int i =0; i++){
        cout << i << endl;
    }
    */

    /*
    for(;;){
        cout << "vegtelen cilus" << endl;
    }
    */
    //

    cout << "i j" << endl;
    for(int i = 0; i<3; i++){
        for(int j=0; j<5; j++){
            cout << i << " " << j << endl;
        }
    }
    


    int szamok[5] = {20,30,40,50,60};
    /*cout << szamok << endl; //memoria cimet ad vissza, implicit megkell adnunk hogy mivel irja ki*/

    for(int i = 0; i < 5; i++){
        cout << szamok[i] << " ";
        //szamok[i] = szamok[i-1] * 2;
    }
    cout << endl;

    
    // for(tipus nev : tomb)
    for(int szam : szamok){ //nincs indexeles
        cout<< szam << " ";
    }
    cout << endl;

    cout << sizeof(szamok) << " byte" << endl; // int 4byte, 5 elem => 5 x 4byte = 20byte

    for(int i = 0; i<sizeof(szamok)/sizeof(int); i++){
        cout << szamok[i] << " ";
    }
    cout << endl;


/*
    int i = 0;
    while(i<10){
        cout << i << " ";
        i++;
        if( i == 4 ){
            break;
        }
    }

    int b = 0;
    while(b<10){
        if(b==4){
            b++;
            continue;
        }
        cout << b << " ";
        b++;
    }
    cout << endl;
*/

    char betuk[2][4]={
        {'a','b','c','d'},
        {'e','f','g','h'}
    };

    cout << betuk[0] << " " << betuk[1] << " " << betuk[0][2] << endl;

    for(int i = 0; i<2;i++){
        for(int j = 0;j<4;j++){
            cout<<betuk[i][j]<< " ";
        }
        cout << endl;
    }


    int szam2d[3][4] = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
    };

    
    //sorok atlaga (plusszpont sikertelen(hozza se tudtam kezdeni))
    float osszeg;
    for( int i = 0; i<3 ;i++){
            osszeg = 0;
            for(int j = 0; j<4;j++){
                osszeg += szam2d[i][j];
            }
            cout<< osszeg/4 << endl;
    }
    



    return 0;
}