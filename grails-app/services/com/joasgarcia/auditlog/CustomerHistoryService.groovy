package com.joasgarcia.auditlog

class CustomerHistoryService {

    public CustomerHistory save(Customer customer, String fieldName, String oldValue, String newValue) {
        CustomerHistory customerHistory = new CustomerHistory()
        customerHistory.customer = customer
        customerHistory.fieldName = fieldName
        customerHistory.oldValue = oldValue
        customerHistory.newValue = newValue

        customerHistory.save(flush: true, failOnError: true)

        return customerHistory
    }
}
