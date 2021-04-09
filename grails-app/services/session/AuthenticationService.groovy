package session

import com.session.AccessLevel
import com.tracker.StringConstant

import java.util.stream.Collectors

class AuthenticationService {

    def springSecurityService

    def getCurrentUser(){
        return springSecurityService.isLoggedIn() ?
                springSecurityService.loadCurrentUser() :
                null
    }

    def getCurrentUserAuthorities(){
        def principal = getCurrentPrincipal()
        return principal?.authorities
    }

    def isSystemUser(){
        def authorities = getCurrentUserAuthorities()
        return authorities?.parallelStream().anyMatch{(it.role.contains(StringConstant.SYSTEM_ROLE))}
    }

    def isSuperAdminUser(){
        def authorities = getCurrentUserAuthorities()
        return authorities?.parallelStream().anyMatch{(it.role.contains(StringConstant.SUPER_ADMIN_ROLE))}
    }

    def isAdminUser(){
        def authorities = getCurrentUserAuthorities()
        return authorities?.parallelStream().anyMatch{(it.role.contains(StringConstant.ADMIN_ROLE))}
    }

    def isDataEntryUser(){
        def authorities = getCurrentUserAuthorities()
        return authorities?.parallelStream().anyMatch{(it.role.contains(StringConstant.DATA_ENTRY_ROLE))}
    }

    private def getCurrentPrincipal(){
        def auth =  springSecurityService.isLoggedIn() ?
                springSecurityService.getAuthentication() :
                null

        if(auth == null){
            return null
        }

        return auth.principal
    }

    def getCurrentUserAccessLevel(){
        def principal = getCurrentPrincipal()

        if(principal == null){
            return null
        }

        return principal.accessLevel
    }

    def getCurrentUserSiteIdList(){

        def accessLevel = getCurrentUserAccessLevel()

        if (!accessLevel || !accessLevel.siteMap){
            return null
        }

        return accessLevel.siteMap.keySet().parallelStream().collect(Collectors.toList())
    }
}
