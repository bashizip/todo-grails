package training

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ChecklistServiceSpec extends Specification {

    ChecklistService checklistService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Checklist(...).save(flush: true, failOnError: true)
        //new Checklist(...).save(flush: true, failOnError: true)
        //Checklist checklist = new Checklist(...).save(flush: true, failOnError: true)
        //new Checklist(...).save(flush: true, failOnError: true)
        //new Checklist(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //checklist.id
    }

    void "test get"() {
        setupData()

        expect:
        checklistService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Checklist> checklistList = checklistService.list(max: 2, offset: 2)

        then:
        checklistList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        checklistService.count() == 5
    }

    void "test delete"() {
        Long checklistId = setupData()

        expect:
        checklistService.count() == 5

        when:
        checklistService.delete(checklistId)
        sessionFactory.currentSession.flush()

        then:
        checklistService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Checklist checklist = new Checklist()
        checklistService.save(checklist)

        then:
        checklist.id != null
    }
}
