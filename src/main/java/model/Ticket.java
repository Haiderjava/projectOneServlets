package model;

public class Ticket {

	private int id;
	private int amount;
	private long submited;
	private long resolved;
	private String desc;
	// private receipt ;
	private int author;
	private int resolver;
	private int r_status_id;
	private int r_type_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getSubmited() {
		return submited;
	}

	public void setSubmited(long submited) {
		this.submited = submited;
	}

	public long getResolved() {
		return resolved;
	}

	public void setResolved(long resolved) {
		this.resolved = resolved;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getR_status_id() {
		return r_status_id;
	}

	public void setR_status_id(int r_status_id) {
		this.r_status_id = r_status_id;
	}

	public int getR_type_id() {
		return r_type_id;
	}

	public void setR_type_id(int r_type_id) {
		this.r_type_id = r_type_id;
	}

	public Ticket(int amount, long submited, long resolved, String desc, int author, int resolver, int r_status_id,
			int r_type_id, int id) {
		super();
		this.amount = amount;
		this.submited = submited;
		this.resolved = resolved;
		this.desc = desc;
		this.author = author;
		this.resolver = resolver;
		this.r_status_id = r_status_id;
		this.r_type_id = r_type_id;
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + author;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + id;
		result = prime * result + r_status_id;
		result = prime * result + r_type_id;
		result = prime * result + (int) (resolved ^ (resolved >>> 32));
		result = prime * result + resolver;
		result = prime * result + (int) (submited ^ (submited >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (amount != other.amount)
			return false;
		if (author != other.author)
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (id != other.id)
			return false;
		if (r_status_id != other.r_status_id)
			return false;
		if (r_type_id != other.r_type_id)
			return false;
		if (resolved != other.resolved)
			return false;
		if (resolver != other.resolver)
			return false;
		if (submited != other.submited)
			return false;
		return true;
	}

	// Alt +shif+s to genrate methods
	
	

}
