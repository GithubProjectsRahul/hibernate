package com.projects.github.hibernate;

import com.projects.github.hibernate.repository.CustomerRepository;
import com.projects.github.hibernate.repository.GuideRepository;
import com.projects.github.hibernate.repository.MessageRepository;
import com.projects.github.hibernate.repository.MovieRepository;
import com.projects.github.hibernate.repository.PersonRepository;
import com.projects.github.hibernate.repository.StudentRepository;
import com.projects.github.hibernate.service.MovieService;
import com.projects.github.hibernate.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

	private MessageRepository messageRepository;
	private PersonRepository personRepository;
	private StudentRepository studentRepository;
	private GuideRepository guideRepository;
	private StudentService studentService;
	private CustomerRepository customerRepository;
	private MovieRepository movieRepository;
	private MovieService movieService;

	public HibernateApplication(MessageRepository messageRepository, PersonRepository personRepository, StudentRepository studentRepository, GuideRepository guideRepository, StudentService studentService, CustomerRepository customerRepository, MovieRepository movieRepository, MovieService movieService) {
		this.messageRepository = messageRepository;
		this.personRepository = personRepository;
		this.studentRepository = studentRepository;
		this.guideRepository = guideRepository;
		this.studentService = studentService;
		this.customerRepository = customerRepository;
		this.movieRepository = movieRepository;
		this.movieService = movieService;
	}

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Persist
		/*Message message = new Message("Hello World");
		messageRepository.save(message);*/

		// Read
		/*Optional<Message> byId = messageRepository.findById(1L);
		System.out.println(byId.get());*/

		// Update
		/*Optional<Message> updateMessage = messageRepository.findById(1L);
		updateMessage.get().setText("Hello World Updated");
		messageRepository.save(updateMessage.get());*/

		// Delete
		/*Optional<Message> deleteMessage = messageRepository.findById(1L);
		messageRepository.delete(deleteMessage.get());*/


		// ***********************************************************************
		// Person and Address, person is entity type object and address is value type object

		/*Address homeAddress = new Address();
		homeAddress.setCity("Gurgoan");
		homeAddress.setStreet("Synera 81");
		homeAddress.setZipcode("122004");

		Address billingAddress = new Address();
		billingAddress.setCity("Gurgoan");
		billingAddress.setStreet("NSEZ Tech Part");
		billingAddress.setZipcode("122001");

		Person person = new Person();
		person.setName("Rahul Choudhary");
		person.setHomeAddress(homeAddress);
		person.setBillingAddress(billingAddress);*/

		// Persist
		//personRepository.save(person);

		// Read
		/*Optional<Person> personById = personRepository.findById(1L);
		System.out.println(personById.get());*/

		// Update
		/*Optional<Person> personById = personRepository.findById(1L);
		personById.get().setName("Shalu Choudhary");
		personById.get().getHomeAddress().setStreet("2105 Synera Sector 81");
		personRepository.save(personById.get());*/

		// Delete
		/*Optional<Person> personById = personRepository.findById(1L);
		personRepository.delete(personById.get());*/

		// ***********************************************************************
		// Student and Guide, 1 Guide can guide Many Students
		// Persist -> first Guide then Student
		// Delete -> first Student then Guide

		// Persist
		/*Guide guide = new Guide();
		guide.setName("Shalu");
		guide.setSalary("25000");
		guide.setStaffId("1212");

		Student student = new Student();
		student.setEnrollmentId("A1B2");
		student.setName("Surya");
		student.setGuide(guide);

		guideRepository.save(guide);
		studentRepository.save(student);*/

		// Read
		/*Optional<Guide> findGuide = guideRepository.findById(1L);
		System.out.println(findGuide.get());

		Optional<Student> findStudent = studentRepository.findById(1L);
		System.out.println(findStudent.get());*/

		// update
		/*Optional<Guide> findGuide = guideRepository.findById(1L);
		findGuide.get().setName("Shalu Choudhary");
		guideRepository.save(findGuide.get());

		Optional<Student> findStudent = studentRepository.findById(1L);
		findStudent.get().setEnrollmentId("A1B2C3");
		studentRepository.save(findStudent.get());*/

		// Delete : Order Matters, Student has FK Constraint so it should be deleted first
		/*Optional<Student> findStudent = studentRepository.findById(1L);
		studentRepository.delete(findStudent.get());

		Optional<Guide> findGuide = guideRepository.findById(1L);
		guideRepository.delete(findGuide.get());*/


		// ***********************************************************************
		// Student and Guide, this time we will going to add Cascade to Student Object, so that we can save whole object graph in 1 go
		// instead of saving guide first & then student

	  /* // This scenario will work when we dont have cascade persist, adding back cascade persist
	    Guide guide = new Guide();
		guide.setName("Shalu");
		guide.setSalary("25000");
		guide.setStaffId("1212");

		Student student = new Student();
		student.setEnrollmentId("A1");
		student.setName("Surya");
		student.setGuide(guide);

		Student student2 = new Student();
		student2.setEnrollmentId("B2");
		student2.setName("Global");
		student2.setGuide(guide);

		guideRepository.save(guide);

		studentRepository.save(student);
		studentRepository.save(student2);*/

		// Delete : Remove cascade remove from many to one as recommended
		/*Optional<Student> findStudent = studentRepository.findById(1L);
		findStudent.get().setGuide(null);
		studentRepository.delete(findStudent.get());*/


		// ***********************************************************************
		// Student and Guide, bidirectional

		// Persist
		/*Guide guide1 = new Guide();
		guide1.setName("guide 1");
		guide1.setStaffId("Staff ID 1");
		guide1.setSalary("1000");

		Guide guide2 = new Guide();
		guide2.setName("guide 2");
		guide2.setStaffId("Staff ID 2");
		guide2.setSalary("2000");

		Student student1 = new Student();
		student1.setName("Student 1");
		student1.setEnrollmentId("Enrollment 1");
		student1.setGuide(guide1);

		Student student2 = new Student();
		student2.setName("Student 2");
		student2.setEnrollmentId("Enrollment 2");
		student2.setGuide(guide1);

		guide1.getStudent().add(student1);
		guide1.getStudent().add(student2);

		guideRepository.save(guide1);
		guideRepository.save(guide2);*/

		// Update
		// guide is no the owner so we need to add the helper method addStudent(), otherwise guide won't update student
		// student is owner of relationship, if we update student then it will update guide as well
		//studentService.updateStudent();

		// ***********************************************************************
		// Customer & Passport, OneToOne Bidirectional

		/*Passport passport = new Passport();
		passport.setPassportNumber("A1B2C3");

		Customer customer = new Customer();
		customer.setName("Rahul Choudhary");
		customer.setPassport(passport);

		customerRepository.save(customer);*/

		// ***********************************************************************
		// Orphan Removal True, let suppose we have 2 guide and 3 students, student 1 point to guide 1 & student 2,3 point to guide 2
		// now when

		// ***********************************************************************
		// Movie & Actor, ManyToMany Bidirectional
		// movieService.addMovie();


	}
}
