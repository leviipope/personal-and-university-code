#include <iostream>
#include <fstream>
#include <map>

using namespace std;

bool isAlpha(char ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
}

bool isUpper(char ch) {
    return (ch >= 'A' && ch <= 'Z');
}

int main() {
    // Fájl beolvasása
    ifstream inputFile("sorok.txt");
    if (!inputFile) {
        cerr << "Nem sikerült megnyitni a sorok.txt fájlt." << endl;
        return 1;
    }

    // Karakterek gyakoriságának tárolása
    map<char, int> charFrequency;
    int uppercaseCount = 0;
    char ch;

    while (inputFile.get(ch)) {
        if (isAlpha(ch)) {  // Csak betűket vizsgálunk
            charFrequency[ch]++;
            if (isUpper(ch)) {
                uppercaseCount++;
            }
        }
    }

    inputFile.close();

    // Legritkábban előforduló betű keresése
    char rarestChar = '\0';
    int minFrequency = -1;  // Kezdőértéknek egy lehetetlen negatív számot választunk

    for (const auto& pair : charFrequency) {
        if (minFrequency == -1 || pair.second < minFrequency) {
            minFrequency = pair.second;
            rarestChar = pair.first;
        }
    }

    // Eredmények kiírása a gyakori.txt fájlba
    ofstream outputFile("gyakori.txt");
    if (!outputFile) {
        cerr << "Nem sikerült megnyitni a gyakori.txt fájlt." << endl;
        return 1;
    }

    outputFile << "Legritkábban előforduló betű: " << rarestChar << " ("
               << minFrequency << " alkalommal)" << endl;
    outputFile << "Nagybetűk száma: " << uppercaseCount << endl;

    outputFile.close();

    return 0;
}