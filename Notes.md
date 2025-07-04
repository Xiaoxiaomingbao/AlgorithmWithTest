# 异或运算实现交换操作

由异或运算是无进位加法可推知，异或运算具有交换律和结合律。

$$ a\prime = a \oplus b $$
$$ b\prime = a\prime \oplus b = (a \oplus b) \oplus b = a \oplus (b \oplus b) = a \oplus 0 = a $$
$$ a\prime\prime = a\prime \oplus b\prime = (a \oplus b) \oplus a = (b \oplus a) \oplus a = b \oplus (a \oplus a) = b \oplus 0 = b $$

可以看出，将$a$与$b$的异或值赋给$a$，将$a$与$b$的异或值赋给$b$，再将$a$与$b$的异或值赋给$a$，可实现交换操作。

# Master 公式

$$ T(N) = a T(\frac{N}{b}) + \mathcal{O}(N^c) $$

时间复杂度为

$$
\begin{cases}
\mathcal{O}(N^c) & \text{若 } \log_{b}{a} < c \\
\mathcal{O}(N^{\log_{b}{a}}) & \text{若 } \log_{b}{a} > c \\
\mathcal{O}(N^c\log{N}) & \text{若 } \log_{b}{a} = c
\end{cases}
$$
