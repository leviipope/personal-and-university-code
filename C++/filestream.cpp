#include <iostream>
#include <fstream>
#include <string>
#include <vector>
using namespace std;

int main(){

/*
    ofstream - output file stream - output, writing
    ifstream - input file stream - input, read-only
    fstream - file stream - read, write, create
*/

    // Creating a file
    ofstream myfile; 
    myfile.open("file1.txt"); 
    myfile << "Megnyitottuk a filet irasra";
    myfile.close(); 

    // Reading a file
    string text;
    ifstream readfile("file1.txt");
    while(getline(readfile,text)){
        cout << text << endl;
    }
    readfile.close();

    // Example

    string name; 

    ofstream outfile;
    outfile.open("yourname.dat");
    cout << "Whats your name?" << endl;
    cin >> name;
    outfile << name << endl;
    outfile.close();

    ifstream infile;
    infile.open("yourname.dat");
    string read;
    infile >> read;
    cout << read << endl;
    infile.close();

    /*
    Állomány megnyitási módok:

    ios:app Append - Hozzáfűzés, minden output a fájl végére kerül
    ios:ate Kimenetre nyitjuk az állományt, a read/write vezérlés a fájl végére kerül	

	ios::in Megnyitás olvasásra
	ios::out Megnyitás írásra
	ios::trunch Ha a fájl létezik, a tartalmát kitörli megnyitás előtt
    */

    outfile.open("yourname.dat", ios::out | ios::trunc);
    outfile.close();

   	fstream ffile;
	ffile.open("yourname.dat", ios::out | ios::in);
	ffile.close();



    return 0;
}