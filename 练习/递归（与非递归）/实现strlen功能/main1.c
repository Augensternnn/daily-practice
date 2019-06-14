#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//非递归分别实现strlen
int main()
{
	int i = 0, cout = 0;
	char arr[] = "abcdef";
	if (arr[i] == '\0')
		printf("%d\n", i);
	else
	{
		while (arr[i] != '\0')
		{
			cout = cout + 1;
			i++;
		}
		printf("%d\n", cout);
	}
	system("pause");
	return 0;
}