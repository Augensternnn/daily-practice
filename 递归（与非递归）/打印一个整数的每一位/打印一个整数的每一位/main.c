#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//�ݹ鷽ʽʵ�ִ�ӡһ��������ÿһλ
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