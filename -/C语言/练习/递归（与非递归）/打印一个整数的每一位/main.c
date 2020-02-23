#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//递归方式实现打印一个整数的每一位
void printfSum(int n)
{
	if (n == 0)
		return;
	else
		printfSum(n / 10);
	printf("%d  ", n % 10);
}

int main()
{
	int n = 1234;
	printfSum(n);
	system("pause");
	return 0;
}