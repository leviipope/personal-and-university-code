#include <iostream>
#include <algorithm>

using namespace std;

/*3. Írjon függvényt, amelynek 3 integer paramétere van (a, b, c). A legkisebb és
legnagyobb értéket írja felül 0-ra, majd cserélje meg az a és c, majd a b és a változók
értékét. A függvény visszatérési értéke void. (a&lt;-&gt;c, b&lt;-&gt;a)*/


#include <iostream>
#include <algorithm> // a std::min és std::max függvényekhez

void processValues(int &a, int &b, int &c) {
    // Az eredeti értékek tárolása az egyszerűség kedvéért
    int originalA = a;
    int originalB = b;
    int originalC = c;

    // A legkisebb és legnagyobb érték megkeresése
    int minValue = std::min({a, b, c});
    int maxValue = std::max({a, b, c});

    // A legkisebb és legnagyobb érték felülírása 0-ra
    if (a == minValue || a == maxValue) a = 0;
    if (b == minValue || b == maxValue) b = 0;
    if (c == minValue || c == maxValue) c = 0;

    // a és c értékének cseréje
    std::swap(a, c);

    // b és a értékének cseréje
    std::swap(b, a);

    // Debug üzenetek a teszteléshez (ha szükséges)
    std::cout << "Eredeti értékek: a = " << originalA << ", b = " << originalB << ", c = " << originalC << std::endl;
    std::cout << "Módosított értékek: a = " << a << ", b = " << b << ", c = " << c << std::endl;
}

int main() {
    int a = 5, b = 1, c = 10;

    // Eredeti értékek kiírása
    std::cout << "Eredeti értékek: a = " << a << ", b = " << b << ", c = " << c << std::endl;

    // A függvény meghívása
    processValues(a, b, c);

    // Módosított értékek kiírása
    std::cout << "Módosított értékek: a = " << a << ", b = " << b << ", c = " << c << std::endl;

    return 0;
}