#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//实现一个函数判断year是不是闰年
int judge_year(int i)
{
	return((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0));
}

int main()
{
	int i;
	printf("Please enter a year:");
	scanf("%d", &i);
	if (judge_year(i))
		printf("%d\n", i);
	system("pause");
	return 0;
}