#include <iostream>
#include <cstdlib>

using namespace std;

int main(int argc, char const *argv[])
{
	int o, s, p;
	o = 100;
	s = 200;
	p = 700;
	int total = 20;
	int contPausa = 0;
	int num;
	int tempo;
	while(total--)
	{

		num = rand()%5;
		if(num == 0)
		{
			if(contPausa == 4)
			{
				contPausa = 0;
				continue;
			}
			contPausa++;
			cout << 0 << endl;
		}
		else
		{
			contPausa = 0;
			tempo = rand()%3;
			num = rand()%10;
			if(num == 9)
			{
				if(o > 0)
				{
					o--;
					tempo += 4;
					cout << 1 << " " << tempo << endl;
				}
				else if(s > 0)
				{
					s--;
					tempo += 2;
					cout << 2 << " " << tempo << endl;
				}
				else
				{
					p--;
					tempo += 1;
					cout << 3 << " " << tempo << endl;
				}
			}
			else if(num >= 7)
			{
				if(s > 0)
				{
					s--;
					tempo += 2;
					cout << 2 << " " << tempo << endl;
				}
				
				else if(o > 0)
				{
					o--;
					tempo += 4;
					cout << 1 << " " << tempo << endl;
				} 
				else
				{
					p--;
					tempo += 1;
					cout << 3 << " " << tempo << endl;
				}
			}
			else
			{
				if(p > 0)
				{
					p--;
					tempo += 1;
					cout << 3 << " " << tempo << endl;
					
				}
				else if(o > 0)
				{
					o--;
					tempo += 4;
					cout << 1 << " " << tempo << endl;
				} 
				else
				{
					s--;
					tempo += 2;
					cout << 2 << " " << tempo << endl;
				}
			}
		}
	}
	cout << 0 << endl
		<< 0 << endl
		<< 0 << endl
		<< 0 << endl
		<< 0;

	return 0;
}