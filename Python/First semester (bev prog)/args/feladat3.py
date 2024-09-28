import sys

def count_of_odds() -> int:
    paratlan = 0
    argc = len(sys.argv)
    for i in range(1,argc):
        if int(sys.argv[i]) % 2 == 1:
            paratlan += 1
    print(paratlan)
def main():
    count_of_odds()

if __name__== "__main__":
    main()
