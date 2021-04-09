package tracker

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class AccessToken implements Serializable {

    private static final long serialVersionUID = 1

    String authenticationKey
    byte[] authentication

    String username
    String clientId

    String value
    String tokenType

    Date expiration
    Map<String, Object> additionalInformation

    static hasOne = [refreshToken: String]
    static hasMany = [scope: String]

    static constraints = {
        username nullable: true
        clientId nullable: false, blank: false
        value nullable: false, blank: false, unique: true
        tokenType nullable: false, blank: false
        expiration nullable: false
        scope nullable: false
        refreshToken nullable: true
        authenticationKey nullable: false, blank: false, unique: true
        authentication nullable: false, minSize: 1, maxSize: 1024 * 4
        additionalInformation nullable: true
    }

    static mapping = {
        version false
        scope lazy: false
    }
}
