package dk.adventurealley.app.Controllers;


import dk.adventurealley.app.DAO.ActivityRepository;
import dk.adventurealley.app.DAO.BookingRepository;
import dk.adventurealley.app.DAO.CustomerRepository;
import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ViewBookingController {

    @Autowired
    ActivityRepository activityRepository = new ActivityRepository();
    @Autowired
    BookingRepository bookingRepository = new BookingRepository();
    @Autowired
    CustomerRepository customerRepository = new CustomerRepository();

    ArrayList<Booking> bookingArray = new ArrayList<>();

    @GetMapping("/viewBooking")
    public String viewBooking(Model model){
        bookingArray = bookingRepository.readAll();
        model.addAttribute("booking", bookingArray);
        return "viewBooking";
    }



}
