package main;

import java.util.Scanner;
import java.sql.Date;
import dao.PatientDAO;
import dao.DoctorDAO;
import dao.AppointmentDAO;

public class HospitalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. View Appointments");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Patient ID: ");
                    int pid = sc.nextInt();

                    System.out.print("Name: ");
                    String pname = sc.next();

                    System.out.print("Age: ");
                    int age = sc.nextInt();

                    System.out.print("Gender: ");
                    String gender = sc.next();

                    System.out.print("Disease: ");
                    String disease = sc.next();

                    System.out.print("Phone: ");
                    String pphone = sc.next();

                    patientDAO.addPatient(
                        pid, pname, age, gender, disease, pphone
                    );
                    break;

                case 2:
                    System.out.print("Doctor ID: ");
                    int did = sc.nextInt();

                    System.out.print("Name: ");
                    String dname = sc.next();

                    System.out.print("Specialization: ");
                    String spec = sc.next();

                    System.out.print("Phone: ");
                    String dphone = sc.next();

                    doctorDAO.addDoctor(
                        did, dname, spec, dphone
                    );
                    break;

                case 3:
                    doctorDAO.viewDoctors();
                    break;

                case 4:
                    System.out.print("Appointment ID: ");
                    int aid = sc.nextInt();

                    System.out.print("Patient ID: ");
                    int apPid = sc.nextInt();

                    System.out.print("Doctor ID: ");
                    int apDid = sc.nextInt();

                    System.out.print("Appointment Date (yyyy-mm-dd): ");
                    String dateStr = sc.next();

                    Date appDate = Date.valueOf(dateStr);

                    appointmentDAO.bookAppointment(
                        aid, apPid, apDid, appDate
                    );
                    break;

                case 5:
                    appointmentDAO.viewAppointments();
                    break;

                case 6:
                    System.out.println("Exiting application...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
