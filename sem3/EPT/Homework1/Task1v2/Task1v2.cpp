#include <stdio.h>
#include <fstream>
using namespace std;
int main()
{
	fstream myfile;
	myfile.open("sales.txt", ios::out);
	const int PEOPLE = 4, PRODS = 5;
	int i, j;
	double sales[PEOPLE][PRODS];
	for (i = 0;i < PEOPLE;i++)
	{
		printf("\nPerson#%d:\n", i + 1);
		for (j = 0;j < PRODS;j++)
		{
			printf("Enter Sale value of Product#:$", j + 1);
			scanf_s("%lf", &sales[i][j]);
		}
	}
	double personTot = 0.0;
	printf("\tProd#1\tProd#2\tProd#3\tProd#4\tProd#5\tTotal Amt\n");
	myfile << "\tProd#1\tProd#2\tProd#3\tProd#4\tProd#5\tTotal Amt\n";
	for (i = 0;i < PEOPLE;i++)
	{
		personTot = 0.0;
		printf("Person#:", j + 1);
		myfile << "Person#:", j + 1;
		for (j = 0;j < PRODS;j++)
		{
			printf("%.1lf\t", sales[i][j]);
			myfile << sales[i][j];
			myfile << '\t';
			personTot += sales[i][j];
		}
		printf("%.1lf\n", personTot);
		myfile << personTot;
		myfile << '\n';
	}
	//Displaying each product sales total by all people
	double prodTot = 0;
	printf("total:");
	myfile << "total \t";
	for (j = 0;j < PRODS;j++)
	{
		prodTot = 0.0;
		for (i = 0;i < PEOPLE;i++)
		{
			prodTot += sales[i][j];
		}
		printf("%.1lf\t", prodTot);
		myfile << prodTot;
		myfile << '\t';
	}
	return 0;
}