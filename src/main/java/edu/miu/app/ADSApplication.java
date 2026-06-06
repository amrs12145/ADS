package edu.miu.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.domain.Appointment;
import edu.miu.domain.Dentist;
import edu.miu.domain.Patient;
import edu.miu.domain.Surgery;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ADSApplication {

    public static void main(String[] args) throws JsonProcessingException {

        // 1. Create Patients
        Patient john = new Patient(1L, "John", "Smith", "(641) 001-1234", LocalDate.of(1987, 1, 19));
        Patient anna = new Patient(2L, "Anna", "Jones", "(319) 716-1987", LocalDate.of(2001, 7, 26));
        Patient carlos = new Patient(3L, "Carlos", "Jimenez", "(319) 098-7711", LocalDate.of(1969, 11, 5));
        Patient albert = new Patient(4L, "Albert", "Einstein", "(641) 119-6142", LocalDate.of(1955, 12, 28));

        // 2. Create Dentist (can reuse one dummy if not given)
        Dentist dentist = new Dentist(1L, "Sarah", "Taylor");

        // 3. Create Surgery
        Surgery surgery = new Surgery(1L, "ADS Main Clinic", "Iowa City", "641-000-0000");

        // 4. Create Appointments
        List<Appointment> appointments = new ArrayList<>();

        appointments.add(new Appointment(1L, LocalDate.of(2026, 2, 28), LocalTime.of(10, 5), john, dentist, surgery));
        appointments.add(new Appointment(2L, LocalDate.of(2025, 12, 31), LocalTime.of(13, 45), anna, dentist, surgery));
        appointments.add(new Appointment(3L, LocalDate.of(2027, 5, 4), LocalTime.of(14, 0), carlos, dentist, surgery));
        appointments.add(new Appointment(4L, LocalDate.of(2026, 9, 16), LocalTime.of(11, 15), albert, dentist, surgery));

//        Sorting
        appointments.sort(
                Comparator.comparing(Appointment::getAppointmentDate).thenComparing(Appointment::getAppointmentTime).reversed()
        );


//        Printing
        System.out.println("\n\n\nALL APPOINTMENTS SORTED BY Date and Time in descending order\n\n\n");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(appointments));


//        Report
        int month = LocalDate.now().getMonthValue();
        int currentQuarter = (month - 1) / 3 + 1;
        final int nextQuarter;
        final int targetYear;
        if (currentQuarter == 4) {nextQuarter = 1;targetYear = LocalDate.now().getYear() + 1;} else {nextQuarter = currentQuarter + 1;targetYear = LocalDate.now().getYear();}

        List<Appointment> result = appointments.stream()
                .filter(a -> {
                    int apptQuarter = (a.getAppointmentDate().getMonthValue() - 1) / 3 + 1;
                    return apptQuarter == nextQuarter && a.getAppointmentDate().getYear() == targetYear;
                })
                .sorted(Comparator.comparing(Appointment::getAppointmentDate).thenComparing(Appointment::getAppointmentTime))
                .toList();

        System.out.println("\n\n\nNEXT QUARTER APPOINTMENTS SORTED ascending order\n\n\n");
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result));

    }
}