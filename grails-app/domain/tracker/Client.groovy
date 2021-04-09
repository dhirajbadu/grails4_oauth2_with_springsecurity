package tracker

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class Client implements Serializable {

    private static final long serialVersionUID = 1

    private static final String NO_CLIENT_SECRET = ''

    String clientId
    String clientSecret

    Integer accessTokenValiditySeconds
    Integer refreshTokenValiditySeconds

    Map<String, Object> additionalInformation

    static hasMany = [
            authorities: String,
            authorizedGrantTypes: String,
            resourceIds: String,
            scopes: String,
            autoApproveScopes: String,
            redirectUris: String
    ]

    static constraints = {
        clientId blank: false, unique: true
        clientSecret nullable: true

        accessTokenValiditySeconds nullable: true
        refreshTokenValiditySeconds nullable: true

        authorities nullable: true
        authorizedGrantTypes nullable: true

        resourceIds nullable: true

        scopes nullable: true
        autoApproveScopes nullable: true

        redirectUris nullable: true
        additionalInformation nullable: true
    }
}
