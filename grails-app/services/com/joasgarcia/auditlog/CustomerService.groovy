package com.joasgarcia.auditlog

class CustomerService {

    def customerHistoryService

    public void update(Long customerId, Map params) {
        Customer customer = Customer.get(customerId)

        customer.properties = params

        //#1
        List<Map> listOfUpdatedFields = getUpdatedFields(customer)

        customer.save(flush: true, failOnError: true)

        //#2
        listOfUpdatedFields.removeAll{ !Customer.getDeclaredField(it.fieldName).isAnnotationPresent(Auditable) }

        //#3
        for (Map updatedField : listOfUpdatedFields) {
            customerHistoryService.save(customer, updatedField.fieldName, updatedField.oldValue, updatedField.newValue)
        }
    }

    private List<Map> getUpdatedFields(domainInstance) {
        List listOfUpdatedFields = []

        for (String fieldName : domainInstance.dirtyPropertyNames) {
            listOfUpdatedFields += [
                    fieldName: fieldName,
                    oldValue: domainInstance.getPersistentValue(fieldName).toString(),
                    newValue: domainInstance[fieldName].toString()
            ]
        }

        return listOfUpdatedFields
    }
}
