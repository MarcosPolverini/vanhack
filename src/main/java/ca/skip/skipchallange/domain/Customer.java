package ca.skip.skipchallange.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import ca.skip.skipchallange.exception.BadCredentialsException;

public final class Customer {

	@Id
	private Long id;

	private String email;

	private String name;

	private String address;

	private LocalDateTime creation;

	private String password;

	public Customer() {
	}

	public Customer(Long id, String email, String name, String address, LocalDateTime creation, String password) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.address = address;
		this.creation = creation;
		this.password = password;
	}

	public void validatePassword(String password) throws BadCredentialsException {
		// Need cripto
		if (this.password == null || !this.password.equals(password)) {
			throw new BadCredentialsException();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}