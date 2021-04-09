package tracker

import grails.compiler.GrailsCompileStatic
import groovy.transform.ToString

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class RefreshToken implements Serializable {

    private static final long serialVersionUID = 1

    String value
    Date expiration
    byte[] authentication

    static constraints = {
        value nullable: false, blank: false, unique: true
        expiration nullable: true
        authentication nullable: false, minSize: 1, maxSize: 1024 * 4
    }

    static mapping = {
        version false
    }
}
