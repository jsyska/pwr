#include <iostream>
#include <stdlib.h>
using namespace std;

void v_alloc_table_add_5(int iSize) {

    if (iSize < 0) {
        return;
    }

    int* pi_array = new int[iSize];

    for (int offset = 0; offset < iSize; offset++)
    {
        pi_array[offset] = offset + 5;
        cout << pi_array[offset] << " ";
    }

    delete[] pi_array;  //free the memory block of allocated memory
}

// In here we will need "***" in place of "???",
//as we need to clearly specify the type of "piTable" which is pointer to double pointer

bool b_alloc_table_2_dim(int*** piTable, int iSizeX, int iSizeY) {
    if (iSizeX < 0 || iSizeY < 0) {
        return false;
    }

    int** pi_table = new int* [iSizeX];
    for (int ii = 0; ii < iSizeX; ii++)
    {
        pi_table[ii] = new int[iSizeY];
    }

    *piTable = pi_table;
    return true;
}


bool b_dealloc_table_2_dim(int** piTable, int iSizeX, int iSizeY) {
    if (iSizeX < 0 || iSizeY < 0) {
        return false;
    }

    for (int ii = 0; ii < iSizeX; ii++)
    {
        delete[] piTable[ii];
    }

    delete[] piTable;
    return true;
}

//Yes the function can have fewer arguments, as it requires only the number of rows of the array. Argument iSizeY can be ommited.

int main()
{
    //task 1
    v_alloc_table_add_5(5);
    v_alloc_table_add_5(10);

    //task 2
    int** pi_table;
    //In this line "???", there will be a "&" in place of question mark,
    // as we will be passing pointer that points the address of the double pointer
    bool b = b_alloc_table_2_dim(&pi_table, 5, 3);


    int count = 0, iSizeX = 5, iSizeY = 3;
    for (int i = 0;i < iSizeX;i++)
        for (int j = 0;j < iSizeY;j++)
            pi_table[i][j] = count++;
    for (int i = 0;i < iSizeX;i++)
    {
        for (int j = 0;j < iSizeY;j++)
            cout << pi_table[i][j] << "\t";
        cout << "\n";
    }
    //Task 3
    b_dealloc_table_2_dim(pi_table, 5, 3);
}

