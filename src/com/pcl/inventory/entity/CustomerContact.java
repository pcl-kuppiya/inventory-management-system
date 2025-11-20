package com.pcl.inventory.entity;

public class CustomerContact {
    private String contact;
    private String customerId;

    public CustomerContact() {
    }

    public CustomerContact(String contact, String customerId) {
        this.contact = contact;
        this.customerId = customerId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
