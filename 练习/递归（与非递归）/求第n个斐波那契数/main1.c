#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//�ݹ�ʵ�����n��쳲�������
int Fib(int n)
{
	if (n <= 2)
		return 1;
	else
		return Fib(n - 1) + Fib(n - 2);
}

int main1()
{
	int n;
	scanf("%d", &n);
	printf("%d\n", Fib(n));
	system("pause");
	return 0;
}