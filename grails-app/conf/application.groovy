

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'tracker.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'tracker.UserRole'
grails.plugin.springsecurity.authority.className = 'tracker.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/oauth/authorize',access: "isFullyAuthenticated() and (request.getMethod().equals('GET') or request.getMethod().equals('POST'))"],
	[pattern: '/oauth/token',    access: "isFullyAuthenticated() and request.getMethod().equals('POST')"],
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	//[pattern: '/**',             filters: 'JOINED_FILTERS'],
	[pattern: '/oauth/token',               filters: 'JOINED_FILTERS,-oauth2ProviderFilter,-securityContextPersistenceFilter,-logoutFilter,-authenticationProcessingFilter,-rememberMeAuthenticationFilter,-exceptionTranslationFilter'],
	[pattern: '/api/**', filters: 'JOINED_FILTERS,-securityContextPersistenceFilter,-logoutFilter,-authenticationProcessingFilter,-rememberMeAuthenticationFilter,-oauth2BasicAuthenticationFilter,-exceptionTranslationFilter'],
	[pattern: '/**',                        filters: 'JOINED_FILTERS,-statelessSecurityContextPersistenceFilter,-oauth2ProviderFilter,-clientCredentialsTokenEndpointFilter,-oauth2BasicAuthenticationFilter,-oauth2ExceptionTranslationFilter']
]

grails.plugin.springsecurity.interceptUrlMap = [
		[pattern:'/**', access: ['permitAll']],
		[pattern:'/**/js/**', access: ['permitAll']],
		[pattern:'/**/plugins/**', access: ['permitAll']],
		[pattern:'/**/css/**', access: ['permitAll']],
		[pattern:'/static/js/**', access: ['permitAll']],
		[pattern:'/static/plugins/**', access: ['permitAll']],
		[pattern:'/static/css/**', access: ['permitAll']],
		[pattern:'/static/images/**', access: ['permitAll']],
		[pattern:'/login/**', access: ['permitAll']],
		[pattern:'/logout/**', access: ['permitAll']],
		[pattern:'/register/forgotPassword', access: ['permitAll']],
		[pattern:'/register/resetPassword', access: ['permitAll']],
		[pattern: '/oauth/token/**', access: ['permitAll']]
]

// Added by the Spring Security OAuth2 Provider plugin:
grails.plugin.springsecurity.oauthProvider.clientLookup.className = 'tracker.Client'
grails.plugin.springsecurity.oauthProvider.authorizationCodeLookup.className = 'tracker.AuthorizationCode'
grails.plugin.springsecurity.oauthProvider.accessTokenLookup.className = 'tracker.AccessToken'
grails.plugin.springsecurity.oauthProvider.refreshTokenLookup.className = 'tracker.RefreshToken'

