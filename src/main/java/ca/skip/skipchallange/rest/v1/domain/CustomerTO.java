package ca.skip.skipchallange.rest.v1.domain;

import java.time.LocalDateTime;

public final class CustomerTO {

	public Long id;

	public String email;

	public String name;

	public String address;

	public LocalDateTime creation;

	public String password;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", name=" + name + ", address=" + address + ", creation="
				+ creation + ", password=" + password + "]";
	}

}