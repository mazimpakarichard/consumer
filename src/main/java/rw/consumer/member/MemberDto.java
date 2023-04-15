/**
 * 
 */
package rw.consumer.member;

import java.util.UUID;

/**
 * The Class MemberDto.
 *
 * @author richard.mazimpaka
 */
public class MemberDto {

	/** The id. */
	private UUID id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The national id. */
	private String nationalId;

	/** The location. */
	private String location;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the national id.
	 *
	 * @return the national id
	 */
	public String getNationalId() {
		return nationalId;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

}
