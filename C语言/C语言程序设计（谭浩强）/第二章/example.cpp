#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//Çó5£¡
int main()
{
	int i, j;
	i = 1;
	j = 2;
	while (j <= 5)
	{
		j = i * j;
		j = j + 1;
	}
	printf("%d\n", j);
	system("pause");
	return 0;
}