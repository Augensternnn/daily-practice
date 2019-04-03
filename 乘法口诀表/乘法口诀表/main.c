#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
int printfTable(int n)
{
	int i, j;
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= i; j++)
		{
			printf("%d*%d=%d\t", j, i, i * j);
		}
		printf("\n");
	}
}


int main()
{
	//实现一个函数，打印乘法口诀表，口诀表的行数和列数自己指定.例:输入9，输出9*9口诀表;输入12，输出12*12的乘法口诀表.
	int n, i, j;
	scanf("%d", &n);
	printfTable(n);


	printf("\n");
	printf("\n");
	printf("\n");
	printf("\n");
	printf("\n");
	printf("\n");
	printf("\n");
	printf("\n");
	//输出乘法口诀表
	int a, b;
	for (a = 1; a <= 9; a++)
	{
		for (b = 1; b <= a; b++)
		{
			printf("%d*%d=%d\t", b, a, a * b);
		}
			printf("\n");
	}





	system("pause");
	return 0;
}