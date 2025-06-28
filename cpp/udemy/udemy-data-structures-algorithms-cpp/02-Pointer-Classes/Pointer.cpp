#include <iostream>

using namespace std;

int main(){
    int n1 = 11;
    int n2 = n1;

    n1 = 100;

    int* n3 = new int(11);
    int* n4 = n3;

    *n3 = 22;

    cout << "n1 = " << n1 << endl;
    cout << "n2 = " << n2 << endl;
    cout << "n3 = " << *n3 << endl;
    cout << "n4 = " << *n4 << endl;
}