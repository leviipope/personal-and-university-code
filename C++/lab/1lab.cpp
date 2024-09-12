#include <iostream>

#define LENGTH 10

int g = 10; //globalis valtozo

int main(){

    std::cout << "Hello World!\n";
    std::cout << "Hello World!" << std::endl;

    std::cout << "a" << "b" << "c" << "d" << std::endl;

    char c = 'c'; //'c' karakter literál
    int i = 0;
    short int si = 1;
    long int li = 50;
    float f = 10.2;
    bool b = false;
    double d = 10.2;

    "str";//string literal

    std::cout << "char: " << sizeof(char) << std::endl;
    std::cout << "int: " << sizeof(int) << std::endl;
    std::cout << "short int: " << sizeof(short int) << std::endl;
    std::cout << "long int: " << sizeof(long int) << std::endl;
    std::cout << "float: " << sizeof(float) << std::endl;
    std::cout << "double: " << sizeof(double) << std::endl;
    std::cout << "bool: " << sizeof(bool) << std::endl << std::endl;

    int il = 1, i2 = 2;
    char x,y;
    int z; //megegyezik: int z = 0, a memoriaba egy random szamot fog visszaadni

    std::cout << "z: " << z << std::endl;

    //egysoros komment

    /*
        tobbsoros
        komment
    */

    typedef int egesz;

    egesz e = 22;

    std::cout<< "length: " <<LENGTH<<std::endl;

    const int width = 11;
    //width = 12;

    std::cout << g << std::endl << std::endl;

    {
            std::cout << g << std::endl;
            int g = 5; //lokalis valtozo
            std::cout << g << std::endl; // 5
    }
    std::cout << g << std::endl << std::endl; // 10

    //\ ' " ? alert backspace form-feed new-line carriage-return, tab, vertical tab
    std::cout<< "\\ \'\" \? \a \b \f \n \r \t \v" << std::endl;

    //+ - * / % ++ --

    int mod = 10%3; // 1

    std::cout << "mod: " << mod << std::endl;

    std::cout << "++mod: " << ++mod << std::endl;//eloszor hozzadja majd kirrja
    std::cout << "mod++: " << mod++ << std::endl;//eloszor elvegz a kiirast

    std::cout << "mod (mod++ utan): " << mod << std::endl;

    return 0;
}
