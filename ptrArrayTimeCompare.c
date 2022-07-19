#include <stdio.h>
#include <time.h> //for clock comparison

void myArr(); //cleans up undeclared function warnings
void myPtr();

int main() {
  clock_t start, stop;
  double cpuTime;

  //starts cpu clock
  start = clock();

  for(int i=0; i<50000; i++){
    myArr(); //access directly
  }

  // stops cpu clock
  stop = clock();

  // time elapsed in seconds
  cpuTime = ((double) (stop - start)) / CLOCKS_PER_SEC;

  printf("Execution time directly::%f\n",cpuTime);

  start = clock();

  for(int i=0; i<50000; i++){
    myPtr(); //access by pointers
  }

  stop = clock();

  // calculating the time elapsed in array reference through pointers.
  cpuTime = ((double) (stop - start)) / CLOCKS_PER_SEC;
  printf("Execution time with pointers::%f\n",cpuTime);
  return 0;
}

void myArr() {
  int arr[20][20] = {0};
  for(int j=0; j<20 ; j++){
    for(int i=0; i<20; i++){
      arr[i][j];
    }
  }
  return;
}

void myPtr() {
  int arr[20][20] = {0};
  for(int j=0; j<20 ; j++){
    for(int i=0; i<20; i++){
      *(*(arr+i)+j);
    }
  }
  return;
}
