package com.realtycare.realtymanagementsystem.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Agreement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long agreementId;

	private String agreementTitle;
	private String agreementType;
	private String agreementDescription;
	private String agreementStatus;
	private LocalDate agreementStartDate;
	private LocalDate agreementEndDate;

	@ManyToOne
	@JoinTable(name = "tenantId")
	private Tenant tenant;

	@ManyToOne
	@JoinTable(name = "agreementTemplateId")
	private AgreementTemplate agreementTemplate;

	@ManyToOne
	@JoinTable(name = "customerId")
	private Customer customer;

	@ManyToOne
	@JoinTable(name = "propertyId")
	private Property property;

	@OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL)
	Set<Notification> notifications = new HashSet<>();

	// Constructors, getters, setters and toString
	
	public Agreement() {
		// default constructor
		super();
	}

	public Agreement(String agreementTitle, String agreementType, String agreementDescription, String agreementStatus,
			LocalDate agreementStartDate, LocalDate agreementEndDate) {
		super();
		this.agreementTitle = agreementTitle;
		this.agreementType = agreementType;
		this.agreementDescription = agreementDescription;
		this.agreementStatus = agreementStatus;
		this.agreementStartDate = agreementStartDate;
		this.agreementEndDate = agreementEndDate;
	}

	public long getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(long agreementId) {
		this.agreementId = agreementId;
	}

	public String getAgreementTitle() {
		return agreementTitle;
	}

	public void setAgreementTitle(String agreementTitle) {
		this.agreementTitle = agreementTitle;
	}

	public String getAgreementType() {
		return agreementType;
	}

	public void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
	}

	public String getAgreementDescription() {
		return agreementDescription;
	}

	public void setAgreementDescription(String agreementDescription) {
		this.agreementDescription = agreementDescription;
	}

	public String getAgreementStatus() {
		return agreementStatus;
	}

	public void setAgreementStatus(String agreementStatus) {
		this.agreementStatus = agreementStatus;
	}

	public LocalDate getAgreementStartDate() {
		return agreementStartDate;
	}

	public void setAgreementStartDate(LocalDate agreementStartDate) {
		this.agreementStartDate = agreementStartDate;
	}

	public LocalDate getAgreementEndDate() {
		return agreementEndDate;
	}

	public void setAgreementEndDate(LocalDate agreementEndDate) {
		this.agreementEndDate = agreementEndDate;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public AgreementTemplate getAgreementTemplate() {
		return agreementTemplate;
	}

	public void setAgreementTemplate(AgreementTemplate agreementTemplate) {
		this.agreementTemplate = agreementTemplate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return "Agreement [agreementId=" + agreementId + ", agreementTitle=" + agreementTitle + ", agreementType="
				+ agreementType + ", agreementDescription=" + agreementDescription + ", agreementStatus="
				+ agreementStatus + ", agreementStartDate=" + agreementStartDate + ", agreementEndDate="
				+ agreementEndDate + ", tenant=" + tenant + ", customer=" + customer + ", property=" + property + "]";
	}
	
	
	
	

}
