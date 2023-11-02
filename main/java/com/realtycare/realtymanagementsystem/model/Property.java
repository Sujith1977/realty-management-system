package com.realtycare.realtymanagementsystem.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/**
 * @author Sujith1977
 *
 */

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    private String propertyName;
    private String propertyType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address propertyAddress;

    private String propertyDescription;
    private int propertySize;
    private int bedrooms;
    private int bathrooms;
    private String propertyStatus;

    @ElementCollection
    @CollectionTable(name = "propertyImages")
    @Column(name = "imageUrl")
    private List<String> propertyImages;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Report> reports;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Agreement> agreements;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Document> documents;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Bill> bills;

    @ManyToMany
    @JoinTable(name = "propertyVendor",
            joinColumns = @JoinColumn(name = "propertyId"),
            inverseJoinColumns = @JoinColumn(name = "vendorId"))
    private Set<Vendor> vendors;

    @ManyToMany
    @JoinTable(name = "propertyTenant",
            joinColumns = @JoinColumn(name = "propertyIid"),
            inverseJoinColumns = @JoinColumn(name = "tenantId"))
    private Set<Tenant> tenants;

    @ManyToMany
    @JoinTable(name = "propertySchedule",
            joinColumns = @JoinColumn(name = "propertyId"),
            inverseJoinColumns = @JoinColumn(name = "scheduleId"))
    private Set<Schedule> schedules;

    @ManyToMany
    @JoinTable(name = "propertyService",
            joinColumns = @JoinColumn(name = "propertyId"),
            inverseJoinColumns = @JoinColumn(name = "serviceId"))
    private Set<Service> services;

    @ManyToMany
    @JoinTable(name = "propertyAmenity",
            joinColumns = @JoinColumn(name = "propertyId"),
            inverseJoinColumns = @JoinColumn(name = "amenityId"))
    private Set<Amenity> amenities;

    // Constructors, getters, setters, and toString method
    
    public Property() {
        // Default constructor
    	super();
    }

    public Property(String propertyName, String propertyType, Address propertyAddress, String propertyDescription, Customer customer) {
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.propertyAddress = propertyAddress;
        this.propertyDescription = propertyDescription;
        this.customer = customer;
    }

    // Getters and setters
    
    public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Address getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(Address propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public int getPropertySize() {
		return propertySize;
	}

	public void setPropertySize(int propertySize) {
		this.propertySize = propertySize;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	public List<String> getPropertyImages() {
		return propertyImages;
	}

	public void setPropertyImages(List<String> propertyImages) {
		this.propertyImages = propertyImages;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public List<Agreement> getAgreements() {
		return agreements;
	}

	public void setAgreements(List<Agreement> agreements) {
		this.agreements = agreements;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Set<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}

	public Set<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(Set<Tenant> tenants) {
		this.tenants = tenants;
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

	public Set<Amenity> getAmenities() {
		return amenities;
	}

	public void setAmenities(Set<Amenity> amenities) {
		this.amenities = amenities;
	}    
    
    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", propertyAddress=" + propertyAddress +
                ", propertyDescription='" + propertyDescription + '\'' +
                ", propertySize=" + propertySize +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", propertyStatus='" + propertyStatus + '\'' +
                ", propertyImages=" + propertyImages +
                ", customer=" + customer +
                ", reports=" + reports +
                ", agreements=" + agreements +
                ", documents=" + documents +
                ", bills=" + bills +
                ", vendors=" + vendors +
                ", tenants=" + tenants +
                ", schedules=" + schedules +
                ", services=" + services +
                ", amenities=" + amenities +
                '}';
    }
}
