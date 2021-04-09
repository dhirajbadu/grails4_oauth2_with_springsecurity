package tracker

import grails.plugin.springsecurity.annotation.Secured

class ApiController {

    def authenticationService

    @Secured(value=["hasAuthority('ROLE_AUTHENTICATED')"], httpMethod='GET')
    def testOauth(){
        def currentUSer = authenticationService.getCurrentUser()
        def currentAccessLevel = authenticationService.getCurrentUserAccessLevel()
        def currentAuthority = authenticationService.getCurrentUserAuthorities()
        def currentUserSiteIdList = authenticationService.getCurrentUserSiteIdList()
        def isSystemUser = authenticationService.isSystemUser()
        def isAdminUser = authenticationService.isAdminUser()
        def result = ["dhiraj" , "astha" , "suresh dai"]
        render( result)
    }
}
