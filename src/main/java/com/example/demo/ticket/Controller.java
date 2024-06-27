package com.example.demo.ticket;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controller {
	@Autowired
	private TicketFieldRepo ticketrepo;
	
	@GetMapping("/getTickets")
	public ResponseEntity<?>GetTickets(){
		try {
		List<TicketFields> tickets= ticketrepo.findAll();
		return ResponseEntity.ok(tickets);
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@PostMapping("/createTicket")
	public ResponseEntity<?>SaveTickets(@RequestBody TicketFields ticket){
		try {
			ticket.setCreatedDate(LocalDate.now());
			ticketrepo.save(ticket);	
		return ResponseEntity.ok().body("Ticket Saved");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getTickets/{id}")
	public ResponseEntity<?>GetTicketbyid(@PathVariable Long id){
		try {
		TicketFields ticket= ticketrepo.findById(id).orElse(null);
		return ResponseEntity.ok(ticket);
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/DeleteTicket/{id}")
	public ResponseEntity<?>DeleteTicketByid(@PathVariable Long id){
		try {
			ticketrepo.deleteById(id);
		return ResponseEntity.ok(" Ticket Deleted Sucessfully");
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
