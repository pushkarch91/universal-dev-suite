#include <iostream>

using namespace std;

class Cookie
{
private:
    string color;

public:
    Cookie(string color)
    {
        this->color = color;
    }
    string getColor()
    {
        return color;
    }
    void setColor(string color)
    {
        this->color = color;
    }
};

int main()
{
    Cookie *c1 = new Cookie("red");
    Cookie *c2 = new Cookie("blue");

    c1->setColor("yellow");

    cout << "c1: " << c1->getColor() << endl;
    cout << "c2: " << c2->getColor() << endl;
}
