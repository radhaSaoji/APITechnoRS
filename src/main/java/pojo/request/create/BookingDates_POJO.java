package pojo.request.create;

public class BookingDates_POJO {

	public String checkin;
	public String checkout;

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkin == null) ? 0 : checkin.hashCode());
		result = prime * result + ((checkout == null) ? 0 : checkout.hashCode());
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
		BookingDates_POJO other = (BookingDates_POJO) obj;
		if (checkin == null) {
			if (other.checkin != null)
				return false;
		} else if (!checkin.equals(other.checkin))
			return false;
		if (checkout == null) {
			if (other.checkout != null)
				return false;
		} else if (!checkout.equals(other.checkout))
			return false;
		return true;
	}
	
	
}
