package space.bumtiger.edbExer.model;

import java.util.Objects;

public class Car {
	private Long id;
	private String name;
	private int price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car) o;
		return price == car.price && Objects.equals(id, car.id)
				&& Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("자동차{");
		sb.append("아이디=").append(id);
		sb.append(", 이름='").append(name).append('\'');
		sb.append(", 가격=").append(price);
		sb.append('}');
		return sb.toString();
	}
}
