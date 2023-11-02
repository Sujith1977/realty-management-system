package com.realtycare.realtymanagementsystem.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/**
 * @author Sujith1977
 *
 */

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId;
	private String customerName;
	private String customerEmail;
	private String customerPhoneNumber;
	private LocalDateTime customerCreatedTime;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private Set<Property> properties = new HashSet<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private Set<Agreement> agreements = new HashSet<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private Set<Bill> bills = new HashSet<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private Set<Report> reports = new HashSet<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private Set<Receipt> receipts = new HashSet<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private Set<Payment> payments = new HashSet<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private Set<ServiceRequest> serviceRequests = new HashSet<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private Set<Notification> notifications = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "customerSchedule",
        joinColumns = @JoinColumn(name = "customerId"),
        inverseJoinColumns = @JoinColumn(name = "scheduleId")
    )
    private Set<Schedule> schedules = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "customerService",
        joinColumns = @JoinColumn(name = "customerId"),
        inverseJoinColumns = @JoinColumn(name = "serviceId")
    )
    private Set<Service> services = new HashSet<>();
    
    public Customer(){
    	//default constructor
    }
    
    public Customer(String customerName, String customerEmail, String customerPhoneNumber, LocalDateTime customerCreatedTime, Address address) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerCreatedTime = customerCreatedTime;
        this.address = address;
    }
    
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return customerEmail;
    }

    public void setEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public Set<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(Set<Agreement> agreements) {
        this.agreements = agreements;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

    public Set<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Set<Receipt> receipts) {
        this.receipts = receipts;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Set<ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }

    public void setServiceRequests(Set<ServiceRequest> serviceRequests) {
        this.serviceRequests = serviceRequests;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
    
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", customerCreatedTime=" + customerCreatedTime +
                ", address=" + address +
                '}';
    }



}
