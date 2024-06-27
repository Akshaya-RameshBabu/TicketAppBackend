package com.example.demo.ticket;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table
@Getter@Setter@NoArgsConstructor
public class TicketFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	 @Column(length=100)
	private String Description;
	private String Priority;
	private String Status;
	private LocalDate createdDate;
	private String CustomerName;
	private String customerEmail;
	private String phone;

}
