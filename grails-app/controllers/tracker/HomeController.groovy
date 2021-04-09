package tracker

import com.tracker.StringConstant
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class HomeController {

    def authenticationService

    // @Secured('permitAll')
    //@Secured(['AUTHENTICATED']) SecurityExpressionRoot
    @Secured(value=["hasAuthority('ROLE_AUTHENTICATED')"], httpMethod='GET')
    def index() {
    def currentUSer = authenticationService.getCurrentUser()
    def currentAccessLevel = authenticationService.getCurrentUserAccessLevel()
    def currentAuthority = authenticationService.getCurrentUserAuthorities()
    def currentUserSiteIdList = authenticationService.getCurrentUserSiteIdList()
        def isSystemUser = authenticationService.isSystemUser()
        def isAdminUser = authenticationService.isAdminUser()
        log.info(currentUSer as JSON)
        log.warn(currentAccessLevel as JSON)
        log.warn(currentAuthority as JSON)

        render view: 'index'
    }
}
