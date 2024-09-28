# negativ = 0
# while True:
#     try:
#         n= int(input("add meg a szamot: "))
#         if n<0:
#             negativ += 1
#     except EOFError:
#         print("negativ szamok szama: ",negativ)
#         break


# negativ = 0
# while True:
#     try:
#         szamok = input().split()
#         list = [int(i) for i in szamok]
#         mennyi = len(list)
#         i = 0
#         while i<=mennyi:
#              if list[i]<0:
#                  negativ += 1
#              i += 1
#     except EOFError:
#         print("negativ szamok: ",negativ)
#         break


#hozzunk letre listat benne szavakkal majd list c. segitsegevel egy masikat melyben nagybetusen jelennek meg a szavak pl: tojas -> TOJAS
#
# li = ["alma","tojas","tej","beke"]
# li2 = [s.upper() + "!" for s in li]
# print(li2)

#hozzuk letre listat random szamokbol  de csak paros szamokbol

# import random
# li =[random.randint(1,50)*2 for i in range(10)]
# print(li)

#hozzunk letre listat li elemeibol ahol a szavak hossza >5

# li = ["alma","tojas","tej","beke"]
# li2 = [s for s in li if len(li)>=5]
# print(li2)

#lista li emelebol de minden elem a li szvainak hossza
#lista igaz hamis elemek rnadom sorozata

# import random
# li2 = [random.randint(1,100)%2==0 for n in range(1,100)]
# print(li2)

#lista 1,100 elemelek sorozataval de csak minden 3.at
#
# li2 = [n for n in range(1,100,3)]
# print(li2)

#olssaunk be szamokat  majddontsuk el hogy parosak e ha igen akkor zoamoljuk meg oket, ha nem akkor vegun kel egyet a szamitasbol, addig amig a flhaszanlo 0-t nem ad

# counter = 0
# while True:
#     n = int(input())
#     if n==0:
#         break
#     elif n%2==0:
#         counter += 1
#     else:
#         counter -= 1
# print(counter)

#glikemias index, (0-40 alacsony, 40-60 magas 60 100 bomba robbanas type of beat erted a jatekot baba
#
# n = -1
# while n!=101:
#     n = int(input())
#     if n > 0 and n <= 40:
#         print("alacsony")
#     elif n > 40 and n <= 60:
#         print("kozepes")
#     elif n > 60 and n<=100:
#         print("szivemben bomba robban fel")

li = ["tomi aszu","ko pal","tank aranka","gipsz jakab","kasza blanka","am erika","felek elek"]
max_length = li[0]

for name in li:
    if len(name) < len(max_length):
        max_length = name
print(max_length)
