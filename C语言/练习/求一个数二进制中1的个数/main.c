#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
//返回参数二进制中 1 的个数 
int count_one_bits1(unsigned int value)
{
	int count = 0;
	for (value; value != 0; value /= 2)
	{
		if (value % 2 == 1)
			count++;
	}
	return count;
}

int count_one_bits2(unsigned int value)
{
	int i, count = 0;
	for (i = value; i; i /= 2)
	{
		count += i % 2;
	}
	return count;
}

int count_one_bits3(unsigned int value)
{
	int count = 0;
	do
	{
		count++;
	} while (value &= value - 1);
	return count;
}
int main()
{
	int i;
	scanf("%d", &i);
	printf("%d\n", count_one_bits3(i));
	system("pause");
	return 0;
}