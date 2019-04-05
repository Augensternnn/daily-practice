#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int Judge(int n)
{
	int i;
	double tmp;
	tmp = sqrt(n);
	for (i = 2; i <= tmp; i++)
	{
		if (n % i == 0)
			return 0;
	}
	return 1;
}

//用函数判断一个数是不是素数
int main()
{
	int i, count = 0;
	printf("Please enter a number:");
	scanf("%d", &i);
	if (Judge(i))
	{
		printf("%d  ", i);
		count++;
	}
	if (count % 10 == 0)
		printf("\n");


	system("pause");
	return 0;
}