"""
@author: Saeid Samadi-Dana
Credit Card problem https://open.kattis.com/problems/creditcard
"""

import math

def round_up(n, decimals=0):
    multiplier = 10**decimals
    return math.ceil(n * multiplier) / multiplier

samplesCount= int(input())
samples=[]
for i in range(samplesCount):
    samples.append(input())
      
for i in range(samplesCount):
    #monthly interest rate,outstanding balance,monthly payment
    R,B,M=[float(x) for x in samples[i].split()]
        
    count = 0 #number of months to pay the credit card
    while count <= 1200 and B > 0:        
        monthlyInterest = round_up( B * R / 100.0,2)
        B += monthlyInterest - M
        count+=1
    
    if count > 1200 :
        print("impossible")
    else:
        print(count)               
