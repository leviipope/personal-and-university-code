# def negyszog(a: int,b: int = 0) -> int:
#     if(b==0):
#         return a*a
#     return a*b
#
# def main():
#     print(negyszog(5))
#     print(negyszog(5,10))
#
# if __name__ == "__main__":
#         main()

#N faktorialsa

# def faktorialis(alap: int) -> int:
#     if alap==1:
#         return 1
#     return alap * faktorialis(alap-1)
#
# def main():
#     print(faktorialis(50))
#
# if __name__ == "__main__":
#              main()
#

def hatvany(alap,kitevo):
    if kitevo == 0:
        return 1
    return alap * hatvany(alap, kitevo-1)

def hatvany_for(alap,kitevo):
    eredmeny=1
    for i in range(kitevo):
        eredmeny *= alap
    return eredmeny

def hatvany_while(alap,kitevo):
    eredmeny = 1
    while True:
        if kitevo == 0:
            break
        eredmeny *= alap
        kitevo -= 1


def main():
    print(hatvany_while(3,3))

if __name__ == "__main__":
    main()
