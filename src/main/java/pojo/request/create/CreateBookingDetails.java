package pojo.request.create;

public class CreateBookingDetails {
	public String firstname;
	public String lastname;
	public int totalprice;
	public boolean depositpaid;
	public String additionalneeds;
	public BookingDates_POJO bookingdates;

	public BookingDates_POJO getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(BookingDates_POJO bookingdates) {
		this.bookingdates = bookingdates;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additionalneeds == null) ? 0 : additionalneeds.hashCode());
		result = prime * result + ((bookingdates == null) ? 0 : bookingdates.hashCode());
		result = prime * result + (depositpaid ? 1231 : 1237);
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + totalprice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		CreateBookingDetails other = (CreateBookingDetails) obj;
		if (additionalneeds == null) {
			if (other.additionalneeds != null)
				return false;
		} else if (!additionalneeds.equals(other.additionalneeds))
			return false;
		if (bookingdates == null) {
			if (other.bookingdates != null)
				return false;
		} else if (!bookingdates.equals(other.bookingdates))
			return false;
		if (depositpaid != other.depositpaid)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (totalprice != other.totalprice)
			return false;
		return true;
	}
	
	
}
