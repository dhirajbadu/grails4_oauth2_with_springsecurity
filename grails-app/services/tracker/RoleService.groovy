package tracker

import com.tracker.StringConstant
import grails.gorm.transactions.Transactional

@Transactional
class RoleService {

    def getSystemRole(){
        return Role.findByAuthority(StringConstant.SYSTEM_ROLE)
    }

    def getSuperAdminRole(){
        return Role.findByAuthority(StringConstant.SUPER_ADMIN_ROLE)
    }

    def getAdminRole(){
        return Role.findByAuthority(StringConstant.ADMIN_ROLE)
    }

    def getDataEntryRole(){
        return Role.findByAuthority(StringConstant.DATA_ENTRY_ROLE)
    }

    def getAllRole(){
        return Role.findAll()
    }
}
