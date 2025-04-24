from keres import Feladat, best_first, szélességi_fakereső


class nyolckiralyno_problema (Feladat):
    def __init__(self, k , N):
        # k: initial state tuple (queen_col_0, ..., queen_col_N-1, next_row_index)
        # N: number of queens / board size
        self.kezdő = k
        self.N = N # Store N explicitly
        # The goal is implicitly defined when next_row_index == N

    def célteszt(self, a):
        # Goal is reached when the next row index (stored at a[self.N]) equals N
        return a[self.N] == self.N

    def rákövetkező(self, a):
        gyerekek = []
        s = a[self.N] # Row index (0 to N-1) to place the next queen

        # If N queens are already placed (s == N), no more children
        if s >= self.N:
            return gyerekek

        # Iterate through possible columns (j) for the queen in row s
        for j in range(0, self.N):
            alkalmazhato = True # Assume the position (s, j) is valid initially
            # Check against previously placed queens (in rows 0 to s-1)
            # a[i] is the column of the queen in row i
            for i in range(0, s):
                # Check if queen at (i, a[i]) attacks (s, j)
                # Same column (a[i] == j) or same diagonal (abs(i-s) == abs(a[i]-j))
                if a[i] == j or abs(i - s) == abs(a[i] - j):
                    alkalmazhato = False # Position is not valid
                    break # No need to check further for this column j

            # If the position (s, j) is valid after checking all previous queens
            if alkalmazhato:
                tmp = list(a)
                tmp[s] = j       # Place queen in row s at column j
                tmp[self.N] = s + 1  # Increment the index for the next row
                uj_allapot = tuple(tmp)
                # Action string indicates placing queen in row s at column j
                action_str = str(s) + "->" + str(j)
                gyerekek.append((action_str, uj_allapot))

        return gyerekek
    
    def heurisztika(csucs):
        a = csucs.állapot
        s = a[-1]  # aktuálisan elhelyezett királynők száma
        konfliktus = 0

        for i in range(s):
            for j in range(i + 1, s):
                if a[i] == a[j] or abs(i - j) == abs(a[i] - a[j]):
                    konfliktus += 1

        return konfliktus

if __name__ == "__main__":
    N = 8 # Define board size / number of queens
    # Initial state: N placeholders (e.g., -1 or 0) + starting row index 0
    # Using -1 as placeholder to distinguish from column 0
    initial_state = tuple([-1] * N + [0])
    # The goal check uses N, no separate goal value needed in init
    kir = nyolckiralyno_problema(initial_state, N)

    print(f"Keresés {N} királynő problémára...")
    print("Kezdő állapot:", kir.kezdő)

    # Find solution using breadth-first search (assuming keres.py is available and correct)
    try:
        # csúcs = szélességi_fakereső(kir)
        csúcs = best_first(kir, nyolckiralyno_problema.heurisztika)

        # Print result
        if csúcs:
            # Try to reconstruct path if possible (depends on 'keres' module's Node)
            try:
                út = csúcs.út()
                út.reverse()  # Reverse the path to get from start to goal
                print("Út (lépések):",út)
            except AttributeError:
                print("Nem sikerült az utat rekonstruálni (Node osztály struktúrája ismeretlen).")
            # Print the final state (queen positions)
            print("Megoldás (állapot):", csúcs.állapot)
        else:
            print("Nincs megoldás.")
    except ImportError:
        print("Hiba: A 'keres' modul nem található.")
    except NameError:
        print("Hiba: A 'szélességi_fakereső' függvény nem található a 'keres' modulban.")
    except Exception as e:
        print(f"Hiba történt a keresés során: {e}")
