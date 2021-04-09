package tracker

import com.tracker.StringConstant
import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        defaultUser()

        createRole(StringConstant.SUPER_ADMIN_ROLE)
        createRole(StringConstant.ADMIN_ROLE)
        createRole(StringConstant.DATA_ENTRY_ROLE)

        oauthSetup()
    }

    @Transactional
    def oauthSetup(){
        //authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
        /*clientId: 'my-client',
        authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
        authorities: ['ROLE_CLIENT'],
        scopes: ['read', 'write'],
        redirectUris: ['http://myredirect.com']*/
        Client client = Client.findByClientId(StringConstant.OAUTH_CLIENT_ID)
        if(!client) {
            client = new Client()

            client.clientId = StringConstant.OAUTH_CLIENT_ID
            client.clientSecret = StringConstant.OAUTH_CLIENT_SECRET
            client.authorizedGrantTypes = ["password", "authorization_code", "refresh_token"]
            client.authorities = ['ROLE_CLIENT']
            client.scopes = ['read', 'write']
            client.redirectUris = ["http://localhost:8080/login"]
            client.accessTokenValiditySeconds = 120000
            client.refreshTokenValiditySeconds = 240000

            client.save(flush: true)
        }
    }

    def defaultUser(){
        Role role = createRole(StringConstant.SYSTEM_ROLE)

        if (User.findByUsername(StringConstant.SYSTEM_USERNAME) == null) {

            User user = createUser()

            UserRole userRole = new UserRole()

            userRole.user = user
            userRole.role = role

            userRole.save()
        }
    }

    def createRole(String roleName){
        Role role = Role.findByAuthority(roleName)
        if(!role) {
             role = new Role()

            role.authority = roleName
            role.save()
        }

        return role
    }

    def createUser(){
        User user = new User()

        user.username = StringConstant.SYSTEM_USERNAME
        user.password = StringConstant.SYSTEM_PASSWORD

        return user.save()
    }

    def destroy = {
    }
}
