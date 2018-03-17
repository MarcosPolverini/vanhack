package ca.skip.skipchallange.rest.v1.domain;

public final class StoreTO {

	public Long id;

	public String name;

	public String address;

	public Long cousineId;

	public StoreTO() {
	}

	public StoreTO(Long id, String name, String address, Long cousineId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.cousineId = cousineId;
	}

}