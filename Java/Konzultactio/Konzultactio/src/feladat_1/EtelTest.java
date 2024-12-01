package feladat_1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

//ZH-n: asserFalse, asserTrue, assertEquals, assertNotEquals, assertThrows, assertThrowsExactly

class EtelTest {

    @Test
    void getNev() throws EtelException {
        Etel e1 = new Etel("paradicsom leves","0",2, LocalDate.of(2024,1,1),"leves");
        assertEquals("paradicsom leves",e1.getNev()/*,delta*/); // a deltával meg tudjuk adni, ohgy hány tizedesjegy pontosággal vegye a teszten, ha számot adunk meg
        assertThrows(EtelException.class,()->e1.getNev()); //<---- meg tudjuk adni, hogy mire dobja azt a kivételt pl.: ha lenne setAr( akkor arra
    }
}