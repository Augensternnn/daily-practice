#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//编写一个函数实现n^k，使用递归实现
int myPow(int k, int n)
{
	if (n == 1)
	{
		return k;
	}
	return k * myPow(k, n - 1);
}
int main()
{
	printf("%d\n", myPow(2, 3));
	system("pause");
	return 0;
}