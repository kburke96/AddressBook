package com.kevin.addressbook;

import java.util.List;
import java.util.Scanner;

import com.kevin.addressbook.Model.Address;
import com.kevin.addressbook.Model.Person;
import com.kevin.addressbook.Repository.AddressRepository;
import com.kevin.addressbook.Repository.PersonRepository;
import com.kevin.addressbook.Service.AddressService;
import com.kevin.addressbook.Service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressbookApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private PersonService personService;

	@Autowired
	private AddressService addressService;

	public static void main(String[] args) {
		SpringApplication.run(AddressbookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Seed data
		Address address1 = Address.builder().street("Main St").city("Limerick").state("Ireland").postalCode("W34V21")
				.build();
		Person person1 = Person.builder().firstName("Kevin").lastName("Burke").address(address1).build();

		addressRepo.save(address1);
		personRepo.save(person1);

		Scanner scanner = new Scanner(System.in);
		int option = 0;

		while (option != 9) {
			System.out.println("\n\n-- Address Book Main Menu --");
			System.out.println("Please select an option:");
			System.out.println("1 - Add a person");
			System.out.println("2 - Edit a person");
			System.out.println("3 - Delete a person");
			System.out.println("4 - Add an address to a person");
			System.out.println("5 - Edit an address");
			System.out.println("6 - Delete an address");
			System.out.println("7 - List Persons");
			System.out.println("8 - Count Persons");
			System.out.println("9 - Exit\n\n");

			option = scanner.nextInt();
			if (option > 9 || option < 0) {
				System.out.println("Sorry, that option is not supported. Exiting");
				System.exit(-1);
			}

			List<Person> allPersons = personService.getAll();
			List<Address> allAddresses = addressService.getAll();

			switch (option) {
				case 1:
					System.out.println("First name: ");
					String firstName = scanner.next();
					System.out.println("Last Name: ");
					String lastName = scanner.next();
					Person newPerson = Person.builder().firstName(firstName).lastName(lastName).build();
					personService.addPerson(newPerson);
					System.out.println("New person added!");
					break;
				case 2:
					System.out.println("Edit a person.....");
					allPersons.forEach(System.out::println);
					System.out.println("Please provide the ID of the Person to edit: ");
					int idToUpdate = scanner.nextInt();
					System.out.println("First name: ");
					String newFirstName = scanner.next();
					System.out.println("Last Name: ");
					String newLastName = scanner.next();
					personService.updatePerson(idToUpdate, newFirstName, newLastName);
					break;
				case 3:
					allPersons.forEach(System.out::println);
					System.out.println("Please provide the ID of the Person to delete: ");
					int idToDelete = scanner.nextInt();
					personService.deletePerson(idToDelete);
					break;
				case 4:
					allPersons.forEach(System.out::println);
					System.out.println("Please provide the ID of the Person to add address to: ");
					int idToAddAddress = scanner.nextInt();
					System.out.println("Street: ");
					String street = scanner.next();
					System.out.println("City: ");
					String city = scanner.next();
					System.out.println("State: ");
					String state = scanner.next();
					System.out.println("Postal Code: ");
					String postalCode = scanner.next();
					Address newAddress = Address.builder().street(street).city(city).state(state).postalCode(postalCode)
							.build();
					personService.addAddressToPerson(idToAddAddress, newAddress);
					System.out.println("New address added!");
					break;
				case 5:
					System.out.println("Edit an address.....");
					allAddresses.forEach(System.out::println);
					System.out.println("Please provide the ID of the Address to edit: ");
					int addressIdToUpdate = scanner.nextInt();
					System.out.println("Street: ");
					String newStreet = scanner.next();
					System.out.println("City: ");
					String newCity = scanner.next();
					System.out.println("State: ");
					String newState = scanner.next();
					System.out.println("Postal Code: ");
					String newPostalCode = scanner.next();
					addressService.updateAddress(addressIdToUpdate, newStreet, newCity, newState, newPostalCode);
					System.out.println("Address updated!");
					break;
				case 6:
					System.out.println("Please select an Address ID to delete: ");
					allAddresses.forEach(System.out::println);
					idToDelete = scanner.nextInt();
					//addressService.deleteAddress(idToDelete);  // This doesn't work because Address and Person are coupled.
					System.out.println("Sorry, this option does not work yet. Address has not been deleted.");
					break;
				case 7:
					System.out.println("Finding all Persons...");
					allPersons.forEach(System.out::println);
					break;
				case 8:
					System.out.println(
							"\n\nThe number of Persons currently in the database is: " + personService.countPersons());
					break;

			}
		}

		scanner.close();

		System.out.println("Finished, bye!");

	}

}
