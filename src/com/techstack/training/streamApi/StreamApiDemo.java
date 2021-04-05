package com.techstack.training.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiDemo {

	public static class contact {
		String fname;
		String lname;
		String address_Line1;
		String city;
		String state;
		String zip_Code;
		String phone_no;
		String email;

		@Override
		public String toString() {
			return "contact [fname=" + fname + ", lname=" + lname + ", address_Line1=" + address_Line1 + ", city="
					+ city + ", state=" + state + ", zip_Code=" + zip_Code + ", phone_no=" + phone_no + ", email="
					+ email + "]";
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getAddress_Line1() {
			return address_Line1;
		}

		public void setAddress_Line1(String address_Line1) {
			this.address_Line1 = address_Line1;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZip_Code() {
			return zip_Code;
		}

		public void setZip_Code(String zip_Code) {
			this.zip_Code = zip_Code;
		}

		public String getPhone_no() {
			return phone_no;
		}

		public void setPhone_no(String phone_no) {
			this.phone_no = phone_no;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void add(String a, String b, String c, String d, String e, String f, String g, String h) {
			this.fname = a;
			this.lname = b;
			this.address_Line1 = c;
			this.city = d;
			this.state = e;
			this.zip_Code = f;
			this.phone_no = g;
			this.email = h;
		}
	}

	public static class address_book {

		String address_book_name;
		HashSet<contact> hs = new HashSet();

		public HashSet<contact> getHs() {
			return hs;
		}

		/**
		 * @param address_book_name
		 */
		public address_book(String address_book_name) {
			this.address_book_name = address_book_name;
		}

		public address_book() {
			super();
		}

		public String getAddress_book_name() {
			return address_book_name;
		}

		public void setAddress_book_name(String address_book_name) {
			this.address_book_name = address_book_name;
		}

	}

	@SuppressWarnings("resource")
	public static void main(String args[]) {

		System.out.println("Welcome to Address Book Program \n \n");
		Scanner keyboard = new Scanner(System.in);

		HashSet<address_book> addBookList = new HashSet<address_book>();
		String loopExit = "Y";
		String loopCheck = "Y";
		int count=0;
		while (!loopExit.equals("N")) {
			
			System.out.println("Please enter below options: \n" + "1. Create New Address Book. \n"
					+ "2. Add Contact to Existing Address Book. \n" + "3. Search across Address Books. \n"
					+ "4. Exit.\n" + "Value :");
			int choiceAddBook = 0;
			int choice = 0;
			//String loopCheck = "";
			choiceAddBook = keyboard.nextInt();
			keyboard.nextLine();
			address_book ab = new address_book();
			if (choiceAddBook == 1) {
				System.out.println("\n Enter the Address Book Name to Create");
				String addBookName = keyboard.nextLine();
				ab.setAddress_book_name(addBookName);
				System.out.println("Please select from below options: \n" + "1. Add Contact to Address Book.\n"
						+ "2. Update Contact to Address Book. \n" + "3. Delete Contact to Address Book. \n"
						+ "4. Search Contact from Address book using City \n" + "5. Exit.\n \n" + "Value :");
				choice = keyboard.nextInt();
				keyboard.nextLine();
				loopCheck="Y";
				count=0;
			} else if (choiceAddBook == 2) {
				System.out.println("\n Enter the Address Book Name to Search");
				String addBookName = keyboard.nextLine();
				address_book ab1 = addBookList.stream().filter(s -> s.address_book_name.equals(addBookName))
						.collect(Collectors.toList()).get(0);
				ab = ab1;
				System.out.println("Please select from below options: \n" + "1. Add Contact to Address Book.\n"
						+ "2. Update Contact to Address Book. \n" + "3. Delete Contact to Address Book. \n"
						+ "4. Search Contact from Address book using City \n" + "5. Exit.\n \n" + "Value :");
				choice = keyboard.nextInt();
				keyboard.nextLine();
				loopCheck="Y";
				count=0;
			} else if (choiceAddBook == 3) {
				System.out.println("\n Enter City to search contact");
				String city = keyboard.nextLine();
				List<contact> c = addBookList.stream().flatMap(a -> a.getHs().stream()).filter(s -> s.city.equals(city))
						.collect(Collectors.toList());
				System.out.println("Result : \n" + c.toString());
			}
			else if (choiceAddBook == 4) {
				break;			}
			while (!loopCheck.equals("N")) {
				if(count>0) {
					System.out.println("Please select from below options: \n" + "1. Add Contact to Address Book.\n"
							+ "2. Update Contact to Address Book. \n" + "3. Delete Contact to Address Book. \n"
							+ "4. Search Contact from Address book using City \n" + "5. Exit.\n \n" + "Value :");
					choice = keyboard.nextInt();
					keyboard.nextLine();
				}
				if (choice == 1) {
					contact c1 = new contact();
					System.out.print("\nPlease enter fname: ");
					String fname = keyboard.nextLine(); // local variable
					System.out.print("\nPlease enter lname: ");
					String lname = keyboard.nextLine();
					System.out.print("\nPlease enter addressLine1: ");
					String addressLine1 = keyboard.nextLine();
					System.out.print("\nPlease enter city: ");
					String city = keyboard.nextLine();
					System.out.print("\nPlease enter state: ");
					String state = keyboard.nextLine();
					System.out.print("\nPlease enter zip: ");
					String zip = keyboard.nextLine();
					System.out.print("\nPlease enter phone: ");
					String phone = keyboard.nextLine();
					System.out.print("\nPlease enter email: ");
					String email = keyboard.nextLine();
					c1.add(fname, lname, addressLine1, city, state, zip, phone, email);
					// Boolean b =
					List<contact> c = ab.hs.stream().filter(s -> s.fname.equals(fname))
							.peek(s -> System.out.println("Record Exist " + s)).collect(Collectors.toList());
					;
					if (c.size() == 0) {
						ab.hs.add(c1);
					}
				}

				else if (choice == 2) {
					System.out.println("\n Enter the First Name to Search");
					String name = keyboard.nextLine();
					int upChoice = 0;
					System.out.println("\n Enter your choice: \n" + "1. Update fname.\n" + "2. Update lname.\n"
							+ "3. Update phone.\n" + "4. Update email.\n" + "5. Update city.\n" + "6. Update state. \n"
							+ "7. Update zip.\n" + "Value");
					if (upChoice == 1) {
						System.out.println("\n Enter the First Name to update");
						String fname = keyboard.nextLine();
						ab.hs.stream().filter(s -> s.fname.equals(name)).findFirst().ifPresent(s -> s.setFname(fname));
					} else if (upChoice == 2) {
						System.out.println("\n Enter the Last Name to update");
						String lname = keyboard.nextLine();
						ab.hs.stream().filter(s -> s.fname.equals(name)).findFirst().ifPresent(s -> s.setLname(lname));
					} else if (upChoice == 3) {
						System.out.println("\n Enter the phone to update");
						String phone = keyboard.nextLine();
						ab.hs.stream().filter(s -> s.fname.equals(name)).findFirst()
								.ifPresent(s -> s.setPhone_no(phone));
					} else if (upChoice == 4) {
						System.out.println("\n Enter the email to update");
						String email = keyboard.nextLine();
						ab.hs.stream().filter(s -> s.fname.equals(name)).findFirst().ifPresent(s -> s.setEmail(email));
					} else if (upChoice == 5) {
						System.out.println("\n Enter the city to update");
						String city = keyboard.nextLine();
						ab.hs.stream().filter(s -> s.fname.equals(name)).findFirst().ifPresent(s -> s.setCity(city));
					} else if (upChoice == 6) {
						System.out.println("\n Enter the state to update");
						String state = keyboard.nextLine();
						ab.hs.stream().filter(s -> s.fname.equals(name)).findFirst().ifPresent(s -> s.setState(state));
					} else if (upChoice == 7) {
						System.out.println("\n Enter the zip to update");
						String zip = keyboard.nextLine();
						ab.hs.stream().filter(s -> s.fname.equals(name)).findFirst().ifPresent(s -> s.setZip_Code(zip));
					} else if (upChoice == 8) {
						System.out.println("\n Enter the Address Line1 to update");
						String addressLine1 = keyboard.nextLine();
						ab.hs.stream().filter(s -> s.fname.equals(name)).findFirst()
								.ifPresent(s -> s.setAddress_Line1(addressLine1));
					}
					// .anyMatch(s -> s.fname.equals(name))
					;
				}

				else if (choice == 3) {
					System.out.println("\n Enter the First Name to Delete Contact");
					String name = keyboard.nextLine();
					// Predicate<Item> isQualified = s -> s.fname.equals(name);
					// ab.hs.stream().filter(isQualified).findFirst();
					ab.hs.removeIf(s -> s.fname.equals(name));
				}

				else if (choice == 4) {
					System.out.println("\n Enter City to search contact");
					String city = keyboard.nextLine();
					List<contact> c = ab.hs.stream().filter(s -> s.city.equals(city)).collect(Collectors.toList());
					System.out.println("Result : \n" + c.toString());
				}

				else if (choice == 5) {
					System.out.println("\n Exiting the program");
					break;
				}
				count++;
				System.out.println("\nDo you want to continue:(Y/N) ");
				loopCheck = keyboard.nextLine();
			}
			System.out.println(ab.hs.toString());
			String name=ab.address_book_name;
			addBookList.removeIf(s->s.address_book_name.equals(name));
			addBookList.add(ab);
			System.out.println("\nDo you want to continue:(Y/N) ");
			loopExit = keyboard.nextLine();
		}
		//System.out.println(addBookList.stream().toString());
	}
}
