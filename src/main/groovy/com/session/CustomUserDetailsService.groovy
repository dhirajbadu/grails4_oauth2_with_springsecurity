package com.session

import com.tracker.StringConstant;
import grails.plugin.springsecurity.SpringSecurityUtils;
import grails.plugin.springsecurity.userdetails.GrailsUserDetailsService;
import grails.plugin.springsecurity.userdetails.NoStackUsernameNotFoundException;
import grails.gorm.transactions.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tracker.User

public class CustomUserDetailsService implements GrailsUserDetailsService {

    /**
     * Some Spring Security classes (e.g. RoleHierarchyVoter) expect at least
     * one role, so we give a user with no granted roles this one which gets
     * past that restriction but doesn't grant anything.
     */
    static final List<SimpleGrantedAuthority> NO_ROLES = [new SimpleGrantedAuthority(SpringSecurityUtils.NO_ROLE)];


    public UserDetails loadUserByUsername(String username, boolean loadRoles)
            throws UsernameNotFoundException {
        return loadUserByUsername(username);
    }

    @Transactional(readOnly=true, noRollbackFor=[IllegalArgumentException, UsernameNotFoundException])
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = User.findByUsername(username)
        if (!user) throw new NoStackUsernameNotFoundException()

        def roles = user.getAuthorities();

        // or if you are using role groups:
        // def roles = user.authorities.collect { it.authorities }.flatten().unique()

        def authorities = roles.collect {
            new SimpleGrantedAuthority(it.authority)
        }

        authorities = authorities ?: NO_ROLES

        authorities.add( new SimpleGrantedAuthority(StringConstant.DEFAULT_ROLE))

        AccessLevel accessLevel = getAccessLevel(user)

        return new CustomUserDetails(user.username, user.password, user.enabled,
                !user.accountExpired, !user.passwordExpired,
                !user.accountLocked, authorities, user.id , accessLevel)
    }

    def getAccessLevel(User user){
        //TODO get accesslevel

        AccessLevel accessLevel = new AccessLevel();

        accessLevel.setCompanyName("xyz")
        accessLevel.setLogo("path")

        Map<Long , String> site = new HashMap<>();

        site.put(1 , "New Baneshwor Branch");

        accessLevel.setSiteMap(site)

        return accessLevel;
    }
}