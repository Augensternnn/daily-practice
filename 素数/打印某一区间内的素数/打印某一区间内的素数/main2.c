#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <math.h>


//用函数判断一个数是不是素数
int judge(int n)
{
	int i, tmp;
	tmp = sqrt(n);
	for (i = 2; i <= tmp; i++)
	{
		if (n % i == 0)
		{
			return 0;
		}
	}
	return 1;
}

int main1()
{
	int i, count = 0;
	scanf("%d", &i);
	//for (i = 2; i < 10000; i++)
	//{
		if (judge(i))
		{
			printf("%4d ", i);
			count++;
			if (count % 10 == 0)
			{
				putchar('\n');
			}
		}
	//}
	system("pause");
	return 0;
}