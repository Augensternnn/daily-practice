#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//����һ���Ǹ����������������������֮�͡����磬����DigitSum(1729)����Ӧ�÷���1 + 7 + 2 + 9�����ĺ���19
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