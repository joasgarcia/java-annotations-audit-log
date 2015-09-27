package com.joasgarcia.auditlog

class CustomerService {

    public void update(Long customerId, Map params) {
        Customer customer = Customer.get(customerId)
        customer.properties = params

        customer.save(flush: true, failOnError: true)
    }
}
