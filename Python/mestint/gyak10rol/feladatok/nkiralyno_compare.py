import time
from keres import Feladat, best_first, szélességi_fakereső

# --- N-Queens Problem Definition ---
class nyolckiralyno_problema (Feladat):
    def __init__(self, k , N):
        self.kezdő = k
        self.N = N

    def célteszt(self, a):
        return a[self.N] == self.N

    def rákövetkező(self, a):
        gyerekek = []
        s = a[self.N]
        if s >= self.N:
            return gyerekek
        for j in range(0, self.N):
            alkalmazhato = True
            for i in range(0, s):
                if a[i] == j or abs(i - s) == abs(a[i] - j):
                    alkalmazhato = False
                    break
            if alkalmazhato:
                tmp = list(a)
                tmp[s] = j
                tmp[self.N] = s + 1
                uj_allapot = tuple(tmp)
                action_str = str(s) + "->" + str(j)
                gyerekek.append((action_str, uj_allapot))
        return gyerekek

    def heurisztika(csucs):
        # Heuristic: Number of remaining queens to place.
        try:
            a = csucs.állapot
            N = len(a) - 1
            queens_placed = a[-1] 
            # queens_placed = a[N] # The last element is the index of the next row to place a queen
            remaining_queens = N - queens_placed
            return remaining_queens
        except AttributeError:
            print("Hiba: A 'csucs' objektumnak nincs 'állapot' attribútuma.")
            return float('inf') # Return a high value if state cannot be accessed
        except IndexError:
            print(f"Hiba: Indexelési hiba az állapotban: {a}")
            return float('inf')

# --- Comparison Execution ---
if __name__ == "__main__":
    N = 10 # Define board size / number of queens
    initial_state = tuple([-1] * N + [0])
    kir = nyolckiralyno_problema(initial_state, N)

    print(f"Keresés {N} királynő problémára...")
    print("Kezdő állapot:", kir.kezdő)
    print("-" * 30)

    # --- Time Szélességi Fakereső (Breadth-First Search) ---
    print("Szélességi Fakereső indítása...")
    start_time_bfs = time.time()
    csucs_bfs = None # Initialize to None
    try:
        csucs_bfs = szélességi_fakereső(kir)
        end_time_bfs = time.time()
        print(f"Szélességi Fakereső befejezve.")
        print(f"Időtartam: {end_time_bfs - start_time_bfs:.4f} másodperc")
        if csucs_bfs:
            print("Megoldás (állapot):", csucs_bfs.állapot[:N])
            # Optional: Add path reconstruction if needed/possible
            # try:
            #     út_bfs = csucs_bfs.út() # Assuming 'út' method exists
            #     út_bfs.reverse()
            #     print("Út (BFS):", út_bfs)
            # except AttributeError:
            #     print("Nem sikerült az utat rekonstruálni (BFS).")
        else:
            print("Nincs megoldás (BFS).")
        # Optional: If your search function tracks expanded nodes, print it here
        # try:
        #    print(f"Kibontott csúcsok (BFS): {szélességi_fakereső.expanded_nodes}") # Example if static/class variable
        # except AttributeError:
        #    pass
    except ImportError:
        print("Hiba: A 'keres' modul vagy szükséges függvényei nem találhatóak.")
    except NameError:
        print("Hiba: A 'szélességi_fakereső' függvény nem található.")
    except Exception as e:
        print(f"Hiba történt a BFS keresés során: {e}")

    print("-" * 30)

    # --- Time Best-First Search ---
    print("Best-First Kereső indítása (heurisztikával)...")
    start_time_best = time.time()
    csucs_best = None # Initialize to None
    try:
        # Pass the static method correctly
        csucs_best = best_first(kir, nyolckiralyno_problema.heurisztika)
        end_time_best = time.time()
        print(f"Best-First Kereső befejezve.")
        print(f"Időtartam: {end_time_best - start_time_best:.4f} másodperc")
        if csucs_best:
            print("Megoldás (állapot):", csucs_best.állapot[:N])
            # Add path reconstruction if needed/possible
            try:
                út_best = csucs_best.út() # Assuming 'út' method exists
                út_best.reverse()
                print("Út (Best-First):", út_best)
            except AttributeError:
                 print("Nem sikerült az utat rekonstruálni (Best-First).")
        else:
            print("Nincs megoldás (Best-First).")
        # Optional: If your search function tracks expanded nodes, print it here
        # try:
        #    print(f"Kibontott csúcsok (Best-First): {best_first.expanded_nodes}") # Example if static/class variable
        # except AttributeError:
        #    pass
    except ImportError:
        print("Hiba: A 'keres' modul vagy szükséges függvényei nem találhatóak.")
    except NameError:
        print("Hiba: A 'best_first' függvény nem található.")
    except Exception as e:
        print(f"Hiba történt a Best-First keresés során: {e}")

    print("-" * 30)