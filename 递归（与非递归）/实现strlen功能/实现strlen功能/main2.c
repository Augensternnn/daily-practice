#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//µ›πÈ µœ÷strlen
int myStrlen(char *str)
{
	if (*str == '\0')
		return 0;
	else
		return 1 + myStrlen(str + 1);
}

int main1()
{
	char str[] = "abcdef";
	printf("%d\n", myStrlen(str));
	system("pause");
	return 0;
}