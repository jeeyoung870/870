package ParentGeneric;

public class Tv {
	private String company;
	private String product;
	
	public Tv(String com, String pd) {
		this.company = com;
		this.product = pd;
	}

	public String getCompany() {
		return company;
	}

	public String getProduct() {
		return product;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return company + product;
	}
	
	

}
