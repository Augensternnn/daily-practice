#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//�ǵݹ�ֱ�ʵ����n�Ľ׳� 
int main()
{
	int n, i, j = 1;
	scanf("%d", &n);
	if (n == 0 || n == 1)
		printf("1\n");
	else
	{
		for (i = 1; i <= n; i++)
		{
			j = j * i;
		}
		printf("%d\n", j);
	}
	system("pause");
	return 0;
}