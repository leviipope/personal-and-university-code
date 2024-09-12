#include <iostream>

#define LENGTH 10

int g = 10; //globális változó

int main(){
	
	std::cout << "Hello, world!\n";
	std::cout << "Hello, world!" << std::endl;
	
	std::cout << "a" << "b" << "c" << "d" << std::endl;
	
	char c = 'c'; //'c' karakter literál
	int i = 0;
	short int si = 1;
	long int li = 50;
	float f = 10.2;
	double d = 10.2;
	bool b = false;
	
	"str";//string literál
	
	std::cout << "char :" << sizeof(char) << std::endl; //char adattípus méretének kíírása
	std::cout << "int :" << sizeof(int) << std::endl;
	std::cout << "short int :" << sizeof(short int) << std::endl;
	std::cout << "long int :" << sizeof(long int) << std::endl;
	std::cout << "float :" << sizeof(float) << std::endl;
	std::cout << "double :" << sizeof(double) << std::endl;
	std::cout << "bool :" << sizeof(bool) << std::endl;
	
	int i1 = 1, i2 = 2;
	char x,y;
	int z; //int z = 0;
	
	std::cout << z << std::endl;
	
	//egysoros komment
	
	/*
		többsoros
		komment
	
	*/
	
	typedef int egesz;
	
	egesz e = 22;
	
	std::cout << LENGTH << std::endl;
	
	const int width = 11;
	//width = 12;
	
	std::cout << g << std::endl;
	
	{
		std::cout << g << std::endl;
		int g = 5; //lokális változó
		std::cout << g << std::endl;
	}
	std::cout << g << std::endl;
	
	//\ ' " ? alert backspace form-feed new-line carriage-return, tab, vertical tab
	std::cout << "\\ \' \" \? \a \b \f \n \r \t \v" << std::endl;
	
	//+ - * / % ++ --
	
	int mod = 10 % 3;
	
	std::cout << mod << std::endl;
	
	std::cout << ++mod << std::endl;
	std::cout << mod++ << std::endl;
	
	std::cout << mod << std::endl;
	
	
	
	

	return 0;
}
