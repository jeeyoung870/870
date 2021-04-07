
public class ISpyChecker implements Dictionary, SpyChecker {	//스파이 가려내기
	
	private String [] names;
	private int nation;
	private String [] southP = { "박일", "박이", "김삼", "김사", "김오" };
	private String [] northP = new String [5]; 
	private String [] southS = {"박이", "김사"};
	private String [] northS = {"김일", "박사"};
	private boolean bomb;
	
	
	@Override
	public String[] checkS() {
		// TODO Auto-generated method stub
		String [] spyNames = new String [names.length];
		int count = 0;
		for (int i = 0; i < names.length; ++i) {
			if (nation == 0) {
				boolean clean = false;
				for (int j = 0; j < southS.length; ++j) {
					if (names[i] == southS[j]) { 
						spyNames [count++] = names[i];
					} 
				} 
				
			}
			else {
				if (nation == 1) {
					for (int j = 0; j < northS.length; j++) {
						if (names[i] == northS[j]) { 
						spyNames [count++] = names[i];
						}
					}
				}
			}
		}
		return spyNames;
	}
	
	@Override
	public void setNation(int n) {
		// TODO Auto-generated method stub
		this.nation = n;
	}
	
	@Override
	public void setNames(String[] names) {
		// TODO Auto-generated method stub
		this.names = names;
	}
	
	@Override
	public String[] checkNorth() {
		// TODO Auto-generated method stub
		int count = 0;
		for(String name : names) {
			boolean r = find(name);
			if(!r)		//r이 false면
				northP[count++] = name;
		}
		return northP;
	}
	
	public String[] checkSouth() {
		int count = 0;
		for (String name : names) {
			boolean r = find(name);
			if(r == true)
				southP[count++] = name;
		}
		return southP;
	}
	
	@Override
	public boolean find(String name) {
		// TODO Auto-generated method stub
		for (int j = 0; j < southP.length; ++j) {
			if (name.equals(southP[j])) {
				return true;
			}
		}
		return false;
	}
	
}
