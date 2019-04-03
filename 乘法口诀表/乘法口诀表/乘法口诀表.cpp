#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
int main()
{
	int a, b, c = 0;
	for (a = 1; a <= 9; a++)
	{
		for (b = 1; b <= a; b++)
		{
			c = a*b;
			printf("%d*%d=%d\t",b,a,c);
		}
		printf("\n");
	}
	system("pause");
	return 0;
}