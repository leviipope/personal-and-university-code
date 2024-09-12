#include <iostream>

int main(){

    // == <= >= < > != !
    std::cout<< (10 == 1) << std::endl;

    //LOGIKAI OPERÁTOROK
    // && || !
    // es vagy tagadas
    std::cout << !false << std::endl;
    std::cout << (true || false ) << std::endl;

    //BITMŰVELETEK
    // & | ^ << >>
    //bitenkenti: es, vagy, XOR, balra eltolas, jobbra eltolas

    int A = 60;
    int B = 13;

    std::cout << (A & B) << std::endl;
    std::cout << A << 2 << std::endl; 
    std::cout << (A << 2) << std::endl; //bitmuveletkent ertelmezve

    //ÉRTÉKADÓ OPERÁTOROK
    // = += -= *= /= %= <<= >>= &= |= ^=
    // A <<= 2    ---->   A = A << 2

    A += 10;
    std::cout << A << std::endl; 

    //TÖMB
    //homogen adaszerkezet (pl. csak int), fix méretű
    //tipus nev[meret];
    //tipus nev[meret] = {t1,t2,t3,...};


    int tomb[5] = {1, 2, 3, 4, 5};
    
    std::cout << tomb[0] << std::endl;
    // std::cout << tomb[7] << std::endl; //memoria szemet ---> olyan memória területre hivatkozunk ami még a programé, de nem az adatszerkezeté
    // std::cout << tomb[3000] << std::endl; // seg. fault ---> olyan memória területre hivatkozunk ami nem tartozik már a programhoz se

    tomb[0] = 2;

    char sztring[] = "Hello, world!"; //char típusú tömb, neve: sztring, méretét a "Hello, world!" méretéből nyeri ki
    sztring[0] = 'h';
    std::cout << sztring << std::endl;

    std::string cppstring = "Hello, world!";
    cppstring[0] = 'h';
    std::cout << cppstring << std::endl;

    using namespace std;

    cout << "std névtérben vagyunk most" << endl;


    //IMPLICIT TÍPUSKONVERYIÓ
    int num = 92;
    double d;

    d = num;
    cout << d << endl;

    // int -> double
    // 4 bajt -> 8 bajt
    // 92 -> 92.0

    //----------
    double double_num = 1.11;
    int int_num;

    int_num = double_num;
    cout << int_num << endl;
    
    // double(8 bajt) -> int(4bajt)
    // 1.11 -> 1 (értékvesztés)

    // int(4 bajt) -> float(4 bajt) ->> nem biztos hogy belefog férni 

    
    //EXPLICIT TÍPISKONVERZIÓ
    int z = 21;
    double dupla;

    dupla = double(z);

    
    //IF

    if (21 > 10){
        cout << "A feltétel igaz" <<endl;
    }

    if (A){
        cout << "A feltétel igaz, (nem teljesen 0 A)." << endl;
    }

    if (A == 1){ // összehasonlítás
        cout << "A feltétel igaz, a==1" << endl;
    }

    if (A = 1){ // ha véletlen lehagyjuk az egyik egy. jelet, nem dob errort, hülyeséget fog kiírni
            cout << "A feltétel igaz" << endl;
        }

    if (21 > 10 ){
            cout << "A feltétel igaz" << endl;
    } else {
        cout << "A feltétel hamis" << endl;
    }

    if (21 > 10 ){
            cout << "igaz ág" << endl;
    } else if (1<2) {
        cout << "else if ág" << endl;
    } else if (3>2) {
        cout << "else if 2. ág" << endl;
    } else {
        cout << "else ág" << endl;
    }

    if (10>9) {
        if (1<2) {
            cout << "belső if" << endl;
        }
    }

    int cif = 10>9 ? 1 : 0;
    // (feltétel) ? értek_ha_igaz : érték_ha_hamis;
    cout << cif << endl;

    int x1 = 1;
    int y1 = 10;
    string eredmeny;
    
    eredmeny = (x1==y1) ? "egyenlő" : "nem egyenlő";
    cout << eredmeny << endl;

    if (x1 == y1){
        eredmeny = "egyenlő";
    } else if (x1 < y1){
        eredmeny = "kisebb";
    } else {
        eredmeny = "nagyobb";
    }

    cout << eredmeny << endl;

    eredmeny = (x1 == y1) ? "egyenlő" : (x1 < y1) ? "kisebb" : "nagyobb";
    cout << eredmeny << endl;


    //SWITCH

    int nap = 7;

    switch(nap){
        case 6: 
                cout << "szombat" << endl;
                break;
        case 7:
                cout << "vasárnap" << endl;
                break;
        default:
                cout << "mindjárt hétvége" << endl;
                break; // default után nem szükéséges break
    }

    
    //WHILE

    int i = 0;
    while(i < 10){ //előltesztelő ciklus, 0 vagy több alkalommal fut
        cout<<i<<" ";
        i++;
    }
    cout << endl;


    do{ //hátultesztelő ciklus, 1 vagy több alkalommal fut
        cout << i << " ";
        i++;
    } while (i < 10);
    cout << endl;
    

    //FOR
    // meghatározott klépésszámú ciklus
    // előírt lépésszámú ciklus
    // for(ciklusváltozó inicializálás; leállási feltétel; ciklusváltozó értékváltoztatása)

    for (int i = 0; i < 10; i++){
        cout << i << " ";
    }
    cout << endl;





    return 0;
}