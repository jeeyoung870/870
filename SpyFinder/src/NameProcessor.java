
public class NameProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ISpyChecker spyChecker = new ISpyChecker ();
		SpyChecker sc = spyChecker;
		String [] agora = {"박일", "박이", "박삼", "박사", "박오", "김일", "김이", "김삼", "김사", "김오"};
		String [] north;
		String [] south;
		String [] sSpy;
		String [] nSpy;
		
		sc.setNames(agora);
		// sc.checkNation();
		
		north = sc.checkNorth();
		System.out.println("<북한 국적>");
		for(int i = 0; i < north.length; ++i) {
			System.out.println(north[i]);
		}
		System.out.println();
		
		south = sc.checkSouth();
		System.out.println("<남한 국적>");
		for(int i = 0; i < south.length; ++i) {
			System.out.println(south[i]);
		}
		
		System.out.println();
		
		//국적 설정 - 남한=0, 북한=1
		sc.setNation(0);
		sc.checkS();
		sSpy = sc.checkS();
		System.out.println("!!!!남한 간첩!!!!");
		for(int i = 0; i < sSpy.length; ++i) {
			if (sSpy[i] != null)
			System.out.println(sSpy[i]);
		}
		System.out.println();
		sc.setNation(1);
		sc.checkS();
		nSpy = sc.checkS();
		System.out.println("!!!!북한 간첩!!!!");
		for(int i = 0; i < nSpy.length; ++i) {
			if (nSpy[i] != null)
			System.out.println(nSpy[i]);
		}
		
		
		
	}

}
