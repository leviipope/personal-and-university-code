#include <iostream>
using namespace std;

int lkkt(int a, int b){
    int lcm;
    if(a>b){
        lcm = a;
    } else {
        lcm = b;
    }
    while(1) {
      if( lcm%a==0 && lcm%b==0 ) {
         break;
      }
      lcm++;
   }
   return lcm;
}


int main() {
    cout << lkkt(5,7) << endl;
}