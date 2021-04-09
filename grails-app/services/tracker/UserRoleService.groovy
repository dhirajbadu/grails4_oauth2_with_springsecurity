package tracker


import grails.gorm.transactions.Transactional

import java.util.stream.Collectors

@Transactional
class UserRoleService {

    def roleService

    def getSystemRoleUserList(){
        return UserRole.findAllByRole(roleService.systemRole)?.parallelStream()?.map{it.user}?.collect(Collectors.toList())
    }

    def getSuperAdminRoleUserList(){
        return UserRole.findAllByRole(roleService.superAdminRole)?.parallelStream()?.map{it.user}?.collect(Collectors.toList())
    }

    def getAdminRoleUserList(){
        return UserRole.findAllByRole(roleService.adminRole)?.parallelStream()?.map{it.user}?.collect(Collectors.toList())
    }

    def getDataEntryRoleUserList(){
        return UserRole.findAllByRole(roleService.dataEntryRole)?.parallelStream()?.map{it.user}?.collect(Collectors.toList())
    }
}
