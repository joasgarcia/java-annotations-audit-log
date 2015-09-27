package com.joasgarcia.auditlog

class CustomerController {

    static scaffold = true

    def customerService

    def update() {
        println params

        customerService.update(params.long("id"), params)

        flash.message = "Cliente alterado com sucesso"

        render(controller: "customer", view: "edit", id: params.long("id"))
    }
}
