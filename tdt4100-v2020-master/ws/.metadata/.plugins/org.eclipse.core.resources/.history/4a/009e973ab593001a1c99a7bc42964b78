package bike;

import java.time.LocalDateTime;
import java.util.Collection;

public class BikeRental {

	// TODO: del 1, stations and bikes

	/**
	 * Counts the number of available bikes within a certain distance of a provided location.
	 * @param location
	 * @param distance
	 * @return the number of available bikes within a certain distance of a provided location
	 */
	private int countAvailableBikesNearby(final GeoLocation location, final double distance) {
		// TODO: del 1
	}

	/**
	 * Finds the closest station (location) within the provided (maximum) distance of the provided bike
	 * @param bike
	 * @param minDistance
	 * @return the closest station (location) within the provided (maximum) distance of the provided bike
	 */
	private GeoLocation getStationNearby(final Bike bike, final double maxDistance) {
		// TODO: del 1
	}

	/**
	 * @return the bikes that currently are rented
	 */
	private Collection<Bike> getRentedBikes() {
		// TODO: del 1
	}

	/**
	 * @return the bikes that are close to a station (within 30 meters), but still are rented
	 */
	private Collection<Bike> getUnreturnedBikes() {
		// TODO: del 1
	}

	/**
	 * Called when a person starts renting a bike by taking it from a station.
	 * Checks the arguments before registering all necessary info of the rental.
	 * @param person
	 * @param now the start time of the rental
	 * @param returnTime the expected return time
	 * @throws (some subclass of) RuntimeException if the now isn't before returnTime
	 * @throws (some subclass of) RuntimeException if the bike isn't available for rental
	 */
	public void rentBike(final Person person, final Bike bike, final LocalDateTime now, final LocalDateTime returnTime) {
		// TODO: del 1
	}

	/**
	 * Called when a person extends an ongoing bike rental.
	 * Checks the arguments before registering all necessary info of the rental extension.
	 * @param person
	 * @param bike
	 * @param now the time the extension starts
	 * @param returnTime the (new) expected return time
	 * @throws (some subclass of) RuntimeException if the now isn't before returnTime
	 * @throws (some subclass of) RuntimeException if the bike isn't currently being rented
	 * @throws (some subclass of) RuntimeException if person isn't currently renting the bike
	 */
	public void extendRental(final Person person, final Bike bike, final LocalDateTime now, final LocalDateTime returnTime) {
		// TODO: del 1
	}

	/**
	 * Called when a person returns a bike.
	 * Checks the arguments, computes the price, performs the payment and clears the rental info.
	 * Note that if the payment isn't completed, the rental info should not be cleared.
	 * @param person
	 * @param bike
	 * @param now the time the bike is returned
	 * @throws (some subclass of) RuntimeException if the bike isn't currently being rented by the person argument
	 * @throws (some subclass of) RuntimeException if person isn't near (within 30 meters of) a station
	 */
	public void returnBike(final Person person, final Bike bike, final LocalDateTime now) {
		// TODO: del 1
	}

	public static void main(final String[] args) {
		// Some geo-locations to use in testing:
		// In the hall outside F1: 63.416522, 10.403345
		// By the entrance to Realfagsbygget closest to F1: 63.416017, 10.404729
		// Another spot by the same entrance, closer than 30 meters: 63.416079, 10.404565
		System.out.println(GeoLocation.distance(63.416017, 10.404729, 63.416079, 10.404565));
	}
}
