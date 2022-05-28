#include <iostream>
#include <stdlib.h>
using namespace std;

void v_alloc_table_add_5(int iSize) {
        int* array = NULL; //Pointer initialization to NULL
        array = new(nothrow) int[iSize]; //Request memory fo the array using new operator
        if (!array) { //if it fails then print error
            cout << "Allocation of memory failed!\n";
                return;
        };
        for (int i = 0; i < iSize; i++) { //Initialization of array offset+5
            array[i] = i + 5;
        };

        //Print array
        cout << "Elements of the array are:";
        for (int i = 0; i < iSize;i++) {
            cout << array[i] << "";
        }
        cout << endl;
        delete[] array; //free the memory block of allocated memory
}

// In here we will need "***" in place of "???",
//as we need to clearly specify the type of "piTable" which is pointer to double pointer

//bool b_alloc_table_2_dim(int*** piTable, int iSizeX, int iSizeY)
//{
//    //we assign a row of pointers to create the rows
//    *piTable = (int**)malloc(iSizeX * sizeof(int*));
//    //we loop and then allocate space according to the "iSizeY" passed as parameter
//    for (int i = 0;i < iSizeX;i++)
//        (*piTable)[i] = (int*)malloc(iSizeY * sizeof(int));
//    //it returns 1 if executed till here successfully , else program will get stuck
//    return 1;
//}

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

//bool b_dealloc_table_2_dim(int** piTable, int iSizeX, int iSizeY) {
//    try {
//        for (int i = 0; i <= iSizeY; i++)
//            delete[] piTable[i];
//        delete[] piTable;
//        return true;
//    }
//    catch (...) {
//        return false;
//    }
//}

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

//Yes the function can have fewer arguments, as it requires only the number of rows of the array.Argument iSizeY can be ommited.

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


    //This code is for testing purpose, that dows the space gets allocated or not.
    // If yes then the following code will print number from 0-14
    //<----------------REMOVE THE FOLLOWING CODE--------------------TESTING PURPOSE ONLY---------->
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
    b_dealloc_table_2_dim(pi_table, 5, 3);
}

