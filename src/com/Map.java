package com;

public class Map {
	
	private static String _1
	= "    XXXXXX\n"
	+ "    XX   X\n"
	+ "    XX*  X\n"
	+ "  XXXX  *XX\n"
	+ "  XX  * * X\n"
	+ "XXXX X XX X   XXXXXX\n"
	+ "XX   X XX XXXXX  ..X\n"
	+ "XX *  *          ..X\n"
	+ "XXXXXX XXX X@XX  ..X\n"
	+ "    XX     XXXXXXXXX\n"
	+ "    XXXXXXXX\n";
	
	private static String _2
	= "XXXXXXXXXXXX\n"
	+ "X..  X     XXX\n"
	+ "X..  X *  *  X\n"
	+ "X..  X*XXXX  X\n"
	+ "X..    @ XX  X\n"
	+ "X..  X X  * XX\n"
	+ "XXXXXX XX* * X\n"
	+ "  X *  * * * X\n"
	+ "  X    X     X\n"
	+ "  XXXXXXXXXXXX\n";
	
	private static String _3
	= "        XXXXXXXX \n"
	+ "        X     @X \n"
	+ "        X *X* XX \n"
	+ "        X *  *X  \n"
	+ "        XX* * X  \n"
	+ "XXXXXXXXX * X XXX\n"
	+ "X....  XX *  *  X\n"
	+ "XX...    *  *   X\n"
	+ "X....  XXXXXXXXXX\n"
	+ "XXXXXXXX\n";
	
	private static String _4
	= "              XXXXXXXX\n"
	+ "              X  ....X\n"
	+ "   XXXXXXXXXXXX  ....X\n"
	+ "   X    X  * *   ....X\n"
	+ "   X ***X*  * X  ....X\n"
	+ "   X  *     * X  ....X\n"
	+ "   X ** X* * *XXXXXXXX\n"
	+ "XXXX  * X     X       \n"
	+ "X   X XXXXXXXXX       \n"
	+ "X    *  XX            \n"
	+ "X **X** @X            \n"
	+ "X   X   XX            \n"
	+ "XXXXXXXXX             \n";
	
	private static String _5
	= "        XXXXX    \n"
	+ "        X   XXXXX\n"
	+ "        X X*XX  X\n"
	+ "        X     * X\n"
	+ "XXXXXXXXX XXX   X\n"
	+ "X....  XX *  *XXX\n"
	+ "X....    * ** XX \n"
	+ "X....  XX*  * @X \n"
	+ "XXXXXXXXX  *  XX \n"
	+ "        X * *  X \n"
	+ "        XXX XX X \n"
	+ "          X    X \n"
	+ "          XXXXXX \n";

	private static String _6
	= "XXXXXX  XXX \n"
	+ "X..  X XX@XX\n"
	+ "X..  XXX   X\n"
	+ "X..     ** X\n"
	+ "X..  X X * X\n"
	+ "X..XXX X * X\n"
	+ "XXXX * X*  X\n"
	+ "   X  *X * X\n"
	+ "   X *  *  X\n"
	+ "   X  XX   X\n"
	+ "   XXXXXXXXX\n";
	
	private static String _7
	= "       XXXXX \n"
	+ " XXXXXXX   XX\n"
	+ "XX X @XX ** X\n"
	+ "X    *      X\n"
	+ "X  *  XXX   X\n"
	+ "XXX XXXXX*XXX\n"
	+ "X *  XXX ..X \n"
	+ "X * * * ...X \n"
	+ "X    XXX...X \n"
	+ "X ** X X...X \n"
	+ "X  XXX XXXXX \n"
	+ "XXXX  \n";
	
	private static String _8
	= "  XXXX          \n"
	+ "  X  XXXXXXXXXXX\n"
	+ "  X    *   * * X\n"
	+ "  X *X * X  *  X\n"
	+ "  X  * *  X    X\n"
	+ "XXX *X X  XXXX X\n"
	+ "X@X* * *  XX   X\n"
	+ "X    * X*X   X X\n"
	+ "XX  *    * * * X\n"
	+ " XXXX  XXXXXXXXX\n"
	+ "  XXX  XXX      \n"
	+ "  X      X      \n"
	+ "  X      X      \n"
	+ "  X......X      \n"
	+ "  X......X      \n"
	+ "  X......X      \n"
	+ "  XXXXXXXX    \n";
	
	private static String _9
	= "          XXXXXXX\n"
	+ "          X  ...X\n"
	+ "      XXXXX  ...X\n"
	+ "      X      ...X\n"
	+ "      X  XX  ...X\n"
	+ "      XX XX  ...X\n"
	+ "     XXX XXXXXXXX\n"
	+ "     X *** XX    \n"
	+ " XXXXX  * * XXXXX\n"
	+ "XX   X* *   X   X\n"
	+ "X@ *  *    *  * X\n"
	+ "XXXXXX ** * XXXXX\n"
	+ "     X *    X    \n"
	+ "     XXXX XXX    \n"
	+ "        X  X     \n"
	+ "        X  X     \n"
	+ "        X  X     \n"
	+ "        XXXX     \n";
	
	private static String _10
	= "              XXXX   \n"
	+ "         XXXXXX  X   \n"
	+ "         X       X   \n"
	+ "         X  XXXX XXX \n"
	+ " XXX  XXXXX XXX    X \n"
	+ "XX@XXXX   *** X    X \n"
	+ "X **   ** *   X....XX\n"
	+ "X  ***X    *  X.....X\n"
	+ "X *   X ** ** X.....X\n"
	+ "XXX   X  *    X.....X\n"
	+ "  X   X * * * X.....X\n"
	+ "  X XXXXXXX XXX.....X\n"
	+ "  X   X  * *  X.....X\n"
	+ "  XXX X ** * *XXXXXXX\n"
	+ "    X X  *      X    \n"
	+ "    X X *** *** X    \n"
	+ "    X X       X X    \n"
	+ "    X XXXXXXXXX X    \n"
	+ "    X           X    \n"
	+ "    XXXXXXXXXXXXX    \n";

	
	/** 
	 * @param lv
	 * @return String
	 */
	public static String get(int lv) {
		switch(lv) {
			case 2: return _2;
			case 3: return _3;
			case 4: return _4;
			case 5: return _5;
			case 6: return _6;
			case 7: return _7;
			case 8: return _8;
			case 9: return _9;
			case 10: return _10;
		}
		return _1;
	}

}
