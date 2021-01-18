package training

import grails.gorm.services.Service

@Service(CheckList)
interface CheckListService {

    CheckList get(Serializable id)

    List<CheckList> list(Map args)

    Long count()

    void delete(Serializable id)

    CheckList save(CheckList checkList)

}