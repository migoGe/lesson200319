nterms = int(input("Enter amount of nums: "))
n1, n2 = 0, 1
count = 0
if nterms <= 0:
   print("Entered number is not positive please provide positive number")
elif nterms == 1:
   print("Fibonacci sequence up to",nterms,":")
   print(n1)
else:
   print("Fibonacci sequence:")
   while count < nterms:
       print(n1)
       nth = n1 + n2
       n1 = n2
       n2 = nth
       count += 1
