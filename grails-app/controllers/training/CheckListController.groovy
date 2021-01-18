package training

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CheckListController {

    CheckListService checkListService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond checkListService.list(params), model:[checkListCount: checkListService.count()]
    }

    def show(Long id) {
        respond checkListService.get(id)
    }

    def create() {
        respond new CheckList(params)
    }

    def save(CheckList checkList) {
        if (checkList == null) {
            notFound()
            return
        }

        try {
            checkListService.save(checkList)
        } catch (ValidationException e) {
            respond checkList.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'checkList.label', default: 'CheckList'), checkList.id])
                redirect checkList
            }
            '*' { respond checkList, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond checkListService.get(id)
    }

    def update(CheckList checkList) {
        if (checkList == null) {
            notFound()
            return
        }

        try {
            checkListService.save(checkList)
        } catch (ValidationException e) {
            respond checkList.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'checkList.label', default: 'CheckList'), checkList.id])
                redirect checkList
            }
            '*'{ respond checkList, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        checkListService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'checkList.label', default: 'CheckList'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'checkList.label', default: 'CheckList'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
