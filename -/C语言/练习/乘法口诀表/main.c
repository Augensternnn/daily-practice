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
	//ʵ��һ����������ӡ�˷��ھ����ھ���������������Լ�ָ��.��:����9�����9*9�ھ���;����12�����12*12�ĳ˷��ھ���.
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
	//����˷��ھ���
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