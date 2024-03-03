## Mortgage Calculator

#### A mortgage calculator project is a software application designed to help users estimate their monthly mortgage payments. It takes into account factors such as the loan amount (principal), annual interest rate, and loan term (period in years). The app is written in Java.

* M = monthly payment 
* P = principal amount
* R = monthly interest rate ($\frac{anuualRate}{12}$)
* N = number of payments in months (ex.: 10 years -> 120 payments)

#### Formula used to Calculate the payments:

$M = P * \frac{R*(1+R)^N}{(1+R)^N - 1}$