#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//输入一个非负整数，返回组成它的数字之和。例如，调用DigitSum(1729)，则应该返回1 + 7 + 2 + 9，它的和是19
int DigitSum(int n)
{
	if (n == 0)
		return 0;
	else
		return (n % 10) + DigitSum(n / 10);
}

int main()
{
	printf("%d\n", DigitSum(1729));
	system("pause");
	return 0;
}