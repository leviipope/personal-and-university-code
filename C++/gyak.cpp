/*
2. Írjon függvényt, amelynek egy 5x5-ös kétdimenziós tömb a paramétere és visszaadja
a soronkénti maximum és minimum különbségét egy 5 méretű tömbben.

3. Írjon függvényt, amelynek 3 integer paramétere van (a, b, c). A legkisebb és
legnagyobb értéket írja felül 0-ra, majd cserélje meg az a és c, majd a b és a változók
értékét. A függvény visszatérési értéke void. (a&lt;-&gt;c, b&lt;-&gt;a)

4. Kérjen be a felhasználótól 5 db szóköz nélküli stringet. Írja ki a
képernyőre azokat, amelyek hossza az kisebb, mint az összes szóban található „a”
betűk számossága. darab(a)

5. Hozzon létre egy osztályt vagy struktúrát Banan néven, amelynek van súlya,
minősége(„A vagy B”), egy bool adattagja, amely jelzi, hogy bio-e. (10, „A”,1) Töltsön
fel egy 5 méretű tömböt banánokkal. Rendezze a tömböt súly szerint.

6. Olvassa be a sorok.txt állományt egy tetszőleges adatszerkezetbe. Írja ki a
gyakori.txt-be a legritkábban előforduló betűt és számosságát, valamint a nagy betűk
számát.
*/

#include <iostream>
#include <vector>
#include <fstream>
#include <algorithm>
#include <map>

using namespace std;

bool isLetter(char t){
    return(t>='a'&&t<='z') || (t>='A'&&t<='Z');
}

bool isUpper(char t){
    return (t>='A'&&t<='Z');
}


int main(){

    ifstream input;
    input.open("sorok.txt");

    map<char,int> charFreq;
    char t;
    int upperCount = 0;
    while(input.get(t)){
        if(isLetter(t)){
            charFreq[t]++;
            if(isUpper(t)){
                upperCount++;
            }
        }
    }
    input.close();

    char rarestChar;
    int rarestCharFreq = -1;
    for(const auto& pair : charFreq){
        if(rarestCharFreq == -1 || pair.second < rarestCharFreq){
            rarestCharFreq = pair.second;
            rarestChar = pair.first;
        }
    }

    ofstream output("gyakori.txt");
    output<<"legritkabb: " << rarestChar<< " ennyiszer: " << rarestCharFreq << endl;
    output << "nagybetuk: " << upperCount;
    output.close();



    return 0;
}