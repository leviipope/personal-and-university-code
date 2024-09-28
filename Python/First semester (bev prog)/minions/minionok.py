import sys
from typing import NamedTuple


Minion = NamedTuple("Minion",[("name",str),("hunger",int),("motivation",int),("size",str)])
Minion

def line_to_minion(line):
    minion_list = line.strip("\n").split(";")
    return Minion(minion_list[0],minion_list[1],minion_list[2],minion_list[3])
def minion_to_line(minion):
     return f"{minion.name} {minion.hunger} {minion.size}"
def sort_minions(minions: list):
    minions.sort(key=lambda minion: (-minion.motivation,minion.name))

def main():
    minions=[]
    for line in sys.stdin:
        minions.append(line_to_minion(line))
    for minion in sort_minions(minions):
        print(minion_to_line(minion))

if __name__=="__main__":
    main()